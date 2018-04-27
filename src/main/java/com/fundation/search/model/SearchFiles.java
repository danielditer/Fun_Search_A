/**
 * @(#)SearchFiles.java 03/25/18
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

import com.fundation.search.common.Converter;
import com.fundation.search.common.SearchQuery;
import com.google.gson.Gson;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.spi.FileTypeDetector;
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
    private AbstractSearchCriteria searchCriteria;
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

    //private SearchCriteriaMultimedia searchCriteriaMultimedia;
    /**
     * Object to create asset objects (files, multimedia, directory).
     */
    private AssetFactory assetFactory;

    FFprobe fFprobe;

    public SearchFiles() throws IOException {
    }

    /**
     * Method to set searchCriteria attribute.
     *
     * @param searchCriteria is the param received in order to set the search criteria.
     */
    public void setSearchCriteria(AbstractSearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * Method to initialize search.
     */
    public void init(String searchType) {
        arrayResultFiles = new ArrayList<>();
        arrayFinalResult = new ArrayList<>();
        assetFactory = new AssetFactory();
        File filePath = null;
        if ("1".equals(searchType)) {
            if (searchCriteria.getPath() != null) {
                filePath = new File(searchCriteria.getPath());
            }
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
                if (searchCriteria.getOwner() != null) {
                    if (matchesCriteria && !searchOwner(results, searchCriteria.getOwner())) {
                        matchesCriteria = false;
                    }
                }
                if (searchCriteria.getExtension() != null) {
                    if (matchesCriteria && !searchExtension(results, searchCriteria.getExtension())) {
                        matchesCriteria = false;
                    }
                }
                if (searchCriteria.getSizeRequired() != null) {
                    if (matchesCriteria && !searchSize(results, searchCriteria.getSizeSign(), searchCriteria.getSizeRequired(), searchCriteria.getSizeMeasure())) {
                        matchesCriteria = false;
                    }
                }
                if ((searchCriteria.getCreatedDate() || searchCriteria.getModifiedDate() || searchCriteria.getAccessedDate()) && results instanceof ResultFile) {
                    if (matchesCriteria && !searchDate(results, searchCriteria.getCreatedDate(), searchCriteria.getModifiedDate(), searchCriteria.getAccessedDate(), searchCriteria.getFromDate(), searchCriteria.getToDate())) {
                        matchesCriteria = false;
                    }
                }
                if (searchCriteria.getContent() != null) {
                    if (matchesCriteria && !searchContent(results, searchCriteria.getContent(), searchCriteria.getContentCaseSensitive())) {
                        matchesCriteria = false;
                    }
                }
                if (matchesCriteria) {
                    arrayFinalResult.add(results);
                }
            }
        } else if ("2".equals(searchType)) {
            if (searchCriteria.getPath() != null) {
                filePath = new File(searchCriteria.getPath());
            }
            if (searchCriteria.getPath() != null) {
                resultResultFiles = recoverFiles(filePath, arrayResultFiles);
            }
            for (Asset results : resultResultFiles) {
                boolean matchesCriteriaMulti = true;
                if (searchCriteria.getName() != null) {
                    if (!searchFile(results, searchCriteria.getNameFileCaseSensitive())) {
                        matchesCriteriaMulti = false;
                    }
                }
                if (matchesCriteriaMulti && !searchCodec(results, searchCriteria.getCodec())) {
                    matchesCriteriaMulti = false;
                }
                if (matchesCriteriaMulti && !searchResolution(results, searchCriteria.getVideoSize())) {
                    matchesCriteriaMulti = false;
                }
                if (matchesCriteriaMulti && !searchAspectRatio(results, searchCriteria.getAspectRatio())) {
                    matchesCriteriaMulti = false;
                }
                if (matchesCriteriaMulti && !searchFrameRate(results, searchCriteria.getFrameRate())) {
                    matchesCriteriaMulti = false;
                }
                if (searchCriteria.getBitRate() != null) {
                    if (matchesCriteriaMulti && !searchBitRate(results, searchCriteria.getBitRate())) {
                        matchesCriteriaMulti = false;
                    }
                }
                if (matchesCriteriaMulti) {
                    arrayFinalResult.add(results);
                }
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
                 * Section to know a files dates*/
                BasicFileAttributes fileAttributes = Files.readAttributes(fileEntry.toPath(), BasicFileAttributes.class);
                DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                String creationTime = dateFormat.format(fileAttributes.creationTime().toMillis());
                String lastAccessTime = dateFormat.format(fileAttributes.lastAccessTime().toMillis());
                String lastModifiedTime = dateFormat.format(fileAttributes.lastModifiedTime().toMillis());
                assetFactory = new AssetFactory();
                if (fileEntry.isDirectory()) {
                    recoverFiles(fileEntry, arrayResultFiles);
                    arrayResultFiles.add(assetFactory.getAsset("directory", fileEntry.getPath(), fileEntry.getName(),
                            fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 3,
                            owner.getName().substring(owner.getName().indexOf("\\") + 1),
                            null, 0L, null, null, null, null, 0.0, 0, null, null));
                } else if (!isMultimedia(fileEntry)) {
                    String extension = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);

                    arrayResultFiles.add(assetFactory.getAsset("file", fileEntry.getPath(), fileEntry.getName(),
                            fileEntry.isHidden(), 0.0, !fileEntry.canWrite(), 1,
                            owner.getName().substring(owner.getName().indexOf("\\") + 1),
                            extension, fileEntry.length(), creationTime, lastAccessTime, lastModifiedTime, null, 0.0, 0, null, null));
                } else if (isMultimedia(fileEntry)) {
                    fFprobe = new FFprobe("C:\\FFMPEG\\bin\\ffprobe.exe");
                    String extension = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);
                    FFmpegStream multimediaFile = fFprobe.probe(fileEntry.getPath()).getStreams().get(0);
                    double duration = multimediaFile.duration;
                    if (!isAudio(fileEntry)) {
                        String videoSize = multimediaFile.width + "x" + multimediaFile.height;
                        System.out.println("frame rate:" + getFrameRate(multimediaFile.r_frame_rate));
                        arrayResultFiles.add(assetFactory.getAsset("multimedia", fileEntry.getPath(), fileEntry.getName(),
                                fileEntry.isHidden(), duration, !fileEntry.canWrite(), 2,
                                owner.getName().substring(owner.getName().indexOf("\\") + 1),
                                extension, fileEntry.length(), creationTime, lastAccessTime, lastModifiedTime, multimediaFile.codec_name, getFrameRate(multimediaFile.r_frame_rate), 0, videoSize, multimediaFile.display_aspect_ratio));
                    } else {
                        String videoSize = multimediaFile.width + "x" + multimediaFile.height;
                        arrayResultFiles.add(assetFactory.getAsset("multimedia", fileEntry.getPath(), fileEntry.getName(),
                                fileEntry.isHidden(), duration, !fileEntry.canWrite(), 2,
                                owner.getName().substring(owner.getName().indexOf("\\") + 1),
                                extension, fileEntry.length(), creationTime, lastAccessTime, lastModifiedTime, multimediaFile.codec_name, 0.0, (int) multimediaFile.bit_rate / 1000, videoSize, multimediaFile.display_aspect_ratio));
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayResultFiles;
    }

    private boolean isAudio(File fileEntry) {
        String ext = fileEntry.getName().substring(fileEntry.getName().lastIndexOf(".") + 1);
        System.out.println(ext);
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
            return false;
        }

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
     *
     * @param arrayResultFiles array of Assets.
     * @param readOnly         search criteria value.
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
     *
     * @param arrayResultFiles array of Assets.
     * @param typeFile         search criteria value.
     * @return the array of coincidences, in this case hidden file coincidences.
     */
    public boolean searchFilesOrDirectoriesOnly(Asset arrayResultFiles, int typeFile) {
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
     *
     * @param arrayResultFiles
     * @param extension
     * @return
     */
    public boolean searchExtension(Asset arrayResultFiles, String extension) {
        if (!(arrayResultFiles instanceof ResultFile)) {
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
    public boolean searchSize(Asset arrayResultFiles, String sizeSign, String sizeRequired, String sizeMeasure) {
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

    public boolean searchDate(Asset arrayResultFiles, boolean createDate, boolean modifiedDate, boolean accessedDate, String fromDate, String toDate) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        boolean dateInRange = true;
        if (createDate || modifiedDate || accessedDate) {
            try {
                Date dateFromDate = formatDate.parse(fromDate);
                Date dateToDate = formatDate.parse(toDate);
                Date dateCreation = formatDate.parse(arrayResultFiles.getCreationTime());
                Date dateModification = formatDate.parse(arrayResultFiles.getLastModifiedTime());
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
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return dateInRange;
    }

    public String getFileContent(Asset fileEntry, String extension) {
        if (extension.equalsIgnoreCase("docx") && fileEntry.getSize() > 0L) {
            try {
                FileInputStream fis = new FileInputStream(fileEntry.getPath());
                XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                return extractor.getText();
            } catch (Exception ex) {
                return null;
            }
        }
        if (extension.equalsIgnoreCase("txt") && fileEntry.getSize() > 0L) {
            Scanner in = null;
            String content = null;
            try {
                in = new Scanner(new FileReader(fileEntry.getFileName()));
                while (in.hasNextLine()) {
                    content = in.nextLine();
                }
            } catch (IOException e) {
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
                e.getMessage();
            }

        }
        return null;
    }


    public boolean searchContent(Asset arrayResultFiles, String content, boolean contentCaseSensitive) {
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
     * method saveSearchCriteria
     *
     * @return a string with the json search criterial
     */

    public String saveSearchCriteria() {
        Gson gson = new Gson();
        String json = gson.toJson(searchCriteria);
        System.out.println("JSON:" + json);
        SearchQuery searchQuery = new SearchQuery();

        return searchQuery.addCriteria(json);
    }

    public boolean isMultimedia(File file) {
        String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        System.out.println(ext);
        if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("aac") || ext.equalsIgnoreCase("ogg") || ext.equalsIgnoreCase("avi")
                || ext.equalsIgnoreCase("wma") || ext.equalsIgnoreCase("wav") || ext.equalsIgnoreCase("flac") || ext.equalsIgnoreCase("mpg") || ext.equalsIgnoreCase("flv")
                || ext.equalsIgnoreCase("m4a") || ext.equalsIgnoreCase("mkv")
                || ext.equalsIgnoreCase("mov") || ext.equalsIgnoreCase("wmv")
                || ext.equalsIgnoreCase("webm") || ext.equalsIgnoreCase("vob")) {
            return true;
        }
        return false;
    }


    public double getFrameRate(Fraction fraction) {
        return fraction.doubleValue();
    }

    public boolean searchCodec(Asset asset, String codec) {
        if ("all".equalsIgnoreCase(codec)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return (codec.toLowerCase().contains(((ResultMultimediaFile) asset).getCodec()));
        }
        return false;
    }

    public boolean searchResolution(Asset asset, String resolution) {
        if ("all".equalsIgnoreCase(resolution)) {
            return true;
        }
        if (asset instanceof ResultMultimediaFile) {
            return ((ResultMultimediaFile) asset).getVideoSize().equalsIgnoreCase(resolution);
        }
        return false;
    }

    public boolean searchAspectRatio(Asset asset, String aspectRatio) {
        if ("all".equalsIgnoreCase(aspectRatio)) {
            return true;
        }
        if ("null".equalsIgnoreCase(aspectRatio)) {
            return false;
        }
        if (asset instanceof ResultMultimediaFile) {
            System.out.println("aspect ratio:"+((ResultMultimediaFile) asset).getAspectRatio());
            return ((ResultMultimediaFile) asset).getAspectRatio().equalsIgnoreCase(aspectRatio);
        }
        return false;
    }

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

    public boolean searchBitRate(Asset asset, String bitRate) {
        if (asset instanceof ResultMultimediaFile) {
            int bit = (int) Double.parseDouble(bitRate);
            if (bit > 0) {
                System.out.println("bit rate:" + ((ResultMultimediaFile) asset).getAudioBitRate());
                return ((ResultMultimediaFile) asset).getAudioBitRate() == bit;
            }
            return true;
        }
        return false;
    }
}
