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

    /**
     * duration attribute to know its duration (hour minute second)
     */
    private double duration;

    /**
     * Extension attribute for files and multimedia files only.
     */
    private String extension;

    /**
     * Attribute audio codec.
     */
    private String audioCodec;
    /**
     * Attribute video codec.
     */
    private final String videoCodec;
    /**
     * Attribute aspect ratio.
     */
    private String aspectRatio;
    /**
     * Attribute audio bit rate.
     */
    private int audioBitRate;
    /**
     * Attribute frame rate.
     */
    private double frameRate;
    /**
     * Attribute video size.
     */
    private String videoSize;
    /**
     * Attribute is file system.
     */
    private boolean fileSystem;


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
    public ResultMultimediaFile(String path, String fileName, boolean hidden, double duration, int typeFile, String owner, String extension, long size, String creationTime, String lastModifiedTime, String lastAccessTime, String videoCodec, String audioCodec, double frameRate, int audioBitRate, String videoSize, String aspectRatio , boolean fileSystem) {
        super(path, fileName, hidden, true, typeFile, owner, size, creationTime, lastModifiedTime, lastAccessTime, fileSystem);
        this.extension = extension;
        this.duration = duration;
        this.audioCodec = audioCodec;
        this.videoCodec = videoCodec;
        this.frameRate = frameRate;
        this.audioBitRate = audioBitRate;
        this.videoSize = videoSize;
        this.aspectRatio = aspectRatio;
        this.fileSystem = fileSystem;
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
     * Getter for video codec attribute.
     * @return
     */
    public String getVideoCodec() {
        return this.videoCodec;
    }

    /**
     * Getter for audio codec attribute.
     * @return
     */
    public String getAudioCodec() {
        return this.audioCodec;
    }

    /**
     * Getter for frame rate attribute.
     * @return
     */
    public double getFrameRate() {
        return this.frameRate;
    }

    /**
     * Getter for aspect ratio attribute.
     * @return
     */
    public String getAspectRatio() {
        return this.aspectRatio;
    }

    /**
     * Getter for video size attribute.
     * @return
     */
    public String getVideoSize() {
        return this.videoSize;
    }

    /**
     * Getter for audio bit rate attribute.
     * @return
     */
    public int getAudioBitRate() {
        return this.audioBitRate;
    }
    /**
     * Getter for audio bit rate attribute.
     * @return
     */
    public boolean getFileSystem() {
        return this.fileSystem;
    }
}
