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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import java.awt.Color;


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
        buttonSearch = new JButton();
        buttonLoad = new JButton();
        tableResult = new JTable();
        String columnNames[] = new String[]{"Id", "Name"};

        tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(columnNames);


        setBorder(new TitledBorder("Search Criterial"));
        setOpaque(false);
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
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
        add(textFieldName, new TableLayoutConstraints(1, 0, 4, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button search criterial ----
        buttonSearch.setText("Search");

        add(buttonSearch, new TableLayoutConstraints(5, 0, 5, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- table results ----
        tableResult.setModel(tableModel);
        tableResult.setPreferredScrollableViewportSize(new Dimension(420, 70));
        tableResult.setFillsViewportHeight(true);
        //tableResult.setEnabled(false);
        //change the header color
        JTableHeader header = tableResult.getTableHeader();
        header.setBackground(Color.darkGray);
        header.setForeground(Color.white);
        TableColumnModel columnModel = tableResult.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);


        JScrollPane scrollPane = new JScrollPane(tableResult);
        add(scrollPane, new TableLayoutConstraints(0, 1, 5, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button select criterial ----
        buttonSelect.setText("Select");

        add(buttonSelect, new TableLayoutConstraints(5, 2, 5, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Button select criterial ----
        buttonLoad.setText("Load");

        add(buttonLoad, new TableLayoutConstraints(0, 2, 0, 2,
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
    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }
    public void setTableResultModel() {
        this.tableResult.setModel(this.tableModel);
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
     * @return buttonLoad.
     */
    public JButton getButtonLoad(){
        return buttonLoad;
    }
    /**
     * @return buttonSelect.
     */
    public JButton getButtonSelect(){
        return buttonSelect;
    }
    /**
     * method to get the table result
     * @return tableResult.
     */
    public JTable getTableResult() {
        return tableResult;
    }

}
