/**
 * @(#)SearchControllerTest.java 05/01/18
 * <p>
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.controller;

import com.fundation.search.model.SearchFiles;
import com.fundation.search.view.*;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit class to test controller class.
 * @version May, 1st 2018 @Manuel Valdez
 */
public class SearchControllerTest {
    /**
     * Test areValidParams method, all valid params.
     */
    @Test
    public void testAreValidParams() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertTrue(searchController.areValidParams("C:\\", "test1.txt", "05-01-2018", "05-01-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, invalid path.
     */
    @Test
    public void testAreValidParamsInvalidPath() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\xxxx", "test1.txt", "05-01-2018", "05-01-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, invalid name.
     */
    @Test
    public void testAreValidParamsInvalidName() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\", "te:st.txt", "05-01-2018", "05-01-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, invalid date null.
     */
    @Test
    public void testAreValidParamsInvalidADateNull() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\", "test.txt", null, "05-01-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, invalida date from higher to.
     */
    @Test
    public void testAreValidParamsInvalidDateFromMajorTo() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\", "test.txt", "05-20-2018", "05-01-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, empty size.
     */
    @Test
    public void testAreValidParamsEmptySize() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\", "test.txt", "05-01-2018", "05-02-2018", true, true, true, "x"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    /**
     * Test areValidParams method, invalid wild card.
     */
    @Test
    public void testAreValidParamsWildcard() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            assertFalse(searchController.areValidParams("C:\\", "tes*t.txt", "05-01-2018", "05-02-2018", true, true, true, "100"));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Test init method of controller.
     */
    @Test
    public void testInit() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.init();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test search action performed method of controller.
     */
    @Test
    public void testSearchActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.searchActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test clear action performed method of controller.
     */
    @Test
    public void testClearActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.clearActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test sace action performed method of controller.
     */
    @Test
    public void testSaveActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.saveActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test load action performed method of controller.
     */
    @Test
    public void testLoadActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.loadActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test select action performed method of controller.
     */
    @Test
    public void testSelectActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.selectActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test delete action performed method of controller.
     */
    @Test
    public void testDeleteActionPerformed() {
        try {
            SearchController searchController = new SearchController(new SearchFiles(), new MainView());
            searchController.deleteActionPerformed();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }


    /**
     * Test search button action listener method of controller.
     */
    @Test
    public void testSearchButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
            PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
            PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
            searchController.searchButtonActionListener(panel, panelNamePath, panelMultimediaSearch);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test clear button action listener method of controller.
     */
    @Test
    public void testClearButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelNormalSearch panel = (PanelNormalSearch) mainView.getPanel();
            PanelSaveCriterial panelSaveCriterial = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
            PanelSearchResults panelResults = (PanelSearchResults) mainView.getPanelResultList();
            PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
            PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
            searchController.clearButtonActionListener(panel, panelSaveCriterial, panelResults, panelNamePath, panelMultimediaSearch);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test save button action listener method of controller.
     */
    @Test
    public void testSaveButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelSaveCriterial panel = (PanelSaveCriterial) mainView.getPanelSaveCriterial();
            PanelNormalSearch panelMain = (PanelNormalSearch) mainView.getPanel();
            PanelNamePath panelNamePath = (PanelNamePath) mainView.getPanelNamePath();
            PanelMultimediaSearch panelMultimediaSearch = mainView.getPanelMultimediaSearch();
            searchController.saveButtonActionListener(panel, panelMain, panelNamePath, panelMultimediaSearch);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test load button action listener method of controller.
     */
    @Test
    public void testLoadButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
            searchController.loadButtonActionListener(panel);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test select button action listener method of controller.
     */
    @Test
    public void testSelectButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
            searchController.selectButtonActionListener(panel);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test delete button action listener method of controller.
     */
    @Test
    public void testDeleteButtonActionListener() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            PanelSearchCriterial panel = (PanelSearchCriterial) mainView.getPanelSearchCriterial();
            searchController.deleteButtonActionListener(panel);
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }


    /**
     * Test valid criteria params method of controller.
     */
    @Test
    public void testAreValidCriterialParams() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            assertTrue(searchController.areValidCriterialParams("NameCriteriaTest1"));
            assertFalse(searchController.areValidCriterialParams(""));
            assertFalse(searchController.areValidCriterialParams(" "));
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * Test send search criteria to model method of controller.
     */
    @Test
    public void testSendSearchCriteriaToModel() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            searchController.sendSearchCriteriaToModel("D:\\Fundación JALA\\Prog102\\Search\\Fun_Search_A\\src\\test\\java\\com\\fundation\\search\\pathTest", "test1.txt", "3", "3", 0, false, false, "owner", "txt",
                    "Equals", "100", "Mb", true, true, true, "05-01-2018", "05-01-2018", "", false,
                    0.0, 0.0, "All", "All", "All", "0", "All", "All");
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    /**
     * Test get search criterias method of controller.
     */
    @Test
    public void testGetSearchCriterias() {
        try {
            MainView mainView = new MainView();
            SearchController searchController = new SearchController(new SearchFiles(), mainView);
            searchController.getSearchCriterias();
        } catch (IOException e) {
            e.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}