/**
 * @(#)Controller.java 03/28/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.common.Validator;
import com.fundation.search.model.ResultFile;
import com.fundation.search.model.SearchCriteria;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.MainView;
import com.fundation.search.view.PanelNormalSearch;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * This class is the Controller for MVC pattern,
 * it will get values from view, then send to model,
 * get results from model and display in view.
 * For this release results are not displayed in view, just in console.
 *
 * @version 28 Mar 2018  * @Juan Manuel
 */
public class SearchController implements Controller {
    private SearchFiles searchFile;
    private MainView mainView;
    private SearchCriteria searchCriteria;
    private static final int START_COLUMN = 0;

    /**
     * Constructor for controller.
     *
     * @param searchFile
     * @param mainView
     */
    public SearchController(SearchFiles searchFile, MainView mainView) {
        this.searchFile = searchFile;
        this.mainView = mainView;
    }

    /**
     * Method to initialize all controller methods.
     */
    @Override
    public void init() {
        searchCriteria = new SearchCriteria();
        getActionPerformed();
    }

    /**
     * Method to get values from button search in the View.
     */
    public void getActionPerformed() {
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        panel.getButtonSearch().addActionListener(e -> searchButtonActionListener(panel));
    }

    /**
     * Method lambda to add action listener to button search.
     *
     * @param panel
     */
    public void searchButtonActionListener(PanelNormalSearch panel) {
        if (areValidParams(panel.getPath(), panel.getName())) {
            sendSearchCriteriaToModel(panel.getPath(), panel.getName());
        }
    }

    /**
     * Method to validate each input.
     *
     * @param path
     * @param name
     * @return
     */
    public boolean areValidParams(String path, String name) {
        Validator validator = new Validator();
        if (!validator.isAValidPath(path)) {
            JOptionPane.showMessageDialog(null, "Invalid Path Name");
            return false;
        }
        if (!validator.isAValidName(name)) {
            JOptionPane.showMessageDialog(null, "Invalid File Name");
            return false;
        }
        return true;
    }

    /**
     * Method to set search criteria for Model and start search.
     *
     * @param path
     * @param name
     */
    public void sendSearchCriteriaToModel(String path, String name) {
        searchCriteria.setPath(path);
        searchCriteria.setName(name);
        searchFile.setSearchCriteria(searchCriteria);
        searchFile.init();
        setResultsToTable();
    }

    /**
     * Method to get Model results and display them.
     */
    public void setResultsToTable() {
        List<ResultFile> resultFileList = searchFile.getResultResultFiles();
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        DefaultTableModel tableModel = panel.getTableModel();
        System.out.println("File Name\tFile Path\tHidden");

        for (int i = 0; i < resultFileList.size(); i++) {
            tableModel.addRow(new Object[]{resultFileList.get(i).getFileName(), resultFileList.get(i).getPath(), resultFileList.get(i).getHidden()});
            System.out.println(resultFileList.get(i).getFileName() + "\t" + resultFileList.get(i).getPath() + "\t" + resultFileList.get(i).getHidden());
        }
        panel.setTableModel(tableModel);
        panel.setTableResultModel();
    }
}

