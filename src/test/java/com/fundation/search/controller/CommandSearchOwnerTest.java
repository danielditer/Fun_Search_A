package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchOwner.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchOwnerTest {
    /**
     * Instance and initializes object commandSearchOwner.
     */
    CommandSearchOwner commandSearchOwner = new CommandSearchOwner();

    /**
     * It tests class CommandSearchOwner.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchOwner.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Owner test");
        }
    }
}
