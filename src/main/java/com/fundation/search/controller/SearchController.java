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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private SearchFiles searchFile;
    private MainView mainView;
    private SearchCriteria searchCriteria;
    private SearchCriteriaMultimedia searchCriteriaMultimedia;
    private SearchCriteria searchCriteriaForDB;
    private static final int START_COLUMN = 0;
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
        getActionPerformed();
        saveActionPerformed();
        loadActionPerformed();
        selectActionPerformed();
        clearActionPerformed();

        searchMultimediaActionPerformed();
    }

    /**
     * Method to get values from button search in the View.
     */
    public void getActionPerformed() {
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        panel.getButtonSearch().addActionListener(e -> searchButtonActionListener(panel));
    }
    /**
     * Method to get values from button search in the tab Multimedia.
     */
    public void searchMultimediaActionPerformed() {
        PanelMultimediaSearch panel = mainView.getPanelMultimediaSearch();
        panel.getSearchMultimediaButton().addActionListener(e -> searchButtonMultimediaActionListener(panel));
    }

    /**
     * Method to clear values the View.
     */
    public void clearActionPerformed() {
        PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
        PanelSaveCriterial panelSaveCriterial = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
        PanelSearchResults panelResults = (PanelSearchResults) mainView.getPanelResultList();
        panel.getButtonClear().addActionListener(e -> clearButtonActionListener(panel, panelSaveCriterial, panelResults));
    }

    /**
     * Method lambda to add action listener for button search.
     *
     * @param panel
     */
    public void searchButtonActionListener(PanelNormalSearch panel) {
        String typeFileString = panel.getRadioAllFiles();
        int typeFile = Integer.parseInt(typeFileString);
        /*if (panel.getCheckBoxOnlyFiles() && panel.getCheckBoxOnlyDirectory()) {
            typeFile = 0;
        } else if (panel.getCheckBoxOnlyFiles()) {
            typeFile = 1;
        } else if (panel.getCheckBoxOnlyDirectory()) {
            typeFile = 3;
        }*/
        if (areValidParams(panel.getPath(), panel.getName(), panel.getFormattedTextFieldStart(), panel.getFormattedTextFieldEnd(), panel.getCheckBoxCreated(), panel.getCheckBoxModified(), panel.getCheckBoxAccessed(), panel.getTextFieldSize())) {
            sendSearchCriteriaToModel(panel.getPath(), panel.getName(), panel.getCheckBoxHidden(), panel.getCheckBoxReadOnly(),
                    typeFile, panel.getCaseSensitiveName(), panel.getTextFieldOwner(), panel.getTextFieldExt(),
                    panel.getComboBoxSize(), panel.getTextFieldSize(), panel.getComboBoxType(),
                    panel.getCheckBoxCreated(), panel.getCheckBoxModified(), panel.getCheckBoxAccessed(),
                    panel.getFormattedTextFieldStart(), panel.getFormattedTextFieldEnd(), panel.getContent(),
                    panel.getCaseSensitiveContent());
        }
    }

    public void searchButtonMultimediaActionListener(PanelMultimediaSearch panel) {
        if (areValidMultimediaParams(panel.getPath(), panel.getName())) {
            sendSearchCriteriaMultimediaToModel(panel.getPath(), panel.getName(), panel.getCaseSensitiveName(), panel.getCodec(), panel.getResolution(), panel.getFrameRate(), panel.getBitRate());
        }
    }

    /**
     * Method to save a criteria in the database using save button on the View.
     */
    public void saveActionPerformed() {
        PanelSaveCriterial panel = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
        PanelNormalSearch panelMain = (PanelNormalSearch) mainView.getPanel();
        panel.getButtonSave().addActionListener(e -> saveButtonActionListener(panel, panelMain));
    }

    /**
     * Method to add Action Listener for button save.
     *
     * @param panel
     * @param panelMain
     */
    public void saveButtonActionListener(PanelSaveCriterial panel, PanelNormalSearch panelMain) {
        searchCriteriaForDB = new SearchCriteria();
        String nameSearchCriteria = panel.getName();
        //int typeFile = 0;
       /* if (panelMain.getCheckBoxOnlyFiles() && panelMain.getCheckBoxOnlyDirectory()) {
            typeFile = 0;
        } else if (panelMain.getCheckBoxOnlyFiles()) {
            typeFile = 1;
        } else if (panelMain.getCheckBoxOnlyDirectory()) {
            typeFile = 3;
        }*/
        String typeFileString = panelMain.getRadioAllFiles();
        int typeFile = Integer.parseInt(typeFileString);

        boolean validParams = areValidParams(panelMain.getPath(), panelMain.getName(), panelMain.getFormattedTextFieldStart(), panelMain.getFormattedTextFieldEnd(), panelMain.getCheckBoxCreated(), panelMain.getCheckBoxModified(), panelMain.getCheckBoxAccessed(), panelMain.getTextFieldSize());
        boolean validCriterialParams = areValidCriterialParams(panel.getName());
        if (validParams && validCriterialParams) {

            searchCriteriaForDB.setSearchCriteriaName(nameSearchCriteria);
            searchCriteriaForDB.setPath(panelMain.getPath());
            searchCriteriaForDB.setName(panelMain.getName());
            searchCriteriaForDB.setHidden(panelMain.getCheckBoxHidden());
            searchCriteriaForDB.setReadOnly(panelMain.getCheckBoxReadOnly());
            searchCriteriaForDB.setTypeFile(typeFile);
            searchCriteriaForDB.setNameFileCaseSensitive(panelMain.getCaseSensitiveName());
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

            searchFile.setSearchCriteria(searchCriteriaForDB);
            System.out.println("DB:" + searchFile.saveSearchCriteria());
        }
    }

    /**
     * Method to load a criteria from the database by using button ´Load´ in the View.
     */
    public void loadActionPerformed() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        panel.getButtonLoad().addActionListener(e -> loadButtonActionListener(panel));
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
     * Method to select a criteria and fill al items.
     */
    public void selectActionPerformed() {
        PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
        panel.getButtonSelect().addActionListener(e -> selectButtonActionListener(panel));
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
        return true;
    }

    public boolean areValidMultimediaParams(String path, String name) {
        Validator validator = new Validator();
        if (!validator.isAValidPath(path)) {
            mainView.displayResult("Invalid Path Name");
            return false;
        }
        if (!validator.isAValidName(name)) {
            mainView.displayResult("Invalid File Name");
            return false;
        }
        /*if (minorDuration == majorDuration) {
            mainView.displayResult("Duration times should be different");
            return false;
        }

        if (minorDuration > majorDuration) {
            mainView.displayResult("More than should be a major time");
            return false;
        }*/
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
    public void sendSearchCriteriaToModel(String path, String name, String hidden, String readOnly, int typeFile, boolean nameFileCaseSensitive, String owner, String extension, String sizeSign, String sizeRequired, String sizeMeasure, boolean create, boolean modified, boolean accessed, String fromDate,
                                          String toDate, String content, boolean contentCaseSensitive) {
        searchCriteria = new SearchCriteria();
        searchCriteria.setPath(path);
        if (!name.isEmpty()) {
            searchCriteria.setName(name);
        }
        searchCriteria.setHidden(hidden);
        searchCriteria.setReadOnly(readOnly);
        searchCriteria.setTypeFile(typeFile);
        searchCriteria.setNameFileCaseSensitive(nameFileCaseSensitive);
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
        searchFile.setSearchCriteria(searchCriteria);
        searchFile.init("1");
        setResultsToTable();
    }

    public void sendSearchCriteriaMultimediaToModel(String path, String name, boolean nameFileCaseSensitive, String codec, String resolution, String frameRate, String bitRate) {
        searchCriteriaMultimedia = new SearchCriteriaMultimedia();
        searchCriteriaMultimedia.setPath(path);
        if (!name.isEmpty()) {
            searchCriteriaMultimedia.setName(name);
        }
        searchCriteriaMultimedia.setNameFileCaseSensitive(nameFileCaseSensitive);
        searchCriteriaMultimedia.setCodec(codec);
        searchCriteriaMultimedia.setVideoSize(resolution);
        searchCriteriaMultimedia.setFrameRate(frameRate);
        searchCriteriaMultimedia.setBitRate(bitRate);

        searchFile.setSearchCriteria(searchCriteriaMultimedia);
        searchFile.init("2");
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
            if (resultFileList.get(i) instanceof ResultFile) {
                tableModel.addRow(new Object[]{resultFileList.get(i).getFileName(), resultFileList.get(i).getPath(), resultFileList.get(i).getHidden(), resultFileList.get(i).getReadOnly(), resultFileList.get(i).getOwner(), resultFileList.get(i).getSize()});
            } else {
                tableModel.addRow(new Object[]{resultFileList.get(i).getFileName(), resultFileList.get(i).getPath(), resultFileList.get(i).getHidden(), resultFileList.get(i).getReadOnly(), resultFileList.get(i).getOwner(), 0L});
            }

            System.out.println(resultFileList.get(i).getFileName() + "\t" + resultFileList.get(i).getPath() + "\t" + resultFileList.get(i).getHidden());
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

        panel.setTextFieldName(mapSearchCriteriasResults.get(key).getName());
        panel.setTextFieldPath(mapSearchCriteriasResults.get(key).getPath());
        panel.setCheckBoxCaseSensitiveName(mapSearchCriteriasResults.get(key).getNameFileCaseSensitive());
       /* if (mapSearchCriteriasResults.get(key).getTypeFile() == 1) {
            panel.setCheckBoxOnlyFiles(true);
        }
        if (mapSearchCriteriasResults.get(key).getTypeFile() == 3) {
            panel.setCheckBoxOnlyDirectory(true);
        }
        if (mapSearchCriteriasResults.get(key).getTypeFile() == 0) {
            panel.setCheckBoxOnlyFiles(true);
            panel.setCheckBoxOnlyDirectory(true);
        }*/
        int typeFiles = mapSearchCriteriasResults.get(key).getTypeFile();
        panel.setRadioAllFiles(Integer.toString(typeFiles));

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
    }

    /**
     * This method clear the fields with the information retrieved of a search criteria selected.
     *
     * @param panelMain is the panel that contain all the elements for the normal search
     */

    public void clearButtonActionListener(PanelNormalSearch panelMain, PanelSaveCriterial panelSaveCriterial, PanelSearchResults panelResults) {
        panelSaveCriterial.setTextFieldName("");
        DefaultTableModel tableModel = panelResults.getTableModel();
        tableModel.setRowCount(0);
        panelResults.setTableModel(tableModel);
        panelMain.setTextFieldName(null);
        panelMain.setTextFieldPath(null);
        panelMain.setCheckBoxCaseSensitiveName(false);
        // panelMain.setCheckBoxOnlyFiles(false);
        //panelMain.setCheckBoxOnlyDirectory(false);
        panelMain.setRadioAllFiles("0");

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
    }
}

