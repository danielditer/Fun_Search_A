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
public class ResultFile {
    private String path;
    private String fileName;
    private boolean hidden;

    /**
     * ResultFile object.
     *
     * @param path     is the path of files.
     * @param fileName is the file name of files.
     * @param hidden   is the hidden state of files.
     */
    public ResultFile(String path, String fileName, boolean hidden) {
        this.path = path;
        this.fileName = fileName;
        this.hidden = hidden;
    }

    /**
     * Method that gets the path of ResultFile object.
     *
     * @return the path of ResultFile object.
     */
    public String getPath() {
        return path;
    }

    /**
     * Method that gets the file name of ResultFile object.
     *
     * @return the file name of ResultFile object.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Method that gets the hidden state of ResultFile object.
     *
     * @return the hidden state of ResultFile object.
     */
    public boolean getHidden() {
        return hidden;
    }
}
