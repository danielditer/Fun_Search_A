/**
 * @(#)SearchCriteriaTest.java 04/30/2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * JUnit to test class search criteria.
 * @version April, 30th 2018  * @Manuel Valdez
 */
public class SearchCriteriaTest {
    /**
     * Instance of object search criteria*/
    private SearchCriteria searchCriteria;

    /**
     * Initializes the object search criteria.
     */
    @Before
    public void init() {
        searchCriteria = new SearchCriteria();
    }

    /**
     * Test search criteria name.
     */
    @Test
    public void testGetSearchCriteriaName() {
        String searchCriteriaName = "Search Criteria Name";
        searchCriteria.setSearchCriteriaName(searchCriteriaName);
        assertEquals(searchCriteriaName, searchCriteria.getSearchCriteriaName());
    }

    /**
     * Test name.
     */
    @Test
    public void testGetName() {
        String searchName = "File Name";
        searchCriteria.setName(searchName);
        assertEquals(searchName, searchCriteria.getName());
    }

    /**
     * Test path.
     */
    @Test
    public void testGetPath() {
        String searchPath = "File Path";
        searchCriteria.setPath(searchPath);
        assertEquals(searchPath, searchCriteria.getPath());
    }

    /**
     * Test hidden.
     */
    @Test
    public void testGetHidden() {
        String searchHidden = "1";
        searchCriteria.setHidden(searchHidden);
        assertEquals(searchHidden, searchCriteria.getHidden());
    }

    /**
     * Test read only.
     */
    @Test
    public void testGetReadOnly() {
        String searchReadOnly = "1";
        searchCriteria.setReadOnly(searchReadOnly);
        assertEquals(searchReadOnly, searchCriteria.getReadOnly());
    }

    /**
     * Test type file.
     */
    @Test
    public void testGetTypeFile() {
        int searchTypeFile = 1;
        searchCriteria.setTypeFile(searchTypeFile);
        assertEquals(searchTypeFile, searchCriteria.getTypeFile());
    }

    /**
     * Test name file case sensitive.
     */
    @Test
    public void testGetNameFileCaseSensitive() {
        boolean searchNameFileCaseSensitive = true;
        searchCriteria.setNameFileCaseSensitive(searchNameFileCaseSensitive);
        assertEquals(searchNameFileCaseSensitive, searchCriteria.getNameFileCaseSensitive());
    }

    /**
     * Test file system.
     */
    @Test
    public void testGetFileSystem() {
        boolean searchFileSystem = true;
        searchCriteria.setFileSystem(searchFileSystem);
        assertEquals(searchFileSystem, searchCriteria.getFileSystem());
    }

    /**
     * Test owner.
     */
    @Test
    public void testGetOwner() {
        String searchOwner = "Owner";
        searchCriteria.setOwner(searchOwner);
        assertEquals(searchOwner, searchCriteria.getOwner());
    }

    /**
     * Test extension.
     */
    @Test
    public void testGetExtension() {
        String searchExtension = "txt";
        searchCriteria.setExtension(searchExtension);
        assertEquals(searchExtension, searchCriteria.getExtension());
    }

    /**
     * Test size sign.
     */
    @Test
    public void testGetSizeSign() {
        String searchSizeSign = "minor";
        searchCriteria.setSizeSign(searchSizeSign);
        assertEquals(searchSizeSign, searchCriteria.getSizeSign());
    }

    /**
     * Test size required.
     */
    @Test
    public void testGetSizeRequired() {
        String searchSizeRequired = "1000";
        searchCriteria.setSizeRequired(searchSizeRequired);
        assertEquals(searchSizeRequired, searchCriteria.getSizeRequired());
    }

    /**
     * Test size measure.
     */
    @Test
    public void testGetSizeMeasure() {
        String searchSizeMeasure = "Mb";
        searchCriteria.setSizeMeasure(searchSizeMeasure);
        assertEquals(searchSizeMeasure, searchCriteria.getSizeMeasure());
    }

