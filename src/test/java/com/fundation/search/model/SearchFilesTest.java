/**
 * @(#)Validator.java 03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @version 25 Mar 2018  * @Jimmy Romero
 */
public class SearchFilesTest{

    private SearchFiles pathFiles;
    private File path;

    /**
     * Initializes pathFiles.
     */
    @Before
    public void initialize() {
        path = new File("C:\\AT06\\MagicPath");
        pathFiles = new SearchFiles();
    }

    /**
     * Test in order to show all files of a path.
     */
    @Test
    public void testDisplayFilesOfAPath() {
        List<String> expected = new ArrayList<>();
        expected.add("test1-1.txt");
        expected.add("test2-1.docx");
        expected.add("test3-1.xlsx");
        expected.add("test1.txt");
        expected.add("test2.docx");
        expected.add("test3.xlsx");
        assertEquals(expected, pathFiles.displayAllFiles(path));
    }

    /**
     * Test in order to show an specific file of a path.
     */
    @Test
    public void testDisplaySpecificFileOfAPath() {
        List<String> expected = new ArrayList<>();
        expected.add("test1.txt");
        assertEquals(expected, pathFiles.displaySpecificFile(path));
    }
}