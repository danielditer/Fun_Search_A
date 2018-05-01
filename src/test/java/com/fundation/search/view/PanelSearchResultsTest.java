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

/**
 * @version 30 Apr 2018  * @Maria Canqui.
 * Class that contains test to validate search criterial panel.
 */
public class PanelSearchResultsTest {
    private PanelSearchResults panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelSearchResults();
    }
    /**
     * getTableModel test, validate table model.
     */
    @Test
    public void getTableModel() {
        assertEquals(16, panel.getTableModel().getColumnCount());
    }
    /**
     * getTableModelDistinct test, validate table model.
     */
    @Test
    public void getTableModelDistinct() {
        assertNotEquals(0, panel.getTableModel().getColumnCount());
    }

}
