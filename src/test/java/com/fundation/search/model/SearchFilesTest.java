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

/**
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class SearchFilesTest {

    private SearchFiles pathFiles;
    private File path;

    /**
     * Initializes SearchFiles class.
     */
    @Before
    public void initialize() {
        final String pathname = "src/main/java/com/fundation/search/pathTest";
        path = new File(pathname);
        pathFiles = new SearchFiles();
    }

    /**
     * Test to compare the array of FileS objects.
     */
    @Test
    public void testRecoverResultFilesObject() {
        List<FileS> expected = new ArrayList<>();
        expected.add(new FileS("src\\main\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt",
                "test1-1.txt", false));

        assertEquals(expected.get(0).getPath(), pathFiles.recoverFiles(path).get(0).getPath());
        assertEquals(expected.get(0).getFileName(), pathFiles.recoverFiles(path).get(0).getFileName());
        assertEquals(expected.get(0).getHidden(), pathFiles.recoverFiles(path).get(0).getHidden());
    }

    /**
     * Test in order to show all files of a path.
     */
    @Test
    public void testDisplayFilesOfAPath() {
        List<String> expected = new ArrayList<>();

        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx");
        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx");
        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        expected.add("src\\main\\java\\com\\fundation\\search\\pathTest\\test3.xlsx");
        assertEquals(expected, pathFiles.searchAllFiles(pathFiles.recoverFiles(path)));
    }

    /**
     * Test in order to show an specific file of a path.
     */
    @Test
    public void testDisplayFileOfAPath() {
        List<String> expected = new ArrayList<>();
        expected.add("test4.txt");
        assertEquals(expected, pathFiles.searchFile(pathFiles.recoverFiles(path)));
    }

    /**
     * Test in order to show all hidden files of a path.
     */
    @Test
    public void testSearchHiddenFiles() {
        List<String> expected = new ArrayList<>();
        expected.add("test4.txt");
        expected.add("test5.docx");
        assertEquals(expected, pathFiles.searchHiddenFiles(pathFiles.recoverFiles(path)));
    }
}
