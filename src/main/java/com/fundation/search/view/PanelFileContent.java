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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;

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
        labelComboTypeFile.setText("Type: txt - docx - pdf");
        add(labelComboTypeFile, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboBoxSize ----
        /*comboTypeFile.addItem("txt");
        comboTypeFile.setPreferredSize(new Dimension(20, 20));
        add(comboTypeFile, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));*/

        //======== scrollPaneContent ========
        //---- textAreaContent ----
        scrollPaneContent.setViewportView(textAreaContent);
        add(scrollPaneContent, new TableLayoutConstraints(0, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));


        //
        textAreaContent.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String inputText = textAreaContent.getText();
                if(inputText.length() > 0) {
                    checkBoxCaseSensitive.setEnabled(true);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String inputText = textAreaContent.getText();
                if(inputText.length() == 0) {
                    checkBoxCaseSensitive.setEnabled(false);
                    checkBoxCaseSensitive.setSelected(false);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        //---- checkBoxCaseSensitive ----
        checkBoxCaseSensitive.setText("No Case sensitive");
        add(checkBoxCaseSensitive, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        checkBoxCaseSensitive.setEnabled(false);
        checkBoxCaseSensitive.setSelected(false);
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

     //setters
    /**
     * Setter for the only content textarea.
     */
    public void setTextAreaContent(String textAreaContent) {
        this.textAreaContent.setText(textAreaContent);
    }
    /**
     * Setter for the case sensitive checkbox.
     */
    public void setCheckBoxCaseSensitive(boolean checkBoxCaseSensitive) {
        this.checkBoxCaseSensitive.setSelected(checkBoxCaseSensitive);
    }


}
