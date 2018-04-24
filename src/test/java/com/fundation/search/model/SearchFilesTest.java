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
import org.powermock.reflect.Whitebox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * JUnit class developed in order to test all different methods for searching files.
 *
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class SearchFilesTest {

    /**
     * pathFiles is the variable to perform the methods.
     */
    private SearchFiles searchFiles;
    /**
     * path is the parameter sent to the methods.
     */
    private File path;

    /**
     * Initializes SearchFiles class.
     */
    @Before
    public void initialize() {
        final String filePath = "src/test/java/com/fundation/search/pathTest";
        path = new File(filePath);
        searchFiles = new SearchFiles();
    }

    /**
     * Test to compare the array of ResultFile objects.
     */
    @Test
    public void testRecoverResultFilesObject() throws Exception {
        List<Asset> arrayResultFiles = new ArrayList<>();
        List<Asset> expectedResultFiles = new ArrayList<>();
        AssetFactory assetFactory = new AssetFactory();
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", false, 0.0, true, 1, "Administrators", "txt", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test2-1.docx", false, 0.0, false, 1, "Administrators", "docx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx", "test3-1.xlsx", false, 0.0, false, 1, "Administrators", "xlsx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", "d", 0L, "", "", ""));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", false, 0.0, false, 1, "Administrator", "docx", 11564L, "04-10-2018", "04-20-2018", "04-24-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx", "test3.xlsx", false, 0.0, false, 1, "Administrators", "xlsx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test4.txt", "test4.txt", false, 0.0, false, 1, "Administrators", "txt", 0L, "04-10-2018", "04-19-2018", "04-19-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test5.docx", true, 0.0, true, 1, "Administrators", "docx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.pdf", "test5.pdf", false, 0.0, false, 1, "Administrators", "pdf", 92172L, "04-20-2018", "04-20-2018", "04-24-2018"));
        List<Asset> resultResultFiles = Whitebox.invokeMethod(searchFiles, "recoverFiles", path, arrayResultFiles);
        for (int i = 0; i < resultResultFiles.size(); i++) {
            assertEquals(expectedResultFiles.get(i).getPath(), resultResultFiles.get(i).getPath());
            assertEquals(expectedResultFiles.get(i).getFileName(), resultResultFiles.get(i).getFileName());
            assertEquals(expectedResultFiles.get(i).getHidden(), resultResultFiles.get(i).getHidden());
            assertEquals(expectedResultFiles.get(i).getReadOnly(), resultResultFiles.get(i).getReadOnly());
            assertEquals(expectedResultFiles.get(i).getTypeFile(), resultResultFiles.get(i).getTypeFile());
            assertEquals(expectedResultFiles.get(i).getOwner(), resultResultFiles.get(i).getOwner());
            if (expectedResultFiles instanceof ResultFile) {
                assertEquals(expectedResultFiles.get(i).getExtension(), resultResultFiles.get(i).getExtension());
                assertEquals(expectedResultFiles.get(i).getCreationTime(), resultResultFiles.get(i).getCreationTime());
                assertEquals(expectedResultFiles.get(i).getLastModifiedTime(), resultResultFiles.get(i).getLastModifiedTime());
                assertEquals(expectedResultFiles.get(i).getLastAccessTime(), resultResultFiles.get(i).getLastAccessTime());
            }
            assertEquals(expectedResultFiles.get(i).getSize(), resultResultFiles.get(i).getSize());
        }
    }

    /**
     * Test in order to show all files of a path.
     */
    /*@Test
    public void testDisplayFilesOfAPath() {
        List<Asset> expected = new ArrayList<>();
        List<Asset> arrayResultFiles = new ArrayList<>();

        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt"
                , "test1-1.txt", false, false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx"
                , "test2-1.docx", false,  false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx"
                , "test3-1.xlsx", false,  false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt"
                , "test1.txt", false,  false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx"
                , "test2.docx", false,  false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));
        expected.add(new ResultFile("src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx"
                , "test3.xlsx", false,  false, 1, "", "txt", 0L, "MM-dd-yyyy", "MM-dd-yyyy", "MM-dd-yyyy", ""));

        assertEquals(expected.get(0).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getPath());
        assertEquals(expected.get(0).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getFileName());
        assertEquals(expected.get(0).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(0).getHidden());
        assertEquals(expected.get(1).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(1).getPath());
        assertEquals(expected.get(1).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(1).getFileName());
        assertEquals(expected.get(1).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(1).getHidden());
        assertEquals(expected.get(2).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(2).getPath());
        assertEquals(expected.get(2).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(2).getFileName());
        assertEquals(expected.get(2).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(2).getHidden());
        assertEquals(expected.get(3).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(3).getPath());
        assertEquals(expected.get(3).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(3).getFileName());
        assertEquals(expected.get(3).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(3).getHidden());
        assertEquals(expected.get(4).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(4).getPath());
        assertEquals(expected.get(4).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(4).getFileName());
        assertEquals(expected.get(4).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(4).getHidden());
        assertEquals(expected.get(5).getPath(), pathFiles.recoverFiles(path, arrayResultFiles).get(5).getPath());
        assertEquals(expected.get(5).getFileName(), pathFiles.recoverFiles(path, arrayResultFiles).get(5).getFileName());
        assertEquals(expected.get(5).getHidden(), pathFiles.recoverFiles(path, arrayResultFiles).get(5).getHidden());
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
        assertEquals();
    }*/
}
