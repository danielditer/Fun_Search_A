/**
 * @(#)SearchFiles.java 03/25/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class made in order to develop different methods for search files.
 * Like: search files of a path, search specific files, search hidden files.
 *
 * @version April 4th, 2018  * @Jimmy Romero
 */
public class SearchFiles {
    /**
     * searchCriteria is the attribute that is used for setting the criteria of searching.
     */
    private SearchCriteria searchCriteria;
    /**
     * resultResultFiles is the attribute in which we are going to recover files depending the type of searching.
     */
    private List<ResultFile> resultResultFiles;
    /**
     * arrayResultFiles is the array that is used for insert ResultFile objects inside of it.
     */
    private List<ResultFile> arrayResultFiles;
    /**
     * arrayCoincidences is the array in which all the search coincidences depending the method used, are going to be stored.
     */
    private List<ResultFile> arrayCoincidences;

    /**
     * Method to set searchCriteria attribute.
     *
     * @param searchCriteria is the param received in order to set the search criteria.
     */
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * Method to initialize search.
     */
    public void init() {
        arrayResultFiles = new ArrayList<>();
        File filePath = new File(searchCriteria.getPath());
        if (searchCriteria.getPath() != null) {
            resultResultFiles = recoverFiles(filePath, arrayResultFiles);
        }
        if (searchCriteria.getName() != null) {
            resultResultFiles = searchFile(resultResultFiles);
        }
    }

    /**
     * Method to get resultResultFiles.
     *
     * @return resultResultFiles is going to get the result files for the search controller.
     */
    public List<ResultFile> getResultResultFiles() {
        return this.resultResultFiles;
    }

    /**
     * Method that is going to recover all File objects into an array.
     *
     * @param path is given in order to obtain all files of a path.
     * @return the array of Files object.
     */
    private List<ResultFile> recoverFiles(File path, List<ResultFile> arrayResultFiles) {
        try {
            for (File fileEntry : path.listFiles()) {
                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry, arrayResultFiles);
                } else {
                    arrayResultFiles.add(new ResultFile(fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden()));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return arrayResultFiles;
    }

    /**
     * Method that returns an array of visible files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case visible files.
     */
    private List<ResultFile> searchAllFiles(List<ResultFile> arrayResultFiles) {
        arrayCoincidences = new ArrayList<>();
        for (ResultFile fileEntry : arrayResultFiles) {
            if (!fileEntry.getHidden()) {
                arrayCoincidences.add(fileEntry);
            }
        }
        return arrayCoincidences;
    }

    /**
     * Method that returns an array of coincidences of fileNames of files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case fileName coincidences.
     */
    private List<ResultFile> searchFile(List<ResultFile> arrayResultFiles) {
        arrayCoincidences = new ArrayList<>();
        for (ResultFile fileEntry : arrayResultFiles) {
            if (fileEntry.getFileName().contains(searchCriteria.getName())) {
                arrayCoincidences.add(fileEntry);
            }
        }
        return arrayCoincidences;
    }

    /**
     * Method that returns an array of hidden coincidences of files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    private List<ResultFile> searchHiddenFiles(List<ResultFile> arrayResultFiles) {
        arrayCoincidences = new ArrayList<>();
        for (ResultFile fileEntry : arrayResultFiles) {
            if (fileEntry.getHidden()) {
                arrayCoincidences.add(fileEntry);
            }
        }
        return arrayCoincidences;
    }
}
