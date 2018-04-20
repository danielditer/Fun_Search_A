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
    /**Path of file*/
    private String path;

    /**Name of file*/
    private String fileName;

    /**Hidden property of file*/
    private boolean hidden;

    /**Readonly property of file*/
    private boolean readOnly;

    /**Type of file*/
    private int typeFile;

    /**Owner of file*/
    private String owner;

    /**Size of file*/
    private long size;

    /**
     * Constructor.
     * @param path the path of file.
     * @param fileName the name of file.
     * @param hidden if file is hidden or not.
     * @param readOnly if file is readonly or not.
     * @param typeFile type of file.
     * @param owner file owner.
     * @param size file size.
     */

    public Asset(String path, String fileName, boolean hidden, boolean readOnly, int typeFile, String owner, long size) {
        this.path = path;
        this.fileName = fileName;
        this.hidden = hidden;
        this.readOnly = readOnly;
        this.typeFile = typeFile;
        this.owner = owner;
        this.size = size;
    }

    /**
     * Method that gets the path of ResultFile object.
     * @return the path of ResultFile object.
     */
    public String getPath() {
        return path;
    }

    /**
     * Method that gets the file name of ResultFile object.
     * @return the file name of ResultFile object.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Method that gets the hidden state of ResultFile object.
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
     * Method to get owner attribute
     * @return owner attribute.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Method to get extension attribute.
     * @return extension attribute.
     */
    public String getExtension() {
        return getExtension();
    }

    /**
     * Method to get size attribute.
     * @return size attribute.
     */
    public long getSize() {
        return this.size;
    }

    public String getCreationTime() {
        return getCreationTime();
    }
    public String getLastModifiedTime() {
        return getLastModifiedTime();
    }
    public String getLastAccessTime() {
        return getLastAccessTime();
    }
}
