package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchPath.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchPathTest {
    /**
     * Instance and initializes commandSearchPath.
     */
    CommandSearchPath commandSearchPath = new CommandSearchPath();

    /**
     * It tests class CommandSearchPath.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchPath.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Path test");
        }
    }
}
