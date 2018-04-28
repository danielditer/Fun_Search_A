/**
 * @(#)Validator.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to build all the criterias user chose.
 *
 * @version 27 Mar 2018  * @Juan Manuel
 */
public class SearchCriteria extends AbstractSearchCriteria{
    /**
     * Attribute to know which name the user set to save search criteria in DB.
     */
    private String searchCriteriaName;
    /**
     * Attribute of file name
     */
    private String name;
    /**
     * Attribute of path name
     */
    private String path;
    /**
     * Attribute of hidden or not file
     */
    private String hidden;
    /**
     * Attribute of read only
     */
    private String readOnly;
    /**
     * Attribute which type of file (file -> 1, directory -> 2, multimedia -> 3)
     */
    private int typeFile;
    /**
     * Attribute to know if name is case sensitive or not
     */
    private boolean nameFileCaseSensitive;
    /**
     * Attribute to know a file's or directory's ownes
     */
    private String owner;
    /**
     * Attribute to search's extension
     */
    private String extension;
    /**
     * Attribute for size sign (less, more or equals)
     */
    private String sizeSign;
    /**
     * Attribute for size required
     */
    private String sizeRequired;
    /**
     * Attribute for size measure (Mb, Gb, Bytes)
     */
    private String sizeMeasure;
    /**
     * Attribute for created date
     */
    private boolean createDate;
    /**
     * Attribute for modified date
     */
    private boolean modifiedDate;
    /**
     * Attribute for accessed date
     */
    private boolean accessedDate;
    /**
     * Attribute for from date
     */
    private String fromDate;
    /**
     * Attribute for to date
     */
    private String toDate;
    /**
     * Attribute for file content
     */
    private String content;
    /**
     * Attribute for content case sensitive check
     */
    private boolean contentCaseSensitive;
    /**
     * Attribute for multimedia files, video codec.
     */
    private String videoCodec;
    /**
     * Attribute for multimedia files, frame rate.
     */
    private String frameRate;
    /**
     * Attribute for multimedia files, bit rate.
     */
    private String bitRate;
    /**
     * Attribute for multimedia files, video size.
     */
    private String videoSize;
    /**
     * Attribute for multimedia files, aspect ratio.
     */
    private String aspectRatio;
    /**
     * Attribute for multimedia files, audio codec.
     */
    private String audioCodec;
    /**
     * Attribute for multimedia files, minor duration.
     */
    private double minorDuration;
    /**
     * Attribute for multimedia files, major duration.
     */
    private double majorDuration;

    /**
     * Setter for search criteria name to save in DB.
     *
     * @param searchCriteriaName
     */
    @Override
    public void setSearchCriteriaName(String searchCriteriaName) {
        this.searchCriteriaName = searchCriteriaName;
    }

    /**
     * Setter for name attribute.
     *
     * @param name, is the file name the user is searching.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for path attribute.
     *
     * @param path, is the path where the user is searching a file.
     */
    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Setter for hidden attribute
     *
     * @param hidden
     */
    @Override
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    /**
     * Setter for readonly attribute.
     *
     * @param readOnly boolean attribute;
     */
    @Override
    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Setter for typeFile.
     * @param setTypeFile 1, 2, 3, 0 to know if search is file, multimedia, directory or all of them.
     */
    @Override
    public void setTypeFile(int setTypeFile) {
        this.typeFile = setTypeFile;
    }

    /**
     * Setter for nameFileCaseSensitive.
     * @param nameFileCaseSensitive true for case sensitive search.
     */
    @Override
    public void setNameFileCaseSensitive(boolean nameFileCaseSensitive) {
        this.nameFileCaseSensitive = nameFileCaseSensitive;
    }

    /**
     * Setter for owner attribute.
     * @param owner input from UI.
     */
    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Setter for extension attribute.
     * @param extension input from UI.
     */
    @Override
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Setter for size sign.
     * @param sizeSign input from UI.
     */
    @Override
    public void setSizeSign(String sizeSign) {
        this.sizeSign = sizeSign;
    }

    /**
     * Setter for size required.
     * @param sizeRequired
     */
    @Override
    public void setSizeRequired(String sizeRequired) {
        this.sizeRequired = sizeRequired;
    }

    /**
     * Setter for size measure.
     * @param sizeMeasure
     */
    @Override
    public void setSizeMeasure(String sizeMeasure) {
        this.sizeMeasure = sizeMeasure;
    }

    /**
     * Setter for create date.
     * @param createDate
     */
    @Override
    public void setCreateDate(boolean createDate) {
        this.createDate = createDate;
    }

