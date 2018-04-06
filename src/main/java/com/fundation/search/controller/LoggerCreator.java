package com.fundation.search.controller;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;

/**
 * Class LoggerCreator to register events of the programm.
 */
public class LoggerCreator {

    private static final Logger LOGGER = Logger.getLogger(LoggerCreator.class.getName());
    private String action;
    private static LoggerCreator logInstance;

    /**
     * Constructor LoggerCreator.
     *
     * @param action the action executed.
     */
    private LoggerCreator(String action) {
        this.action = action;
    }

    /**
     * Method getInstance to determina if exists an instance.
     *
     * @param action the action executed.
     */
    public static LoggerCreator getInstance(String action) {
        if (logInstance == null) {
            logInstance = new LoggerCreator(action);
        }
        return logInstance;
    }

    /**
     * Method setLog to insert information in searchFiles log.
     */
    public void setLog() {
        Handler consoleHandler = null;
        Handler fileHandler = null;
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./searchFiles.log");
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.info(getAction());
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error ", exception);
        }
    }

    /**
     * Method getAction to get the action of the constructor.
     *
     * @return a string with the action description.
     */
    public String getAction() {
        return action;
    }
}
