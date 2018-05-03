/**
 * @(#)MainView.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.controller.LoggerCreator;
import com.fundation.search.model.SearchFiles;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.io.IOException;


/**
 * @version
 * 27 Mar 2018  * @Daniel Caballero.
 * Class that contains the Main Window of the Search application.
 */
public class MainView extends JFrame {
    private JMenuBar menuBar;

    private JMenu menuHelp;
    private JTabbedPane tabbedPane;
    private PanelMultimediaSearch panelMultimediaSearch;

    private JPanel panelResults;
    private JPanel panelSearchCrit;
    private JPanel panelSaveCrit;

    private PanelNormalSearch panelNormalSearch;
    private PanelSearchResults panelSearchResult;
    private PanelSearchCriterial panelSearchCriterial;
    private PanelSaveCriterial panelSaveCriterial;


    private JPanel panelSearch;
    private PanelNamePath panelNamePath;
    private JPanel panelButton;
    private PanelButtonSearch panelButtonSearch;
    /**
     * MainView constructor.
     */
    public MainView() {
        initComponents();
    }

    /**
     * Initializes variables.
     */
    protected void initComponents() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icons/icon.png")));

        LoggerCreator.getInstance().info(this.getClass().getName(),"Initialized view");


        menuBar = new JMenuBar();
        menuHelp = new JMenu();
        tabbedPane = new JTabbedPane();
        panelNormalSearch = new PanelNormalSearch();
        panelSearchResult = new PanelSearchResults();
        panelMultimediaSearch = new PanelMultimediaSearch();
        panelSearchCriterial = new PanelSearchCriterial();
        panelSaveCriterial = new PanelSaveCriterial();

        /*********/
        panelSearch = new JPanel();
        panelNamePath = new PanelNamePath();
        panelButton = new JPanel();
        panelButtonSearch = new PanelButtonSearch();
        /*********/

        panelResults = new JPanel();
        panelSearchCrit = new JPanel();
        panelSaveCrit = new JPanel();
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        //======== menuHelp ========
        menuHelp.setText("Help");

        //menuBar.add(menuHelp);
        setJMenuBar(menuBar);


        //======== panel Search Name, Path ========
        panelSearch.setBorder(new EmptyBorder(5,5,5,5));
        panelSearch.add(panelNamePath);
        contentPane.add(panelSearch, BorderLayout.NORTH);


        tabbedPane.setPreferredSize(new Dimension(340, 350));
        tabbedPane.setBorder(new EmptyBorder(5,15,5,10));
        //======== panelNormalSearch ========
        tabbedPane.addTab("Normal Search", panelNormalSearch);
        //======== panelMultimediaSearch ========
        tabbedPane.addTab("Multimedia Search", panelMultimediaSearch);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        //======== panelButtonSearch ========
        panelButton.setBorder(new EmptyBorder(5,15,5,10));
        panelButton.add(panelButtonSearch);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        //======== panelTabbedPane ========
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366,650);
        setLocationRelativeTo(null);
        setResizable(false);

        EmptyBorder borderRes = new EmptyBorder(5,365,10,10);
        //======== panel Search Results ========
        panelSaveCrit.setBorder(borderRes);
        panelSaveCrit.add(panelSaveCriterial);
        contentPane.add(panelSaveCrit, BorderLayout.NORTH);
        //======== panel Search Criterial ========
        panelSearchCrit.setBorder(borderRes);
        panelSearchCrit.add(panelSearchCriterial);
        contentPane.add(panelSearchCrit, BorderLayout.CENTER);

        //======== panel Search Results ========
        panelResults.setBorder(borderRes);
        panelResults.add(panelSearchResult);
        contentPane.add(panelResults, BorderLayout.SOUTH);

    }

    /**
     * @return the Panel ´panelNormalSerch´.
     */
    public JPanel getPanel() {
        return panelNormalSearch;
    }
    public JPanel getPanelButton() {
        return panelButtonSearch;
    }
    public JPanel getPanelNamePath() {
        return panelNamePath;
    }

    /**
     * @return the Panel ´panelNormalSerch´.
     */
    public JPanel getPanelResultList() {
        return panelSearchResult;
    }

    /**
     * Getter for the search criterial panel.
     *
     * @return ta boolean of ´panelSearchCriterial´ panel.
     */
    public JPanel getPanelSearchCriterial() {
        return panelSearchCriterial;
    }
    /**
     * Getter for the save criterial panel.
     *
     * @return ta boolean of ´panelSaveCriterial´ panel.
     */
    public JPanel getPanelSaveCriterial() {
        return panelSaveCriterial;
    }

    /*
    * method displayResult tp display an error message
    * @param result that contains the error message
    **/
    public void displayResult(String result){
        SearchFiles searchFile = null;
        try {
            searchFile = new SearchFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoggerCreator.getInstance().info(searchFile.getClass().getName(), "MESSAGE: " + result);
        JOptionPane.showMessageDialog(null, result, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public PanelMultimediaSearch getPanelMultimediaSearch() {
        return panelMultimediaSearch;
    }
}
