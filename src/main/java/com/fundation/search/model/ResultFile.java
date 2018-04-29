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

    /**
     * ResultFile object.
     *
     * @param path     is the path of files.
     * @param fileName is the file name of files.
     * @param hidden   is the hidden state of files.
     */
    public ResultFile(String path, String fileName, boolean hidden, boolean readOnly, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime) {
        super(path, fileName, hidden, readOnly, typeFile, owner, size, creationTime, lastModifiedTime, lastAccessTime);
        this.extension = extension;
    }

    /**
     * Getter for extension attribute.
     * @return extension attribute.
     */
    public String getExtension() {
        return this.extension;
    }
}
