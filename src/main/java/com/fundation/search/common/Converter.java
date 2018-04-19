package com.fundation.search.common;

public class Converter {
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
