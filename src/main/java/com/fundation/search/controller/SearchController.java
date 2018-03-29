
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
 * @version
 * 28 Mar 2018  * @Juan Manuel
 */
public class SearchController {
    private SearchFiles searchFile;
    private MainView mainView;
    private SearchCriteria searchCriteria;

    public SearchController(SearchFiles searchFile, MainView mainView) {
        this.searchFile = searchFile;
        this.mainView = mainView;
    }

    public void init() {
        searchCriteria = new SearchCriteria();
        getActionPerformed();
    }

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

    public void sendSearchCriteriaToModel(String path, String name) {
        File filePath = new File(path);
        searchCriteria.setPath(filePath);
        searchCriteria.setName(name);
        searchFile.setSearchCriteria(searchCriteria);
        searchFile.init();
        setResultsToTable();
    }

    public void setResultsToTable() {
        List<ResultFile> resultFileList = searchFile.getResultResultFiles();
        System.out.println("File Name\tFile Path\tHidden");
        for (ResultFile rf : resultFileList) {
            System.out.println(rf.getFileName() + "\t" + rf.getPath() + "\t" + rf.getHidden());
        }
    }
}
