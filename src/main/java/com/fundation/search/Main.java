/**
 * @(#)Main.java  03/29/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search;

import com.fundation.search.controller.SearchController;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.MainView;

/**
 * Main class to run project.
 * @version
 * 29 Mar 2018  * @Juan Manuel
 */
public class Main {
    /**
     * Method main to run project.
     * @param args
     */
    public static void main (String[] args) {
        SearchFiles searchFile = new SearchFiles();
        MainView mainView = new MainView();
        SearchController searchController = new SearchController(searchFile, mainView);
        searchController.init();
    }
}
