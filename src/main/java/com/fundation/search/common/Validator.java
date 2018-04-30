/**
 * @(#)Validator.java  03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */
package com.fundation.search.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class Validator will have methods to validate the criterias used in the program.
 * So far these are fileName and pathName.
 * @version
 * 25 Mar 2018  * @Juan Manuel
 */
public class Validator {
    private static final int MAX_PATH_VALUE = 246;
    private static final int INDEX_THREE = 3;

    static final List<Character> INVALID_CHARACTERS = new ArrayList<>();

    /**
     * static method to fill list with characters that are not
     * allowed when a file or path directory is created in windows.
     */
    static {
        INVALID_CHARACTERS.add('/');
        INVALID_CHARACTERS.add(':');
        INVALID_CHARACTERS.add('*');
        INVALID_CHARACTERS.add('?');
        INVALID_CHARACTERS.add('<');
        INVALID_CHARACTERS.add('>');
        INVALID_CHARACTERS.add('|');
        INVALID_CHARACTERS.add('"');
        INVALID_CHARACTERS.add('\\');
    }

    public Validator() {

    }
    /**
     * Method to validate file name, it should not contains special characters for windows..
     * @param name file name.
     * @return boolean value is valid.
     */
    public boolean isAValidName(String name) {
        INVALID_CHARACTERS.remove((Character) '*');
        char[] nameCharacters = name.toCharArray();
        for (char value : nameCharacters) {
            if (INVALID_CHARACTERS.contains(value)) {
                INVALID_CHARACTERS.add('*');
                return false;
            }
        }
        return true;
    }

    /**
     * Method to validate each directory of a path.
     * @param path
     * @return
     */
    public boolean isAValidPathName(String path) {
        String[] directoryName = path.split(Pattern.quote(File.separator));
        for (String value : directoryName) {
            if (!isAValidNameForPath(value)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method to validate if is a valid name path.
     * @param name
     * @return
     */
    public boolean isAValidNameForPath(String name) {
        char[] nameCharacters = name.toCharArray();
        for (char value : nameCharacters) {
            if (INVALID_CHARACTERS.contains(value)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method to validate path exists.
     * @param path .
     * @return boolean value is valid.
     */
    public boolean pathExists(String path) {
            File file = new File(path);
            return file.exists();
    }

    /**
     * Method to validate if path is valid, if this is longer than 246, if it exists and if it has a valid name.
     * @param path .
     * @return boolean value is valid.
     */
    public boolean isAValidPath(String path) {
        String[] file = path.split(":");
        if (path.isEmpty()) {
            return false;
        }
        if (path.length() > MAX_PATH_VALUE) {
            return false;
        }
        if (file.length == 2)
        {
            if (!pathExists(file[1])) { //.substring(0, path.indexOf("\\")))
                return false;
            }
        }
        else {
            return false;
        }
        return isAValidPathName(path.substring(INDEX_THREE));
    }

    /**
     * Method to validate if a string is a number.
     * @param size .
     * @return boolean value is valid.
     */
    public boolean isANumber(String size) {
        return size.matches("[0-9]+");
    }
    /**
     * Method to validate the dates are not empty.
     * @param fromDate
     * @param toDate
     * @return boolean value is valid.
     */
    public boolean datesNotEmptyString (String fromDate, String toDate) {
        return fromDate != null && toDate != null;
    }
    /**
     * Method to validate if is a valid range dates.
     * @param fromDate
     * @param toDate
     * @return boolean value is valid.
     */
    public boolean isAValidRangeDate(String fromDate, String toDate) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date dateFromDate = formatDate.parse(fromDate);
            Date dateToDate = formatDate.parse(toDate);
            if (dateFromDate.compareTo(dateToDate) > 0) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * Method to validate if name criterial is not empty.
     * @param name
     * @return boolean value is valid.
     */
    public boolean nameCriterialIsNorEmpty(String name) {
        return !name.isEmpty() && name.compareTo(" ") != 0;
    }
    /**
     * Method to validate if is a valid range dates.
     * @param name
     * @return boolean value is valid.
     */
    public boolean isAValidWildCard(String name) {
        return !name.contains("*") || name.endsWith("*") || name.startsWith("*");
    }
}
