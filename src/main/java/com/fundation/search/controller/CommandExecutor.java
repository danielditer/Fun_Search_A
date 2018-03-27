/**
 * @(#)Validator.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;
/**
 * @version
 * 27 Mar 2018  * @Maria Canqui
 */

public class CommandExecutor {
    /**
     * @param commandString command
     * @return results command execution
     */
    public String exeCmd(String commandString) {

        SearchCriteria criteria = new SearchCriteria();
        String[] commandArray = commandString.split(" ");

        for (int i = 0; i < commandArray.length; i++) {
            if (commandArray[i].contains("-n")) { /* Search by name*/
                criteria.setName(commandArray[i + 1]);
                System.out.println("get name: " + criteria.getName());
            }
            if (commandArray[i].contains("-p")) { /* Search by path*/
                criteria.setPath(commandArray[i + 1]);
                System.out.println("get path: " + criteria.getPath());
            }
            if (commandArray[i].contains("-h")) { /* Search by files hidden*/
                System.out.println("set hidden: " + commandArray[i + 1]);
            }
        }
        return "list";

    }

}
