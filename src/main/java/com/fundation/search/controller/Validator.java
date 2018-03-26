/**
 * @(#)Validator.java  03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import java.util.ArrayList;
import java.util.List;
/**
 * @version
 * 25 Mar 2018  * @Juan Manuel
 */
public class Validator {

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
}