    /**
     * Test created date.
     */
    @Test
    public void testGetCreatedDate() {
        boolean searchCreateDate = true;
        searchCriteria.setCreateDate(searchCreateDate);
        assertEquals(searchCreateDate, searchCriteria.getCreatedDate());
    }

    /**
     * Test modified date.
     */
    @Test
    public void testGetModifiedDate() {
        boolean searchModifyDate = true;
        searchCriteria.setModifiedDate(searchModifyDate);
        assertEquals(searchModifyDate, searchCriteria.getModifiedDate());
    }

    /**
     * Test accessed date.
     */
    @Test
    public void testGetAccessedDate() {
        boolean searchAccessedDate = true;
        searchCriteria.setAccessedDate(searchAccessedDate);
        assertEquals(searchAccessedDate, searchCriteria.getAccessedDate());
    }

    /**
     * Test from date.
     */
    @Test
    public void testGetFromDate() {
        String searchFromDate = "04-30-2018";
        searchCriteria.setFromDate(searchFromDate);
        assertEquals(searchFromDate, searchCriteria.getFromDate());
    }

    /**
     * Test to date.
     */
    @Test
    public void testGetToDate() {
        String searchToDate = "04-30-2018";
        searchCriteria.setToDate(searchToDate);
        assertEquals(searchToDate, searchCriteria.getToDate());
    }

    /**
     * Test content.
     */
    @Test
    public void testGetContent() {
        String searchContent = "file content";
        searchCriteria.setContent(searchContent);
        assertEquals(searchContent, searchCriteria.getContent());
    }

    /**
     * Test content case sensitive.
     */
    @Test
    public void testGetContentCaseSensitive() {
        boolean searchContentCaseSensitive = false;
        searchCriteria.setContentCaseSensitive(searchContentCaseSensitive);
        assertEquals(searchContentCaseSensitive, searchCriteria.getContentCaseSensitive());
    }

    /**
     * Test video codec.
     */
    @Test
    public void testGetVideoCodec() {
        String searchVideoCodec = "h465";
        searchCriteria.setVideoCodec(searchVideoCodec);
        assertEquals(searchVideoCodec, searchCriteria.getVideoCodec());
    }

    /**
     * Test frame rate.
     */
    @Test
    public void testGetFrameRate() {
        String searchFrameRate = "frame rate";
        searchCriteria.setFrameRate(searchFrameRate);
        assertEquals(searchFrameRate, searchCriteria.getFrameRate());
    }

    /**
     * Test bit rate.
     */
    @Test
    public void testGetBitRate() {
        String searchBitRate = "bit rate";
        searchCriteria.setBitRate(searchBitRate);
        assertEquals(searchBitRate, searchCriteria.getBitRate());
    }

    /**
     * Test video size.
     */
    @Test
    public void testGetVideoSize() {
        String searchVideoSize = "1098x640";
        searchCriteria.setVideoSize(searchVideoSize);
        assertEquals(searchVideoSize, searchCriteria.getVideoSize());
    }

    /**
     * Test aspect ratio.
     */
    @Test
    public void testGetAspectRatio() {
        String searchAspectRatio = "16:3";
        searchCriteria.setAspectRatio(searchAspectRatio);
        assertEquals(searchAspectRatio, searchCriteria.getAspectRatio());
    }

    /**
     * Test audio codec.
     */
    @Test
    public void testGetAudioCodec() {
        String searchAudioCodec = "16:3";
        searchCriteria.setAudioCodec(searchAudioCodec);
        assertEquals(searchAudioCodec, searchCriteria.getAudioCodec());
    }

    /**
     * Test minor duration.
     */
    @Test
    public void testGetMinorDuration() {
        Double searchMinorDuration = 16.0;
        searchCriteria.setMinorDuration(searchMinorDuration);
        assertEquals(searchMinorDuration, searchCriteria.getMinorDuration(), 0);
    }

    /**
     * Test major duration.
     */
    @Test
    public void testGetMajorDuration() {
        Double searchMajorDuration = 20.1;
        searchCriteria.setMajorDuration(searchMajorDuration);
        assertEquals(searchMajorDuration, searchCriteria.getMajorDuration(), 0);
    }
}