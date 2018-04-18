/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Class to initialize panel for normal search tab.
 *
 * @version 27 Mar 2018  * @Daniel Caballero.
 */
public class PanelNormalSearch extends JPanel {
    private PanelNamePath panelNamePath;

    private PanelDate panelDate;
    private PanelAttributes panelAttributes;
    private PanelButtonSearch panelButtonSearch;
    private PanelFileContent panelFileContents;
    /**
     * Class constructor to initialize components and set visible this panel.
     */
    public PanelNormalSearch() {
        initComponents();
        setVisible(true);
    }
    /**
     * Initializes panel components.
     */
    public void initComponents() {
        panelNamePath = new PanelNamePath();
        panelFileContents = new PanelFileContent();
        panelDate = new PanelDate();
        panelAttributes = new PanelAttributes();
        panelButtonSearch = new PanelButtonSearch();

        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED}}));
        //======== panelNamePath ========
        add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelFileContent ========
        add(panelFileContents, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelDate ========
        add(panelDate, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelAttributes ========
        final int constraints1 = 3;
        add(panelAttributes, new TableLayoutConstraints(0, constraints1, 0, constraints1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelButtonSearch ========
        add(panelButtonSearch, new TableLayoutConstraints(0, 4, 0, 4,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
    /**
     * Getter for the search button.
     *
     * @return ´buttonSearch´ button.
     */
    public JButton getButtonSearch() {
        return panelButtonSearch.getButtonSearch();
    }
    /**
     * Getter for the path.
     *
     * @return the String of ´textFieldPath´ text field.
     */
    public String getPath() {
        return panelNamePath.getPath();
    }
    /**
     * Getter for the file name.
     *
     * @return the String of ´textFieldName´ text field.
     */
    public String getName() {
        return panelNamePath.getName();
    }
    /**
     * Getter for the case sensitive name.
     *
     * @return ta boolean of ´checkBoxCaseSensitiveName´ text field.
     */
    public boolean getCaseSensitiveName() {
        return panelNamePath.getCaseSensitive();
    }
    /**
     * Getter for the case sensitive name.
     *
     * @return ta boolean of ´checkBoxCaseSensitiveName´ text field.
     */
    public boolean getCheckBoxOnlyFiles() {
        return panelNamePath.getCheckBoxOnlyFiles();
    }
    /**
     * Getter for the case sensitive name.
     *
     * @return ta boolean of ´checkBoxCaseSensitiveName´ text field.
     */
    public boolean getCheckBoxOnlyDirectory() {
        return panelNamePath.getCheckBoxOnlyDirectory();
    }
    /**
     * Getter for the Case sensitive input content.
     * @return the boolean of ´getContent´ method.
     */
    public String getContent() {
        return panelFileContents.getContent();
    }
    /**
     * Getter for the Case sensitive file content.
     * @return the boolean of ´getCaseSensitiveContent´ method.
     */
    public Boolean getCaseSensitiveContent() {
        return panelFileContents.getCaseSensitiveContent();
    }
    /**
     * Getter for the creation date checkbox.
     * @return the boolean of ´getCheckBoxCreated´ method.
     */
    public Boolean getCheckBoxCreated() {
        return panelDate.getCheckBoxCreated();
    }
    /**
     * Getter for the modified date checkbox.
     * @return the boolean of ´getCheckBoxModified´ method.
     */
    public Boolean getCheckBoxModified() {
        return panelDate.getCheckBoxModified();
    }
    /**
     * Getter for the las acceced date checkbox.
     * @return the boolean of ´getCheckBoxAccessed´ method.
     */
    public Boolean getCheckBoxAccessed() {
        return panelDate.getCheckBoxAccessed();
    }
    /**
     * Getter for the date start.
     * @return the boolean of ´getFormattedTextFieldStart´ method.
     */
    public String getFormattedTextFieldStart() {
        return panelDate.getFormattedTextFieldStart();
    }
    /**
     * Getter for the date end.
     * @return the boolean of ´getFormattedTextFieldEnd´ method.
     */
    public String getFormattedTextFieldEnd() {
        return panelDate.getFormattedTextFieldEnd();
    }
    /**
     * Getter for the read only checkbox.
     *
     * @return ta boolean of ´getCheckBoxReadOnly´ text field.
     */
    public String getCheckBoxReadOnly() {
        return panelAttributes.getCheckBoxReadOnly();
    }
    /**
     * Getter for the hidden checkbox.
     *
     * @return ta boolean of ´checkBoxHidden´ text field.
     */
    public String getCheckBoxHidden() {
        return panelAttributes.getCheckBoxHidden();
    }

    /**
     * Getter for the extension type.
     *
     * @return ta boolean of ´textFieldExt´ text field.
     */
    public String getTextFieldExt() {
        return panelAttributes.getTextFieldExt();
    }
    /**
     * Getter for the size file.
     *
     * @return ta boolean of ´textFieldSize´ text field.
     */
    public String getTextFieldSize() {
        return panelAttributes.getTextFieldSize();
    }
    /**
     * Getter for the combobox size.
     *
     * @return ta boolean of ´comboBoxSize´ text field.
     */
    public String getComboBoxSize() {
        return panelAttributes.getComboBoxSize();
    }
    /**
     * Getter for the combobox type size.
     *
     * @return ta boolean of ´comboBoxType´ text field.
     */

    public String getComboBoxType() {
        return panelAttributes.getComboBoxType();
    }
    /**
     * Getter for the owner input.
     *
     * @return ta boolean of ´textFieldOwner´ text field.
     */
    public String getTextFieldOwner() {
        return panelAttributes.getTextFieldOwner();
    }


}
