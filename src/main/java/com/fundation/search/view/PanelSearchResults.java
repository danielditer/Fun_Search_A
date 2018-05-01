/**
 * @(#)Controller.java 04/12/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Dimension;
import java.awt.Color;

/**
 * Class PanelSearchResults that contain methods to set the result table.
 *
 * @version 12 Apr 2018  * @Maria Canqui.
 */
public class PanelSearchResults extends JPanel {

    private JTable tableResult;
    private DefaultTableModel tableModel;
    private PanelSearchResults panelSearchResults;

    /**
     * Initializes panel components.
     */
    public PanelSearchResults() {
        initComponents();
    }
    /**
     * Initializes panel components.
     */
    public void initComponents() {
        tableResult = new JTable();

        String columnNames[] = new String[]{"File Name", "File Path", "Hidden", "Read Only", "Owner", "Size (bytes)", "Created", "Modified", "Accessed"};

        tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(columnNames);

        setBorder(new TitledBorder("Results"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));

        tableResult.setModel(tableModel);
        tableResult.setPreferredScrollableViewportSize(new Dimension(600, 250));
        tableResult.setFillsViewportHeight(true);
        tableResult.setEnabled(false);
        JTableHeader header = tableResult.getTableHeader();
        header.setBackground(Color.darkGray);
        header.setForeground(Color.white);

        JScrollPane scrollPane = new JScrollPane(tableResult);
        add(scrollPane, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
    /**
     * Getter for the controller to get model for the result table.
     *
     * @return tableModel, which is the model for the table.
     */
    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }
    /**
     * Method to set model in table.
     */
    public void setTableResultModel() {
        this.tableResult.setModel(this.tableModel);
    }
    /**
     * Setter for the controller to set model filled with results.
     *
     * @param model, the TableModel filled with results.
     */
    public void setTableModel(DefaultTableModel model) {
        this.tableModel = model;
    }


}
