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

import java.util.HashMap;
import java.util.Map;


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
        Map<String, StrategyCommand> commandMap = new HashMap<>();
        commandMap.put("-p", new CommandSearchPath());
        commandMap.put("-n", new CommandSearchName());
        commandMap.put("-h", new CommandSearchHidden());
        commandMap.put("-r", new CommandSearchReadOnly());
        commandMap.put("-s", new CommandSearchCaseSensitive());
        commandMap.put("-ext", new CommandSearchExtension());
        commandMap.put("-ow", new CommandSearchOwner());
        commandMap.put("-type", new CommandSearchType());
        commandMap.put("-cd", new CommandSearchCreationDate());
        commandMap.put("-md", new CommandSearchModifiedDate());
        commandMap.put("-ad", new CommandSearchAccessedDate());
        commandMap.put("-size", new CommandSearchSize());

        if (inputCommands[0].equals("-help")) { /*Helper*/
            helpMessage();

        } else {

            for (int i = 0; i < inputCommands.length - 1; i++) {
                if(commandMap.containsKey(inputCommands[i])){
                    Context context = new Context(commandMap.get(inputCommands[i]));
                    context.executeCommand(inputCommands[i], inputCommands,i,searchCriteria);
                }
                else{
                    if(inputCommands[i].contains("")){}
                }
            }
            searchFiles.setSearchCriteria(searchCriteria);
            searchFiles.init();
        }
    }


    /**
     * Method for displaying the help message for the command line.
     */
    public void helpMessage() {
        System.out.println("Usage: java [-options] [args...]");
        System.out.println("To perform a search");
        System.out.println("In order to use search methods, path is required \b");
        System.out.printf("%-15s %-20s %20s %n", "-p", "[path\\example]", "to display all files in the path.");
        System.out.printf("%-15s %-20s %20s %n", "-n", "[nameFile.exa]", "to display the specific file of a path.");
        System.out.printf("%-15s %-20s %20s %n", "-h", "HIDDEN", "to display the hidden/no hidden/all files of a path");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-h 1]", "display the hidden files of a path");
        System.out.printf("%-15s %-20s %20s %n", "", "[-h 2]", "display the no hidden files of a path");
        System.out.printf("%-15s %-20s %20s %n", "-r", "READ-ONLY", "to display the read-only/no read-only/all files of a path");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-r 1]", "display the read-only files of a path");
        System.out.printf("%-15s %-20s %20s %n", "", "[-r 2]", "display the no read-only files of a path");
        System.out.printf("%-15s %-20s %20s %n", "", "[-r 3]", "display all files of a path");
        System.out.printf("%-15s %-20s %20s %n", "-s", "SENSITIVE-CASE", "to display all files of a resultant match of a path");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-s true]", "enables the sensitive-case search search.");
        System.out.printf("%-15s %-20s %20s %n", "", "[-s false]", "disables the sensitive-case search.");
        System.out.printf("%-15s %-20s %20s %n", "-ext", "[.txt]", "to display all files of a resultant match of extension of a path");
        System.out.printf("%-15s %-20s %20s %n", "-ow", "[Administrators]", "to display all files of an owner of a path");
        System.out.printf("%-15s %-20s %20s %n", "-type", "TYPE", "to display the type of files of a path");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-type 0]", "display all types of files of a path");
        System.out.printf("%-15s %-20s %20s %n", "", "[-type 1]", "display the files of a path (e.g. txt, docx, exe)");
        System.out.printf("%-15s %-20s %20s %n", "", "[-type 2]", "display the multimedia files of a path (e.g. mp3, mp4)");
        System.out.printf("%-15s %-20s %20s %n", "", "[-type 3]", "display directories of a path");
        System.out.printf("%-15s %-20s %20s %n", "", "DATE", "to display the files of a path in a range of dates");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-cd]", "display the created files in a range of dates");
        System.out.printf("%-15s %-20s %20s %n", "", "[-md]", "display the modified files in a range of dates");
        System.out.printf("%-15s %-20s %20s %n", "", "[-ma]", "display the last accessed files in a range of dates");
        System.out.printf("%-15s %-20s %20s %n", "", "SIZE", "to display the files of a path in by size");
        System.out.printf("%-15s %-20s %20s %n", "Where options include", "", "");
        System.out.printf("%-15s %-20s %20s %n", "", "[-size major xx mb]", "display the major files in a range of sizes");
        System.out.printf("%-15s %-20s %20s %n", "", "[-size minor xx mb]", "display the minor files in a range of sizes");
        System.out.printf("%-15s %-20s %20s %n", "", "[-size equals xx mb]", "display the equals files in a range of sizes");
        
    }
}