/**
 * @(#)PanelNamePath.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;

import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @version 12 Apr 2018  * @Maria Canqui.
 * Class that contains the components of the Panel "File content".
 */
public class PanelFileContent extends JPanel {
    private JTextArea textAreaContent;
    private JScrollPane scrollPaneContent;
    private JCheckBox checkBoxCaseSensitive;
    private JComboBox comboTypeFile;
    private JLabel labelComboTypeFile;
    /**
     * Class constructor.
     */
    public PanelFileContent() {
        initComponents();
    }
    /**
     * Initializes panel components.
     */
    public void initComponents() {
        textAreaContent = new JTextArea(2, 23);
        scrollPaneContent = new JScrollPane();
        checkBoxCaseSensitive = new JCheckBox();
        comboTypeFile = new JComboBox();
        labelComboTypeFile = new JLabel();


        //---- File content ----
        setBorder(new TitledBorder("File content"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));

        //---- textFieldExtension ----
        labelComboTypeFile.setText("Type");
        add(labelComboTypeFile, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        comboTypeFile.addItem("txt");
        comboTypeFile.setPreferredSize(new Dimension(20, 20));
        add(comboTypeFile, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== scrollPaneContent ========
        //---- textAreaContent ----
        scrollPaneContent.setViewportView(textAreaContent);
        add(scrollPaneContent, new TableLayoutConstraints(0, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxCaseSensitive ----
        checkBoxCaseSensitive.setText("Case sensitive");
        add(checkBoxCaseSensitive, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
    /**
     * Getter for the Case sensitive for the content.
     * @return the boolean of ´textAreaContent´ input.
     */
    public String getContent() {
        return textAreaContent.getText();
    }
    /**
     * Getter for the Case sensitive file content.
     * @return the boolean of ´checkBoxCaseSensitive´ checkbox.
     */
    public Boolean getCaseSensitiveContent() {
        return checkBoxCaseSensitive.isSelected();
    }
}
