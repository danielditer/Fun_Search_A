/**
 * @(#)ResultMultimediaFileTest.java 01/05/2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;

/**
 * JUnit to test class asset.
 * @version May, 1st 2018  * @Manuel Valdez
 */
public class ResultMultimediaFileTest {
    /**
     * Instance of object ResultMultimediaFile*/
    private ResultMultimediaFile resultMultimediaFile;
    /**
     * Initializes the object ResultMultimediaFile.
     */
    @Before
    public void init() {
        resultMultimediaFile = new ResultMultimediaFile("C:\\", "test.mpg", false, 55.0, 2, "Owner", "mpg", 1000L, "10-10-2017", "10-11-2017",  "10-12-2017", "videocodec", "audiocodec", 8.0, 1, "1090x780" , "ratio", false);
    }

    /**
     * Test get duration method.
     */
    @Test
    public void testGetDuration() {
        assertEquals(55.0, resultMultimediaFile.getDuration(), 0);
        assertNotEquals(50.0, resultMultimediaFile.getDuration(), 0);
    }
    /**
     * Test get extension method.
     */
    @Test
    public void testGetExtension() {
        assertEquals("mpg", resultMultimediaFile.getExtension());
        assertNotEquals("txt", resultMultimediaFile.getExtension());
    }
    /**
     * Test get video codec method.
     */
    @Test
    public void testGetVideoCodec() {
        assertEquals("videocodec", resultMultimediaFile.getVideoCodec());
        assertNotEquals("xxxxxxx", resultMultimediaFile.getVideoCodec());
    }
    /**
     * Test get audio codec method.
     */
    @Test
    public void testGetAudioCodec() {
        assertEquals("audiocodec", resultMultimediaFile.getAudioCodec());
        assertNotEquals("xxxxxxx", resultMultimediaFile.getAudioCodec());
    }
    /**
     * Test get frame rate method.
     */
    @Test
    public void testGetFrameRate() {
        assertEquals(8.0, resultMultimediaFile.getFrameRate(), 0);
        assertNotEquals(0.0, resultMultimediaFile.getFrameRate(), 0);
    }
    /**
     * Test get aspect ratio method.
     */
    @Test
    public void testGetAspectRatio() {
        assertEquals("ratio", resultMultimediaFile.getAspectRatio());
        assertNotEquals("xxxxxxx", resultMultimediaFile.getAspectRatio());
    }
    /**
     * Test get video size method.
     */
    @Test
    public void testGetVideoSize() {
        assertEquals("1090x780", resultMultimediaFile.getVideoSize());
        assertNotEquals("xxxxxxx", resultMultimediaFile.getVideoSize());
    }
    /**
     * Test get audio bit rate method.
     */
    @Test
    public void testGetAudioBitRate() {
        assertEquals(1, resultMultimediaFile.getAudioBitRate());
        assertNotEquals(0, resultMultimediaFile.getAudioBitRate());
    }
    /**
     * Test get file system method.
     */
    @Test
    public void testGetFileSystem() {
        assertFalse(resultMultimediaFile.getFileSystem());
    }
}