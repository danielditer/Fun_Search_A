/**
 * @(#)PanelNamePath.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.controller.LoggerCreator;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.border.TitledBorder;
import java.awt.Dimension;

/**
 * @version 12 Apr 2018  * @Maria Canqui.
 * Class that contains the components of the Panel Save criterial.
 */
public class PanelSaveCriterial extends JPanel {
    JLabel labelName;
    JTextField textFieldName;
    JButton buttonSave;
    /**
     * Class constructor.
     */
    public PanelSaveCriterial() {
        initComponents();
    }

    /**
     * Initializes panel components.
     */
    public void initComponents() {

        LoggerCreator.getInstance().info(this.getClass().getName(),"Panel save criterial created");
        labelName = new JLabel();
        textFieldName = new JTextField();
        buttonSave = new JButton();

        setBorder(new TitledBorder("Save Search Criteria"));
        setOpaque(false);
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- labelName ----
        labelName.setText("Name:");
        labelName.setPreferredSize(new Dimension(240, 20));
        add(labelName, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldName ----
        final Dimension preferredSize = new Dimension(670, 20);
         textFieldName.setPreferredSize(preferredSize);
        add(textFieldName, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button search criterial ----
        buttonSave.setText("Save");
        add(buttonSave, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
    /**
     * Getter for the file name.
     * @return the String of ´textFieldName´ text field.
     */
    public String getName() {
        return textFieldName.getText();
    }
    /**
     * @return buttonSave.
     */
    public JButton getButtonSave(){
        return buttonSave;
    }

    /**
     * Setter for the name text field file.
     */
    public void setTextFieldName(String textFieldName) {
        this.textFieldName.setText(textFieldName);
    }
}
