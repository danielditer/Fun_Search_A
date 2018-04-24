/**
 * @(#)ResultMultimediaFile.java  04/12/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to store results if a multimedia file is found while searching.
 * @version April, 12th  * @Manuel Valdez
 */
public class ResultMultimediaFile extends Asset {

    private double frameRate;
    /**
     * duration attribute to know its duration (hour minute second)*/
    private double duration;

    /**
     * Extension attribute for files and multimedia files only.*/
    private String extension;

    /**File creation time*/
    private String creationTime;

    /**File last access time*/
    private String lastAccessTime;

    /**File last modified time*/
    private String lastModifiedTime;

    /**File codec Audio*/
    private String codecAudio;

    /**File codec Video*/
    private String codecVideo;

    /**
     * Constructor for this class, recieves the same as the father class,
     * it sends them with super and sets its own attribute duration
     * @param path the path of the file.
     * @param fileName the name of the file.
     * @param hidden if the file is hidden or not.
     * @param duration hour minute second of file.
     */
    public ResultMultimediaFile(String path, String fileName, boolean hidden, double duration, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime, String codecAudio, String codecVideo, double frameRate) {
        super(path, fileName, hidden, true, typeFile, owner, size);
        this.duration = duration;
        this.extension = extension;
        this.creationTime = creationTime;
        this.lastModifiedTime = lastModifiedTime;
        this.lastAccessTime = lastAccessTime;
        this.codecAudio = codecAudio;
        this.codecVideo = codecVideo;
        this.frameRate = frameRate;
    }

    /**
     * Getter of duration attribute.
     * @return  the attribute with values.
     */
    public double getDuration() {
        return this.duration;
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

    public String getCodecAudio() {
        return this.codecAudio;
    }

    public String getCodecVideo() {
        return this.codecVideo;
    }

    public double getFrameRate() {
        return this.frameRate;
    }
}
