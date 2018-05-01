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
 * Class that contains test to validate save criterial panel.
 */
public class PanelSaveCriterialTest {
    private PanelSaveCriterial panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelSaveCriterial();
    }
    /**
     * getName test, validate name content.
     */
    @Test
    public void getName() {
        panel.setTextFieldName("test");
        assertEquals("test", panel.getName());
    }
    /**
     * getNameDistinct test, validate name content.
     */
    @Test
    public void getNameDistinct() {
        panel.setTextFieldName("test");
        assertNotEquals("test test", panel.getName());
    }
    /**
     * getButtonSave test, validate button save.
     */
    @Test
    public void getButtonSave() {
        assertTrue(panel.getButtonSave().isVisible());
    }


}