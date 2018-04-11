package com.fundation.search.common;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Class that contain test to commandExecutor.
 * @version
 * 29 Mar 2018  * @Maria Canqui
 */
public class ValidatorCommandTest {
    private ValidatorCommand valcom;
    /**
     * * initialize CommandController.
     * */
    @Before
    public void initialize() {
        valcom = new ValidatorCommand();
    }

    /**
     * the searchFileCommandName method provide a positive test for the first and second word.
     */
    @Test
    public void searchFileCommandValid() {
        assertTrue( valcom.isAValidFirstSecondWord("java search -n test -p C:\\Users"));
    }

    /**
     * the searchFileCommandName method provide a negative test for the first word.
     */
    @Test
    public void searchFileCommandFirstWord() {
        assertFalse( valcom.isAValidFirstSecondWord("javac search -n test -p C:\\Users"));
    }
    /**
     * the searchFileCommandName method provide a negative test for the second word.
     */
    @Test
    public void searchFileCommandSecondWord() {
        assertFalse( valcom.isAValidFirstSecondWord("java searchh -n test -p C:\\Users"));
    }
    /**
     * the searchFileCommandName method provide a negative test for the second and first word.
     */
    @Test
    public void searchFileCommandFirsrSecondWord() {
        assertFalse( valcom.isAValidFirstSecondWord("javac searchh -n test -p C:\\Users"));
    }

    /**
     * the searchFileCommandName method provide a positive and negative test for the word after the command.
     */
    @Test
    public void searchFileCommandArgumentAfterWord() {
        assertTrue( valcom.isAValidArgumentAfterCommand("java search -n test -p C:\\Users"));
        assertTrue( valcom.isAValidArgumentAfterCommand("java search -n -ptest"));
    }

    /**
     * the searchFileCommandName method provide a negative test for the word after command.
     */
    @Test
    public void searchFileCommandNotArgumentAfterWord() {
        assertFalse( valcom.isAValidArgumentAfterCommand("java search -n -p"));

    }

}
