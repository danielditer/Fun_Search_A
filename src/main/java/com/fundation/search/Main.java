/**
 * @(#)Main.java  03/29/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search;

import com.fundation.search.controller.CommandController;
import com.fundation.search.controller.Controller;
import com.fundation.search.controller.SearchController;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.CommandResultView;
import com.fundation.search.view.MainView;

/**
 * Main class to run project.
 * @version
 * 29 Mar 2018  * @Juan Manuel
 */
public class Main {
    /**
     * Method main to run project.
     * @param args, commands as an input to search files
     */
    public static void main (String[] args) {
        Controller controller;
        SearchFiles searchFile = new SearchFiles();
        if (args.length > 0) {
            CommandResultView commandResultView = new CommandResultView();
            controller = new CommandController(searchFile, commandResultView, args);
        } else {
            MainView mainView = new MainView();
            controller = new SearchController(searchFile, mainView);
        }
        controller.init();
    }
}