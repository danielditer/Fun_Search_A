/**
 * @(#)Validator.java 03/25/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @version 25 Mar 2018  * @Jimmy Romero
 */
public class SearchFiles {
    private static final String TEST_1 = "test1.txt";
    private List<String> arrayFiles = new ArrayList<>();

    /**
     * Method to display all files of specific path.
     *
     * @param path is the specific path.
     * @return all the  files contained in the path.
     */
    public List<String> displayAllFiles(File path) {
        for (File fileEntry : Objects.requireNonNull(path.listFiles()))
            if (fileEntry.isDirectory()) {
                displayAllFiles(fileEntry);
            } else {
                arrayFiles.add(fileEntry.getName());
            }
        return arrayFiles;
    }

    /**
     * Method to display an specific file of an specific path.
     *
     * @param path is the specific path.
     * @return the specific file.
     */
    public List<String> displaySpecificFile(File path) {
        for (File fileEntry : Objects.requireNonNull(path.listFiles()))
            if (fileEntry.isDirectory()) {
                displaySpecificFile(fileEntry);
            } else {
                if (fileEntry.getName().contains(TEST_1)) {
                    arrayFiles.add(fileEntry.getName());
                }
            }
        return arrayFiles;
    }
}
