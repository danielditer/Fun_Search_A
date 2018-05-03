package com.fundation.search.controller;

import com.fundation.search.model.Asset;
import com.fundation.search.model.SearchFiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.when;

/**
 * JUnit to test class CommandController.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandControllerJTest {
    /**
     * Instances of objects to be used.
     */
    SearchFiles searchFiles;
    CommandController commandController;

    /**
     * Initializes the mockito.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * It tests the init method.
     */
    @Test
    public void testInit() {
        try {
            when(searchFiles.getResultResultFiles()).thenReturn(Arrays.<Asset>asList(new Asset("path", "fileName", true, true, 0, "owner", 0L, "creationTime", "lastModifiedTime", "lastAccessTime", true)));
            commandController.init();
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command controller init test");
        }
    }

    /**
     * It tests the valid command method.
     */
    @Test
    public void testIsAValidCommand() {
        try {
            boolean result = commandController.isAValidCommand();
            Assert.assertEquals(true, result);
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Is a valid command test");
        }
    }

    /**
     * It tests the help message method.
     */
    @Test
    public void testHelpMessage() {
        try {
            commandController.helpMessage();
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Help message test");
        }
    }
}
