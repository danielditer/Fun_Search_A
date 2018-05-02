package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchName.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchNameTest {
    /**
     * Instance and initializes object commandSearchName.
     */
    CommandSearchName commandSearchName = new CommandSearchName();

    /**
     * It tests class CommandSearchName.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchName.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Name test");
        }
    }
}
