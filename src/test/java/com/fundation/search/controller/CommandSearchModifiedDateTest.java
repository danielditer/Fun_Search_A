package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchModifiesDate.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchModifiedDateTest {

    /**
     * Instance and initializes object CommandSearchModifiedDate.
     */
    CommandSearchModifiedDate commandSearchModifiedDate = new CommandSearchModifiedDate();

    /**
     * It tests the CommandSearchModifiedDate class.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchModifiedDate.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Modified Date test");
        }
    }
}
