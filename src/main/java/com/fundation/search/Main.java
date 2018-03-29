package com.fundation.search;

import com.fundation.search.controller.SearchController;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.MainView;

/**
 * Main class.
 */
public class Main {
    public static void main (String[] args) {
        SearchFiles searchFile = new SearchFiles();
        MainView mainView = new MainView();
        SearchController searchController = new SearchController(searchFile, mainView);
        searchController.init();
    }
}
