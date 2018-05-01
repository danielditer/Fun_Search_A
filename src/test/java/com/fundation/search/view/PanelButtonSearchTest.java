/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JButton;

import static org.junit.Assert.assertTrue;
/**
 * Class to test button search panel.
 *
 * @version 30 April 2018  * @Maria Canqui.
 */
public class PanelButtonSearchTest {
    private PanelButtonSearch panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelButtonSearch();
    }

    /**
     * getButtonSearch test, validate getter button search.
     */
    @Test
    public void getButtonSearch() {
        JButton search = panel.getButtonSearch();
        assertTrue(search.isVisible());
    }

    /**
     * getButtonClear test, validate getter button search.
     */
    @Test
    public void getButtonClear() {
        JButton clear = panel.getButtonClear();
        assertTrue(clear.isVisible());
    }

}