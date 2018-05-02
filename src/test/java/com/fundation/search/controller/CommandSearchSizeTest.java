package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchSize.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchSizeTest {
    /**
     * Instance and initializes object commandSearchSize.
     */
    CommandSearchSize commandSearchSize = new CommandSearchSize();

    /**
     * It tests class CommandSearchSize.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchSize.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Size test");
        }
    }
}
