package com.fundation.search.common;

public class Converter {
    public static double convertToBytes(double size, String measure) {
        double sizeConverted = 0.0;
        if (measure.equalsIgnoreCase("bytes")) {
            return size;
        }
        if (measure.equalsIgnoreCase("Mb")) {
            sizeConverted = size * 1024;
            return sizeConverted;
        }
        if (measure.equalsIgnoreCase("Gb")) {
            sizeConverted = size * 1024 * 1024;
            return sizeConverted;
        }
        return sizeConverted;
    }
}
