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
 * Class to test panel content.
 *
 * @version 30 April 2018  * @Maria Canqui.
 */
public class PanelFileContentTest {
    private PanelFileContent panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelFileContent();
    }
    /**
     * getContent test, validate text area content
     */
    @Test
    public void getContent() {
        panel.setTextAreaContent("test");
        assertEquals("test", panel.getContent());
    }
    /**
     * getContent test, validate text area content
     */
    @Test
    public void getContentDistinct() {
        panel.setTextAreaContent("test");
        assertNotEquals("test test", panel.getContent());
    }
    /**
     * getContent test, validate text area content
     */
    @Test
    public void getCaseSensitiveContent() {
        panel.setCheckBoxCaseSensitive(true);
        assertTrue(panel.getCaseSensitiveContent());
    }
    /**
     * getContent test, validate text area content
     */
    @Test
    public void getCaseSensitiveContentDistinct() {
        panel.setCheckBoxCaseSensitive(false);
        assertFalse(panel.getCaseSensitiveContent());
    }

}
