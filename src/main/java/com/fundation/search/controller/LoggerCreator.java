/**
 * @(#)LoggerCreator.java 04/13/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.Main;
import com.fundation.search.common.Constants;
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
     * Class constructor.
     */
    public LoggerCreator() {

    }

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
     * @param logLevel
     * @param logContent
     */
    public void writeLog(int logLevel, String myClass, String logContent) {
        switch (logLevel) {
            case Constants.DEBUG:
                LOGGER.debug(myClass + logContent);
                break;
            case Constants.INFO:
                LOGGER.info(myClass + logContent);
                break;
            case Constants.WARN:
                LOGGER.warn(myClass + logContent);
                break;
            case Constants.ERROR:
                LOGGER.error(myClass + logContent);
                break;
            default:
                System.out.println("error log level for writeLog error");
                break;
        }
    }

    public void info(String myClass, String message) {
        LOGGER.info("[" + myClass + "] " + message);

    }

    public void error(String myClass, String message, Exception ce) {
        LOGGER.error("[" + myClass + "] " + message, ce);
    }

    public void warning(String myClass, String message) {
        LOGGER.warn("[" + myClass + "] " + message);
    }
}

