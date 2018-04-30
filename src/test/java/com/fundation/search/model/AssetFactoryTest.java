/**
 * @(#)SearchFilesTest.java 04/30/2018
 * <p>
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit class developed in order to test method of asset factory class.
 *
 * @version April, 30th 2018  * @Manuel Valdez
 */
public class AssetFactoryTest {
    /**
     * Instance of object asset factory*/
    private AssetFactory assetFactory;

    /**
     * Initializes the object asset factory.
     */
    @Before
    public void init() {
        assetFactory = new AssetFactory();
    }

    /**
     * Method to test if a result file is instanced.
     */
    @Test
    public void testGetAssetResultFile() {
        Asset asset = assetFactory.getAsset("file", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(asset instanceof ResultFile);
    }
    /**
     * Method to test if a result multimedia file is instanced.
     */
    @Test
    public void testGetAssetResultMultimediaFile() {
        Asset asset = assetFactory.getAsset("multimedia", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(asset instanceof ResultMultimediaFile);
    }
    /**
     * Method to test if a result directory is instanced.
     */
    @Test
    public void testGetAssetResultDirectory() {
        Asset asset = assetFactory.getAsset("directory", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertTrue(asset instanceof ResultDirectory);
    }
    /**
     * Method to test if a result directory is instanced.
     */
    @Test
    public void testGetAssetNullAssetType() {
        Asset asset = assetFactory.getAsset(null, "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertNull(asset);
    }
    /**
     * Method to test if a result directory is instanced.
     */
    @Test
    public void testGetAssetInvalidAssetType() {
        Asset asset = assetFactory.getAsset("otherfile", "src\\test\\java\\com\\fundation\\search\\pathTest\\New folder\\test1-1.txt", "test1-1.txt", true, 0.0, false, 1, "Administrators", "txt", 19L, "04-10-2018", "04-10-2018", "04-10-2018", "0.0", "0.0", 0.0, 0, "", "", false);
        assertNull(asset);
    }
}