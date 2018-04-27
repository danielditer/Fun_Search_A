/**
 * @(#)ResultMultimediaFile.java 04/12/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to store results if a multimedia file is found while searching.
 *
 * @version April, 12th  * @Manuel Valdez
 */
public class ResultMultimediaFile extends Asset {

    private final String videoCodec;
    private String aspectRatio;
    private int audioBitRate;
    private double frameRate;
    /**
     * duration attribute to know its duration (hour minute second)
     */
    private double duration;

    /**
     * Extension attribute for files and multimedia files only.
     */
    private String extension;

    /**
     * File creation time
     */
    private String creationTime;

    /**
     * File last access time
     */
    private String lastAccessTime;

    /**
     * File last modified time
     */
    private String lastModifiedTime;

    /**
     * File codec
     */
    private String audioCodec;

    public String videoSize;


    /**
     * Constructor for this class, recieves the same as the father class,
     * it sends them with super and sets its own attribute duration
     *
     * @param path      the path of the file.
     * @param fileName  the name of the file.
     * @param hidden    if the file is hidden or not.
     * @param duration  hour minute second of file.
     * @param videoSize
     */
    public ResultMultimediaFile(String path, String fileName, boolean hidden, double duration, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime, String videoCodec, String audioCodec, double frameRate, int audioBitRate, String videoSize, String aspectRatio) {
        super(path, fileName, hidden, true, typeFile, owner, size);
        this.duration = duration;
        this.extension = extension;
        this.creationTime = creationTime;
        this.lastModifiedTime = lastModifiedTime;
        this.lastAccessTime = lastAccessTime;
        this.audioCodec = audioCodec;
        this.videoCodec = videoCodec;
        this.frameRate = frameRate;
        this.audioBitRate = audioBitRate;
        this.videoSize = videoSize;
        this.aspectRatio = aspectRatio;
    }

    /**
     * Getter of duration attribute.
     *
     * @return the attribute with values.
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * Getter for extension attribute.
     *
     * @return extension attribute.
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * Method to get creation time.
     *
     * @return creationTime attribute.
     */
    public String getCreationTime() {
        return this.creationTime;
    }

    /**
     * Method to get last modified time.
     *
     * @return lastModifiedTime attribute.
     */
    public String getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    /**
     * Method to get last accessed time.
     *
     * @return lastAccessedTime attribute.
     */
    public String getLastAccessTime() {
        return this.lastAccessTime;
    }

    public String getVideoCodec() {
        return this.videoCodec;
    }

    public String getAudioCodec() {
        return this.audioCodec;
    }

    public double getFrameRate() {
        return this.frameRate;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public String getVideoSize() {
        return this.videoSize;
    }

    public int getAudioBitRate() {
        return this.audioBitRate;
    }
}
