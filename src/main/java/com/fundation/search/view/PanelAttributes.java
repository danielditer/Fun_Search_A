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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;
import java.awt.Dimension;

public class PanelAttributes extends JPanel{
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxReadOnlyNo;
    private JCheckBox checkBoxHidden;
    private JCheckBox checkBoxHiddenNo;
    private JLabel labelExt;
    private JTextField textFieldExt;
    private JLabel labelSize;
    private JTextField textFieldSize;
    private JComboBox comboBoxSize;
    private JComboBox comboBoxType;
    private JLabel labelOwner;
    private JTextField textFieldOwner;

    /**
     * Class constructor.
     */
    public PanelAttributes() {
        initComponents();
    }

    /**
     * Initializes panel components.
     */
    public void initComponents(){
        checkBoxReadOnly = new JCheckBox();
        checkBoxHidden = new JCheckBox();
        checkBoxHiddenNo = new JCheckBox();
        checkBoxReadOnlyNo = new JCheckBox();
        labelExt = new JLabel();
        textFieldExt = new JTextField();
        labelSize = new JLabel();
        textFieldSize = new JTextField();
        comboBoxSize = new JComboBox();
        comboBoxType = new JComboBox();
        labelOwner = new JLabel();
        textFieldOwner = new JTextField();

        setBorder(new TitledBorder("Attributes"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- checkBoxReadOnly ----
        checkBoxReadOnly.setText("Read-only");
        add(checkBoxReadOnly, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxReadOnly ----
        checkBoxReadOnlyNo.setText("No RO.");
        add(checkBoxReadOnlyNo, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxHidden ----
        checkBoxHidden.setText("Hidden");
        add(checkBoxHidden, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxHiddenNo ----
        checkBoxHiddenNo.setText("No h.");
        add(checkBoxHiddenNo, new TableLayoutConstraints(3, 0, 3, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelExtension ----
        labelExt.setText("Extension:");
        final Dimension preferredSize = new Dimension(65, 20);
        labelExt.setPreferredSize(preferredSize);
        add(labelExt, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldExtension ----
        textFieldExt.setPreferredSize(preferredSize);
        add(textFieldExt, new TableLayoutConstraints(1, 1, 3, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelSize ----
        labelSize.setText("Size:");
        labelSize.setPreferredSize(preferredSize);
        add(labelSize, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldExtension ----
        textFieldSize.setPreferredSize(preferredSize);
        add(textFieldSize, new TableLayoutConstraints(2, 2, 2, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboBoxSize.setPreferredSize(preferredSize);
        comboBoxSize.addItem("Minor");
        comboBoxSize.addItem("Equals");
        comboBoxSize.addItem("Mayor");
        add(comboBoxSize, new TableLayoutConstraints(1, 2, 1, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboBoxType.setPreferredSize(new Dimension(50, 20));
        comboBoxType.addItem("Gb");
        comboBoxType.addItem("Mb");
        add(comboBoxType, new TableLayoutConstraints(3, 2, 3, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelOwner ----
        labelOwner.setText("Owner:");
        labelOwner.setPreferredSize(preferredSize);
        add(labelOwner, new TableLayoutConstraints(0, 3, 0, 3,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldOwner ----
        textFieldOwner.setPreferredSize(preferredSize);
        add(textFieldOwner, new TableLayoutConstraints(1, 3, 3, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

    }
    /**
     * Getter for the read only checkbox.
     *
     * @return ta boolean of ´checkBoxReadOnly´ text field.
     */
    public boolean getCheckBoxReadOnly() {
        return checkBoxReadOnly.isSelected();
    }
    /**
     * Getter for the hidden checkbox.
     *
     * @return ta boolean of ´checkBoxHidden´ text field.
     */
    public boolean getCheckBoxHidden() {
        return checkBoxHidden.isSelected();
    }
    /**
     * Getter for the no hidden checkbox.
     *
     * @return ta boolean of ´checkBoxHiddenNo´ text field.
     */
    public boolean getCheckBoxNoHidden() {
        return checkBoxHiddenNo.isSelected();
    }
    /**
     * Getter for the no readonly checkbox.
     *
     * @return ta boolean of ´checkBoxReadOnlyNo´ text field.
     */
    public boolean checkBoxReadOnlyNo() {
        return checkBoxReadOnlyNo.isSelected();
    }
    /**
     * Getter for the extension type.
     *
     * @return ta boolean of ´textFieldExt´ text field.
     */
    public String getTextFieldExt() {
        return textFieldExt.getText();
    }
    /**
     * Getter for the size file.
     *
     * @return ta boolean of ´textFieldSize´ text field.
     */
    public String getTextFieldSize() {
        return textFieldSize.getText();
    }
    /**
     * Getter for the combobox size.
     *
     * @return ta boolean of ´comboBoxSize´ text field.
     */
    public String getComboBoxSize() {
        return comboBoxSize.getSelectedItem().toString();
    }
    /**
     * Getter for the combobox type size.
     *
     * @return ta boolean of ´comboBoxType´ text field.
     */

    public String getComboBoxType() {
        return comboBoxType.getSelectedItem().toString();
    }
    /**
     * Getter for the owner input.
     *
     * @return ta boolean of ´textFieldOwner´ text field.
     */
    public String getTextFieldOwner() {
        return textFieldOwner.getText();
    }
}
