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
     * Second test.
     */
    @Test
    public void testIsValidNameTwoPoints() {
        assertFalse("A name with : is not valid", validator.isAValidName(":"));
    }

    /**
     * Third test.
     */
    @Test
    public void testIsValidNameAsterisk() {
        assertFalse("A name with * is not valid", validator.isAValidName("*"));
    }

    /**
     * Fourth test.
     */
    @Test
    public void testIsValidNameQuestionMark() {
        assertFalse("A name with ? is not valid", validator.isAValidName("?"));
    }

    /**
     * Fifth test.
     */
    @Test
    public void testIsValidNameLessThan() {
        assertFalse("A name with < is not valid", validator.isAValidName("<"));
    }

    /**
     * Sixth test.
     */
    @Test
    public void testIsValidNameMoreThan() {
        assertFalse("A name with > is not valid", validator.isAValidName(">"));
    }

    /**
     * Seventh test.
     */
    @Test
    public void testIsValidNamePipe() {
        assertFalse("A name with | is not valid", validator.isAValidName("|"));
    }

    /**
     * Eight test.
     */
    @Test
    public void testIsValidNameWithTwoPoints() {
        assertFalse("file:name is not valid", validator.isAValidName("file:name"));
    }

    /**
     * Nineth test.
     */
    @Test
    public void testIsValidNameValidFileName() {
        assertTrue("file_name is a valid name", validator.isAValidName("file_name"));
    }

    /**
     * Tenth test, validate a path that exists.
     */
    @Test
    public void testPathExists() {
        final String param = "src\\test\\java\\com\\fundation\\search\\test-file";
        assertTrue("Path C:\\Users does not exist", validator.pathExists(param));
    }

    /**
     * Eleventh test, validate a path that does not exist.
     */
    @Test
    public void testPathExistsDoesNotExist() {
        final String param = "src\\test\\java\\com\\fundation\\s\\test-file";
        assertFalse("Path src\\test\\java\\com\\fundation\\s\\test-file doesn't exist", validator.pathExists(param));
    }

    /**
     * Twelfth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPath() {
        final String param = "src\\test\\java\\com\\fundation\\s\\test-file";
        assertTrue("Path src\\test\\java\\com\\fundation\\search\\test-file", validator.isAValidPath(param));
    }

    /**
     * Thirteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidPath() {
        final String param = "src\\test\\java\\com\\funda*/\\s\\test:file";
        assertFalse("Path c:\\Users", validator.isAValidPath(param));
    }

    /**
     * Fourteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidDrive() {
        final String param = "xxx\\test\\java\\com\\funda*/\\s\\test:file";
        assertFalse("Path c:\\Users", validator.isAValidPath(param));
    }

    /**
     * Fifteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidLength() {
        final String param = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param1 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param2 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param3 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        assertFalse("Path c:\\Users", validator.isAValidPath(param.concat(param1).concat(param2).concat(param3)));
    }
}
