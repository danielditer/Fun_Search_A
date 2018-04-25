/**
 * @(#)ResultFile.java 03/28/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class ResultFile extends Asset {
    /**
     * Extension attribute for files and multimedia files only.*/
    private String extension;

    /**File creation time*/
    private String creationTime;

    /**File last access time*/
    private String lastAccessTime;

    /**File last modified time*/
    private String lastModifiedTime;

    /**
     * ResultFile object.
     *
     * @param path     is the path of files.
     * @param fileName is the file name of files.
     * @param hidden   is the hidden state of files.
     */
    public ResultFile(String path, String fileName, boolean hidden, boolean readOnly, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime) {
        super(path, fileName, hidden, readOnly, typeFile, owner, size);
        this.extension = extension;
        this.creationTime = creationTime;
        this.lastModifiedTime = lastModifiedTime;
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * Getter for extension attribute.
     * @return extension attribute.
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * Method to get creation time.
     * @return creationTime attribute.
     */
    public String getCreationTime() {
        return this.creationTime;
    }

    /**
     * Method to get last modified time.
     * @return lastModifiedTime attribute.
     */
    public String getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    /**
     * Method to get last accessed time.
     * @return lastAccessedTime attribute.
     */
    public String getLastAccessTime() {
        return this.lastAccessTime;
    }

}
