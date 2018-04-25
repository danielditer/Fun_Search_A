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
 * Class that contain test to validate method exeCmd of commandExecutor.
 * @version
 * 28 Mar 2018  * @Maria Canqui
 */
public class CommandControllerTest {
    private CommandController comex;
    /**
     * * initialize CommandController.
     * */
    @Before
    public void initialize() {
       // comex = new CommandController();
    }
    /**
     * the searchFileCommandName method provide a test for the command -n name and -p path.
     */
    @Test
    public void searchFileCommandName() {
        //assertEquals("test", comex.exeCmd("java search -n test -p C:\\Users\\Administrator\\Documents\\"));
    }
}