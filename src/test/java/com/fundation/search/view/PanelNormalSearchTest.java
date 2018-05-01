/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Class to test panel normal search.
 *
 * @version 30 April 2018  * @Maria Canqui.
 */
public class PanelNormalSearchTest {
    private PanelNormalSearch panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelNormalSearch();
    }
    /**
     * getContent test, validate text area content.
     */
    @Test
    public void getContent() {
        panel.setTextAreaContent("test");
        assertEquals("test", panel.getContent());
    }
    /**
     * getContentDistinct test, validate text area content.
     */
    @Test
    public void getContentDistinct() {
        panel.setTextAreaContent("test");
        assertNotEquals("test test", panel.getContent());
    }
    /**
     * getCaseSensitiveContent test, validate checkbox area content.
     */
    @Test
    public void getCaseSensitiveContent() {
        panel.setCheckBoxCaseSensitiveContent(true);
        assertTrue(panel.getCaseSensitiveContent());
    }
    /**
     * getCaseSensitiveContentFalse test, validate checkbox area content.
     */
    @Test
    public void getCaseSensitiveContentFalse() {
        panel.setCheckBoxCaseSensitiveContent(false);
        assertFalse(panel.getCaseSensitiveContent());
    }
    /**
     * getCheckBoxCreated test, validate checkbox creation date.
     */
    @Test
    public void getCheckBoxCreated() {
        panel.setCheckBoxCreatedPanel(true);
        assertTrue(panel.getCheckBoxCreated());
    }
    /**
     * getCheckBoxCreatedFalse test, validate checkbox creation date.
     */
    @Test
    public void getCheckBoxCreatedFalse() {
        panel.setCheckBoxCreatedPanel(false);
        assertFalse(panel.getCheckBoxCreated());
    }
    /**
     * getCheckBoxModified test, validate checkbox modification date.
     */
    @Test
    public void getCheckBoxModified() {
        panel.setCheckBoxModifiedPanel(true);
        assertTrue(panel.getCheckBoxModified());
    }
    /**
     * getCheckBoxModifiedFalse test, validate checkbox modification date.
     */
    @Test
    public void getCheckBoxModifiedFalse() {
        panel.setCheckBoxModifiedPanel(false);
        assertFalse(panel.getCheckBoxModified());
    }
    /**
     * getCheckBoxAccessed test, validate checkbox access date.
     */
    @Test
    public void getCheckBoxAccessed() {
        panel.setCheckBoxAccessedPanel(true);
        assertTrue(panel.getCheckBoxAccessed());
    }
    /**
     * getCheckBoxAccessedFalse test, validate checkbox access date.
     */
    @Test
    public void getCheckBoxAccessedFalse() {
        panel.setCheckBoxAccessedPanel(false);
        assertFalse(panel.getCheckBoxAccessed());
    }
    /**
     * getFormattedTextFieldStart test, validate textfield date.
     */
    @Test
    public void getFormattedTextFieldStart() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserFromPanel(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertEquals("12-12-2018", panel.getFormattedTextFieldStart());
    }
    /**
     * getFormattedTextFieldStartDistinct test, validate textfield date.
     */
    @Test
    public void getFormattedTextFieldStartDistinct() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserFromPanel(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertNotEquals("10-12-2018", panel.getFormattedTextFieldStart());
    }

    /**
     * getFormattedTextFieldEnd test, validate textfield date.
     */
    @Test
    public void getFormattedTextFieldEnd() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserToPanel(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertEquals("12-12-2018", panel.getFormattedTextFieldEnd());
    }
    /**
     * getFormattedTextFieldEndDistinct test, validate textfield date.
     */
    @Test
    public void getFormattedTextFieldEndDistinct() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date date = formatDate.parse("12-12-2018");
            panel.setDateChooserToPanel(date);
        } catch (ParseException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        assertNotEquals("10-12-2018", panel.getFormattedTextFieldEnd());
    }
    /**
     * getCheckBoxReadOnly test, validate readonly checkbox.
     */
    @Test
    public void getCheckBoxReadOnly() {
        panel.setBtnGroupReadOnlyAttributes("1");
        assertEquals("1", panel.getCheckBoxReadOnly());
    }
    /**
     * getCheckBoxReadOnlyDistinct test, validate readonly checkbox.
     */
    @Test
    public void getCheckBoxReadOnlyDistinct() {
        panel.setBtnGroupReadOnlyAttributes("1");
        assertNotEquals("2", panel.getCheckBoxReadOnly());
    }
    /**
     * getCheckBoxHidden test, validate hidden checkbox.
     */
    @Test
    public void getCheckBoxHidden() {
        panel.setBtnGroupHiddenAttributes("1");
        assertEquals("1", panel.getCheckBoxHidden());
    }
    /**
     * getCheckBoxHiddenDistinct test, validate hidden checkbox.
     */
    @Test
    public void getCheckBoxHiddenDistinct() {
        panel.setBtnGroupHiddenAttributes("1");
        assertNotEquals("2", panel.getCheckBoxHidden());
    }

    /**
     * getTextFieldExt test, validate extension textfield.
     */
    @Test
    public void getTextFieldExt() {
        panel.setTextFieldExtAttributes("mp3");
        assertEquals("mp3", panel.getTextFieldExt());
    }
    /**
     * getTextFieldExtDistinct test, validate extension textfield.
     */
    @Test
    public void getTextFieldExtDistinct() {
        panel.setBtnGroupHiddenAttributes("mp3");
        assertNotEquals("txt", panel.getTextFieldExt());
    }
    /**
     * getTextFieldSize test, validate size textfield.
     */
    @Test
    public void getTextFieldSize() {
        panel.setTextFieldSizeAttributes("400");
        assertEquals("400", panel.getTextFieldSize());
    }
    /**
     * getTextFieldSizeDistinct test, validate size textfield.
     */
    @Test
    public void getTextFieldSizeDistinct() {
        panel.setTextFieldSizeAttributes("400");
        assertNotEquals("401", panel.getTextFieldSize());
    }
    /**
     * getComboBoxSize test, validate size textfield.
     */
    @Test
    public void getComboBoxSize() {
        panel.setComboBoxSizeAttributes("Minor");
        assertEquals("Minor", panel.getComboBoxSize());
    }
    /**
     * getComboBoxSizeDistinct test, validate size textfield.
     */
    @Test
    public void getComboBoxSizeDistinct() {
        panel.setComboBoxSizeAttributes("Minor");
        assertNotEquals("2", panel.getComboBoxSize());
    }
    /**
     * getComboBoxType test, validate type textfield.
     */
    @Test
    public void getComboBoxType() {
        panel.setComboBoxTypeAttributes("Mb");
        assertEquals("Mb", panel.getComboBoxType());
    }
    /**
     * getComboBoxTypeDistinct test, validate type textfield.
     */
    @Test
    public void getComboBoxTypeDistinct() {
        panel.setComboBoxTypeAttributes("Mb");
        assertNotEquals("2", panel.getComboBoxType());
    }
    /**
     * getComboBoxType test, validate owner textfield.
     */
    @Test
    public void getTextFieldOwner() {
        panel.setTextFieldOwnerAttributes("Administrator");
        assertEquals("Administrator", panel.getTextFieldOwner());
    }
    /**
     * getComboBoxTypeDistinct test, validate owner textfield.
     */
    @Test
    public void getTextFieldOwnerDistinct() {
        panel.setTextFieldOwnerAttributes("Administrator");
        assertNotEquals("2", panel.getTextFieldOwner());
    }

}
