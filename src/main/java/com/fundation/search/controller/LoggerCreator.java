/**
 * @(#)LoggerCreator.java 04/13/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class LoggerCreator to register events of the program.
 *
 * @version April 13 2018  * @Daniel Caballero
 */
public class LoggerCreator {
    private static LoggerCreator logInstance;
    private final static Logger LOGGER = Logger.getLogger(LoggerCreator.class.getName());

    /**
     * @return the instance of Logger.
     */
    public static LoggerCreator getInstance() {
        if (logInstance == null) {
            logInstance = new LoggerCreator();
            BasicConfigurator.configure();
            LOGGER.setLevel(Level.ALL);
        }
        return logInstance;
    }

    /**
     * @param myClass
     * @param message
     */
    public void info(String myClass, String message) {
        LOGGER.info("[" + myClass + "] " + message);

    }

    /**
     * @param myClass
     * @param message
     * @param ce
     */
    public void error(String myClass, String message, Exception ce) {
        LOGGER.error("[" + myClass + "] " + message, ce);
    }

    /**
     * @param myClass
     * @param message
     */
    public void warning(String myClass, String message) {
        LOGGER.warn("[" + myClass + "] " + message);
    }

    /**
     * @param myClass
     * @param message
     */
    public void debug(String myClass, String message) {
        LOGGER.debug("[" + myClass + "] " + message);
    }
}

