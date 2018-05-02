/**
 * @(#)SearchFiles.java 03/25/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import com.fundation.search.common.Converter;
import com.fundation.search.common.SearchQuery;
import com.fundation.search.controller.LoggerCreator;
import com.google.gson.Gson;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    private static final String OS = System.getProperty("os.name").toLowerCase();

    FFprobe fFprobe;

    public SearchFiles() throws IOException {
        LoggerCreator.getInstance().info(this.getClass().getName(),"Search files instance");
        fFprobe = new FFprobe("./bin/ffprobe.exe");
        LoggerCreator.getInstance().info(this.getClass().getName(),"FFprobre instance");
    }

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
    public void init(String searchType) {
        LoggerCreator.getInstance().info(this.getClass().getName(),"Search files init");
        arrayResultFiles = new ArrayList<>();
        arrayFinalResult = new ArrayList<>();
        assetFactory = new AssetFactory();
        File filePath = null;

        if (searchCriteria.getPath() != null) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search files - create file object");
            filePath = new File(searchCriteria.getPath());
        }
        if (searchCriteria.getPath() != null) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search files - begin search");
            resultResultFiles = recoverFiles(filePath, arrayResultFiles);
        }
        for (Asset results : resultResultFiles) {
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Apply criteria to results: " + results.getFileName());
            boolean matchesCriteria = true;
            if (searchCriteria.getName() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search criteria name not null: " + searchCriteria.getNameFileCaseSensitive());
                if (!searchFile(results, searchCriteria.getNameFileCaseSensitive())) {
                    matchesCriteria = false;
                }
            }
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by file system: " + searchCriteria.getFileSystem() + ", enters: " + matchesCriteria);
            if (matchesCriteria && !searchFileSystem(results, searchCriteria.getFileSystem())) {
                matchesCriteria = false;
            }
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by hidden: " + searchCriteria.getHidden() + ", enters: " + matchesCriteria);
            if (matchesCriteria && !searchHiddenFiles(results, searchCriteria.getHidden())) {
                matchesCriteria = false;
            }
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by read only: " + searchCriteria.getReadOnly() + ", enters: " + matchesCriteria);
            if (matchesCriteria && !searchReadOnlyFiles(results, searchCriteria.getReadOnly())) {
                matchesCriteria = false;
            }
            LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by type file: " + searchCriteria.getTypeFile() + ", enters: " + matchesCriteria);
            if (matchesCriteria && !searchFilesOrDirectoriesOnly(results, searchCriteria.getTypeFile())) {
                matchesCriteria = false;
            }
            if (searchCriteria.getOwner() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by owner: " + searchCriteria.getOwner() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchOwner(results, searchCriteria.getOwner())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getExtension() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by extension: " + searchCriteria.getExtension() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchExtension(results, searchCriteria.getExtension())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getSizeRequired() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by size, size sign: " + searchCriteria.getSizeSign() + ", size required: " + searchCriteria.getSizeRequired() + ", size measure: " + searchCriteria.getSizeMeasure() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchSize(results, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure())) {
                    matchesCriteria = false;
                }
            }
            if ((searchCriteria.getCreatedDate() || searchCriteria.getModifiedDate() || searchCriteria.getAccessedDate())) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by date, check created: " + searchCriteria.getCreatedDate() + ", check modified: " + searchCriteria.getModifiedDate() + ", check accessed: " + searchCriteria.getAccessedDate() + ", from date: " + searchCriteria.getFromDate() + ", to date: " + searchCriteria.getToDate() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchDate(results, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getContent() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by content: " + searchCriteria.getContent() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchContent(results, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive())) {
                    matchesCriteria = false;
                }
            }
            /**
             * Search multimedia files*/
            if (searchCriteria.getVideoCodec() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by video codec: " + searchCriteria.getVideoCodec() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchVideoCodec(results, searchCriteria.getVideoCodec())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getAudioCodec() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by audio codec: " + searchCriteria.getAudioCodec() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchAudioCodec(results, searchCriteria.getAudioCodec())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getMajorDuration() > 0.0 || searchCriteria.getMinorDuration() > 0.0) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by duration, major: " + searchCriteria.getMajorDuration() + ", minor: " + searchCriteria.getMinorDuration() +  ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchDuration(results, searchCriteria.getMajorDuration(), searchCriteria.getMinorDuration())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getVideoSize() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by resolution: " + searchCriteria.getVideoSize() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchResolution(results, searchCriteria.getVideoSize())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getAspectRatio() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by resolution: " + searchCriteria.getVideoSize() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchAspectRatio(results, searchCriteria.getAspectRatio())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getFrameRate() != null) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by frame rate: " + searchCriteria.getFrameRate() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchFrameRate(results, searchCriteria.getFrameRate())) {
                    matchesCriteria = false;
                }
            }
            if (searchCriteria.getBitRate() != null && Double.parseDouble(searchCriteria.getBitRate()) > 0.0) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Search by bit rate: " + searchCriteria.getBitRate() + ", enters: " + matchesCriteria);
                if (matchesCriteria && !searchBitRate(results, searchCriteria.getBitRate())) {
                    matchesCriteria = false;
                }
            }
            if (matchesCriteria) {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Passes search criteria: " + results.getFileName());
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
    private List<Asset> recoverFiles(File path, List<Asset> arrayResultFiles) {
        LoggerCreator.getInstance().info(this.getClass().getName(),"Search files - recoverFiles method");
        try {
            for (File fileEntry : path.listFiles()) {
                /**
                 * Section to know a files owner.*/
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Path of file");
                Path path2 = Paths.get(fileEntry.getPath());
                LoggerCreator.getInstance().debug(this.getClass().getName(),"File attribute to get Owner");
                FileOwnerAttributeView foav = Files.getFileAttributeView(path2, FileOwnerAttributeView.class);
                UserPrincipal owner = foav.getOwner();

                /**
                 * Section to know a files dates*/
                LoggerCreator.getInstance().debug(this.getClass().getName(),"Get File dates");
                BasicFileAttributes fileAttributes = Files.readAttributes(fileEntry.toPath(), BasicFileAttributes.class);
                DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                String creationTime = dateFormat.format(fileAttributes.creationTime().toMillis());
                String lastAccessTime = dateFormat.format(fileAttributes.lastAccessTime().toMillis());
                String lastModifiedTime = dateFormat.format(fileAttributes.lastModifiedTime().toMillis());
                LoggerCreator.getInstance().debug(this.getClass().getName(),"System file");
                boolean isFileSystem = OS.contains("windows") ? Files.readAttributes(path.toPath(), DosFileAttributes.class).isSystem() : false;

                assetFactory = new AssetFactory();
                if (fileEntry.isDirectory()) {
                    LoggerCreator.getInstance().debug(this.getClass().getName(),"Directory");
                    long directorySize = FileUtils.sizeOfDirectory(fileEntry);
                    recoverFiles(fileEntry, arrayResultFiles);
                    arrayResultFiles.add(assetFactory.getAsset("directory", fileEntry.getPath(), fileEntry.getName(),
                            fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 3,
                            owner.getName().substring(owner.getName().indexOf("\\") + 1),
                            null, directorySize, creationTime, lastAccessTime, lastModifiedTime,
                            null, null, 0.0, 0, null, null, isFileSystem));
                } else if (!isMultimedia(fileEntry)) {
                    LoggerCreator.getInstance().debug(this.getClass().getName(),"File get extension");
                    String extension = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);

                    arrayResultFiles.add(assetFactory.getAsset("file", fileEntry.getPath(), fileEntry.getName(),
                            fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 1,
                            owner.getName().substring(owner.getName().indexOf("\\") + 1),
                            extension, fileEntry.length(), creationTime, lastAccessTime, lastModifiedTime,
                            null, null, 0.0, 0, null, null, isFileSystem));
                } else if (isMultimedia(fileEntry)) {
                    LoggerCreator.getInstance().debug(this.getClass().getName(),"Multimedia file extension");
                    String extension = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);
                    LoggerCreator.getInstance().debug(this.getClass().getName(),"ffprob get streams");
                    List<FFmpegStream> streams = fFprobe.probe(fileEntry.getPath()).getStreams();
                    if (streams.size() >= 1 && !isAudio(fileEntry)) {
                        LoggerCreator.getInstance().debug(this.getClass().getName(),"Multimedia is video with values");
                        String codecVideo = "";
                        String codecAudio = "";
                        double frameRate = 0.0;
                        double duration = 0.0;
                        String videoSize = "";
                        int audioBitRate = 0;
                        String aspectRatio = "";
                        for (int i = 0; i < streams.size(); i++) {
                            LoggerCreator.getInstance().debug(this.getClass().getName(),"Get multimedia attributes");
                            FFmpegStream stream = fFprobe.probe(fileEntry.getPath()).getStreams().get(i);
                            if (stream.codec_type.name().equalsIgnoreCase("video")) {
                                videoSize = stream.width + "x" + stream.height;
                                codecVideo = stream.codec_name;
                                frameRate = getFrameRate(stream.r_frame_rate);
                                aspectRatio = stream.display_aspect_ratio;
                                duration = stream.duration;

                            }
                            if (stream.codec_type.name().equalsIgnoreCase("audio")) {
                                codecAudio = stream.codec_name;
                                audioBitRate = (int) stream.bit_rate / 1000;
                            }
                        }
                        arrayResultFiles.add(assetFactory.getAsset("multimedia", fileEntry.getPath(), fileEntry.getName(),
                                fileEntry.isHidden(), duration, !fileEntry.canWrite(), 2,
                                owner.getName().substring(owner.getName().indexOf("\\") + 1),
                                extension, fileEntry.length(), creationTime, lastAccessTime, lastModifiedTime,
                                codecVideo, codecAudio, frameRate, audioBitRate, videoSize, aspectRatio, isFileSystem));
                    }
                }
            }

        } catch (NullPointerException e) {
            LoggerCreator.getInstance().error(this.getClass().getName(),"",e);
        } catch (IOException e) {
            LoggerCreator.getInstance().error(this.getClass().getName(),"",e);
            e.printStackTrace();
        }

        return arrayResultFiles;
    }

    /**
     * @param fileEntry
     * @return true is a audio file.
     */
    private boolean isAudio(File fileEntry) {
        String ext = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);
        if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("aac") || ext.equalsIgnoreCase("ogg")
                || ext.equalsIgnoreCase("wma") || ext.equalsIgnoreCase("wav") || ext.equalsIgnoreCase("flac")
                || ext.equalsIgnoreCase("m4a")) {
            return true;
        }
        return false;
    }

    /**
     * Method that returns an array of coincidences of fileNames of files of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case fileName coincidences.
     */
    private boolean searchFile(Asset arrayResultFiles, boolean nameFileCaseSensitive) {
        if (nameFileCaseSensitive) {
            if (searchWildcardCaseSensitive(arrayResultFiles)) {
                return true;
            }
            if (arrayResultFiles.getFileName().equals(searchCriteria.getName())) {
                return true;
            }
        } else {
            if (searchWildcardNoCaseSensitive(arrayResultFiles)) {
                return true;
            }
            if (arrayResultFiles.getFileName().equalsIgnoreCase(searchCriteria.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to search for file's name wildcard when it is case sensitive.
     *
     * @param asset the file.
     * @return true or false.
     */
    private boolean searchWildcardCaseSensitive(Asset asset) {
        try {
            if ("*".equals(searchCriteria.getName())) {
                return true;
            }
            if ("*".equals(searchCriteria.getName().substring(0, 1)) && "*".equals(searchCriteria.getName().substring(searchCriteria.getName().length() - 1))) {
                return asset.getFileName().contains(searchCriteria.getName().substring(1, searchCriteria.getName().length() - 1));
            }
            if ("*".equals(searchCriteria.getName().substring(0, 1))) {
                return asset.getFileName().endsWith(searchCriteria.getName().substring(1));
            }
            if ("*".equals(searchCriteria.getName().substring(searchCriteria.getName().length() - 1))) {
                return asset.getFileName().startsWith(searchCriteria.getName().substring(0, searchCriteria.getName().length() - 1));
            }
            return false;
        } catch (StringIndexOutOfBoundsException ex) {
            LoggerCreator.getInstance().error(this.getClass().getName(),"searchWildcardCaseSensitive method, ", ex);
            return false;
        }
    }

    /**
     * Method to search for file's name wildcard when it is not case sensitive.
     *
     * @param asset the file.
     * @return true or false.
     */
    private boolean searchWildcardNoCaseSensitive(Asset asset) {
        try {
            if ("*".equals(searchCriteria.getName())) {
                return true;
            }
            if ("*".equals(searchCriteria.getName().substring(0, 1)) && "*".equals(searchCriteria.getName().substring(searchCriteria.getName().length() - 1))) {
                return asset.getFileName().toUpperCase().contains(searchCriteria.getName().toUpperCase().substring(1, searchCriteria.getName().length() - 1));
            }
            if ("*".equals(searchCriteria.getName().substring(0, 1))) {
                return asset.getFileName().toUpperCase().endsWith(searchCriteria.getName().toUpperCase().substring(1));
            }
            if ("*".equals(searchCriteria.getName().substring(searchCriteria.getName().length() - 1))) {
                return asset.getFileName().toUpperCase().startsWith(searchCriteria.getName().toUpperCase().substring(0, searchCriteria.getName().length() - 1));
            }
            return false;
        } catch (StringIndexOutOfBoundsException ex) {
            LoggerCreator.getInstance().error(this.getClass().getName(),"searchWildcardNoCaseSensitive method, ", ex);
            return false;
        }

    }
//

    /**
     * Method that returns an array of file system coincidences of a path.
     *
     * @param arrayResultFiles is the array of ResultFile objects.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    private boolean searchFileSystem(Asset arrayResultFiles, boolean fileSystem) {
        if (!fileSystem) { /**file system*/
            if (arrayResultFiles.getFileSystem()) {
                return false;
            }
            if (!arrayResultFiles.getFileSystem()) {
                return true;
            }

        }

        if (fileSystem) { /**file system*/
            if (arrayResultFiles.getFileSystem()) {
                return true;
            }
            if (!arrayResultFiles.getFileSystem()) {
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
    private boolean searchHiddenFiles(Asset arrayResultFiles, String searchHidden) {
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
     *
     * @param arrayResultFiles array of Assets.
     * @param readOnly         search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    private boolean searchReadOnlyFiles(Asset arrayResultFiles, String readOnly) {
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
     *
     * @param arrayResultFiles array of Assets.
     * @param typeFile         search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    private boolean searchFilesOrDirectoriesOnly(Asset arrayResultFiles, int typeFile) {
        if (typeFile == 0) { /**when typeFile is 0 we look for all type of files*/
            return true;
        }
        if (typeFile == 1) { /**when typeFile is 1 we want to look only for files (.txt, .docx, .exe, etc)*/
            if (arrayResultFiles instanceof ResultFile) {
                return true;
            }
        }
        if (typeFile == 3) { /**when typeFile is 3 we want to look only for directories*/
            if (arrayResultFiles instanceof ResultDirectory) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to filter a file for its owner.
     *
     * @param arrayResultFiles
     * @param owner
     * @return
     */
    private boolean searchOwner(Asset arrayResultFiles, String owner) {
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
     *
     * @param arrayResultFiles
     * @param extension
     * @return
     */
    private boolean searchExtension(Asset arrayResultFiles, String extension) {
        if (!(arrayResultFiles instanceof ResultFile || arrayResultFiles instanceof ResultMultimediaFile)) {
            return false;
        }
        if (extension != null) {
            if (arrayResultFiles.getExtension().equalsIgnoreCase(extension)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * Method to filter a files for its size.
     *
     * @param arrayResultFiles
     * @param sizeSign
     * @param sizeRequired
     * @param sizeMeasure
     * @return
     */
    private boolean searchSize(Asset arrayResultFiles, String sizeSign, String sizeRequired, String sizeMeasure) {
        if (sizeRequired == null) {
            return true;
        }
        double size = Double.parseDouble(sizeRequired);
        size = Converter.convertToBytes(size, sizeMeasure);
        if (sizeSign.equalsIgnoreCase("minor")) {
            if (arrayResultFiles.getSize() < size) {
                return true;
            }
            return false;
        }
        if (sizeSign.equalsIgnoreCase("major")) {
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

    /**
     * Method to search files for its date (creation, modification, and last accessed date)
     *
     * @param arrayResultFiles
     * @param createDate
     * @param modifiedDate
     * @param accessedDate
     * @param fromDate
     * @param toDate
     * @return
     */
    private boolean searchDate(Asset arrayResultFiles, boolean createDate, boolean modifiedDate,
                               boolean accessedDate, String fromDate, String toDate) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        boolean dateInRange = true;
        if (createDate || modifiedDate || accessedDate) {
            try {
                LoggerCreator.getInstance().debug(this.getClass().getName(),"searchDate method - dates from format");
                Date dateFromDate = formatDate.parse(fromDate);
                LoggerCreator.getInstance().debug(this.getClass().getName(),"searchDate method - dates to format");
                Date dateToDate = formatDate.parse(toDate);
                LoggerCreator.getInstance().debug(this.getClass().getName(),"searchDate method - date creation format");
                Date dateCreation = formatDate.parse(arrayResultFiles.getCreationTime());
                LoggerCreator.getInstance().debug(this.getClass().getName(),"searchDate method - date modification format");
                Date dateModification = formatDate.parse(arrayResultFiles.getLastModifiedTime());
                LoggerCreator.getInstance().debug(this.getClass().getName(),"searchDate method - date accessed format");
                Date dateAccessed = formatDate.parse(arrayResultFiles.getLastAccessTime());
                if (createDate) {
                    dateInRange = false;
                    if (dateFromDate.compareTo(dateCreation) <= 0 && dateToDate.compareTo(dateCreation) >= 0) {
                        dateInRange = true;
                    }
                }
                if (dateInRange && modifiedDate) {
                    dateInRange = false;
                    if (dateFromDate.compareTo(dateModification) <= 0 && dateToDate.compareTo(dateModification) >= 0) {
                        dateInRange = true;
                    }
                }
                if (dateInRange && accessedDate) {
                    dateInRange = false;
                    if (dateFromDate.compareTo(dateAccessed) <= 0 && dateToDate.compareTo(dateAccessed) >= 0) {
                        dateInRange = true;
                    }
                }
            } catch (ParseException e) {
                LoggerCreator.getInstance().error(this.getClass().getName(),"searchDate method, ", e);
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return dateInRange;
    }

    /**
     * Method to get file's content.
     *
     * @param fileEntry
     * @param extension
     * @return
     */
    private String getFileContent(Asset fileEntry, String extension) {
        if (extension.equalsIgnoreCase("docx") && fileEntry.getSize() > 0L) {
            try {
                FileInputStream fis = new FileInputStream(fileEntry.getPath());
                XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                return extractor.getText();
            } catch (Exception ex) {
                LoggerCreator.getInstance().error(this.getClass().getName(),"getFileContent method - docx, ", ex);
                return null;
            }
        }
        if (extension.equalsIgnoreCase("txt") && fileEntry.getSize() > 0L) {
            String content = null;
            try {
                Scanner in = new Scanner(new FileReader(fileEntry.getPath()));
                while (in.hasNextLine()) {
                    content = in.nextLine();
                }
            } catch (IOException e) {
                LoggerCreator.getInstance().error(this.getClass().getName(),"getFileContent method - txt, ", e);
                e.printStackTrace();
            }
            return content;
        }
        if (extension.equalsIgnoreCase("pdf") && fileEntry.getSize() > 0L) {
            try {
                PDDocument document = PDDocument.load(new File(fileEntry.getPath()));
                document.getClass();
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    String pdfFileInText = tStripper.getText(document);
                    return pdfFileInText.toString();
                }
            } catch (Exception e) {
                LoggerCreator.getInstance().error(this.getClass().getName(),"getFileContent method - pdf, ", e);
                e.getMessage();
            }

        }
        return null;
    }

    /**
     * Method to search for file's content.
     *
     * @param arrayResultFiles
     * @param content
     * @param contentCaseSensitive
     * @return
     */
    private boolean searchContent(Asset arrayResultFiles, String content, boolean contentCaseSensitive) {
        if (!(arrayResultFiles instanceof ResultFile)) {
            return false;
        }
        String fileContent = getFileContent(arrayResultFiles, arrayResultFiles.getExtension());
        if (content == null) {
            return true;
        }
        if (contentCaseSensitive) {
            if (fileContent != null && fileContent.toUpperCase().contains(content.toUpperCase())) {
                return true;
            }
        } else {
            if (fileContent != null && fileContent.contains(content)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to saveSearchCriteria
     *
     * @return a string with the json search criterial
     */
    public String saveSearchCriteria() {
        Gson gson = new Gson();
        String json = gson.toJson(searchCriteria);
        LoggerCreator.getInstance().debug(this.getClass().getName(),"saveSearchCriteria method: " + json);
        SearchQuery searchQuery = new SearchQuery();

        return searchQuery.addCriteria(json);
    }
    public String deleteSearchCriteria(String key) {
        SearchQuery searchQuery = new SearchQuery();
        return searchQuery.deleteCriteria(key);
    }

    /**
     * Method to filter multimedia files.
     *
     * @param file
     * @return
     */
    public boolean isMultimedia(File file) {
        String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("avi")
                || ext.equalsIgnoreCase("mpg") || ext.equalsIgnoreCase("flv")
                || ext.equalsIgnoreCase("mkv")
                || ext.equalsIgnoreCase("mov") || ext.equalsIgnoreCase("wmv")
                || ext.equalsIgnoreCase("webm") || ext.equalsIgnoreCase("vob")) {
            return true;
        }
        return false;
    }

    /**
     * Method to get video frame rate.
     *
     * @param fraction
     * @return
     */
    public double getFrameRate(Fraction fraction) {
        return fraction.doubleValue();
    }

    /**
     * Method to search video codec.
     *
     * @param asset
     * @param codec
     * @return
     */
    public boolean searchVideoCodec(Asset asset, String codec) {
        if ("all".equalsIgnoreCase(codec)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return (codec.toLowerCase().contains(((ResultMultimediaFile) asset).getVideoCodec()));
        }
        return false;
    }

    /**
     * Method to search audio codec.
     *
     * @param asset
     * @param codec
     * @return
     */
    public boolean searchAudioCodec(Asset asset, String codec) {
        if ("all".equalsIgnoreCase(codec)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return (codec.toLowerCase().contains(((ResultMultimediaFile) asset).getAudioCodec()));
        }
        return false;
    }

    /**
     * Method to search resolution.
     *
     * @param asset
     * @param resolution
     * @return
     */
    public boolean searchResolution(Asset asset, String resolution) {
        if ("all".equalsIgnoreCase(resolution)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return resolution.equalsIgnoreCase(((ResultMultimediaFile) asset).getVideoSize());
        }
        return false;
    }

    /**
     * Method to search aspect ratio.
     *
     * @param asset
     * @param aspectRatio
     * @return
     */
    public boolean searchAspectRatio(Asset asset, String aspectRatio) {
        if ("all".equalsIgnoreCase(aspectRatio)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return aspectRatio.equalsIgnoreCase(((ResultMultimediaFile) asset).getAspectRatio());
        }
        return false;
    }

    /**
     * Method to search frame rate.
     *
     * @param asset
     * @param frameRate
     * @return
     */
    public boolean searchFrameRate(Asset asset, String frameRate) {
        if ("all".equalsIgnoreCase(frameRate)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            DecimalFormat df = new DecimalFormat("#.##");
            String fileFrameRate = df.format(((ResultMultimediaFile) asset).getFrameRate());
            return frameRate.equals(fileFrameRate);
        }
        return false;
    }

    /**
     * Method to search bit rate.
     *
     * @param asset
     * @param bitRate
     * @return
     */
    public boolean searchBitRate(Asset asset, String bitRate) {
        int bit = (int) Double.parseDouble(bitRate);
        if (asset instanceof ResultMultimediaFile) {
            return ((ResultMultimediaFile) asset).getAudioBitRate() == bit;
        }
        return false;
    }

    /**
     * Method to search duration.
     *
     * @param asset
     * @param majorDuration
     * @param minorDuration
     * @return
     */
    public boolean searchDuration(Asset asset, double majorDuration, double minorDuration) {
        if (asset instanceof ResultMultimediaFile) {
            if ((((ResultMultimediaFile) asset).getDuration() < majorDuration) &&
                    (((ResultMultimediaFile) asset).getDuration() > minorDuration)) {
                return true;
            }
            return false;
        }
        return false;
    }
}

