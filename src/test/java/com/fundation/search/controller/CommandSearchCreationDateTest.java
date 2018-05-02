package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchCreationDate.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchCreationDateTest {

    /**
     * Instance and initializes object CommandSearchCreationDate.
     */
    CommandSearchCreationDate commandSearchCreationDate = new CommandSearchCreationDate();

    /**
     * It tests class CommandSearchCreationDate.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchCreationDate.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Creation Date test");
        }
    }
}
