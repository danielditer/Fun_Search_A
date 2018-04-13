/**
 * @(#)LoggerCreator.java 04/13/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Class LoggerCreator to register events of the program.
 * @version
 * April 13 2018  * @Daniel Caballero
 */
public class LoggerCreator {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;
    private static LoggerCreator logInstance;
    private static final Logger LOGGER = Logger.getLogger(LoggerCreator.class.getName());

    /**
     * Class constructor.
     */
    public LoggerCreator() {
        BasicConfigurator.configure();
    }

    /**
     * @return the instance of Logger.
     */
    public static LoggerCreator getInstance() {
        if (logInstance == null) {
            logInstance = new LoggerCreator();
        }
        return logInstance;
    }

    /**
     * @param logLevel
     * @param logContent
     */
    public void writeLog(int logLevel, String logContent) {
        switch (logLevel) {
            case DEBUG:
                LOGGER.debug(logContent);
                break;
            case INFO:
                LOGGER.info(logContent);
                break;
            case WARN:
                LOGGER.warn(logContent);
                break;
            case ERROR:
                LOGGER.error(logContent);
                break;
            default:
                System.out.println("error log level for WriteLog error");
                break;
        }
    }
}

