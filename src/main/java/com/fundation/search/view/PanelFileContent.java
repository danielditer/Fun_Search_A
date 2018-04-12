/**
 * @(#)PanelNamePath.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

import javax.swing.border.TitledBorder;

/**
 * @version 12 Apr 2018  * @Maria Canqui.
 * Class that contains the components of the Panel "File content".
 */
public class PanelFileContent extends JPanel {
    private JTextArea textAreaContent;
    private JScrollPane scrollPaneContent;
    private JCheckBox checkBoxCaseSensitive;
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

        setBorder(new TitledBorder("File content"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //======== scrollPaneContent ========
        //---- textAreaContent ----
        scrollPaneContent.setViewportView(textAreaContent);
        add(scrollPaneContent, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxCaseSensitive ----
        checkBoxCaseSensitive.setText("Case sensitive");
        add(checkBoxCaseSensitive, new TableLayoutConstraints(0, 1, 0, 1,
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
