/**
 * @(#)Converter.java 4/19/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.common;

/**
 * Class to convert multiple values.
 * @version April 19th, 2018  * @Manuel Valdez
 */
public class Converter {
    /**
     * Static method to convert kb, mb, gb, to bytes.
     * @param size the value.
     * @param measure kb, mb, gb.
     * @return bytes.
     */
    public static double convertToBytes(double size, String measure) {
        if (measure.equalsIgnoreCase("bytes")) {
            return size;
        }
        if (measure.equalsIgnoreCase("Kb")) {
            return size * 1024;
        }
        if (measure.equalsIgnoreCase("Mb")) {
            return size * 1024 * 1024;
        }
        if (measure.equalsIgnoreCase("Gb")) {
            return size * 1024 * 1024 * 1024;
        }
        return 0.0;
    }
}
