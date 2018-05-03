/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.controller.LoggerCreator;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
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
        LoggerCreator.getInstance().info(this.getClass().getName(),"Panel attributes created");
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
        radioBoxReadOnly.setActionCommand("1");

        radioBoxReadOnlyNo.setText("Not Read-only");
        radioBoxReadOnlyNo.setActionCommand("2");

        radioBoxReadOnlyAll.setText("All");
        radioBoxReadOnlyAll.setActionCommand("3");

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
        radioBoxHidden.setActionCommand("1");

        radioBoxHiddenNo.setText("Not Hidden");
        radioBoxHiddenNo.setActionCommand("2");

        radioBoxHiddenAll.setText("All");
        radioBoxHiddenAll.setActionCommand("3");

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
        comboBoxSize.addItem("Major");
        add(comboBoxSize, new TableLayoutConstraints(1, 3, 1, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboBoxType.setPreferredSize(new Dimension(50, 20));
        comboBoxType.addItem("Bytes");
        comboBoxType.addItem("Kb");
        comboBoxType.addItem("Mb");
        comboBoxType.addItem("Gb");

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

    //setters

    /**
     * Setter for the extension text field.
     */
    public void setTextFieldExt(String textFieldExt) {
        this.textFieldExt.setText(textFieldExt);
    }
    /**
     * Setter for the size text field.
     */
    public void setTextFieldSize(String textFieldSize) {
        this.textFieldSize.setText(textFieldSize);
    }
    /**
     * Setter for the combo box size ><=.
     */
    public void setComboBoxSize(String comboBoxSize) {
        this.comboBoxSize.setSelectedItem(comboBoxSize);
    }
    /**
     * Setter for the combo box type size.
     */
    public void setComboBoxType(String comboBoxType) {
        this.comboBoxType.setSelectedItem(comboBoxType);
    }
    /**
     * Setter for the owner text field.
     */
    public void setTextFieldOwner(String textFieldOwner) {
        this.textFieldOwner.setText(textFieldOwner);
    }
    /**
     * Setter for the hidden checkbox.
     */
    public void setBtnGroupHidden(String btnGroupHidden) {
        if (btnGroupHidden.equals("1")) {
            radioBoxHidden.setSelected(true);
        }
        if (btnGroupHidden.equals("2")) {
            radioBoxHiddenNo.setSelected(true);
        }
        if (btnGroupHidden.equals("3")) {
            radioBoxHiddenAll.setSelected(true);
        }
        //this.btnGroupHidden.getSelection().setActionCommand(btnGroupHidden);
    }
    /**
     * Setter for the readoly checkbox.
     */
    public void setBtnGroupReadOnly(String btnGroupReadonly) {
        if (btnGroupReadonly.equals("1")) {
            radioBoxReadOnly.setSelected(true);
        }
        if (btnGroupReadonly.equals("2")) {
            radioBoxReadOnlyNo.setSelected(true);
        }
        if (btnGroupReadonly.equals("3")) {
            radioBoxReadOnlyAll.setSelected(true);
        }
        //this.btnGroupRead.getSelection().setActionCommand(btnGroupReadonly);
    }


}
