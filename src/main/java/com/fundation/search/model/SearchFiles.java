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
    private static final String TEST_1 = "test4.txt";

    private List<FileS> arrayFiles;
    private List<String> arrayCoincidences;

    /**
     * Method that is going to recover all File objects into an array.
     *
     * @param path is given in order to obtain all files of a path.
     * @return the array of Files object.
     */
    List<FileS> recoverFiles(File path) {
        arrayFiles = new ArrayList<>();
        try {
            for (File fileEntry : path.listFiles()) {
                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry);
                } else {
                    arrayFiles.add(new FileS(fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden()));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return arrayFiles;
    }

    /**
     * Method that returns an array of visible files of a path.
     *
     * @param arrayFiles is the array of FileS objects.
     * @return the array of coincidences, in this case visible files.
     */
    List<String> searchAllFiles(List<FileS> arrayFiles) {
        arrayCoincidences = new ArrayList<>();
        for (FileS fileEntry : arrayFiles) {
            if (!fileEntry.getHidden()) {
                arrayCoincidences.add(fileEntry.getPath());
            }
        }
        return arrayCoincidences;
    }


    /**
     * Method that returns an array of coincidences of fileNames of files of a path.
     *
     * @param arrayFiles is the array of FileS objects.
     * @return the array of coincidences, in this case fileName coincidences.
     */
    List<String> searchFile(List<FileS> arrayFiles) {
        arrayCoincidences = new ArrayList<>();
        for (FileS fileEntry : arrayFiles) {
            if (fileEntry.getFileName().contains(TEST_1)) {
                arrayCoincidences.add(fileEntry.getFileName());
            }
        }
        return arrayCoincidences;
    }

    /**
     * Method that returns an array of hidden coincidences of files of a path.
     *
     * @param arrayFiles is the array of FileS objects.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    List<String> searchHiddenFiles(List<FileS> arrayFiles) {
        arrayCoincidences = new ArrayList<>();
        for (FileS fileEntry : arrayFiles) {
            if (fileEntry.getHidden()) {
                arrayCoincidences.add(fileEntry.getFileName());
            }
        }
        return arrayCoincidences;
    }
}
