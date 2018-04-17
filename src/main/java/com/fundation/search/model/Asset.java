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
    private boolean readOnly;
    private int typeFile;
    private String owner;

    /**
     * Constructor.
     * @param path the path of file.
     * @param fileName the name of file.
     * @param hidden if file is hidden or not.
     * @param readOnly if file is readonly or not.
     * @param typeFile type of file.
     */
    public Asset(String path, String fileName, boolean hidden, boolean readOnly, int typeFile, String owner) {
        this.path = path;
        this.fileName = fileName;
        this.hidden = hidden;
        this.readOnly = readOnly;
        this.typeFile = typeFile;
        this.owner = owner;
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

    /**
     * Method that gets if ResultFile object is read only.
     * @return read only boolean.
     */
    public boolean getReadOnly() {
        return readOnly;
    }

    /**
     * Method that gets Asset type.
     * @return type file.
     */
    public int getTypeFile() {
        return typeFile;
    }

    /**
     * Methot to get owner attribute
     * @return owner attribute.
     */
    public String getOwner() {
        return this.owner;
    }
}
