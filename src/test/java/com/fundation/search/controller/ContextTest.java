package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * JUnit to test class Context.
 *
 * @version April, 30th 2018  * @Jimmy Romero
 */
public class ContextTest {
    /**
     * Instance of context object.
     */
    Context context;

    /**
     * Initializes the mockito.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * It tests the execute command method.
     */
    @Test
    public void testExecuteCommand() {
        try {
            context.executeCommand("command", new String[]{"inputCommands"}, 0, new SearchCriteria());
        } catch (Exception e) {
            LoggerCreator.getInstance().info(this.getClass().getName(), "Execute command test");
        }
    }
}
