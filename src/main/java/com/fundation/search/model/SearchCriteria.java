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
public class SearchCriteria {
    private String searchCriteriaName;

    /**
     * Attribute of file name*/
    private String name;
    /**
     * Attribute of path name*/
    private String path;
    /**
     * Attribute of hidden or not file*/
    private String hidden;
    /**
     * Attribute of read only*/
    private String readOnly;
    /**
     * Attribute which type of file (file -> 1, directory -> 2, multimedia -> 3)*/
    private int typeFile;
    /**
     * Attribute to know if name is case sensitive or not*/
    private boolean nameFileCaseSensitive;
    /**
     * Attribute to know a file's or directory's ownes*/
    private String owner;
    /**
     * Attribute to search's extension*/
    private String extension;
    /**
     * Attribute for size sign (less, more or equals)*/
    private String sizeSign;
    /**
     * Attribute for size required*/
    private String sizeRequired;
    /**
     * Attribute for size measure (Mb, Gb, Bytes)*/
    private String sizeMeasure;
    /**
     * Attribute for created date*/
    private boolean createDate;
    /**
     * Attribute for modified date*/
    private boolean modifiedDate;
    /**
     * Attribute for accessed date*/
    private boolean accessedDate;
    /**
     * Attribute for from date*/
    private String fromDate;
    /**
     * Attribute for to date*/
    private String toDate;
    /**
     * Attribute for file content*/
    private String content;

    /**
     * Setter for search criteria name to save in DB.
     * @param searchCriteriaName
     */
    public void setSearchCriteriaName(String searchCriteriaName) {
        this.searchCriteriaName = searchCriteriaName;
    }

    /**
     * Setter for name attribute.
     * @param name, is the file name the user is searching.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for path attribute.
     * @param path, is the path where the user is searching a file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Setter for hidden attribute
     * @param hidden
     */
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    /**
     * Setter for readonly attribute.
     * @param readOnly boolean attribute;
     */
    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Setter for typeFile.
     * @param setTypeFile 1, 2, 3, 0 to know if search is file, multimedia, directory or all of them.
     */
    public void setTypeFile(int setTypeFile) {
        this.typeFile = setTypeFile;
    }

    /**
     * Setter for nameFileCaseSensitive.
     * @param nameFileCaseSensitive true for case sensitive search.
     */
    public void setNameFileCaseSensitive(boolean nameFileCaseSensitive) {
        this.nameFileCaseSensitive = nameFileCaseSensitive;
    }

    /**
     * Setter for owner attribute.
     * @param owner input from UI.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Setter for extension attribute.
     * @param extension input from UI.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Setter for size sign.
     * @param sizeSign input from UI.
     */
    public void setSizeSign(String sizeSign) {
        this.sizeSign = sizeSign;
    }

    /**
     * Setter for size required.
     * @param sizeRequired
     */
    public void setSizeRequired(String sizeRequired) {
        this.sizeRequired = sizeRequired;
    }

    /**
     * Setter for size measure.
     * @param sizeMeasure
     */
    public void setSizeMeasure(String sizeMeasure) {
        this.sizeMeasure = sizeMeasure;
    }

    /**
     * Setter for create date.
     * @param createDate
     */
    public void setCreateDate(boolean createDate) {
        this.createDate = createDate;
    }

    /**
     * Setter for modified date.
     * @param modifiedDate
     */
    public void setModifiedDate(boolean modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Setter for accessed date.
     * @param accessedDate
     */
    public void setAccessedDate(boolean accessedDate) {
        this.accessedDate = accessedDate;
    }

    /**
     * Setter for from date.
     * @param fromDate
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Setter for to date.
     * @param toDate
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Setter for content.
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Getter for search criteria name saved in DB
     * @return
     */
    public String getSearchCriteriaName() {
        return this.searchCriteriaName;
    }

    /**
     * Getter for name attribute.
     * @return name, is the file name set in previous method.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for path attribute.
     * @return path, is the path set in previous method.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Getter for hidden attribute.
     * @return hidden attribute.
     */
    public String getHidden() {
        return this.hidden;
    }

    /**
     * Getter for readonly attribute
     */
    public String getReadOnly() {
        return this.readOnly;
    }

    /**
     * Getter for type file attribute.
     * @return type file attribute.
     */
    public int getTypeFile() {
        return this.typeFile;
    }

    /**
     * Getter for name file case sensitive.
     * @return name file case sensitive.
     */
    public boolean getNameFileCaseSensitive() {
        return this.nameFileCaseSensitive;
    }

    /**
     * Getter for owner attribute.
     * @return owner attribute.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Getter for extension attribute.
     * @return extesntion attribute.
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * Getter for size sign.
     * @return size sign.
     */
    public String getSizeSign() {
        return this.sizeSign;
    }

    /**
     * Getter for size required.
     * @return
     */
    public String getSizeRequired() {
        return this.sizeRequired;
    }

    /**
     * Getter for size measure.
     * @return
     */
    public String getSizeMeasure() {
        return this.sizeMeasure;
    }

    /**
     * Getter for create date.
     * @return
     */
    public boolean getCreatedDate() {
        return this.createDate;
    }

    /**
     * Getter for modified date.
     * @return
     */
    public boolean getModifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Getter for accessed date.
     * @return
     */
    public boolean getAccessedDate() {
        return this.accessedDate;
    }
    /**
     * Getter of from date.
     * @return creationTime
     */
    public String getFromDate() {
        return this.fromDate;
    }

    /**
     * Getter of to date.
     * @return lastModifiedTime.
     */
    public String getToDate() {
        return this.toDate;
    }

    /**
     * Getter for content.
     * @return
     */
    public String getContent() {
        return this.content;
    }
}