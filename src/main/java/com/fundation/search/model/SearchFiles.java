/**
 * @(#)SearchFiles.java 03/25/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    private List<Asset> resultResultFiles;
    /**
     * arrayResultFiles is the array that is used for insert ResultFile objects inside of it.
     */
    private List<Asset> arrayResultFiles;
    /**
     * arrayCoincidences is the array in which all the search coincidences depending the method used, are going to be stored.
     */
    private List<Asset> arrayCoincidences;

    /**
     * Object to create asset objects (files, multimedia, directory).
     */
    private AssetFactory assetFactory;

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
        assetFactory = new AssetFactory();
        if (searchCriteria.getPath() != null) {
            resultResultFiles = recoverFiles(filePath, arrayResultFiles);
        }
        if (searchCriteria.getName() != null) {
            resultResultFiles = searchFile(resultResultFiles, searchCriteria.getNameFileCaseSensitive());
        }
        resultResultFiles = searchHiddenFiles(resultResultFiles, searchCriteria.getHidden());
        resultResultFiles = searchReadOnlyFiles(resultResultFiles, searchCriteria.getReadOnly());
        resultResultFiles = searchFilesOrDirectoriesOnly(resultResultFiles, searchCriteria.getTypeFile());
    }

    /**
     * Method to get resultResultFiles.
     *
     * @return resultResultFiles is going to get the result files for the search controller.
     */
    public List<Asset> getResultResultFiles() {
        return this.resultResultFiles;
    }

    /**
     * Method that is going to recover all File objects into an array.
     *
     * @param path is given in order to obtain all files of a path.
     * @return the array of Files object.
     */
    public List<Asset> recoverFiles(File path, List<Asset> arrayResultFiles) {
        try {
            for (File fileEntry : path.listFiles()) {
                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry, arrayResultFiles);
                    System.out.println("ownerDir: " + Files.getOwner(fileEntry.toPath()));
                    arrayResultFiles.add(assetFactory.getAsset("directory", fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 3));
                } else {
                    System.out.println("ownerFile: " + Files.getOwner(fileEntry.toPath()));
                    arrayResultFiles.add(assetFactory.getAsset("file", fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 1));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
    private List<Asset> searchAllFiles(List<Asset> arrayResultFiles) {
        arrayCoincidences = new ArrayList<>();
        for (Asset fileEntry : arrayResultFiles) {
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
    private List<Asset> searchFile(List<Asset> arrayResultFiles, boolean nameFileCaseSensitive) {
        arrayCoincidences = new ArrayList<>();
        for (Asset fileEntry : arrayResultFiles) {
            /*if (fileEntry.getFileName().contains(searchCriteria.getName())) {
                arrayCoincidences.add(fileEntry);
            }*/
            if (nameFileCaseSensitive) {
                if (fileEntry.getFileName().equals(searchCriteria.getName())) {
                    arrayCoincidences.add(fileEntry);
                }
            } else {
                if (fileEntry.getFileName().equalsIgnoreCase(searchCriteria.getName())) {
                    arrayCoincidences.add(fileEntry);
                }
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
    public List<Asset> searchHiddenFiles(List<Asset> arrayResultFiles, boolean searchHidden) {
        arrayCoincidences = new ArrayList<>();
        for (Asset fileEntry : arrayResultFiles) {
            if (searchHidden) {
                if (fileEntry.getHidden()) {
                    arrayCoincidences.add(fileEntry);
                }
            } else {
                if (!fileEntry.getHidden()) {
                    arrayCoincidences.add(fileEntry);
                }
            }
        }
        return arrayCoincidences;
    }

    /**
     * Method to search only files read only or not.
     * @param arrayResultFiles array of Assets.
     * @param readOnly search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public List<Asset> searchReadOnlyFiles(List<Asset> arrayResultFiles, boolean readOnly) {
        arrayCoincidences = new ArrayList<>();
        for (Asset fileEntry : arrayResultFiles) {
            if (readOnly) {
                if (fileEntry.getReadOnly()) {
                    arrayCoincidences.add(fileEntry);
                }
            } else {
                if (!fileEntry.getReadOnly()) {
                    arrayCoincidences.add(fileEntry);
                }
            }
        }
        return arrayCoincidences;
    }

    /**
     * Method to search only files or directories or all of them.
     * @param arrayResultFiles array of Assets.
     * @param typeFile search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public List<Asset> searchFilesOrDirectoriesOnly(List<Asset> arrayResultFiles, int typeFile) {
        arrayCoincidences = new ArrayList<>();
        for (Asset fileEntry : arrayResultFiles) {
            if (typeFile == 1) { /**when typeFile is 1 we want to look only for files (.txt, .docx, .exe, etc)*/
                if (fileEntry instanceof ResultFile) {
                    arrayCoincidences.add(fileEntry);
                }
            }
            if (typeFile == 2) { /**when typeFile is 2 we want to look only for multimedia files (.mp3, .mp4, etc)*/
                if (fileEntry instanceof ResultMultimediaFile) {
                    arrayCoincidences.add(fileEntry);
                }
            }
            if (typeFile == 3) { /**when typeFile is 3 we want to look only for directories*/
                if (fileEntry instanceof ResultDirectory) {
                    arrayCoincidences.add(fileEntry);
                }
            }
            if (typeFile == 0) { /**when typeFile is 0 we look for all type of files*/
                arrayCoincidences.add(fileEntry);
            }
        }
        return arrayCoincidences;
    }
}
