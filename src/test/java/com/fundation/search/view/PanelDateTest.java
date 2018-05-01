/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class to test panel date.
 *
 * @version 30 April 2018  * @Maria Canqui.
 */

public class PanelDateTest {
    private PanelDate panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelDate();
    }
    /**
     * getCheckBoxCreated test, validate check box created date.
     */
    @Test
    public void getCheckBoxCreated() {
        panel.setCheckBoxCreated(true);
        assertTrue(panel.getCheckBoxCreated());
    }
    /**
     * getCheckBoxCreatedFalse test, validate check box created date.
     */
    @Test
    public void getCheckBoxCreatedFalse() {
        panel.setCheckBoxCreated(false);
        assertFalse(panel.getCheckBoxCreated());
    }

    /**
     * getCheckBoxModified test, validate getter check box modified date.
     */
    @Test
    public void getCheckBoxModified() {
        panel.setCheckBoxModified(true);
        assertTrue(panel.getCheckBoxModified());
    }
    /**
     * getCheckBoxModifiedFalse test, validate getter check box modified date.
     */
    @Test
    public void getCheckBoxModifiedFalse() {
        panel.setCheckBoxModified(false);
        assertFalse(panel.getCheckBoxModified());
    }
    /**
     * getCheckBoxAccessed test, validate getter check box accessed date.
     */
    @Test
    public void getCheckBoxAccessed() {
        panel.setCheckBoxAccessed(true);
        assertTrue(panel.getCheckBoxAccessed());
    }
    /**
     * getCheckBoxAccessedFalse test, validate getter check box accessed date.
     */
    @Test
    public void getCheckBoxAccessedFalse() {
        panel.setCheckBoxAccessed(false);
        assertFalse(panel.getCheckBoxAccessed());
    }

    /**
     * getFormattedTextFieldStart test, validate getter date from.
     */
    @Test
    public void getFormattedTextFieldStart() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserFrom(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertEquals("12-12-2018", panel.getFormattedTextFieldStart());
    }
    /**
     * getFormattedTextFieldStart test, validate getter date from.
     */
    @Test
    public void getFormattedTextFieldStartDistinct() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserFrom(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertNotEquals("11-12-2018", panel.getFormattedTextFieldStart());
    }


    /**
     * getFormattedTextFieldStart test, validate getter date from.
     */
    @Test
    public void getFormattedTextFieldEnd() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserTo(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertEquals("12-12-2018", panel.getFormattedTextFieldEnd());
    }
    /**
     * getFormattedTextFieldStart test, validate getter date from.
     */
    @Test
    public void getFormattedTextFieldEndDistinct() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserTo(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertNotEquals("11-12-2018", panel.getFormattedTextFieldEnd());
    }



}