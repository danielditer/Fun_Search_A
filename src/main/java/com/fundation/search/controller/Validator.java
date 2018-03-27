/**
 * @(#)Validator.java  03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @version
 * 25 Mar 2018  * @Juan Manuel
 */
public class Validator {
    private static final int MAX_PATH_VALUE = 246;
    private static final int INDEX_THREE = 3;

    static final List<Character> INVALID_CHARACTERS = new ArrayList<>();
    /**
     * static method to fill list.
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
    }

    /**
     * method to validate string.
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
     * method to validate path exists.
     * @param path .
     * @return boolean value is valid.
     */
    public boolean pathExists(String path) {
        File folder = new File(path);
        return folder.exists();
    }

    /**
     * method to validate if path is valid.
     * @param path .
     * @return boolean value is valid.
     */
    public boolean isAValidPath(String path) {
        if (path.length() > MAX_PATH_VALUE) {
            return false;
        }
        if (!pathExists(path.substring(0, 2))) {
            return false;
        }
        if (!isAValidName(path.substring(INDEX_THREE))) {
            return false;
        }
        return true;
    }
}
