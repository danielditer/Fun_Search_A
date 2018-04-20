/**
 * @(#)AssetFactory.java April, 12th 2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class for pattern "Factory", it initializes objects.
 * @version April, 12th 2018  * @Manuel Valdez
 */
public class AssetFactory {

    /**
     * Method to get an instance of the objects.
     * @param assetType is the type of instance that the program needs.
     * @param path is the path where the program has to search files.
     * @param fileName is the name of the file that program has to search.
     * @param hidden if the program has to search for hidden or not hidden files.
     * @param duration if the file is multimedia the program searches for its duration.
     * @return the method return the object instanced.
     */
    public Asset getAsset(String assetType, String path, String fileName, boolean hidden, double duration, boolean readOnly, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            return new ResultFile(path, fileName, hidden, readOnly, typeFile, owner, extension, size, creationTime, lastModifiedTime, lastAccessTime);
        }
        if (assetType.equalsIgnoreCase("multimedia")) {
            return new ResultMultimediaFile(path, fileName, hidden, duration, typeFile, owner, extension, size, creationTime, lastModifiedTime, lastAccessTime);
        }
        if (assetType.equalsIgnoreCase("directory")) {
            return new ResultDirectory(path, fileName, hidden, readOnly, typeFile, owner, size);
        }
        return null;
    }
}
