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
 * Class that contains test to validate multimedia view panel.
 */
public class PanelMultimediaSearchTest {
    private PanelMultimediaSearch panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelMultimediaSearch();
    }
    /**
     * getName test, validate panel search.
     */
    @Test
    public void getName() {
        assertEquals("", panel.getName());
    }
    /**
     * getNameDistinct test, validate panel search.
     */
    @Test
    public void getNameDistinct() {
        assertNotEquals("test", panel.getName());
    }
    /**
     * getName test, validate panel search.
     */
    @Test
    public void getPath() {
        assertEquals("", panel.getPath());
    }
    /**
     * getNameDistinct test, validate panel search.
     */
    @Test
    public void getPathDistinct() {
        assertNotEquals("test", panel.getPath());
    }
    /**
     * getCodec test, validate panel search.
     */
    @Test
    public void getCodec() {
        assertEquals("All", panel.getCodec());
    }
    /**
     * getCodecDistinct test, validate panel search.
     */
    @Test
    public void getCodecDistinct() {
        assertNotEquals("test", panel.getCodec());
    }
    /**
     * getAudioCodec test, validate panel search.
     */
    @Test
    public void getAudioCodec() {
        assertEquals("All", panel.getAudioCodec());
    }
    /**
     * getAudioCodecDistinct test, validate panel search.
     */
    @Test
    public void getAudioCodecDistinct() {
        assertNotEquals("test", panel.getAudioCodec());
    }
    /**
     * getResolution test, validate panel search.
     */
    @Test
    public void getResolution() {
        assertEquals("All", panel.getResolution());
    }
    /**
     * getResolutionDistinct test, validate panel search.
     */
    @Test
    public void getResolutionDistinct() {
        assertNotEquals("test", panel.getResolution());
    }
    /**
     * getFrameRate test, validate panel search.
     */
    @Test
    public void getFrameRate() {
        assertEquals("All", panel.getFrameRate());
    }
    /**
     * getFrameRateDistinct test, validate panel search.
     */
    @Test
    public void getFrameRateDistinct() {
        assertNotEquals("test", panel.getFrameRate());
    }
    /**
     * getFrameRate test, validate panel search.
     */
    @Test
    public void getBitRate() {
        assertEquals("0.0", panel.getBitRate());
    }
    /**
     * getFrameRateDistinct test, validate panel search.
     */
    @Test
    public void getBitRateDistinct() {
        assertNotEquals("test", panel.getBitRate());
    }
    /**
     * getAspectRatio test, validate panel search.
     */
    @Test
    public void getAspectRatio() {
        assertEquals("All", panel.getAspectRatio());
    }
    /**
     * getAspectRatioDistinct test, validate panel search.
     */
    @Test
    public void getAspectRatioDistinct() {
        assertNotEquals("test", panel.getAspectRatio());
    }
    /**
     * getAspectRatio test, validate panel search.
     */
    @Test
    public void getMinorDuration() {
        double caso = 0.0;
        assertEquals(caso, panel.getMinorDuration(), 0);
    }
    /**
     * getAspectRatioDistinct test, validate panel search.
     */
    @Test
    public void getMinorDurationDistinct() {
        assertNotEquals("test", panel.getMinorDuration());
    }
    /**
     * getAspectRatio test, validate panel search.
     */
    @Test
    public void getMajorDuration() {
        assertEquals(0.0, panel.getMajorDuration(), 0);
    }
    /**
     * getAspectRatioDistinct test, validate panel search.
     */
    @Test
    public void getMajorDurationDistinct() {
        assertNotEquals("test", panel.getMajorDuration());
    }
}
