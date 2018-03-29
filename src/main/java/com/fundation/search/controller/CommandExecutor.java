/**
 * @(#)Validator.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

import java.util.StringJoiner;

/** The command Executor class provides methods to execute a kind of Search according a command.
 * @version
 * 27 Mar 2018  * @Maria Canqui
 */

public class CommandExecutor {
    /**
     * Method exeCmd to call functions by command introduced.
     * -p to path
     * -n to name
     * -h to hidden
     * @param commandString command
     * @return results command execution
     */
    public String exeCmd(String commandString) {

        StringJoiner resultString = new StringJoiner(" ");

        SearchCriteria criteria = new SearchCriteria();
        String[] commandArray = commandString.split(" ");

        for (int i = 0; i < commandArray.length; i++) {
            if (commandArray[i].contains("-n")) { /* Search by name*/
                criteria.setName(commandArray[i + 1]);
                resultString.add("get name: " + criteria.getName());
            }
            if (commandArray[i].contains("-p")) { /* Search by path*/
                criteria.setPath(commandArray[i + 1]);
                resultString.add("get path: " + criteria.getPath());
            }
            if (commandArray[i].contains("-h")) { /* Search by files hidden*/
                resultString.add("get hidden: " + commandArray[i + 1]);
            }
        }
        return resultString.toString();

    }

}
