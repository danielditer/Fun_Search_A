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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
        searchFiles = new SearchFiles();
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
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", false, 0.0, true, 1, "Administrators", "txt", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test2-1.docx", false, 0.0, false, 1, "Administrators", "docx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test3-1.xlsx", "test3-1.xlsx", false, 0.0, false, 1, "Administrators", "xlsx", 0L, "04-10-2018", "04-10-2018", "04-10-2018"));
        expectedResultFiles.add(assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder", "New folder", false, 0.0, false, 3, "Administrators", null, 0L, "", "", ""));
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
     * Test search by file name and if it is case sensitive or not.
     * @throws Exception
     */
    @Test
    public void testModelSearchFile() throws Exception {
        searchCriteria.setName("test1.txt");
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileNoCaseSensitive() throws Exception {
        searchCriteria.setName("TEST1.txt");
        searchCriteria.setNameFileCaseSensitive(false);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileCaseSensitiveNotMatches() throws Exception {
        searchCriteria.setName("TEST1.txt");
        searchCriteria.setNameFileCaseSensitive(true);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        assertFalse(Whitebox.invokeMethod(searchFiles, "searchFile", expected, searchCriteria.getNameFileCaseSensitive()));
    }
    @Test
    public void testModelSearchFileCaseSensitiveMatches() throws Exception {
        searchCriteria.setName("test1.txt");
        searchCriteria.setNameFileCaseSensitive(true);
        searchFiles.setSearchCriteria(searchCriteria);
        AssetFactory assetFactory = new AssetFactory();
        Asset expected = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", false, 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test3.xlsx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test5.docx", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test2-1.docx", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, false, 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
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
        Asset expectedFile = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1.txt", expected.isHidden(), 0.0, !expected.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        Asset expectedFile2 = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\test1.txt", "test1.txt", expected2.isHidden(), 0.0, !expected2.canWrite(), 1, "Administrator", "txt", 1L, "04-10-2018", "04-20-2018", "04-23-2018");
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile, searchCriteria.getReadOnly()));
        assertTrue(Whitebox.invokeMethod(searchFiles, "searchReadOnlyFiles", expectedFile2, searchCriteria.getReadOnly()));
    }
}

