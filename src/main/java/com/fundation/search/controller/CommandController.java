/**
 * @(#)CommandController.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;
import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.CommandResultView;
import java.util.StringJoiner;

/**
 * Class CommandController execute command introduced by the user.
 * @version
 * 27 Mar 2018  * @Maria Canqui
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
     * @return list of files found
     */
    private void exeCmd() {
        StringJoiner resultString = new StringJoiner(" ");
        for (int i = 0; i < inputCommands.length - 1; i++) {
            System.out.println("x:" + inputCommands[i + 1]);
            if (inputCommands[i].contains("-n")) { /* Search by name*/
                searchCriteria.setName(inputCommands[i + 1]);
            }
            if (inputCommands[i].contains("-p")) { /* Search by path*/
                searchCriteria.setPath(inputCommands[i + 1]);
            }
            if (inputCommands[i].contains("-h")) { /* Search by files hidden*/
                resultString.add("get hidden: " + inputCommands[i + 1]);
            }
            if (inputCommands[i].contains("-h")) { /* Search by hidden*/
                boolean value = false;
                if ((inputCommands[i + 1]).equals("true")) {
                    value = true;
                }
                //searchCriteria.setHidden(value);
            }
            if (inputCommands[i].contains("-s")) { /* Search by hidden*/
                boolean value = false;
                if ((inputCommands[i + 1]).equals("true")) {
                    value = true;
                }
                searchCriteria.setNameFileCaseSensitive(value);
            }
        }
        searchFiles.setSearchCriteria(searchCriteria);
        searchFiles.init();
    }
}