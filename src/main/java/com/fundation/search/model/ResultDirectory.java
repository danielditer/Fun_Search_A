/**
 * @(#)ResultDirectory.java  04/12/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to store results if a directory is found while searching.
 * @version April, 12th  * @Manuel Valdez
 */
public class ResultDirectory extends Asset {

    /**
     * Constructor for
     * @param path
     * @param fileName
     * @param hidden
     */
    public ResultDirectory(String path, String fileName, boolean hidden, boolean readOnly, int typeFile, String owner, long size, String creationTime, String lastModifiedTime, String lastAccessTime, boolean fileSystem) {
        super(path, fileName, hidden, readOnly, typeFile, owner, size, creationTime, lastModifiedTime, lastAccessTime, fileSystem);
    }
}
