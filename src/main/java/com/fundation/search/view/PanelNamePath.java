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
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

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
    private JRadioButton radioBoxOnlyFiles;
    private JRadioButton radioBoxOnlyDirectory;
    private JRadioButton radioBoxAllFiles;

    ButtonGroup btnGroupTypeFile;

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
        radioBoxOnlyFiles = new JRadioButton();
        radioBoxOnlyDirectory = new JRadioButton();
        radioBoxAllFiles = new JRadioButton();
        fileChooser = new JFileChooser();
        buttonFileChooser = new JButton();
        btnGroupTypeFile = new ButtonGroup();

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
        labelName.setText(" Name:");
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
                    checkBoxCaseSensitiveName.setSelected(false);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        add(textFieldName, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelPath ----
        labelPath.setText(" Path:");
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
        buttonFileChooser.setPreferredSize(new Dimension(8, 20));
        buttonFileChooser.addActionListener(e -> folderChooser(e));
        add(buttonFileChooser, new TableLayoutConstraints(2, 1, 2, 1,
                TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        //---- Case Sensitive ----
        checkBoxCaseSensitiveName.setText("Case sensitive");
        checkBoxCaseSensitiveName.setEnabled(false);
        add(checkBoxCaseSensitiveName, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- All Files ----
        radioBoxAllFiles.setText("All");
        radioBoxAllFiles.setActionCommand("0");
        radioBoxAllFiles.setSelected(true);
        btnGroupTypeFile.add(radioBoxAllFiles);

        add(radioBoxAllFiles, new TableLayoutConstraints(2, 3, 2, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Only Files ----
        radioBoxOnlyFiles.setText("Only files");
        radioBoxOnlyFiles.setActionCommand("1");
        btnGroupTypeFile.add(radioBoxOnlyFiles);

        add(radioBoxOnlyFiles, new TableLayoutConstraints(0, 3, 0, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Only directory ----
        radioBoxOnlyDirectory.setText("Only directories");
        radioBoxOnlyDirectory.setActionCommand("3");
        btnGroupTypeFile.add(radioBoxOnlyDirectory);
        add(radioBoxOnlyDirectory, new TableLayoutConstraints(1, 3, 1, 3,
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
    public String getBtnGroupTypeFiles() {
        return btnGroupTypeFile.getSelection().getActionCommand();
    }

    //setters
    /**
     * Setter for the name text field file.
     */
    public void setTextFieldName(String textFieldName) {
        this.textFieldName.setText(textFieldName);
    }
    /**
     * Setter for the path text field file.
     */
    public void setTextFieldPath(String textFieldPath) {
        this.textFieldPath.setText(textFieldPath);
    }
    /**
     * Setter for the case sensitive checkbox.
     */
    public void setCheckBoxCaseSensitiveName(boolean checkBoxCaseSensitiveName) {
        this.checkBoxCaseSensitiveName.setSelected(checkBoxCaseSensitiveName);
    }
    /**
     * Setter for the case only files radio buttons.
     */
    public void setBtnAllFiles(String btnAllFiles) {
        if (btnAllFiles.equals("0")) {
            radioBoxAllFiles.setSelected(true);
        }
        if (btnAllFiles.equals("1")) {
            radioBoxOnlyFiles.setSelected(true);
        }
        if (btnAllFiles.equals("3")) {
            radioBoxOnlyDirectory.setSelected(true);
        }
        //this.btnGroupHidden.getSelection().setActionCommand(btnGroupHidden);
    }

}
