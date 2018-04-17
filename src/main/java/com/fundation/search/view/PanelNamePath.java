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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * @version 04 Apr 2018  * @Daniel Caballero.
 * Class that contains the components of the Panel "Name/Path".
 */
public class PanelNamePath extends JPanel {
    JLabel labelName;
    JTextField textFieldName;
    JLabel labelPath;
    JTextField textFieldPath;
    JFileChooser fileChooser;
    JButton buttonFileChooser;

    private JCheckBox checkBoxCaseSensitiveName;
    private JCheckBox checkBoxOnlyFiles;
    private JCheckBox checkBoxOnlyDirectory;
    private JTextField pathTextField;

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
        fileChooser = new JFileChooser();
        buttonFileChooser = new JButton();

        fileChooser.setCurrentDirectory(new java.io.File("/"));
        fileChooser.setDialogTitle("Folder chooser for search files");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        setBorder(new TitledBorder("Name/Path"));
        setOpaque(false);
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
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

        textFieldName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String inputText = textFieldName.getText();
                if(inputText.length() > 0) {
                    checkBoxCaseSensitiveName.setEnabled(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String inputText = textFieldName.getText();
                if(inputText.length() == 0) {
                    checkBoxCaseSensitiveName.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
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
        //---- File chooser ----
        buttonFileChooser.setText("...");
        buttonFileChooser.addActionListener(e -> folderChooser(e));
        add(buttonFileChooser, new TableLayoutConstraints(2, 1, 2, 1,
                TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        //---- Case Sensitive ----
        checkBoxCaseSensitiveName.setText("Case sensitive");
        checkBoxCaseSensitiveName.setEnabled(false);
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
     * This method is for open file chooser and search path for folder.
     *
     * @param event, this is event from Action Listener.
     */
    private void folderChooser(ActionEvent event) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            textFieldPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
        } else {
            //loger
        }
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
     * @return buttonSearch.
     */
    public JButton getButtonFileChooser(){
        return buttonFileChooser;
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