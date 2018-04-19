/**
 * @(#)PanelDate.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */

package com.fundation.search.view;

import com.toedter.calendar.JDateChooser;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import java.text.SimpleDateFormat;


/* @version
 * 27 Mar 2018  * @Daniel Caballero.
 * A class that contains the components of the panel "Date".
 */
public class PanelDate extends JPanel {
    private JCheckBox checkBoxCreated;
    private JCheckBox checkBoxModified;
    private JCheckBox checkBoxAccessed;
    private JLabel labelFrom;
    private JLabel labelTo;
    private JDateChooser dateChooserFrom;
    private JDateChooser dateChooserTo;


    /**
     * Class constructor.
     */
    public PanelDate() {
        initComponents();
    }

    /**
     * Initializes panel components.
     */
    public void initComponents() {
        checkBoxCreated = new JCheckBox();
        checkBoxModified = new JCheckBox();
        checkBoxAccessed = new JCheckBox();
        labelFrom = new JLabel();
        labelTo = new JLabel();
        dateChooserFrom = new JDateChooser();
        dateChooserTo = new JDateChooser();


        setBorder(new TitledBorder("Date"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED,
                        TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- checkBoxCreated ----
        checkBoxCreated.setText("Created");
        add(checkBoxCreated, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxModified ----
        checkBoxModified.setText("Modified");
        add(checkBoxModified, new TableLayoutConstraints(3, 0, 3, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxAccessed ----
        checkBoxAccessed.setText("Accesed");

        add(checkBoxAccessed, new TableLayoutConstraints(4, 0, 4, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelFrom ----
        labelFrom.setText("From:");
        add(labelFrom, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));

        add(dateChooserFrom, new TableLayoutConstraints(1, 1, 1, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelTo ----
        labelTo.setText("To:");

        add(labelTo, new TableLayoutConstraints(3, 1,3 , 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(dateChooserTo, new TableLayoutConstraints(4, 1, 4, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

    }
    /**
     * Getter for the created date checkbox.
     * @return the boolean of ´checkBoxCreated´ checkbox.
     */
    public boolean getCheckBoxCreated() {
        return checkBoxCreated.isSelected();
    }
    /**
     * Getter for the las modified checkbox.
     * @return the boolean of ´checkBoxModified´ checkbox.
     */
    public boolean getCheckBoxModified() {
        return checkBoxModified.isSelected();
    }
    /**
     * Getter for the last accessed checkbox.
     * @return the boolean of ´checkBoxAccessed´ checkbox.
     */
    public boolean getCheckBoxAccessed() {
        return checkBoxAccessed.isSelected();
    }
    /**
     * Getter for the start date.
     * @return the boolean of ´formattedTextFieldStart´ checkbox.
     */
    public String getFormattedTextFieldStart() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        return formatDate.format(dateChooserFrom.getDate());
    }
    /**
     * Getter for the en date.
     * @return the boolean of ´formattedTextFieldEnd´ checkbox.
     */
    public String getFormattedTextFieldEnd() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        return formatDate.format(dateChooserTo.getDate());
    }
}
