/**
 * @(#)ConverterTest.java 04/30/2018
 * <p>
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit class to test converter class.
 *
 * @version April, 30th 2018  * @Manuel Valdez
 */
public class ConverterTest {
    @Test
    public void testConvertFromBytes() {
        assertEquals(1000.0, Converter.convertToBytes(1000.0, "bytes"), 0);
    }
    @Test
    public void testConvertFromKbytes() {
        assertEquals(102400.0, Converter.convertToBytes(100.0, "kb"), 0);
    }
    @Test
    public void testConvertFromMbytes() {
        assertEquals(104857600, Converter.convertToBytes(100.0, "mb"), 0);
    }
    @Test
    public void testConvertFromGbytes() {
        assertEquals(107374182400.0, Converter.convertToBytes(100.0, "gb"), 0);
    }
}