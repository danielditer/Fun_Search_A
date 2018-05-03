/**
 * @(#)MainTest.java 05/01/2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search;
import org.junit.Test;
import java.io.IOException;

/**
 * JUnit to test class main.
 * @version May, 1st 2018  * @Manuel Valdez
 */
/**
 * Main test class.
 */
public class MainTest {
    /**
     * Test main method of main class.
     */
    @Test
    public void testMain() {
        try {
            Main.main(new String[]{});
        } catch (IOException e) {
            e.getMessage();
        }

    }
}

