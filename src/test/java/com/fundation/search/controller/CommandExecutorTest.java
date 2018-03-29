/**
 * @(#)Validator.java  03/28/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The class CommandExecutorTest contains test to class Command Executor.
 * @version
 * 28 Mar 2018  * @Maria Canqui
 */
public class CommandExecutorTest {
    private CommandExecutor comex;
    /**
     * * initialize CommandExecutor object.
     * */
    @Before
    public void initialize() {
        comex = new CommandExecutor();
    }

    /**
     * the searchFileCommandName method provide a test for the command -n name.
     */
    @Test
    public void searchFileCommandName() {
        assertEquals("get name: test.txt", comex.exeCmd("java search -n test.txt"));
    }
    /**
     * the searchFileCommandPath method provide a test for the command -p path.
     */
    @Test
    public void searchFileCommandPath() {
        assertEquals("get path: C:/Users", comex.exeCmd("java search -p C:/Users"));
    }
    /**
     * the searchFileCommandNamePathHidden method provide a test for the command -h hidden.
     */
    @Test
    public void searchFileCommandHidden() {
         assertEquals("get hidden: true", comex.exeCmd("java search -h true"));
    }
    /**
     * the searchFileCommandNamePathHidden method provide a test for the command -h -n -p.
     */
    @Test
    public void searchFileCommandNamePathHidden() {
        String command = "java search -h true -p C:/Users -h true";
        String result = "get hidden: true get path: C:/Users get hidden: true";
        assertEquals(result, comex.exeCmd(command));
    }
    /**
     * the searchFileDoesNotFound method provide a test for a nonexistent command.
     */
    @Test
    public void searchFileDoesNotFound() {
        String command = "java search -l true";
        assertEquals("", comex.exeCmd(command));
    }
}
