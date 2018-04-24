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
//        commandMap.put("-h", "");
//        commandMap.put("-r", "");
//        commandMap.put("-s", "");
//        commandMap.put("-ext", "");
//        commandMap.put("-ow", "");
//        commandMap.put("-type", "");
//        commandMap.put("-cd", "");
//        commandMap.put("-md", "");
//        commandMap.put("-ad", "");
//        commandMap.put("-size", "");

        if (inputCommands[0].equals("-help")) { /*Helper*/
            helpMessage();

        } else {
            for (int i = 0; i < inputCommands.length - 1; i++) {
                System.out.println("x:" + inputCommands[i + 1]);
                

                if (inputCommands[i].equals("-n")) { /* Search by name*/
//                    searchCriteria.setName(inputCommands[i + 1]);
                    Context context = new Context(new CommandSearchName());
                    context.executeCommand("-n", inputCommands, i, searchCriteria);
                }
                if (inputCommands[i].equals("-p")) { /* Search by path*/
//                    searchCriteria.setPath(inputCommands[i + 1]);
                    Context context = new Context(new CommandSearchPath());
                    context.executeCommand("-p", inputCommands, i, searchCriteria);
                }
                if (inputCommands[i].equals("-h")) { /* Search by hidden*/
                    searchCriteria.setHidden(inputCommands[i + 1]);
                }
                if (inputCommands[i].equals("-r")) { /* Search by read-only*/
                    searchCriteria.setReadOnly(inputCommands[i + 1]);
                }
                if (inputCommands[i].equals("-s")) { /* Search by sensitive case*/
                    boolean value = false;
                    if ((inputCommands[i + 1]).equals("true")) {
                        value = true;
                    }
                    searchCriteria.setNameFileCaseSensitive(value);
                }
                if (inputCommands[i].equals("-ext")) { /* Search by hidden*/
                    searchCriteria.setExtension(inputCommands[i + 1]);
                }
                if (inputCommands[i].equals("-ow")) { /* Search by owner*/
                    searchCriteria.setOwner(inputCommands[i + 1]);
                }
                if (inputCommands[i].equals("-type")) { /* Search by owner*/
                    searchCriteria.setTypeFile(Integer.parseInt(inputCommands[i + 1]));
                }
                if (inputCommands[i].equals("-cd")) { /* Search by date*/
                    String[] date = inputCommands[i + 1].split("_");
                    searchCriteria.setFromDate(date[0]);
                    searchCriteria.setToDate(date[1]);
                    searchCriteria.setCreateDate(true);
                }
                if (inputCommands[i].equals("-md")) { /* Search by date*/
                    String[] date = inputCommands[i + 1].split("_");
                    searchCriteria.setFromDate(date[0]);
                    searchCriteria.setToDate(date[1]);
                    searchCriteria.setModifiedDate(true);
                }
                if (inputCommands[i].equals("-ad")) { /* Search by date*/
                    String[] date = inputCommands[i + 1].split("_");
                    searchCriteria.setFromDate(date[0]);
                    searchCriteria.setToDate(date[1]);
                    searchCriteria.setAccessedDate(true);
                }
                if(inputCommands[i].equals("-size")){
                    String[] size = inputCommands[i + 1].split(" ");
                    searchCriteria.setSizeSign(size[0]);
                    searchCriteria.setSizeRequired(size[1]);
                    searchCriteria.setSizeMeasure(size[2]);
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
        System.out.printf("%-15s %-20s %20s %n", "", "[-h 3]", "display all files of a path");
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