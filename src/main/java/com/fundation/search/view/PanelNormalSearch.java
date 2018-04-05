/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * @version 27 Mar 2018  * @Daniel Caballero.
 */
public class PanelNormalSearch extends JPanel {
    private PanelNamePath panelNamePath;
    private JPanel panelCoincidences;
    private JPanel panelFileContent;
    private JScrollPane scrollPaneContent;
    private JTextArea textAreaContent;
    private JCheckBox checkBoxCaseSensitive;
    private PanelDate panelDate;
    private JPanel panelAttributes;
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxHidden;
    private JPanel panelResultTable;
    private JButton buttonSearch;
    private JPanel panelButtonSearch;
    private JTable tableResult;
    private TableModel tableModel;

    /**
     * Class constructor.
     */
    public PanelNormalSearch() {
        initComponents();
        setVisible(true);
    }

    /**
     * Initializes panel components.
     */
    public void initComponents() {
        panelNamePath = new PanelNamePath();
        panelCoincidences = new JPanel();
        panelFileContent = new JPanel();
        scrollPaneContent = new JScrollPane();
        textAreaContent = new JTextArea();
        checkBoxCaseSensitive = new JCheckBox();
        panelDate = new PanelDate();
        panelAttributes = new JPanel();
        checkBoxReadOnly = new JCheckBox();
        checkBoxHidden = new JCheckBox();
        panelResultTable = new JPanel();
        panelButtonSearch = new JPanel();
        buttonSearch = new JButton();
        tableResult = new JTable ();

        String columnNames[] = {"A", "B", "C"};
        String rowData[][] = { {},
                {} };
        tableModel = new DefaultTableModel(rowData, columnNames);

        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //======== panelNamePath ========
        add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelCoincidences ========
        panelCoincidences.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        add(panelCoincidences, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelFileContent ========
        panelFileContent.setBorder(new TitledBorder("File content"));
        panelFileContent.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //======== scrollPaneContent ========
        //---- textAreaContent ----
        final Dimension preferredSizeTextArea = new Dimension(240, 20);
        textAreaContent.setPreferredSize(preferredSizeTextArea);
        scrollPaneContent.setViewportView(textAreaContent);
        panelFileContent.add(scrollPaneContent, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxCaseSensitive ----
        checkBoxCaseSensitive.setText("Case sensitive");
        panelFileContent.add(checkBoxCaseSensitive, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelFileContent, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelDate ========
        add(panelDate, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelAttributes ========
        panelAttributes.setBorder(new TitledBorder("Attributes"));
        panelAttributes.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- checkBoxReadOnly ----
        checkBoxReadOnly.setText("Read-only");
        panelAttributes.add(checkBoxReadOnly, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxHidden ----
        checkBoxHidden.setText("Hidden");
        panelAttributes.add(checkBoxHidden, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        final int constraints1 = 3;
        //add(panelAttributes, new TableLayoutConstraints(0, constraints1, 0, constraints1,
        //        TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        /**
         * Panel for results table
         */
        panelResultTable.setBorder(new TitledBorder("Results"));
        panelResultTable.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));

        tableResult.setModel(tableModel);

        panelResultTable.add(tableResult, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelResultTable, new TableLayoutConstraints(0, constraints1, 0, constraints1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelButtonSearch ========
        panelButtonSearch.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- buttonSearch ----
        buttonSearch.setText("Search");
        panelButtonSearch.add(buttonSearch, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelButtonSearch, new TableLayoutConstraints(1, 2, 1, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    /**
     * Getter for the search button.
     * @return ´buttonSearch´ button.
     */
    public JButton getButtonSearch() {
        return buttonSearch;
    }

    /**
     * Getter for the path.
     * @return the String of ´textFieldPath´ text field.
     */
    public String getPath() {
        return panelNamePath.getPath();
    }

    /**
     * Getter for the file name.
     * @return the String of ´textFieldName´ text field.
     */
    public String getName() {
        return panelNamePath.getName();
    }

    /**
     * Getter for the controller to get model for the result table.
     * @return tableModel, which is the model for the table.
     */
    public TableModel getTableModel() {
        return this.tableModel;
    }

    /**
     * Setter for the controller to set model filled with results.
     * @param model, the TableModel filled with results.
     */
    public void setTableModel(TableModel model) {
        this.tableModel = model;
    }

    /**
     * Method to set model in table.
     */
    public void setTableResultModel() {
        this.tableResult.setModel(this.tableModel);
    }
}
