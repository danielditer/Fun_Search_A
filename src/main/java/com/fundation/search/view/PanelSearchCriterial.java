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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;


/**
 * @version 12 Apr 2018  * @Maria Canqui.
 * Class that contains the components of the Panel Search criterial.
 */
public class PanelSearchCriterial extends JPanel {
    JLabel labelName;
    JTextField textFieldName;
    private DefaultTableModel tableModel;
    private JTable tableResult;
    JButton buttonSelect;
    JButton buttonSearch;
    JButton buttonLoad;
    /**
     * Class constructor.
     */
    public PanelSearchCriterial() {
        initComponents();
    }
    /**
     * Initializes panel components.
     */
    public void initComponents() {
        labelName = new JLabel();
        textFieldName = new JTextField();
        buttonSelect = new JButton();
        buttonLoad = new JButton();
        buttonSearch = new JButton();
        tableResult = new JTable();
        String columnNames[] = new String[]{"Name"};

        tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(columnNames);

        setBorder(new TitledBorder("Search Criterial"));
        setOpaque(false);
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
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

        //---- Button search criterial ----
        buttonSearch.setText("Search");
        add(buttonSearch, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- table results ----
        tableResult.setModel(tableModel);
        tableResult.setPreferredScrollableViewportSize(new Dimension(400, 40));
        tableResult.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tableResult);
        add(scrollPane, new TableLayoutConstraints(0, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button select criterial ----
        buttonSelect.setText("Select");
        add(buttonSelect, new TableLayoutConstraints(2, 2, 2, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button select criterial ----
        buttonLoad.setText("Load");
        add(buttonLoad, new TableLayoutConstraints(1, 2, 1, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));


    }

    /**
     * Setter for the controller to set model filled with results.
     *
     * @param model, the TableModel filled with results.
     */
    public void setTableModel(DefaultTableModel model) {
        this.tableModel = model;
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
    public JButton getButtonSearch(){
        return buttonSearch;
    }
    /**
     * @return buttonLoad return all criteria in the database.
     */
    public JButton getButtonLoad(){
        return buttonLoad;
    }


}
