/**
 * @(#)Asset.java April, 11th 2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to determine generic objects.
 * @version April, 11th 2018  * @Manuel Valdez
 */
public class Asset {
    private String path;
    private String fileName;
    private boolean hidden;

    public Asset(String path, String fileName, boolean hidden) {
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
