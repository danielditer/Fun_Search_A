/**
 * @(#)ValidatorTest.java  03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */
package com.fundation.search.controller;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @version
 * 25 Mar 2018  * @Juan Manuel
 */
public class ValidatorTest {
    private Validator validator;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        validator = new Validator();
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameSlash() {
        assertFalse("A name with / is not valid", validator.isAValidName("/"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameTwoPoints() {
        assertFalse("A name with : is not valid", validator.isAValidName(":"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameAsterisk() {
        assertFalse("A name with * is not valid", validator.isAValidName("*"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameQuestionMark() {
        assertFalse("A name with ? is not valid", validator.isAValidName("?"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameLessThan() {
        assertFalse("A name with < is not valid", validator.isAValidName("<"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameMoreThan() {
        assertFalse("A name with > is not valid", validator.isAValidName(">"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNamePipe() {
        assertFalse("A name with | is not valid", validator.isAValidName("|"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameWithTwoPoints() {
        assertFalse("file:name is not valid", validator.isAValidName("file:name"));
    }

    /**
     * First test.
     */
    @Test
    public void testIsValidNameValidFileName() {
        assertTrue("file_name is a valid name", validator.isAValidName("file_name"));
    }
}
