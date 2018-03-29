/**
 * @(#)FileS.java 03/28/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class FileS {
    private String path;
    private String fileName;
    private boolean hidden;

    /**
     * FileS object.
     *
     * @param path     is the path of files.
     * @param fileName is the file name of files.
     * @param hidden   is the hidden state of files.
     */
    public FileS(String path, String fileName, boolean hidden) {
        this.path = path;
        this.fileName = fileName;
        this.hidden = hidden;
    }

    /**
     * Method that gets the path of FileS object.
     *
     * @return the path of FileS object.
     */
    public String getPath() {
        return path;
    }

    /**
     * Method that gets the file name of FileS object.
     *
     * @return the file name of FileS object.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Method that gets the hidden state of FileS object.
     *
     * @return the hidden state of FileS object.
     */
    public boolean getHidden() {
        return hidden;
    }
}
