package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchAccessedDate.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchAccessedDateTest {
    /**
     * Instance and initializes object CommandSearchAccessedDate.
     */
    CommandSearchAccessedDate commandSearchAccessedDate = new CommandSearchAccessedDate();

    /**
     * It tests class CommandSearchAccessedDate.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchAccessedDate.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Accessed Date test");
        }
    }
}
