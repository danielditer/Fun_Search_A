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
     * Attribute fro size measure (Mb, Gb, Bytes)*/
    private String sizeMeasure;


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
}
