package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchCaseSensitive.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchCaseSensitiveTest {
    /**
     * Instance and initializes object commandSearchCaseSensitive .
     */
    CommandSearchCaseSensitive commandSearchCaseSensitive = new CommandSearchCaseSensitive();

    /**
     * It tests class CommandSearchCaseSensitive.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchCaseSensitive.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Case Sensitive test");
        }
    }
}
