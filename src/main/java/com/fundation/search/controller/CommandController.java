/**
 * @(#)CommandController.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.CommandResultView;


/**
 * Class CommandController execute command introduced by the user.
 *
 * @version 27 Mar 2018  * @Maria Canqui
 */
public class CommandController implements Controller {
    private String[] inputCommands;

    private SearchFiles searchFiles;
    private CommandResultView commandResultView;
    private SearchCriteria searchCriteria;

    public CommandController(SearchFiles searchFiles, CommandResultView commandResultView, String[] inputCommands) {
        this.searchFiles = searchFiles;
        this.commandResultView = commandResultView;
        this.inputCommands = inputCommands;
        this.searchCriteria = new SearchCriteria();
    }

    @Override
    public void init() {
        System.out.println("1");
        exeCmd();
        commandResultView.setResultFileList(searchFiles.getResultResultFiles());
        commandResultView.printResults();
    }

    /**
     * Method exeCmd receive a command, separe the string by command and set criteria attributes.
     *
     * @return list of files found
     */
    private void exeCmd() {
        for (int i = 0; i < inputCommands.length - 1; i++) {
            System.out.println("x:" + inputCommands[i + 1]);
            if (inputCommands[i].equals("-n")) { /* Search by name*/
                searchCriteria.setName(inputCommands[i + 1]);
            }
            if (inputCommands[i].equals("-p")) { /* Search by path*/
                searchCriteria.setPath(inputCommands[i + 1]);
            }
            if (inputCommands[i].equals("-h")) { /* Search by hidden*/
                boolean value = false;
                if ((inputCommands[i + 1]).equals("true")) {
                    value = true;
                }
                searchCriteria.setHidden(value);
            }
            if (inputCommands[i].equals("-r")) { /* Search by read-only*/
                boolean value = false;
                if ((inputCommands[i + 1]).equals("true")) {
                    value = true;
                }
                searchCriteria.setReadOnly(value);
            }
            if (inputCommands[i].equals("-s")) { /* Search by sensitive case*/
                boolean value = false;
                if ((inputCommands[i + 1]).equals("true")) {
                    value = true;
                }
                searchCriteria.setNameFileCaseSensitive(value);
            }
            if (inputCommands[i].equals("-help")) { /*Helper*/
                if ((inputCommands[i + 1]).equals("true")) {
                    helpMessage();
                }
            }
        }
        searchFiles.setSearchCriteria(searchCriteria);
        searchFiles.init();
    }

    /**
     * Method for displaying the help message for the command line.
     */
    public void helpMessage() {
        System.out.println("Usage: java [-options] [args...]");
        System.out.println("To perform a search");
        System.out.println("In order to use search methods, path is required \b");
        System.out.println("-p [path\\example]  to display all files in the path.");
        System.out.println("-n [filename.exa]   to display the specific file of a path");
        System.out.println("-h [true\\false]   to display the hidden file of a path");
        System.out.println("-r [true\\false]   to display the read-only file of a path");
        System.out.println("-s [true\\false]   to display the specific file of a path in case sensitive");
    }
}