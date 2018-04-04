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
 * @version 28 Mar 2018  * @Jimmy Romero
 */
public class SearchFiles {
    private SearchCriteria searchCriteria;
    private List<ResultFile> resultResultFiles;
    private List<ResultFile> arrayResultFiles;
    private List<ResultFile> arrayCoincidences;


    /**
     * Method to set searchCriteria attribute.
     * @param searchCriteria
     */
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * Method to initialize search.
     */
    public void init() {
        File filePath = new File(searchCriteria.getPath());
        if (searchCriteria.getPath() != null) {
            resultResultFiles = recoverFiles(filePath);
        }
        if (searchCriteria.getName() != null) {
            resultResultFiles = searchFile(resultResultFiles);
        }
    }

    /**
     * Method to get resultResultFiles.
     * @return resultResultFiles
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
    List<ResultFile> recoverFiles(File path) {
        arrayResultFiles = new ArrayList<>();
        try {
            for (File fileEntry : path.listFiles()) {
                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry);
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
    List<ResultFile> searchAllFiles(List<ResultFile> arrayResultFiles) {
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
    List<ResultFile> searchFile(List<ResultFile> arrayResultFiles) {
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
    List<ResultFile> searchHiddenFiles(List<ResultFile> arrayResultFiles) {
        arrayCoincidences = new ArrayList<>();
        for (ResultFile fileEntry : arrayResultFiles) {
            if (fileEntry.getHidden()) {
                arrayCoincidences.add(fileEntry);
            }
        }
        return arrayCoincidences;
    }
}
