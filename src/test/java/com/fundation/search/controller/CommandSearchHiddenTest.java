package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Test;

/**
 * JUnit to test class CommandSearchHidden.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class CommandSearchHiddenTest {
    /**
     * Instance and initializes object commandSearchHidden.
     */
    CommandSearchHidden commandSearchHidden = new CommandSearchHidden();

    /**
     * It tests class CommandSearchHidden.
     */
    @Test
    public void testCommandHandler() {
        try {
            commandSearchHidden.commandHandler("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Command Search Hidden test");
        }
    }
}
