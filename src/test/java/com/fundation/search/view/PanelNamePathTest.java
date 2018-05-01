/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Class to test panel path.
 *
 * @version 30 April 2018  * @Maria Canqui.
 */
public class PanelNamePathTest {
    private PanelNamePath panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelNamePath();
    }
    /**
     * getPath test, validate text area content
     */
    @Test
    public void getPath() {
        panel.setTextFieldPath("C:/");
        assertEquals("C:/", panel.getPath());
    }
    /**
     * getPathDistinct test, validate text area content
     */
    @Test
    public void getPathDistinct() {
        panel.setTextFieldPath("C:/");
        assertNotEquals("D:/", panel.getPath());
    }
    /**
     * getName test, validate name path
     */
    @Test
    public void getName() {
        panel.setTextFieldName("test");
        assertEquals("test", panel.getName());
    }
    /**
     * getNameDistinct test, validate name path
     */
    @Test
    public void getNameDistinct() {
        panel.setTextFieldName("test");
        assertNotEquals("D:/", panel.getName());
    }
    /**
     * getCaseSensitive test, validate case sensitive name
     */
    @Test
    public void getCaseSensitive() {
        panel.setCheckBoxCaseSensitiveName(true);
        assertTrue(panel.getCaseSensitive());
    }
    /**
     * getCaseSensitiveFalse test, validate case sensitive name
     */
    @Test
    public void getCaseSensitiveFalse() {
        panel.setCheckBoxCaseSensitiveName(false);
        assertFalse(panel.getCaseSensitive());
    }
    /**
     * getFileSystem test, validate checkbox file system
     */
    @Test
    public void getFileSystem() {
        panel.setCheckBoxFileSystem(true);
        assertTrue(panel.getFileSystem());
    }
    /**
     * getFileSystemFalse test, validate checkbox file system
     */
    @Test
    public void getFileSystemFalse() {
        panel.setCheckBoxFileSystem(false);
        assertFalse(panel.getFileSystem());
    }
    /**
     * getFileSystem test, validate checkbox file system
     */
    @Test
    public void getBtnGroupTypeFiles() {
        panel.setBtnAllFiles("1");
        assertEquals("1", panel.getBtnGroupTypeFiles());
    }
    /**
     * getFileSystemFalse test, validate checkbox file system
     */
    @Test
    public void getBtnGroupTypeFilesDistinct() {
        panel.setBtnAllFiles("1");
        assertNotEquals("2", panel.getBtnGroupTypeFiles());
    }

}