package com.fundation.search.view;

import com.fundation.search.common.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PanelAttributesTest {
    private PanelAttributes panel;

    /**
     * method to initialize object.
     */
    @Before
    public void init() {
        panel = new PanelAttributes();
    }

    /**
     * getCheckBoxReadOnly test, validate getter radio read only.
     */
    @Test
    public void getCheckBoxReadOnly() {
        panel.setBtnGroupReadOnly("1");
        assertEquals("1", panel.getCheckBoxReadOnly());
    }
    /**
     * getCheckBoxReadOnlyDistinct test, validate getter radio read only.
     */
    @Test
    public void getCheckBoxReadOnlyDistinct() {
        panel.setBtnGroupReadOnly("1");
        assertNotEquals("2", panel.getCheckBoxReadOnly());
    }

    /**
     * getCheckBoxHidden test, validate getter radio hidden.
     */
    @Test
    public void getCheckBoxHidden() {
        panel.setBtnGroupHidden("1");
        assertEquals("1", panel.getCheckBoxHidden());
    }
    /**
     * getCheckBoxHiddenDistinct test, validate getter radio hidden.
     */
    @Test
    public void getCheckBoxHiddenDistinct() {
        panel.setBtnGroupHidden("1");
        assertNotEquals("2", panel.getCheckBoxHidden());
    }
    /**
     * getTextFieldExt test, validate getter file extension.
     */
    @Test
    public void getTextFieldExt() {
        panel.setTextFieldExt("txt");
        assertEquals("txt", panel.getTextFieldExt());
    }
    /**
     * getTextFieldExtDistinct test, validate getter file extension.
     */
    @Test
    public void getTextFieldExtDistinct() {
        panel.setBtnGroupHidden("txt");
        assertNotEquals("mp3", panel.getTextFieldExt());
    }
    /**
     * getTextFieldSize test, validate getter file extension.
     */
    @Test
    public void getTextFieldSize() {
        panel.setTextFieldSize("400");
        assertEquals("400", panel.getTextFieldSize());
    }
    /**
     * getTextFieldSizeDistinct test, validate getter file extension.
     */
    @Test
    public void getTextFieldSizeDistinct() {
        panel.setTextFieldSize("100");
        assertNotEquals("mp3", panel.getTextFieldSize());
    }

    /**
     * getComboBoxSize test, validate getter file validator.
     */
    @Test
    public void getComboBoxSize() {
        panel.setComboBoxSize("Minor");
        assertEquals("Minor", panel.getComboBoxSize());
    }
    /**
     * getComboBoxSizeDistinct test, validate getter file validator.
     */
    @Test
    public void getComboBoxSizeDistinct() {
        panel.setComboBoxSize("Minor");
        assertNotEquals("mp3", panel.getComboBoxSize());
    }

    /**
     * getComboBoxType test, validate getter size type.
     */
    @Test
    public void getComboBoxType() {
        panel.setComboBoxType("Mb");
        assertEquals("Mb", panel.getComboBoxType());
    }
    /**
     * getComboBoxTypeDistinct test, validate getter size type.
     */
    @Test
    public void getComboBoxTypeDistinct() {
        panel.setComboBoxType("Mb");
        assertNotEquals("mp3", panel.getComboBoxType());
    }

    /**
     * getTextFieldOwner test, validate getter owner.
     */
    @Test
    public void getTextFieldOwner() {
        panel.setTextFieldOwner("Administrator");
        assertEquals("Administrator", panel.getTextFieldOwner());
    }
    /**
     * getTextFieldOwnerDistinct test, validate getter owner.
     */
    @Test
    public void getTextFieldOwnerDistinct() {
        panel.setTextFieldOwner("Administrator");
        assertNotEquals("mp3", panel.getTextFieldOwner());
    }
}