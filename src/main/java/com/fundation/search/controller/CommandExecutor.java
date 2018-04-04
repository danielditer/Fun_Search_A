/**
 * @(#)Validator.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.model.ResultFile;
import com.fundation.search.model.SearchCriteria;
import com.fundation.search.model.SearchFiles;
import java.util.List;
import java.util.StringJoiner;

/**
 * Class CommandExecutor execute command introduced by the user.
 * @version
 * 27 Mar 2018  * @Maria Canqui
 */
public class CommandExecutor {
    /**
     * Method setResultsToTable to print the files.
     * @param searchFil list of files founded
     */
    private void setResultsToTable(SearchFiles searchFil) {
        List<ResultFile> resultFileList = searchFil.getResultResultFiles();
        System.out.println("File Name\tFile Path\tHidden");
        for (ResultFile rf : resultFileList) {
            System.out.println(rf.getFileName() + "\t" + rf.getPath() + "\t" + rf.getHidden());
        }
    }
    /**
     * Method exeCmd receive a command, separe the string by command and set criteria attributes.
     * @param commandString command
     * @return list of files founded
     */
    public String exeCmd(String commandString) {
        StringJoiner resultString = new StringJoiner(" ");
        SearchCriteria criteria = new SearchCriteria();
        String[] commandArray = commandString.split(" ");

        for (int i = 0; i < commandArray.length; i++) {
            if (commandArray[i].contains("-n")) { /* Search by name*/
                criteria.setName(commandArray[i + 1]);
            }
            if (commandArray[i].contains("-p")) { /* Search by path*/
                criteria.setPath(commandArray[i + 1]);
            }
            if (commandArray[i].contains("-h")) { /* Search by files hidden*/
                resultString.add("get hidden: " + commandArray[i + 1]);
            }
        }
        SearchFiles searchFil = new SearchFiles();
        searchFil.setSearchCriteria(criteria);
        searchFil.init();
        setResultsToTable(searchFil);
        return "test";
    }

}
