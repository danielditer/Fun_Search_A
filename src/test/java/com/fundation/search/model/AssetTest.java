/**
 * @(#)AssetTest.java 04/30/2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit to test class asset.
 * @version April, 30th 2018  * @Manuel Valdez
 */
public class AssetTest {
    /**
     * Instance of object asset*/
    private Asset asset;

    /**
     * Initializes the object asset.
     */
    @Before
    public void init() {
        asset = new Asset("path", "name", true, false, 1, "owner", 1L, "04-30-2018", "05-30-2018", "06-30-2018", true);
    }

    /**
     * Test get path.
     */
    @Test
    public void testGetPath() {
        assertEquals("path", asset.getPath());
    }

    /**
     * Test get file name.
     */
    @Test
    public void testGetFileName() {
        assertEquals("name", asset.getFileName());
    }

    /**
     * Test get hidden.
     */
    @Test
    public void testGetHidden() {
        assertTrue(asset.getHidden());
    }

    /**
     * Test get read only.
     */
    @Test
    public void testGetReadOnly() {
        assertFalse(asset.getReadOnly());
    }

    /**
     * Test get type file.
     */
    @Test
    public void testGetTypeFile() {
        assertEquals(1, asset.getTypeFile());
    }

    /**
     * Test get owner.
     */
    @Test
    public void testGetOwner() {
        assertEquals("owner", asset.getOwner());
    }

    /**
     * Test get size.
     */
    @Test
    public void testGetSize() {
        assertEquals(1L, asset.getSize());
    }

    /**
     * Test get creation time.
     */
    @Test
    public void testGetCreationTime() {
        assertEquals("04-30-2018", asset.getCreationTime());
    }

    /**
     * Test get last modified time.
     */
    @Test
    public void testGetLastModifiedTime() {
        assertEquals("05-30-2018", asset.getLastModifiedTime());
    }

    /**
     * Test get last accessed time.
     */
    @Test
    public void testGetLastAccessTime() {
        assertEquals("06-30-2018", asset.getLastAccessTime());
    }

    /**
     * Test get file system.
     */
    @Test
    public void testGetFileSystem() {
        assertTrue(asset.getFileSystem());
    }
}