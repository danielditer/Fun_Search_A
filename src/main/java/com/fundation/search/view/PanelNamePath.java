/**
 * @(#)PanelNamePath.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;

/**
 * @version 04 Apr 2018  * @Daniel Caballero.
 * Class that contains the components of the Panel "Name/Path".
 */
public class PanelNamePath extends JPanel {
    JLabel labelName;
    JTextField textFieldName;
    JLabel labelPath;
    JTextField textFieldPath;

    private JCheckBox checkBoxCaseSensitiveName;
    private JCheckBox checkBoxOnlyFiles;
    private JCheckBox checkBoxOnlyDirectory;

    /**
     * Class constructor.
     */
    public PanelNamePath() {
        initComponents();
    }

    /**
     * Initializes panel components.
     */
    public void initComponents() {
        labelName = new JLabel();
        textFieldName = new JTextField();
        labelPath = new JLabel();
        textFieldPath = new JTextField();
        checkBoxCaseSensitiveName = new JCheckBox();
        checkBoxOnlyFiles = new JCheckBox();
        checkBoxOnlyDirectory = new JCheckBox();

        setBorder(new TitledBorder("Name/Path"));
        setOpaque(false);
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- labelName ----
        labelName.setText("Name:");
        final Dimension preferredSize = new Dimension(120, 20);
        labelName.setPreferredSize(preferredSize);
        add(labelName, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldName ----
        textFieldName.setPreferredSize(preferredSize);
        add(textFieldName, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelPath ----
        labelPath.setText("Path:");
        add(labelPath, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        //---- textFieldPath ----
        textFieldPath.setPreferredSize(preferredSize);
        add(textFieldPath, new TableLayoutConstraints(1, 1, 1, 1,
                TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        //---- Case Sensitive ----
        checkBoxCaseSensitiveName.setText("Case sensitive");
        add(checkBoxCaseSensitiveName, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Only Files ----
        checkBoxOnlyFiles.setText("Only files");
        add(checkBoxOnlyFiles, new TableLayoutConstraints(0, 3, 0, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Only directory ----
        checkBoxOnlyDirectory.setText("Only directory");
        add(checkBoxOnlyDirectory, new TableLayoutConstraints(1, 3, 1, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    /**
     * Getter for the path.
     * @return the String of ´textFieldPath´ text field.
     */
    public String getPath() {
        return textFieldPath.getText();
    }

    /**
     * Getter for the file name.
     * @return the String of ´textFieldName´ text field.
     */
    public String getName() {
        return textFieldName.getText();
    }
    /**
     * Getter for the Case sensitive file name.
     * @return the boolean of ´checkBoxCaseSensitiveName´ checkbox.
     */
    public boolean getCaseSensitive() {
        return checkBoxCaseSensitiveName.isSelected();
    }
    /**
     * Getter for the only files search checkbox.
     * @return the boolean of ´checkBoxOnlyFiles´ checkbox.
     */
    public boolean getCheckBoxOnlyFiles() {
        return checkBoxOnlyFiles.isSelected();
    }
    /**
     * Getter for the only Directory search checkbox.
     * @return the boolean of ´checkBoxOnlyDirectory´ checkbox.
     */
    public boolean getCheckBoxOnlyDirectory() {
        return checkBoxOnlyDirectory.isSelected();
    }
}