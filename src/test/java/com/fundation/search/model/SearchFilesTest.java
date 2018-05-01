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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    private SearchCriteria searchCriteria;

    /**
     * Initializes SearchFiles class.
     */
    @Before
    public void initialize() {
        final String filePath = "src/test/java/com/fundation/search/pathTest";
        path = new File(filePath);
        try {
            searchFiles = new SearchFiles();
        } catch (IOException e) {
            e.getMessage();
        }

        searchCriteria = new SearchCriteria();
    }

    /**
     * Test to compare the array of ResultFile objects.
     */
    @Test
    public void testModelRecoverFiles() throws Exception {
        List<Asset> arrayResultFiles = new ArrayList<>();
        List<Asset> expectedResultFiles = new ArrayList<>();
        AssetFactory assetFactory = new AssetFactory();
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test2-1.docx", false, 0.0, false, 1, "Administrators", "docx", 13153L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx", "test3-1.xlsx", false, 0.0, true, 1, "Administrators", "xlsx", 0L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 13172L, "", "", "", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrators", "txt", 460L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", false, 0.0, false, 1, "Administrators", "docx", 11427L, "04-10-2018", "04-20-2018", "04-24-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx", "test3.xlsx", false, 0.0, false, 1, "Administrators", "xlsx", 0L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test4.txt", "test4.txt", false, 0.0, false, 1, "Administrators", "txt", 0L, "04-10-2018", "04-19-2018", "04-19-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test5.docx", true, 0.0, true, 1, "Administrators", "docx", 0L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.pdf", "test5.pdf", false, 0.0, false, 1, "Administrators", "pdf", 92172L, "04-20-2018", "04-20-2018", "04-24-2018", "0.0", "0.0", 0.0, 0, "", "", false));
        List<Asset> resultResultFiles = Whitebox.invokeMethod(searchFiles, "recoverFiles", path, arrayResultFiles);
        for (int i = 0; i < resultResultFiles.size(); i++) {
            assertEquals("i:" + i, expectedResultFiles.get(i).getPath(), resultResultFiles.get(i).getPath());
            assertEquals("i:" + i, expectedResultFiles.get(i).getFileName(), resultResultFiles.get(i).getFileName());
            assertEquals("i:" + i, expectedResultFiles.get(i).getHidden(), resultResultFiles.get(i).getHidden());
            assertEquals("i:" + i, expectedResultFiles.get(i).getReadOnly(), resultResultFiles.get(i).getReadOnly());
            assertEquals("i:" + i, expectedResultFiles.get(i).getTypeFile(), resultResultFiles.get(i).getTypeFile());
            assertEquals("i:" + i, expectedResultFiles.get(i).getOwner(), resultResultFiles.get(i).getOwner());
            if (expectedResultFiles instanceof ResultFile) {
                assertEquals("i:" + i, expectedResultFiles.get(i).getExtension(), resultResultFiles.get(i).getExtension());
                assertEquals("i:" + i, expectedResultFiles.get(i).getCreationTime(), resultResultFiles.get(i).getCreationTime());
                assertEquals("i:" + i, expectedResultFiles.get(i).getLastModifiedTime(), resultResultFiles.get(i).getLastModifiedTime());
                assertEquals("i:" + i, expectedResultFiles.get(i).getLastAccessTime(), resultResultFiles.get(i).getLastAccessTime());
            }
            assertEquals("i:" +i, expectedResultFiles.get(i).getSize(), resultResultFiles.get(i).getSize());
        }
    }

    /**
     * Test search by file name and if it is case sensitive or not.
     * @throws Exception
     */
    @Test
    public void testModelSearchFile() throws Exception {
        searchCriteria.setName("test1.txt");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileNoCaseSensitive() throws Exception {
        searchCriteria.setName("TEST1.txt");
        searchCriteria.setNameFileCaseSensitive(false);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileCaseSensitiveNotMatches() throws Exception {
        searchCriteria.setName("TEST1.txt");
        searchCriteria.setNameFileCaseSensitive(true);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileCaseSensitiveMatches() throws Exception {
        searchCriteria.setName("test1.txt");
        searchCriteria.setNameFileCaseSensitive(true);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }


    /**
     * Test hidden files if it is not set in search criteria, the file should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenFilesNotSetSearchCriteria() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
    }
    /**
     * Test hidden files if it is set in search criteria with 1 -> hidden, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenFilesOnlyHidden() throws Exception {
        searchCriteria.setHidden("1");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile2, searchCriteria.getHidden()));
    }
    /**
     * Test hidden files if it is set in search criteria with 1 -> hidden, the files should not pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenNoHiddenFilesOnlyHidden() throws Exception {
        searchCriteria.setHidden("1");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile2, searchCriteria.getHidden()));
    }
    /**
     * Test hidden files if it is set in search criteria with 2 -> no hidden, the files should not pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenFilesNotHidden() throws Exception {
        searchCriteria.setHidden("2");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile2, searchCriteria.getHidden()));
    }
    /**
     * Test hidden files if it is set in search criteria with 2 -> no hidden, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenNoHiddenFilesNotHidden() throws Exception {
        searchCriteria.setHidden("2");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile2, searchCriteria.getHidden()));
    }
    /**
     * Test hidden files if it is set in search criteria with 3 -> all files, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchHiddenAllFiles() throws Exception {
        searchCriteria.setHidden("3");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile, searchCriteria.getHidden()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchHiddenFiles", expectedFile2, searchCriteria.getHidden()));
    }





    /**
     * Test read only files if it is set in search criteria with 1 -> read only files, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchReadOnlyFiles() throws Exception {
        searchCriteria.setReadOnly("1");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }
    /**
     * Test read only files if it is set in search criteria with 1 -> read only files, the files should not pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchReadOnlyFilesNoReadOnly() throws Exception {
        searchCriteria.setReadOnly("1");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }
    /**
     * Test read only files if it is set in search criteria with 2 -> read only files, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchReadOnlyFilesNoReadOnlyPass() throws Exception {
        searchCriteria.setReadOnly("2");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }
    /**
     * Test read only files if it is set in search criteria with 2 -> read only files, the files should not pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchReadOnlyFilesNoReadOnlyNotPass() throws Exception {
        searchCriteria.setReadOnly("2");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }
    /**
     * Test read only files if it is set in search criteria with 3 -> all files, the files should pass.
     * @throws Exception
     */
    @Test
    public void testModelSearchReadOnlyFilesAll() throws Exception {
        searchCriteria.setReadOnly("3");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        File expected2 = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }


    /**
     * Test search files or directories or all of them, search criteria with 1, search only files, should pass
     * @throws Exception
     */
    @Test
    public void testSearchFilesOrDirectoriesOnlyFilesPass() throws Exception {
        searchCriteria.setTypeFile(1);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile, searchCriteria.getTypeFile()));
    }
    /**
     * Test search files or directories or all of them, search criteria with 1, search only files, should not pass
     * @throws Exception
     */
    @Test
    public void testSearchFilesOrDirectoriesOnlyFilesNotPass() throws Exception {
        searchCriteria.setTypeFile(1);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 0L, "", "", "", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile, searchCriteria.getTypeFile()));
    }
    /**
     * Test search files or directories or all of them, search criteria with 3, search only directories, should pass
     * @throws Exception
     */
    @Test
    public void testSearchFilesOrDirectoriesOnlyDirectoryPass() throws Exception {
        searchCriteria.setTypeFile(3);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 0L, "", "", "", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile, searchCriteria.getTypeFile()));
    }
    /**
     * Test search files or directories or all of them, search criteria with 3, search only directories, should not pass
     * @throws Exception
     */
    @Test
    public void testSearchFilesOrDirectoriesOnlyDirectoryNotPass() throws Exception {
        searchCriteria.setTypeFile(3);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile, searchCriteria.getTypeFile()));
    }
    /**
     * Test search files or directories or all of them, search criteria with 0, search all files, should pass
     * @throws Exception
     */
    @Test
    public void testSearchFilesOrDirectoriesOnlyAllPass() throws Exception {
        searchCriteria.setTypeFile(0);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        Asset expectedFile2 = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 0L, "", "", "", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile, searchCriteria.getTypeFile()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFilesOrDirectoriesOnly", expectedFile2, searchCriteria.getTypeFile()));
    }


    /**
     * Test method to search owner, if owner if null in search criteria, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchOwnerNull() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchOwner", expectedFile, searchCriteria.getOwner()));
    }
    /**
     * Test method to search owner, owner is anything in search criteria, this should not pass.
     * @throws Exception
     */
    @Test
    public void testSearchOwnerNotPass() throws Exception {
        searchCriteria.setOwner("owner");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchOwner", expectedFile, searchCriteria.getOwner()));
    }
    /**
     * Test method to search owner, owner is Administrator in search criteria, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchOwnerPass() throws Exception {
        searchCriteria.setOwner("Administrator");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchOwner", expectedFile, searchCriteria.getOwner()));
    }




    /**
     * Test method to search file's extension, a directory is sent, this should not pass.
     * @throws Exception
     */
    @Test
    public void testSearchExtensionNotFile() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expectedFile2 = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 0L, "", "", "", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchExtension", expectedFile2, searchCriteria.getExtension()));
    }
    /**
     * Test method to search file's extension, a null extension is set in search criteria, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchExtensionNull() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchExtension", expectedFile, searchCriteria.getExtension()));
    }
    /**
     * Test method to search file's extension, a valid file extension is set, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchExtensionTxtExtension() throws Exception {
        searchCriteria.setExtension("txt");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchExtension", expectedFile, searchCriteria.getExtension()));
    }
    /**
     * Test method to search file's extension, a valid file extension (no case sensitive) is set, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchExtensionTxtExtensionNoCaseSensitive() throws Exception {
        searchCriteria.setExtension("TXT");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchExtension", expectedFile, searchCriteria.getExtension()));
    }
    /**
     * Test method to search file's extension, an invalid extension is set, this should not pass.
     * @throws Exception
     */
    @Test
    public void testSearchExtensionDocxExtension() throws Exception {
        searchCriteria.setExtension("docx");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchExtension", expectedFile, searchCriteria.getExtension()));
    }


    /**
     * Test method to search files by its size, null size is set in search criteria, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeNull() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, valid size is set in search criteria, minor, bytes, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeMinorBytesPass() throws Exception {
        searchCriteria.setSizeSign("minor");
        searchCriteria.setSizeRequired("101");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, invalid size is set in search criteria, minor, bytes, this should not pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeMinorBytesNotPass() throws Exception {
        searchCriteria.setSizeSign("minor");
        searchCriteria.setSizeRequired("90");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, valid size is set in search criteria, mayor, bytes, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeMayorBytesPass() throws Exception {
        searchCriteria.setSizeSign("mayor");
        searchCriteria.setSizeRequired("90");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, invalid size is set in search criteria, mayor, bytes, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeMayorBytesNotPass() throws Exception {
        searchCriteria.setSizeSign("mayor");
        searchCriteria.setSizeRequired("101");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, valid size is set in search criteria, equals, bytes, this should pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeEqualsBytesPass() throws Exception {
        searchCriteria.setSizeSign("equals");
        searchCriteria.setSizeRequired("100");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }
    /**
     * Test method to search files by its size, valid size is set in search criteria, equals, bytes, this should not pass.
     * @throws Exception
     */
    @Test
    public void testSearchSizeEqualsBytesNotPass() throws Exception {
        searchCriteria.setSizeSign("equals");
        searchCriteria.setSizeRequired("1001");
        searchCriteria.setSizeMeasure("bytes");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchSize", expectedFile, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure()));
    }


    /**
     * Test search date method, when a null search criteria is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateNull() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-20-2018", "04-23-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDateOutOfBoundaries() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-09-2018");
        searchCriteria.setToDate("04-11-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDateBoundaries() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-10-2018");
        searchCriteria.setToDate("04-10-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDateLessThanFileDate() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-09-2018");
        searchCriteria.setToDate("04-09-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDateLessToDate() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-09-2018");
        searchCriteria.setToDate("04-10-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDateMoreThanFileDate() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-11-2018");
        searchCriteria.setToDate("04-11-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, created date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateCreateDatetoHigherDate() throws Exception {
        searchCriteria.setCreateDate(true);
        searchCriteria.setFromDate("04-10-2018");
        searchCriteria.setToDate("04-11-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }




    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedDateOutOfBoundaries() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-24-2018");
        searchCriteria.setToDate("04-26-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedDateBoundaries() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-25-2018");
        searchCriteria.setToDate("04-25-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedLessThanFileDate() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-24-2018");
        searchCriteria.setToDate("04-24-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedLessToDate() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-24-2018");
        searchCriteria.setToDate("04-25-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedMoreThanFileDate() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-26-2018");
        searchCriteria.setToDate("04-26-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, modified date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateModifiedDateToHigherDate() throws Exception {
        searchCriteria.setModifiedDate(true);
        searchCriteria.setFromDate("04-25-2018");
        searchCriteria.setToDate("04-26-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }



    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedDateOutOfBoundaries() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("04-29-2018");
        searchCriteria.setToDate("05-01-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedDateBoundaries() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("04-30-2018");
        searchCriteria.setToDate("04-30-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedLessThanFileDate() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("04-29-2018");
        searchCriteria.setToDate("04-29-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedLessToFileDate() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("04-28-2018");
        searchCriteria.setToDate("04-30-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedMoreThanFileDate() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("05-02-2018");
        searchCriteria.setToDate("05-02-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }
    /**
     * Test search date method, accessed date is set, all files should pass.
     * @throws Exception
     */
    @Test
    public void testSearchDateAccessedFromFileDate() throws Exception {
        searchCriteria.setAccessedDate(true);
        searchCriteria.setFromDate("04-30-2018");
        searchCriteria.setToDate("05-02-2018");

        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchDate", expectedFile, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate()));
    }


    /**
     * Test for file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testGetFileContentTxt() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertEquals("contenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content",Whitebox.invokeMethod(searchFiles, "getFileContent", expectedFile, expectedFile.getExtension()));
    }
    /**
     * Test for file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testGetFileContentDocx() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertEquals("Only text to prove the docx document\n", Whitebox.invokeMethod(searchFiles, "getFileContent", expectedFile, expectedFile.getExtension()));
    }
    /**
     * Test for file content method, a pdf file.
     * @throws Exception
     */
    @Test
    public void testGetFileContentPdf() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test5.pdf");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.pdf", "test5.pdf", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "pdf", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertEquals("Este archivo va a ser un test para pdf files \n", Whitebox.invokeMethod(searchFiles, "getFileContent", expectedFile, expectedFile.getExtension()));
    }
    /**
     * Test for file content method, a xlsx file.
     * @throws Exception
     */
    @Test
    public void testGetFileContentInvalidExtension() throws Exception {
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx", "test3.xlsx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "xlsx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertNull(Whitebox.invokeMethod(searchFiles, "getFileContent", expectedFile, expectedFile.getExtension()));
    }
    /**
     * Test to search file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testSearchContentTxt() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "contenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testSearchContentTxtNotPasses() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "contenido de test1.txt para de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testSearchContentTxtCaseSensitive() throws Exception {
        searchCriteria.setContentCaseSensitive(true);
        String content = "contenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testSearchContentTxtCaseSensitiveNotPasses() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "contenido de test1.txt PARA pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a txt file.
     * @throws Exception
     */
    @Test
    public void testSearchContentTxtCaseSensitivePasses() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "contenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de contentcontenido de test1.txt para pruebas de content";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }

    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentDocxCaseSensitive() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "Only text to prove the docx document\n";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentDocxCaseSensitiveDoesNotPass() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "Only text to PROVE the docx document\n";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentDocxNoCaseSensitive() throws Exception {
        searchCriteria.setContentCaseSensitive(true);
        String content = "Only text to PROVE the docx document\n";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentNegativeTest() throws Exception {
        searchCriteria.setContentCaseSensitive(true);
        String content = "w";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentNegativeTest2() throws Exception {
        searchCriteria.setContentCaseSensitive(false);
        String content = "w";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentNotResultfile() throws Exception {
        searchCriteria.setContentCaseSensitive(true);
        String content = "w";
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
    /**
     * Test to search file content method, a docx file.
     * @throws Exception
     */
    @Test
    public void testSearchContentContentEmpty() throws Exception {
        searchCriteria.setContentCaseSensitive(true);
        String content = null;
        searchCriteria.setContent(content);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        File expected = new File("src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx");
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test2.docx", "test2.docx", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "docx", 100L, "04-10-2018", "04-25-2018", "04-30-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchContent", expectedFile, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive()));
    }
}

