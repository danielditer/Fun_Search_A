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
     * Attribute of file name
     */
    private String name;

    /**
     * Attribute of path name
     */
    private String path;

    /**
     * Attribute of path hidden
     */
    private boolean hidden;

    /**
     * Setter for name attribute.
     *
     * @param name, is the file name the user is searching.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for path attribute.
     *
     * @param path, is the path where the user is searching a file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Setter for hidden attribute
     *
     * @param hidden, is the hidden attribute which the user uses for searching.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Getter for name attribute.
     *
     * @return name, is the file name set in previous method.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for path attribute.
     *
     * @return path, is the path set in previous method.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Getter for hidden attribute.
     *
     * @return hidden, is the hidden set in previous method.
     */
    public boolean getHidden() {
        return this.hidden;
    }
}
