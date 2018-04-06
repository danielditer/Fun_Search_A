/**
 * @(#)SearchFilesTest.java 03/25/18
 * <p>
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
import static org.junit.Assert.assertTrue;

/**
 * JUnit class developed in order to test all different methods for searching files.
 *
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class SearchFilesTest {

    /**
     * pathFiles is the variable to perform the methods.
     */
    private SearchFiles pathFiles;
    /**
     * path is the parameter sent to the methods.
     */
    private File path;

    /**
     * Initializes SearchFiles class.
     */
    @Before
    public void initialize() {
        final String pathname = "src/test/java/com/fundation/search/pathTest";
        path = new File(pathname);
        pathFiles = new SearchFiles();
    }

    /**
     * Test to compare the array of ResultFile objects.
     */
    /*@Test
    public void testRecoverResultFilesObject() {
        List<ResultFile> expected = new ArrayList<>();
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt",
                "test1-1.txt", false));
        List<ResultFile> arrayResultFiles = new ArrayList<>();
        assertEquals(expected.get(0).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getPath());
        assertEquals(expected.get(0).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getFileName());
        assertEquals(expected.get(0).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getHidden());
    }*/

    /**
     * Test in order to show all files of a path.
     */
    /*@Test
    public void testDisplayFilesOfAPath() {
        List<ResultFile> expected = new ArrayList<>();
        List<ResultFile> arrayResultFiles = new ArrayList<>();

        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt"
                , "test1-1.txt", false));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx"
                , "test2-1.docx", false));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx"
                , "test3-1.xlsx", false));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt"
                , "test1.txt", false));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx"
                , "test2.docx", false));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx"
                , "test3.xlsx", false));
        assertEquals(expected.get(0).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(0).getPath());
        assertEquals(expected.get(0).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(0).getFileName());
        assertEquals(expected.get(0).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(0).getHidden());
        assertEquals(expected.get(1).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(1).getPath());
        assertEquals(expected.get(1).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(1).getFileName());
        assertEquals(expected.get(1).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(1).getHidden());
        assertEquals(expected.get(2).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(2).getPath());
        assertEquals(expected.get(2).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(2).getFileName());
        assertEquals(expected.get(2).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(2).getHidden());
        assertEquals(expected.get(3).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(3).getPath());
        assertEquals(expected.get(3).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(3).getFileName());
        assertEquals(expected.get(3).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(3).getHidden());
        assertEquals(expected.get(4).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(4).getPath());
        assertEquals(expected.get(4).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(4).getFileName());
        assertEquals(expected.get(4).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(4).getHidden());
        assertEquals(expected.get(5).getPath(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(5).getPath());
        assertEquals(expected.get(5).getFileName(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(5).getFileName());
        assertEquals(expected.get(5).getHidden(), pathFiles.searchAllFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(5).getHidden());

    }*/

    /**
     * Test in order to show all hidden files of a path.
     */
    /*@Test
    public void testSearchHiddenFiles() {
        List<ResultFile> expected = new ArrayList<>();
        List<ResultFile> arrayResultFiles = new ArrayList<>();
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test4.txt",
                "test4.txt", true));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx"
                , "test5.docx", true));
        assertTrue( pathFiles.searchHiddenFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(0).getHidden());
        assertTrue( pathFiles.searchHiddenFiles(pathFiles.recoverFiles(path, arrayResultFiles)).get(1).getHidden());
    }*/
}
