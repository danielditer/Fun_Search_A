package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchReadOnly.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchReadOnlyTest {
    /**
     * Instance and initializes object commandSearchReadOnly.
     */
    CommandSearchReadOnly commandSearchReadOnly = new CommandSearchReadOnly();

    /**
     * It test class CommandSearchReadOnly.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchReadOnly.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Read Only Date test");
        }
    }
}
