/**
 * @(#)Controller.java  03/28/18.
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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * This class is the Controller for MVC pattern,
 * it will get values from view, then send to model,
 * get results from model and display in view.
 * For this release results are not displayed in view, just in console.
 * @version
 * 28 Mar 2018  * @Juan Manuel
 */
public class SearchController {
    private SearchFiles searchFile;
    private MainView mainView;
    private SearchCriteria searchCriteria;

    /**
     * Constructor for controller.
     * @param searchFile
     * @param mainView
     */
    public SearchController(SearchFiles searchFile, MainView mainView) {
        this.searchFile = searchFile;
        this.mainView = mainView;
    }

    /**
     * Method to initialize all controll methods.
     */
    public void init() {
        searchCriteria = new SearchCriteria();
        getActionPerformed();
    }

    /**
     * Method to get values from button search in the View.
     */
    public void getActionPerformed() {
        PanelNormalSearch p = (PanelNormalSearch) mainView.getPanel();
        p.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("name:" + p.getName());
                System.out.println("path:" + p.getPath());
                if (areValidParams(p.getPath(), p.getName())) {
                    System.out.println("name:" + p.getName() + " OK");
                    System.out.println("path:" + p.getPath() + " OK");
                    sendSearchCriteriaToModel(p.getPath(), p.getName());
                }
            }
        });

    }

    /**
     * Method to validate each input.
     * @param path
     * @param name
     * @return
     */
    public boolean areValidParams(String path, String name) {
        Validator validator = new Validator();
        if (!validator.isAValidName(name)) {
            JOptionPane.showMessageDialog(null, "Invalid File Name");
            return false;
        }
        if (!validator.isAValidPath(path)) {
            JOptionPane.showMessageDialog(null, "Invalid Path Name");
            return false;
        }
        return true;
    }

    /**
     * Method to set search criteria for Model and start search.
     * @param path
     * @param name
     */
    public void sendSearchCriteriaToModel(String path, String name) {
        File filePath = new File(path);
        searchCriteria.setPath(filePath);
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
        System.out.println("File Name\tFile Path\tHidden");
        for (ResultFile rf : resultFileList) {
            System.out.println(rf.getFileName() + "\t" + rf.getPath() + "\t" + rf.getHidden());
        }
    }
}