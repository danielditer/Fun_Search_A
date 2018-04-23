/**
 * @(#)MainView.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @version
 * 27 Mar 2018  * @Daniel Caballero.
 * Class that contains the Main Window of the Search application.
 */
public class MainView extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuView;
    private JMenu menuHelp;
    private JTabbedPane tabbedPane;
    private JPanel panelMultimediaSearch;
    private JPanel panelTerminalSearch;
    private JPanel panelResults;
    private JPanel panelSearchCrit;
    private JPanel panelSaveCrit;
    //private JPanel panelTabbedPane;
    private PanelNormalSearch panelNormalSearch;
    private PanelSearchResults panelSearchResult;
    private PanelSearchCriterial panelSearchCriterial;
    private PanelSaveCriterial panelSaveCriterial;
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
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuEdit = new JMenu();
        menuView = new JMenu();
        menuHelp = new JMenu();
        tabbedPane = new JTabbedPane();
        panelNormalSearch = new PanelNormalSearch();
        panelSearchResult = new PanelSearchResults();
        panelMultimediaSearch = new PanelMultimediaSearch();
        panelSearchCriterial = new PanelSearchCriterial();
        panelSaveCriterial = new PanelSaveCriterial();
        //panelTerminalSearch = new JPanel();

        panelResults = new JPanel();
        panelSearchCrit = new JPanel();
        panelSaveCrit = new JPanel();
        //panelTabbedPane = new JPanel();
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.setSize(50, 600);

        //======== menuBar ========
        //======== menuFile ========
        menuFile.setText("File");
        menuBar.add(menuFile);
        //======== menuEdit ========
        menuEdit.setText("Edit");
        menuBar.add(menuEdit);
        //======== menuView ========
        menuView.setText("View");
        menuBar.add(menuView);
        //======== menuHelp ========
        menuHelp.setText("Help");
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        //EmptyBorder bordertab = new EmptyBorder(5,20,5,120);
       // tabbedPane.setBorder(bordertab);

        tabbedPane.setPreferredSize(new Dimension(340, 460));
        //======== panelNormalSearch ========
        tabbedPane.addTab("Normal Search", panelNormalSearch);
        //======== panelMultimediaSearch ========
        tabbedPane.addTab("Multimedia Search", panelMultimediaSearch);

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        //======== panelTabbedPane ========
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,550);
        setLocationRelativeTo(null);
        //setLocationRelativeTo(getOwner());
        setResizable(false);

        EmptyBorder borderRes = new EmptyBorder(5,420,10,100);
        //======== panel Search Criterial ========
        panelSearchCrit.add(panelSearchCriterial);
        panelSearchCrit.setBorder(borderRes);
        contentPane.add(panelSearchCrit, BorderLayout.CENTER);

        //======== panel Search Results ========
        panelResults.add(panelSearchResult);
        panelResults.setBorder(borderRes);
        contentPane.add(panelResults, BorderLayout.SOUTH);
        //======== panel Search Results ========
        panelSaveCrit.add(panelSaveCriterial);
        panelSaveCrit.setBorder(borderRes);
        contentPane.add(panelSaveCrit, BorderLayout.NORTH);

    }

    /**
     * @return the Panel ´panelNormalSerch´.
     */
    public JPanel getPanel() {
        return panelNormalSearch;
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
}
