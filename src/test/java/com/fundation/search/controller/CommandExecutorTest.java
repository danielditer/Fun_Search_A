/**
 * @(#)Validator.java  03/28/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;


import com.fundation.search.model.SearchFiles;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Class that contain test to commandExecutor.
 * @version
 * 28 Mar 2018  * @Maria Canqui
 */
public class CommandExecutorTest {
    private CommandExecutor comex;
    private SearchFiles pathFiles;
    /**
     * * initialize CommandExecutor.
     * */
    @Before
    public void initialize() {
        comex = new CommandExecutor();
        pathFiles = new SearchFiles();
    }

    /**
     * the searchFileCommandName method provide a test for the command -n name and -p path.
     */
    @Test
    public void searchFileCommandName() {
        assertEquals("test", comex.exeCmd("java search -n doc -p C:\\Users\\Administrator\\Documents\\Prog102\\Search\\Fun_Search_A"));
    }



}