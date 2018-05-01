/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JPanel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @version 30 Apr 2018  * @Maria Canqui.
 * Class that contains test to validate Main view panel.
 */
public class MainViewTest {
    private MainView panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new MainView();
    }
     /**
     * getPanel test, validate panel search.
     */
    @Test
    public void getPanel() {
        JPanel search = panel.getPanel();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelButton test, validate panel search.
     */
    @Test
    public void getPanelButton() {
        JPanel search = panel.getPanelButton();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelNamePath test, validate panel search.
     */
    @Test
    public void getPanelNamePath() {
        JPanel search = panel.getPanelNamePath();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelResultList test, validate panel search.
     */
    @Test
    public void getPanelResultList() {
        JPanel search = panel.getPanelResultList();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelSearchCriterial test, validate panel search.
     */
    @Test
    public void getPanelSearchCriterial() {
        JPanel search = panel.getPanelSearchCriterial();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelSaveCriterial test, validate panel search.
     */
    @Test
    public void getPanelSaveCriterial() {
        JPanel search = panel.getPanelSaveCriterial();
        assertTrue(search.isVisible());
    }
    /**
     * getPanelSaveCriterial test, validate panel search.
     */
    @Test
    public void getPanelMultimediaSearch() {
        JPanel search = panel.getPanelMultimediaSearch();
        assertFalse(search.isVisible());
    }

}
