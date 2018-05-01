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
/**
 * @version 30 Apr 2018  * @Maria Canqui.
 * Class that contains test to validate search criterial panel.
 */
public class PanelSearchCriterialTest {
    private PanelSearchCriterial panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelSearchCriterial();
    }
    /**
     * getButtonLoad test, validate load save.
     */
    @Test
    public void getButtonLoad() {
        assertTrue(panel.getButtonLoad().isVisible());
    }
    /**
     * getButtonSelect test, validate selected save.
     */
    @Test
    public void getButtonSelect() {
        assertTrue(panel.getButtonSelect().isVisible());
    }
    /**
     * getTableResult test, validate table save.
     */
    @Test
    public void getTableResult() {
        assertTrue(panel.getTableResult().isVisible());
    }
    /**
     * getTableModel test, validate table save.
     */
    @Test
    public void getTableModel() {
        assertEquals(2,panel.getTableModel().getColumnCount());
    }
    /**
     * getTableModelDistinct test, validate table save.
     */
    @Test
    public void getTableModelDistinct() {
        assertNotEquals(0,panel.getTableModel().getColumnCount());
    }
}