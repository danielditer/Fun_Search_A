/**
 * @(#)ValidatorTest.java  03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */
package com.fundation.search.common;



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
     * First test, validate if a name with slash is valid.
     */
    @Test
    public void testIsValidNameSlash() {
        assertFalse("A name with / is not valid", validator.isAValidName("file/name"));
    }

    /**
     * Second test, validate if a name with two points is valid.
     */
    @Test
    public void testIsValidNameTwoPoints() {
        assertFalse("A name with : is not valid", validator.isAValidName("file:name"));
    }

    /**
     * Third test, validate if a name with asterisk is valid.
     */
    @Test
    public void testIsValidNameAsterisk() {
        assertFalse("A name with * is not valid", validator.isAValidName("file*name"));
    }

    /**
     * Fourth test, validate if a name with question mark is valid.
     */
    @Test
    public void testIsValidNameQuestionMark() {
        assertFalse("A name with ? is not valid", validator.isAValidName("file?name"));
    }

    /**
     * Fifth test, validate if a name with less than is valid.
     */
    @Test
    public void testIsValidNameLessThan() {
        assertFalse("A name with < is not valid", validator.isAValidName("file<name"));
    }

    /**
     * Sixth test, validate if a name with more than is valid.
     */
    @Test
    public void testIsValidNameMoreThan() {
        assertFalse("A name with > is not valid", validator.isAValidName("file>name"));
    }

    /**
     * Seventh test, validate if a name with pipe line is valid.
     */
    @Test
    public void testIsValidNamePipe() {
        assertFalse("A name with | is not valid", validator.isAValidName("file|name"));
    }


    /**
     * Eight test, validate if a name with slash is valid.
     */
    @Test
    public void testIsValidNameWithBackSlash() {
        assertFalse("file\\name is not valid", validator.isAValidName("file\\name"));
    }

    /**
     * Nineth test, validate if a name with underscore is valid.
     */
    @Test
    public void testIsValidNameValidFileName() {
        assertTrue("file_name is a valid name", validator.isAValidName("file_name"));
    }

    /**
     * Tenth test, validate if a path exists.
     */
    @Test
    public void testPathExists() {
        final String param = "src\\test\\java\\com\\fundation\\search";
        assertTrue("Path src\\test\\java\\com\\fundation\\search", validator.pathExists(param));
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
        final String param = "src\\test\\java\\com\\fundation\\search";
        assertFalse("Path src\\test\\java\\com\\fundation\\search", validator.isAValidPath(param));
    }

    /**
     * Thirteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathPathIsNotValid() {
        final String param = "src\\test\\java\\com\\fundation\\s\\test-file";
        assertFalse("Path src\\test\\java\\com\\fundation\\search\\test-file", validator.isAValidPath(param));
    }

    /**
     * Fourteeth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidPath() {
        final String param = "src\\test\\java\\com\\funda*/\\s\\test:file";
        assertFalse("Path c:\\Users", validator.isAValidPath(param));
    }

    /**
     * Fifteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidDrive() {
        final String param = "xxx\\test\\java\\com\\funda*/\\s\\test:file";
        assertFalse("Path c:\\Users", validator.isAValidPath(param));
    }

    /**
     * Sixteenth test, validate if a path is valid.
     */
    @Test
    public void testIsAValidPathInvalidLength() {
        final String param = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param1 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param2 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        final String param3 = "xxx\\test\\java\\com\\funda\\s\\test-file\\xxx\\test\\java\\com\\funda\\s\\test-file\\";
        assertFalse("Path c:\\Users", validator.isAValidPath(param.concat(param1).concat(param2).concat(param3)));
    }

    /**
     * Seventeenth test.
     */
    @Test
    public void testIsAValidPathNames(){
        assertTrue("Path", validator.isAValidPathName("folder\\folder1\\aa"));
    }

    /**
     * Eighteenth test.
     */
    @Test
    public void testIsAInvalidPathNames(){
        assertFalse("Path", validator.isAValidPathName("folderr:rrrr\\file\\document\\"));
    }

    /**
     * method testIsANumberString validate is a string contain only numbers
     */
    @Test
    public void testIsANumberString() {
        assertFalse(validator.isANumber("test"));
    }
    /**
     * method testIsANumberString validate is a string contain only numbers
     */
    @Test
    public void testIsANumberWithString() {
        assertFalse(validator.isANumber("123213test"));
    }
    /**
     * method testIsANumberString validate is a string contain only numbers
     */
    @Test
    public void testIsANumber() {
        assertTrue(validator.isANumber("123213"));
    }

    /**
     * method testDatesNotEmpty validate is the search have two dates: from and to
     */
    @Test
    public void testDatesNotEmpty() {
        assertTrue(validator.datesNotEmptyString("11-05-2018", "11-06-2018"));
    }
    /**
     * method testDatesNotEmpty validate is the search have two dates: from and to
     */
    @Test
    public void testDatesEmpty() {
        assertFalse(validator.datesNotEmptyString(null, null));
    }
    /**
     * method testIsNotAValidRangedate validate is the search have two dates: from and to
     */
    @Test
    public void testIsNotAValidRangedate() {
        assertFalse(validator.isAValidRangeDate("11-07-2018", "11-06-2018"));
    }
    /**
     * method testDatesNotEmpty validate is the search have two dates: from and to
     */
    @Test
    public void testNotAValidRangedate() {
        assertTrue(validator.isAValidRangeDate("11-07-2018", "11-08-2018"));
    }
    /**
     * method testNotValidNameCriterial validate is the name criterial is empty
     */
    @Test
    public void testNotValidNameCriterial() {
        assertFalse(validator.nameCriterialIsNorEmpty(""));
    }
    /**
     * method testNotValidNameCriterial validate is the name criterial is not empty
     */
    @Test
    public void testIsValidNameCriterial() {
        assertTrue(validator.nameCriterialIsNorEmpty("test"));
    }


}
