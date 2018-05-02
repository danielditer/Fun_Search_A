package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchType.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchTypeTest {
    /**
     * Instance and initializes object commandSearchType.
     */
    CommandSearchType commandSearchType = new CommandSearchType();

    /**
     * It tests class CommandSearchType.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchType.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Type test");
        }
    }
}
