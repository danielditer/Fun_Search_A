/**
 * @(#)Controller.java 03/28/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.common.SearchQuery;
import com.fundation.search.common.Validator;
import com.fundation.search.model.*;
import com.fundation.search.view.*;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the Controller for MVC pattern,
 * it will get values from view, then send to model,
 * get results from model and display in view.
 * For this release results are not displayed in view, just in console.
 *
 * @version 28 Mar 2018  * @Juan Manuel
 */
public class SearchController implements Controller {
    /**
     * Model instance
     */
    private SearchFiles searchFile;
    /**
     * View instance
     */
    private MainView mainView;
    /**
     * Search criteria to search files
     */
    private SearchCriteria searchCriteria;
    /**
     * Search criteria to save in DB
     */
    private SearchCriteria searchCriteriaForDB;
    /**
     * Map with search criteria results of DB query
     */
    private Map<Integer, SearchCriteria> mapSearchCriteriasResults;

    /**
     * Constructor for controller.
     *
     * @param searchFile
     * @param mainView
     */
    public SearchController(SearchFiles searchFile, MainView mainView) {
        this.searchFile = searchFile;
        this.mainView = mainView;
    }

    /**
     * Method to initialize all controller methods.
     */
    @Override
    public void init() {
        searchActionPerformed();
        clearActionPerformed();
        saveActionPerformed();
        loadActionPerformed();
        selectActionPerformed();
        deleteActionPerformed();
    }

    /**
     * Method to get values from button search in the View.
     */
    public void searchActionPerformed() {
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        PanelButtonSearch panelButtonSearch = (PanelButtonSearch) mainView.getPanelButton();
        PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
        PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
        panelButtonSearch.getButtonSearch().addActionListener(e -> searchButtonActionListener(panel, panelNamePath, panelMultimediaSearch));
    }

    /**
     * Method to clear values the View.
     */
    public void clearActionPerformed() {
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        PanelSaveCriterial panelSaveCriterial = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
        PanelSearchResults panelResults = (PanelSearchResults) mainView.getPanelResultList();
        PanelButtonSearch panelButtonSearch = (PanelButtonSearch) mainView.getPanelButton();
        PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
        PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
        panelButtonSearch.getButtonClear().addActionListener(e -> clearButtonActionListener(panel, panelSaveCriterial, panelResults, panelNamePath, panelMultimediaSearch));
    }

    /**
     * Method to save a criteria in the database using save button on the View.
     */
    public void saveActionPerformed() {
        PanelSaveCriterial panel = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
        PanelNormalSearch panelMain = (PanelNormalSearch) mainView.getPanel();
        PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
        PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
        panel.getButtonSave().addActionListener(e -> saveButtonActionListener(panel, panelMain, panelNamePath, panelMultimediaSearch));
    }

