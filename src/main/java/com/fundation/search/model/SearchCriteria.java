/**
 * @(#)Validator.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import java.io.File;

/**
 * @version
 * 27 Mar 2018  * @Juan Manuel
 */
public class SearchCriteria {
    private String name;
    private File path;

    /**
     * Setter for name attribute.
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for path attribute.
     * @param path .
     */
    public void setPath(File path) {
        this.path = path;
    }

    /**
     * Getter for name attribute.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for path attribute.
     * @return path.
     */
    public File getPath() {
        return this.path;
    }
}
