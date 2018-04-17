/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;

import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class PanelAttributes that contains elements of the attributes panel for the normal search files.
 *
 * @version 27 Mar 2018  * @Daniel Caballero.
 */
public class PanelAttributes extends JPanel{
    private JRadioButton radioBoxReadOnly;
    private JRadioButton radioBoxReadOnlyNo;
    private JRadioButton radioBoxReadOnlyAll;
    private JRadioButton radioBoxHidden;
    private JRadioButton radioBoxHiddenNo;
    private JRadioButton radioBoxHiddenAll;
    private JLabel labelExt;
    private JTextField textFieldExt;
    private JLabel labelSize;
    private JTextField textFieldSize;
    private JComboBox comboBoxSize;
    private JComboBox comboBoxType;
    private JLabel labelOwner;
    private JTextField textFieldOwner;
    ButtonGroup btnGroupHidden;
    ButtonGroup btnGroupRead;

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
        radioBoxReadOnly = new JRadioButton();
        radioBoxHidden = new JRadioButton();
        radioBoxHiddenNo = new JRadioButton();
        radioBoxHiddenAll = new JRadioButton();
        radioBoxReadOnlyNo = new JRadioButton();
        radioBoxReadOnlyAll = new JRadioButton();
        btnGroupHidden = new ButtonGroup();
        btnGroupRead = new ButtonGroup();
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
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- checkBoxReadOnly ----
        radioBoxReadOnly.setText("Read-only");
        radioBoxReadOnlyNo.setText("No Read-only");
        radioBoxReadOnlyAll.setText("All");
        radioBoxReadOnlyAll.setSelected(true);

        btnGroupRead.add(radioBoxReadOnly);
        btnGroupRead.add(radioBoxReadOnlyNo);
        btnGroupRead.add(radioBoxReadOnlyAll);

        add(radioBoxReadOnly, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(radioBoxReadOnlyNo, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(radioBoxReadOnlyAll, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- checkBoxHidden ----
        radioBoxHidden.setText("Hidden");
        radioBoxHiddenNo.setText("No Hidden");
        radioBoxHiddenAll.setText("All");
        radioBoxHiddenAll.setSelected(true);

        btnGroupHidden.add(radioBoxHidden);
        btnGroupHidden.add(radioBoxHiddenNo);
        btnGroupHidden.add(radioBoxHiddenAll);


        add(radioBoxHidden, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(radioBoxHiddenNo, new TableLayoutConstraints(1, 1, 1, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(radioBoxHiddenAll, new TableLayoutConstraints(2, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));


        //---- labelExtension ----
        labelExt.setText("Extension:");
        final Dimension preferredSize = new Dimension(65, 20);
        labelExt.setPreferredSize(preferredSize);
        add(labelExt, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldExtension ----
        textFieldExt.setPreferredSize(preferredSize);
        add(textFieldExt, new TableLayoutConstraints(1, 2, 3, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelSize ----
        labelSize.setText("Size:");
        labelSize.setPreferredSize(preferredSize);
        add(labelSize, new TableLayoutConstraints(0, 3, 0, 3,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldExtension ----
        textFieldSize.setPreferredSize(preferredSize);
        add(textFieldSize, new TableLayoutConstraints(2, 3, 2, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboBoxSize.setPreferredSize(preferredSize);
        comboBoxSize.addItem("Minor");
        comboBoxSize.addItem("Equals");
        comboBoxSize.addItem("Mayor");
        add(comboBoxSize, new TableLayoutConstraints(1, 3, 1, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboBoxType.setPreferredSize(new Dimension(50, 20));
        comboBoxType.addItem("Gb");
        comboBoxType.addItem("Mb");
        add(comboBoxType, new TableLayoutConstraints(3, 3, 3, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelOwner ----
        labelOwner.setText("Owner:");
        labelOwner.setPreferredSize(preferredSize);
        add(labelOwner, new TableLayoutConstraints(0, 4, 0, 4,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldOwner ----
        textFieldOwner.setPreferredSize(preferredSize);
        add(textFieldOwner, new TableLayoutConstraints(1, 4, 3, 4,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

    }

    /**
     * Getter for the read only checkbox.
     *
     * @return a String of ´checkBoxReadOnly´ text field.
     */
    public String getCheckBoxReadOnly() {
        return btnGroupRead.getSelection().getActionCommand();
    }
    /**
     * Getter for the hidden checkbox.
     *
     * @returnta String of ´checkBoxHidden´ text field.
     */
    public String getCheckBoxHidden() {
        return btnGroupHidden.getSelection().getActionCommand();
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
