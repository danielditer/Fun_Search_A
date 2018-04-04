/**
 * @(#)PanelDate.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */

package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;

/* @version
 * 27 Mar 2018  * @Daniel Caballero.
 * A class that contains the components of the panel "Date".
 */
public class PanelDate extends JPanel {
    private JCheckBox checkBoxCreated;
    private JCheckBox checkBoxModified;
    private JCheckBox checkBoxAccessed;
    private JLabel labelFrom;
    private JFormattedTextField formattedTextFieldStart;
    private JLabel labelTo;
    private JFormattedTextField formattedTextFieldEnd;

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
        formattedTextFieldStart = new JFormattedTextField();
        labelTo = new JLabel();
        formattedTextFieldEnd = new JFormattedTextField();

        setBorder(new TitledBorder("Date"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- checkBoxCreated ----
        checkBoxCreated.setText("Created");
        add(checkBoxCreated, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxModified ----
        checkBoxModified.setText("Modified");
        add(checkBoxModified, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxAccessed ----
        checkBoxAccessed.setText("Accesed");
        final int constraints2 = 4;
        add(checkBoxAccessed, new TableLayoutConstraints(constraints2, 0, constraints2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelFrom ----
        labelFrom.setText("From:");
        add(labelFrom, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        add(formattedTextFieldStart, new TableLayoutConstraints(1, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelTo ----
        labelTo.setText("To:");
        final int constraints1 = 3;
        add(labelTo, new TableLayoutConstraints(constraints1, 1, constraints1, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(formattedTextFieldEnd, new TableLayoutConstraints(constraints2, 1, constraints2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
}