    /**
     * Method to load a criteria from the database by using button ´Load´ in the View.
     */
    public void loadActionPerformed() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        panel.getButtonLoad().addActionListener(e -> loadButtonActionListener(panel));
    }

    /**
     * Method to select a criteria and fill al items.
     */
    public void selectActionPerformed() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        panel.getButtonSelect().addActionListener(e -> selectButtonActionListener(panel));
    }

    /**
     * Method to delete a criteria.
     */
    public void deleteActionPerformed() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        panel.getButtonDelete().addActionListener(e -> deleteButtonActionListener(panel));
    }

    /**
     * Method lambda to add action listener for button search.
     *
     * @param panel
     */
    public void searchButtonActionListener(PanelNormalSearch panel, PanelNamePath panelNamePath, PanelMultimediaSearch panelMultimediaSearch) {
        String typeFileString = panelNamePath.getBtnGroupTypeFiles();
        int typeFile = Integer.parseInt(typeFileString);
        if (areValidParams(panelNamePath.getPath(), panelNamePath.getName(), panel.getFormattedTextFieldStart(), panel.getFormattedTextFieldEnd(), panel.getCheckBoxCreated(), panel.getCheckBoxModified(), panel.getCheckBoxAccessed(), panel.getTextFieldSize())) {
            sendSearchCriteriaToModel(panelNamePath.getPath(), panelNamePath.getName(), panel.getCheckBoxHidden(), panel.getCheckBoxReadOnly(),
                    typeFile, panelNamePath.getCaseSensitive(), panelNamePath.getFileSystem(), panel.getTextFieldOwner(), panel.getTextFieldExt(),
                    panel.getComboBoxSize(), panel.getTextFieldSize(), panel.getComboBoxType(),
                    panel.getCheckBoxCreated(), panel.getCheckBoxModified(), panel.getCheckBoxAccessed(),
                    panel.getFormattedTextFieldStart(), panel.getFormattedTextFieldEnd(),
                    panel.getContent(), panel.getCaseSensitiveContent(),
                    panelMultimediaSearch.getMajorDuration(), panelMultimediaSearch.getMinorDuration(),
                    panelMultimediaSearch.getCodec(), panelMultimediaSearch.getResolution(), panelMultimediaSearch.getFrameRate(), panelMultimediaSearch.getBitRate(), panelMultimediaSearch.getAspectRatio(), panelMultimediaSearch.getAudioCodec());
        }
    }

    /**
     * This method clear the fields with the information retrieved of a search criteria selected.
     *
     * @param panelMain is the panel that contain all the elements for the normal search
     */
    public void clearButtonActionListener(PanelNormalSearch panelMain, PanelSaveCriterial panelSaveCriterial, PanelSearchResults panelResults, PanelNamePath panelNamePath, PanelMultimediaSearch panelMultimediaSearch) {
        panelSaveCriterial.setTextFieldName("");
        DefaultTableModel tableModel = panelResults.getTableModel();
        tableModel.setRowCount(0);
        panelResults.setTableModel(tableModel);
        panelNamePath.setTextFieldName(null);
        panelNamePath.setTextFieldPath(null);
        panelNamePath.setCheckBoxCaseSensitiveName(false);
        panelNamePath.setBtnAllFiles("0");
        panelNamePath.setCheckBoxFileSystem(false);
        panelMain.setBtnGroupHiddenAttributes("3");
        panelMain.setBtnGroupReadOnlyAttributes("3");
        panelMain.setTextFieldExtAttributes(null);
        panelMain.setComboBoxSizeAttributes("Minor");
        panelMain.setTextFieldSizeAttributes(null);
        panelMain.setComboBoxTypeAttributes("bytes");
        panelMain.setTextFieldOwnerAttributes(null);
        panelMain.setCheckBoxCreatedPanel(false);
        panelMain.setCheckBoxModifiedPanel(false);
        panelMain.setCheckBoxAccessedPanel(false);
        panelMain.setDateChooserFromPanel(null);
        panelMain.setDateChooserToPanel(null);
        panelMain.setTextAreaContent(null);
        panelMain.setCheckBoxCaseSensitiveContent(false);

        panelMultimediaSearch.setMajorDuration(0);
        panelMultimediaSearch.setMinorDuration(0);
        panelMultimediaSearch.setCodec("All");
        panelMultimediaSearch.setAudioCodec("All");
        panelMultimediaSearch.setResolution("All");
        panelMultimediaSearch.setFrameRate("All");
        panelMultimediaSearch.setBitRate(0);
        panelMultimediaSearch.setAspectRatio("All");
    }

    /**
     * Method to add Action Listener for button save.
     *
     * @param panel
     * @param panelMain
     */
    public void saveButtonActionListener(PanelSaveCriterial panel, PanelNormalSearch panelMain, PanelNamePath panelNamePath, PanelMultimediaSearch panelMultimediaSearch) {
        searchCriteriaForDB = new SearchCriteria();
        String nameSearchCriteria = panel.getName();
        String typeFileString = panelNamePath.getBtnGroupTypeFiles();
        int typeFile = Integer.parseInt(typeFileString);
        boolean validParams = areValidParams(panelNamePath.getPath(), panelNamePath.getName(), panelMain.getFormattedTextFieldStart(), panelMain.getFormattedTextFieldEnd(), panelMain.getCheckBoxCreated(), panelMain.getCheckBoxModified(), panelMain.getCheckBoxAccessed(), panelMain.getTextFieldSize());
        boolean validCriterialParams = areValidCriterialParams(panel.getName());
        if (validParams && validCriterialParams) {
            searchCriteriaForDB.setSearchCriteriaName(nameSearchCriteria);
            searchCriteriaForDB.setPath(panelNamePath.getPath());
            searchCriteriaForDB.setName(panelNamePath.getName());
            searchCriteriaForDB.setHidden(panelMain.getCheckBoxHidden());
            searchCriteriaForDB.setReadOnly(panelMain.getCheckBoxReadOnly());
            searchCriteriaForDB.setTypeFile(typeFile);
            searchCriteriaForDB.setNameFileCaseSensitive(panelNamePath.getCaseSensitive());
            searchCriteriaForDB.setOwner(panelMain.getTextFieldOwner());
            searchCriteriaForDB.setExtension(panelMain.getTextFieldExt());
            searchCriteriaForDB.setSizeSign(panelMain.getComboBoxSize());
            searchCriteriaForDB.setSizeRequired(panelMain.getTextFieldSize());
            searchCriteriaForDB.setSizeMeasure(panelMain.getComboBoxType());
            searchCriteriaForDB.setCreateDate(panelMain.getCheckBoxCreated());
            searchCriteriaForDB.setModifiedDate(panelMain.getCheckBoxModified());
            searchCriteriaForDB.setAccessedDate(panelMain.getCheckBoxAccessed());
            searchCriteriaForDB.setFromDate(panelMain.getFormattedTextFieldStart());
            searchCriteriaForDB.setToDate(panelMain.getFormattedTextFieldEnd());
            searchCriteriaForDB.setContent(panelMain.getContent());
            searchCriteriaForDB.setContentCaseSensitive(panelMain.getCaseSensitiveContent());
            searchCriteriaForDB.setFileSystem(panelNamePath.getFileSystem());

            searchCriteriaForDB.setMajorDuration(panelMultimediaSearch.getMajorDuration());
            searchCriteriaForDB.setMinorDuration(panelMultimediaSearch.getMinorDuration());
            searchCriteriaForDB.setVideoCodec(panelMultimediaSearch.getCodec());
            searchCriteriaForDB.setAudioCodec(panelMultimediaSearch.getAudioCodec());
            searchCriteriaForDB.setVideoSize(panelMultimediaSearch.getResolution());
            searchCriteriaForDB.setFrameRate(panelMultimediaSearch.getFrameRate());
            searchCriteriaForDB.setBitRate(panelMultimediaSearch.getBitRate());
            searchCriteriaForDB.setAspectRatio(panelMultimediaSearch.getAspectRatio());

            searchFile.setSearchCriteria(searchCriteriaForDB);
            String resultDB = searchFile.saveSearchCriteria();
            System.out.println("DB:" + resultDB);
            mainView.displayResult("Save search criteria, " + resultDB);
        }
    }

    /**
     * Method to add Action Listener for button ´Load´.
     *
     * @param panel
     */
    public void loadButtonActionListener(PanelSearchCriterial panel) {
        getSearchCriterias();
        setSearchCriteriaTable();
    }

    /**
     * Method to add Action Listener for button ´Select´.
     *
     * @param panel
     */
    public void selectButtonActionListener(PanelSearchCriterial panel) {
        JTable table = panel.getTableResult();
        Object criteriaSelected = table.getValueAt(table.getSelectedRow(), 0);
        fillFields(criteriaSelected);
    }

    /**
     * Method to add Action Listener for button ´Delte´.
     * @param panel
     */
    public void deleteButtonActionListener(PanelSearchCriterial panel) {
        JTable table = panel.getTableResult();
        if (table.getRowCount() > 0) {
            Object criteriaSelected = table.getValueAt(table.getSelectedRow(), 0);
            String key = criteriaSelected.toString();
            String resultDB = searchFile.deleteSearchCriteria(key);
            mainView.displayResult("Delete search criteria, " + resultDB);
        }
    }


    /**
     * Method to validate each input in the normal search panel.
     *
     * @param path
     * @param name
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public boolean areValidParams(String path, String name, String dateFrom, String dateTo, boolean created, boolean modified, boolean accessed, String size) {
        Validator validator = new Validator();
        if (!validator.isAValidPath(path)) {
            mainView.displayResult("Invalid Path Name");
            return false;
        }
        if (!validator.isAValidName(name)) {
            mainView.displayResult("Invalid File Name");
            return false;
        }
        if (created || modified || accessed) {
            if (!validator.datesNotEmptyString(dateFrom, dateTo)) {
                mainView.displayResult("Date from and date to can't be empty");
                return false;
            }

            if (!validator.isAValidRangeDate(dateFrom, dateTo)) {
                mainView.displayResult("Date To must be mayor to Date From");
                return false;
            }
        }
        if (size.compareTo("") != 0 && !validator.isANumber(size)) {
            mainView.displayResult("The size must be a number");
            return false;
        }
        if (!validator.isAValidWildCard(name)) {
            mainView.displayResult("Wildcard should be at the beginning or at the end");
            return false;
        }
        return true;
    }

    /**
     * Method to validate each input related to criterial name.
     *
     * @param nameCriterial is the name of the criterial
     * @return true or false
     */
    public boolean areValidCriterialParams(String nameCriterial) {
        Validator validator = new Validator();
        if (!validator.nameCriterialIsNorEmpty(nameCriterial)) {
            mainView.displayResult("Name criterial is empty");
            return false;
        }
        return true;
    }

    /**
     * Method to set search criteria for Model and start search.
     *
     * @param path                  the path from UI.
     * @param name                  the name from UI.
     * @param hidden                value from UI.
     * @param readOnly              value from UI.
     * @param typeFile              value from UI.
     * @param nameFileCaseSensitive value from UI.
     * @param owner                 value from UI.
     * @param extension             value from UI.
     * @param sizeSign              value from UI.
     * @param sizeRequired          value from UI.
     * @param sizeMeasure           value from UI.
     */
    public void sendSearchCriteriaToModel(String path, String name, String hidden, String readOnly, int typeFile, boolean nameFileCaseSensitive, boolean fileSystem, String owner, String extension, String sizeSign, String sizeRequired, String sizeMeasure,
                                          boolean create, boolean modified, boolean accessed, String fromDate, String toDate,
                                          String content, boolean contentCaseSensitive,
                                          double majorDuration, double minorDuration, String codec, String resolution, String frameRate, String bitRate, String aspectRatio, String audioCodec) {
        searchCriteria = new SearchCriteria();
        searchCriteria.setPath(path);
        if (!name.isEmpty()) {
            searchCriteria.setName(name);
        }
        searchCriteria.setHidden(hidden);
        searchCriteria.setReadOnly(readOnly);
        searchCriteria.setTypeFile(typeFile);
        searchCriteria.setNameFileCaseSensitive(nameFileCaseSensitive);
        searchCriteria.setFileSystem(fileSystem);
        if (!owner.isEmpty()) {
            searchCriteria.setOwner(owner);
        } else {
            searchCriteria.setOwner(null);
        }
        if (!extension.isEmpty()) {
            searchCriteria.setExtension(extension);
        } else {
            searchCriteria.setExtension(null);
        }
        searchCriteria.setSizeSign(sizeSign);
        if (!sizeRequired.isEmpty()) {
            searchCriteria.setSizeRequired(sizeRequired);
        }
        searchCriteria.setSizeMeasure(sizeMeasure);
        searchCriteria.setCreateDate(create);
        searchCriteria.setModifiedDate(modified);
        searchCriteria.setAccessedDate(accessed);
        if (fromDate != null) {
            searchCriteria.setFromDate(fromDate);
        } else {
            searchCriteria.setFromDate(null);
        }
        if (toDate != null) {
            searchCriteria.setToDate(toDate);
        } else {
            searchCriteria.setToDate(null);
        }
        if (!content.isEmpty()) {
            searchCriteria.setContent(content);
        } else {
            searchCriteria.setContent(null);
        }
        searchCriteria.setContentCaseSensitive(contentCaseSensitive);
        /**Multimedia search criteria*/
        searchCriteria.setMajorDuration(majorDuration);
        searchCriteria.setMinorDuration(minorDuration);
        searchCriteria.setVideoCodec(codec);
        searchCriteria.setAudioCodec(audioCodec);
        searchCriteria.setVideoSize(resolution);
        searchCriteria.setFrameRate(frameRate);
        searchCriteria.setBitRate(bitRate);
        searchCriteria.setAspectRatio(aspectRatio);
        searchFile.setSearchCriteria(searchCriteria);
        searchFile.init("1");
        setResultsToTable();
    }

    /**
     * Method to get Model results and display them.
     */
    public void setResultsToTable() {
        List<Asset> resultFileList = searchFile.getResultResultFiles();
        PanelSearchResults panel = (PanelSearchResults) mainView.getPanelResultList();
        DefaultTableModel tableModel = panel.getTableModel();
        System.out.println("File Name\tFile Path\tHidden");
        tableModel.setRowCount(0);

        for (int i = 0; i < resultFileList.size(); i++) {
            DecimalFormat df = new DecimalFormat("#.##");
            if (resultFileList.get(i) instanceof ResultFile || resultFileList.get(i) instanceof ResultDirectory) {
                tableModel.addRow(new Object[]{resultFileList.get(i).getFileName(), resultFileList.get(i).getPath(), resultFileList.get(i).getHidden(), resultFileList.get(i).getReadOnly(), resultFileList.get(i).getOwner(), resultFileList.get(i).getSize(), resultFileList.get(i).getCreationTime(), resultFileList.get(i).getLastModifiedTime(), resultFileList.get(i).getLastAccessTime(), "-------------", "-------------", "-------------", "-------------", "-------------", "-------------", "-------------"});
            } else {
                if (resultFileList.get(i) instanceof ResultMultimediaFile) {
                    ResultMultimediaFile resultMultimediaFile = (ResultMultimediaFile) resultFileList.get(i);
                    tableModel.addRow(new Object[]{resultMultimediaFile.getFileName(), resultMultimediaFile.getPath(), resultMultimediaFile.getHidden(), resultMultimediaFile.getReadOnly(), resultMultimediaFile.getOwner(), resultMultimediaFile.getSize(), resultMultimediaFile.getCreationTime(), resultMultimediaFile.getLastModifiedTime(), resultMultimediaFile.getLastAccessTime(), df.format(resultMultimediaFile.getDuration()), resultMultimediaFile.getVideoCodec(), resultMultimediaFile.getAudioCodec(), resultMultimediaFile.getVideoSize(), resultMultimediaFile.getAspectRatio(), df.format(resultMultimediaFile.getFrameRate()), resultMultimediaFile.getAudioBitRate()});
                }
            }
            System.out.println(resultFileList.get(i).getFileName() + "\t" + resultFileList.get(i).getPath() + "\t" + resultFileList.get(i).getHidden() + "\t" + resultFileList.get(i).getFileSystem());
        }
        panel.setTableModel(tableModel);
        panel.setTableResultModel();
    }


    /**
     * Method for obtain the search criterias saved in the database.
     */
    public void getSearchCriterias() {
        mapSearchCriteriasResults = new HashMap<>();
        SearchQuery searchQuery = new SearchQuery();
        try {
            ResultSet resultSet = searchQuery.getAllCriteria();
            while (resultSet.next()) {
                mapSearchCriteriasResults.put(Integer.parseInt(resultSet.getString("ID")), jsonToSearchCriteria(resultSet.getString("CRITERIAJSON")));
            }
        } catch (SQLException e) {
            System.out.println("Controller SQL:" + e.getMessage());
        }
    }

    /**
     * This method converts a String to a SearchCriteria object.
     *
     * @param json a String representation of a Json file.
     * @return the search criteria converted.
     */
    private SearchCriteria jsonToSearchCriteria(String json) {
        Gson gson = new Gson();
        SearchCriteria criteria = gson.fromJson(json, SearchCriteria.class);
        return criteria;
    }

    /**
     * This method puts the search criteria loaded from the Database in a table on the View.
     */
    private void setSearchCriteriaTable() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        DefaultTableModel tableModel = panel.getTableModel();
        tableModel.setRowCount(0);

        for (Integer i : mapSearchCriteriasResults.keySet()) {
            tableModel.addRow(new Object[]{i, mapSearchCriteriasResults.get(i).getSearchCriteriaName()});
        }

        panel.setTableModel(tableModel);
        panel.setTableResultModel();
    }

    /**
     * This method fills the fields with the information retrieved of a search criteria selected
     * from the results of the search criteria table.
     *
     * @param criteriaSelected
     */
    private void fillFields(Object criteriaSelected) {
        int key = (Integer) criteriaSelected;
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
        PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
        panelNamePath.setTextFieldName(mapSearchCriteriasResults.get(key).getName());
        panelNamePath.setTextFieldPath(mapSearchCriteriasResults.get(key).getPath());
        panelNamePath.setCheckBoxCaseSensitiveName(mapSearchCriteriasResults.get(key).getNameFileCaseSensitive());
        panelNamePath.setCheckBoxFileSystem(mapSearchCriteriasResults.get(key).getFileSystem());
        int typeFiles = mapSearchCriteriasResults.get(key).getTypeFile();
        panelNamePath.setBtnAllFiles(Integer.toString(typeFiles));
        panel.setBtnGroupHiddenAttributes(mapSearchCriteriasResults.get(key).getHidden());
        panel.setBtnGroupReadOnlyAttributes(mapSearchCriteriasResults.get(key).getReadOnly());
        panel.setTextFieldExtAttributes(mapSearchCriteriasResults.get(key).getExtension());
        panel.setComboBoxSizeAttributes(mapSearchCriteriasResults.get(key).getSizeSign());
        panel.setTextFieldSizeAttributes(mapSearchCriteriasResults.get(key).getSizeRequired());
        panel.setComboBoxTypeAttributes(mapSearchCriteriasResults.get(key).getSizeMeasure());
        panel.setTextFieldOwnerAttributes(mapSearchCriteriasResults.get(key).getOwner());
        panel.setCheckBoxCreatedPanel(mapSearchCriteriasResults.get(key).getCreatedDate());
        panel.setCheckBoxModifiedPanel(mapSearchCriteriasResults.get(key).getModifiedDate());
        panel.setCheckBoxAccessedPanel(mapSearchCriteriasResults.get(key).getAccessedDate());
        SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
        try {
            panel.setDateChooserFromPanel(formatDate.parse(mapSearchCriteriasResults.get(key).getFromDate()));
            panel.setDateChooserToPanel(formatDate.parse(mapSearchCriteriasResults.get(key).getToDate()));
        } catch (ParseException e) {
            panel.setDateChooserFromPanel(null);
            panel.setDateChooserToPanel(null);
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            panel.setDateChooserFromPanel(null);
            panel.setDateChooserToPanel(null);
        }
        panel.setTextAreaContent(mapSearchCriteriasResults.get(key).getContent());
        panel.setCheckBoxCaseSensitiveContent(mapSearchCriteriasResults.get(key).getContentCaseSensitive());

        panelMultimediaSearch.setMajorDuration(mapSearchCriteriasResults.get(key).getMajorDuration());
        panelMultimediaSearch.setMinorDuration(mapSearchCriteriasResults.get(key).getMinorDuration());
        panelMultimediaSearch.setCodec(mapSearchCriteriasResults.get(key).getVideoCodec());
        panelMultimediaSearch.setAudioCodec(mapSearchCriteriasResults.get(key).getAudioCodec());
        panelMultimediaSearch.setResolution(mapSearchCriteriasResults.get(key).getVideoSize());
        panelMultimediaSearch.setFrameRate(mapSearchCriteriasResults.get(key).getFrameRate());
        panelMultimediaSearch.setBitRate(Double.parseDouble(mapSearchCriteriasResults.get(key).getBitRate()));
        panelMultimediaSearch.setAspectRatio(mapSearchCriteriasResults.get(key).getAspectRatio());
    }

    public void deleteSearchCriteria(Object criteriaSelected) {
        int key = (Integer) criteriaSelected;
    }
}

