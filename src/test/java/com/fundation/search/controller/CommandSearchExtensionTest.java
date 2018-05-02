package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchExtension.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchExtensionTest {
    /**
     * Instance and initializes object commandSearchExtension.
     */
    CommandSearchExtension commandSearchExtension = new CommandSearchExtension();

    /**
     * It tests class CommandSearchExtension.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchExtension.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Extension test");
        }
    }
}
