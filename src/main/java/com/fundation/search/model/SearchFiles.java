/**
 * @(#)SearchFiles.java 03/25/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import com.fundation.search.common.Converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
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
    private List<Asset> arrayFinalResult;

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
        arrayFinalResult  = new ArrayList<>();
        File filePath = new File(searchCriteria.getPath());
        assetFactory = new AssetFactory();
        if (searchCriteria.getPath() != null) {
            resultResultFiles = recoverFiles(filePath, arrayResultFiles);
        }
        for (Asset results : resultResultFiles) {
            boolean matchesCriteria = true;
            if (searchCriteria.getName() != null) {
                if (!searchFile(results, searchCriteria.getNameFileCaseSensitive())) {
                    matchesCriteria = false;
                }
            }
            if (matchesCriteria && !searchHiddenFiles(results, searchCriteria.getHidden())) {
                matchesCriteria = false;
            }
            if (matchesCriteria && !searchReadOnlyFiles(results, searchCriteria.getReadOnly())) {
                matchesCriteria = false;
            }
            if (matchesCriteria && !searchFilesOrDirectoriesOnly(results, searchCriteria.getTypeFile())) {
                matchesCriteria = false;
            }
            if (matchesCriteria && !searchOwner(results, searchCriteria.getOwner())) {
                matchesCriteria = false;
            }
            if (results instanceof ResultFile) {
                if (matchesCriteria && !searchExtension(results, searchCriteria.getExtension())) {
                    matchesCriteria = false;
                }
            }
            if (matchesCriteria && !searchSize(results, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure())) {
                matchesCriteria = false;
            }

            if (matchesCriteria) {
                arrayFinalResult.add(results);
            }
        }

    }

    /**
     * Method to get resultResultFiles.
     *
     * @return resultResultFiles is going to get the result files for the search controller.
     */
    public List<Asset> getResultResultFiles() {
        return this.arrayFinalResult;
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
                /**
                 * Section to know a files owner.*/
                Path path2 = Paths.get(fileEntry.getPath());
                FileOwnerAttributeView foav = Files.getFileAttributeView(path2, FileOwnerAttributeView.class);
                UserPrincipal owner = foav.getOwner();

                /**
                 * Section to know last modified date of a file.*/
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String lastModified = dateFormat.format(fileEntry.lastModified());
                //System.out.println("file name: " + fileEntry.getName() + "**last modified:" + fileEntry.lastModified() + "**formated:" + lastModified);
                /*
public static void main(String[] args) throws ParseException {
    String dateString1 = "05-12-2012";
    String dateString2 = "05-13-2012";

    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    Date date1 = format.parse(dateString1);
    Date date2 = format.parse(dateString2);

    if (date1.compareTo(date2) <= 0) {
        System.out.println("dateString1 is an earlier date than dateString2");
    }
}
                 */

                /**
                 * Section to know a files' size*/
                System.out.println("name:" + fileEntry.getName() + ", **Size:" + fileEntry.length());

                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry, arrayResultFiles);
                    arrayResultFiles.add(assetFactory.getAsset("directory", fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 3, owner.getName().substring(owner.getName().indexOf("\\") + 1), null, 0L));
                } else {
                    String extension = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);
                    arrayResultFiles.add(assetFactory.getAsset("file", fileEntry.getPath(), fileEntry.getName(), fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 1, owner.getName().substring(owner.getName().indexOf("\\") + 1), extension, fileEntry.length()));
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
     * Method that returns an array of coincidences of fileNames of files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case fileName coincidences.
     */
    private boolean searchFile(Asset arrayResultFiles, boolean nameFileCaseSensitive) {
        if (nameFileCaseSensitive) {
            if (arrayResultFiles.getFileName().equals(searchCriteria.getName())) {
                return true;
            }
        } else {
            if (arrayResultFiles.getFileName().equalsIgnoreCase(searchCriteria.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns an array of hidden coincidences of files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public boolean searchHiddenFiles(Asset arrayResultFiles, String searchHidden) {
        if (searchHidden == null) {
            return true;
        }
        if (searchHidden.equals("1")) { /**Hidden*/
            if (arrayResultFiles.getHidden()) {
                return true;
            }
        }
        if (searchHidden.equals("2")) { /**No hidden*/
            if (!arrayResultFiles.getHidden()) {
                return true;
            }
        }
        if (searchHidden.equals("3")) { /**All*/
            return true;
        }
        return false;
    }

    /**
     * Method to search only files read only or not.
     * @param arrayResultFiles array of Assets.
     * @param readOnly search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public boolean searchReadOnlyFiles(Asset arrayResultFiles, String readOnly) {
        if (readOnly == null) {
            return true;
        }
        if (readOnly.equals("1")) {
            if (arrayResultFiles.getReadOnly()) {
                return true;
            }
        }
        if (readOnly.equals("2")) {
            if (!arrayResultFiles.getReadOnly()) {
                return true;
            }
        }
        if (readOnly.equals("3")) { /**All*/
            return true;
        }
        return false;
    }

    /**
     * Method to search only files or directories or all of them.
     * @param arrayResultFiles array of Assets.
     * @param typeFile search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public boolean searchFilesOrDirectoriesOnly(Asset arrayResultFiles, int typeFile) {
        if (typeFile == 1) { /**when typeFile is 1 we want to look only for files (.txt, .docx, .exe, etc)*/
            if (arrayResultFiles instanceof ResultFile) {
                return true;
            }
        }
        if (typeFile == 2) { /**when typeFile is 2 we want to look only for multimedia files (.mp3, .mp4, etc)*/
            if (arrayResultFiles instanceof ResultMultimediaFile) {
                return true;
            }
        }
        if (typeFile == 3) { /**when typeFile is 3 we want to look only for directories*/
            if (arrayResultFiles instanceof ResultDirectory) {
                return true;
            }
        }
        if (typeFile == 0) { /**when typeFile is 0 we look for all type of files*/
            return true;
        }

        return false;
    }

    /**
     * Method to filter a file for its owner.
     * @param arrayResultFiles
     * @param owner
     * @return
     */
    public boolean searchOwner(Asset arrayResultFiles, String owner) {
        if (owner != null) {
            if (arrayResultFiles.getOwner().equalsIgnoreCase(owner)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * Method to filter a files for its extension.
     * @param arrayResultFiles
     * @param extension
     * @return
     */
    public boolean searchExtension(Asset arrayResultFiles, String extension) {
        if (extension != null) {
            if (arrayResultFiles.getExtension().equalsIgnoreCase(extension)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean searchSize(Asset arrayResultFiles, String sizeSign, String sizeRequired, String sizeMeasure) {
        if (sizeRequired == null) {
            return true;
        }
        double size = Double.parseDouble(sizeRequired);
        System.out.println("sizeSign:" + sizeSign + ",sizeRequired:" + size + ",sizeMeasure:" + sizeMeasure);
        size = Converter.convertToBytes(size, sizeMeasure);
        if (sizeSign.equalsIgnoreCase("minor")) {
            if (arrayResultFiles.getSize() < size) {
                return true;
            }
            return false;
        }
        if (sizeSign.equalsIgnoreCase("mayor")) {
            if (arrayResultFiles.getSize() > size) {
                return true;
            }
            return false;
        }
        if (sizeSign.equalsIgnoreCase("equals")) {
            if (Math.abs(arrayResultFiles.getSize() - size) <= 100.0) {
                return true;
            }
            return false;
        }
        return true;
    }
}