    /**
     * Setter for modified date.
     * @param modifiedDate
     */
    @Override
    public void setModifiedDate(boolean modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Setter for accessed date.
     * @param accessedDate
     */
    @Override
    public void setAccessedDate(boolean accessedDate) {
        this.accessedDate = accessedDate;
    }

    /**
     * Setter for from date.
     * @param fromDate
     */
    @Override
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Setter for to date.
     * @param toDate
     */
    @Override
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Setter for content.
     * @param content
     */
    @Override
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Setter for content case sensitive.
     * @param contentCaseSensitive
     */
    @Override
    public void setContentCaseSensitive(boolean contentCaseSensitive) {
        this.contentCaseSensitive = contentCaseSensitive;
    }

    /**
     * Setter for multimedia attribute, video codec.
     * @param videoCodec
     */
    @Override
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * Setter for multimedia attribute, frame rate.
     * @param videoCodec
     */
    @Override
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Setter for multimedia attribute, bit rate.
     * @param videoCodec
     */
    @Override
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * Setter for multimedia attribute, video size.
     * @param videoCodec
     */
    @Override
    public void setVideoSize(String videoSize) {
        this.videoSize = videoSize;
    }

    /**
     * Setter for multimedia attribute, aspect ratio.
     * @param videoCodec
     */
    @Override
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * Setter for multimedia attribute, audio codec.
     * @param videoCodec
     */
    @Override
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Setter for multimedia attribute, minor duration.
     * @param videoCodec
     */
    @Override
    public void setMinorDuration(double minorDuration) {
        this.minorDuration = minorDuration;
    }

    /**
     * Setter for multimedia attribute, major duration.
     * @param videoCodec
     */
    @Override
    public void setMajorDuration(double majorDuration) {
        this.majorDuration = majorDuration;
    }















    /**
     * Getter for search criteria name saved in DB
     *
     * @return
     */
    @Override
    public String getSearchCriteriaName() {
        return this.searchCriteriaName;
    }

    /**
     * Getter for name attribute.
     *
     * @return name, is the file name set in previous method.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Getter for path attribute.
     *
     * @return path, is the path set in previous method.
     */
    @Override
    public String getPath() {
        return this.path;
    }

    /**
     * Getter for hidden attribute.
     *
     * @return hidden attribute.
     */
    @Override
    public String getHidden() {
        return this.hidden;
    }

    /**
     * Getter for readonly attribute
     */
    @Override
    public String getReadOnly() {
        return this.readOnly;
    }

    /**
     * Getter for type file attribute.
     *
     * @return type file attribute.
     */
    @Override
    public int getTypeFile() {
        return this.typeFile;
    }

    /**
     * Getter for name file case sensitive.
     *
     * @return name file case sensitive.
     */
    @Override
    public boolean getNameFileCaseSensitive() {
        return this.nameFileCaseSensitive;
    }

    /**
     * Getter for owner attribute.
     *
     * @return owner attribute.
     */
    @Override
    public String getOwner() {
        return this.owner;
    }

    /**
     * Getter for extension attribute.
     *
     * @return extesntion attribute.
     */
    @Override
    public String getExtension() {
        return this.extension;
    }

    /**
     * Getter for size sign.
     *
     * @return size sign.
     */
    @Override
    public String getSizeSign() {
        return this.sizeSign;
    }

    /**
     * Getter for size required.
     *
     * @return
     */
    @Override
    public String getSizeRequired() {
        return this.sizeRequired;
    }

    /**
     * Getter for size measure.
     *
     * @return
     */
    @Override
    public String getSizeMeasure() {
        return this.sizeMeasure;
    }

    /**
     * Getter for create date.
     *
     * @return
     */
    @Override
    public boolean getCreatedDate() {
        return this.createDate;
    }

    /**
     * Getter for modified date.
     *
     * @return
     */
    @Override
    public boolean getModifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Getter for accessed date.
     *
     * @return
     */
    @Override
    public boolean getAccessedDate() {
        return this.accessedDate;
    }

    /**
     * Getter of from date.
     *
     * @return creationTime
     */
    @Override
    public String getFromDate() {
        return this.fromDate;
    }

    /**
     * Getter of to date.
     *
     * @return lastModifiedTime.
     */
    @Override
    public String getToDate() {
        return this.toDate;
    }

    /**
     * Getter for content.
     * @return
     */
    @Override
    public String getContent() {
        return this.content;
    }

    /**
     * Getter for content case sensitive.
     * @return
     */
    @Override
    public boolean getContentCaseSensitive() {
        return this.contentCaseSensitive;
    }


    /**
     * Getter for multimedia attribute, video codec.
     * @return
     */
    @Override
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Getter for multimedia attribute, frame rate.
     * @return
     */
    @Override
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Getter for multimedia attribute, bit rate.
     * @return
     */
    @Override
    public String getBitRate() {
        return bitRate;
    }

    /**
     * Getter for multimedia attribute, video size.
     * @return
     */
    @Override
    public String getVideoSize() {
        return videoSize;
    }

    /**
     * Getter for multimedia attribute, aspect ratio.
     * @return
     */
    @Override
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Getter for multimedia attribute, audio codec.
     * @return
     */
    @Override
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Getter for multimedia attribute, minor duration.
     * @return
     */
    @Override
    public double getMinorDuration() {
        return minorDuration;
    }

    /**
     * Getter for multimedia attribute, major duration.
     * @return
     */
    @Override
    public double getMajorDuration() {
        return majorDuration;
    }


}