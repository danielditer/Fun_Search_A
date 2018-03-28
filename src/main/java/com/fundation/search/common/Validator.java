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
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Method to validate file name, it should not contains special characters for windows..
     * @param name file name.
     * @return boolean value is valid.
     */
    public boolean isAValidName(String name) {
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
        if (path.length() > MAX_PATH_VALUE) {
            return false;
        }
        if (!pathExists(path.substring(0, path.indexOf("\\")))) {
            return false;
        }
        if (!isAValidName(path.substring(INDEX_THREE))) {
            return false;
        }
        return true;
    }
}
