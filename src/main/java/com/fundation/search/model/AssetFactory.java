/**
 * @(#)AssetFactory.java April, 12th 2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import com.fundation.search.controller.LoggerCreator;

/**
 * Class for pattern "Factory", it initializes objects.
 *
 * @version April, 12th 2018  * @Manuel Valdez
 */
public class AssetFactory {

    /**
     * Method to get an instance of the objects.
     *
     * @param assetType    is the type of instance that the program needs.
     * @param path         is the path where the program has to search files.
     * @param fileName     is the name of the file that program has to search.
     * @param hidden       if the program has to search for hidden or not hidden files.
     * @param duration     if the file is multimedia the program searches for its duration.
     * @param audioBitRate
     * @param videoSize
     * @return the method return the object instanced.
     */
    public Asset getAsset(String assetType, String path, String fileName, boolean hidden, double duration, boolean readOnly, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime, String videoCodec, String audioCodec, double frameRate, int audioBitRate, String videoSize, String aspectRatio, boolean fileSystem) {
        LoggerCreator.getInstance().info(this.getClass().getName(),"Get Asset Method");
        if (assetType == null) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Null instance required");
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Intance Result file");
            return new ResultFile(path, fileName, hidden, readOnly, typeFile, owner, extension, size, creationTime, lastModifiedTime, lastAccessTime, fileSystem);
        }
        if (assetType.equalsIgnoreCase("multimedia")) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Intance Result Multimedia file");
            return new ResultMultimediaFile(path, fileName, hidden, duration, typeFile, owner, extension, size, creationTime, lastModifiedTime, lastAccessTime, videoCodec, audioCodec, frameRate, audioBitRate, videoSize, aspectRatio, fileSystem);
        }
        if (assetType.equalsIgnoreCase("directory")) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Intance Result directory");
            return new ResultDirectory(path, fileName, hidden, readOnly, typeFile, owner, size, creationTime, lastModifiedTime, lastAccessTime, fileSystem);
        }
        LoggerCreator.getInstance().debug(this.getClass().getName(),"Invalid instance required");
        return null;
    }
}
