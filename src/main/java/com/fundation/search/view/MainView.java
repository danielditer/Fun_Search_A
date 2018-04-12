/**
 * @(#)MainView.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import info.clearthought.layout.TableLayout;
import net.miginfocom.swing.MigLayout;

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
    //private JPanel panelTabbedPane;
    private PanelNormalSearch panelNormalSearch;
    private PanelSearchResults panelSearchResult;
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
        //panelTerminalSearch = new JPanel();

        panelResults = new JPanel();
        //panelTabbedPane = new JPanel();
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        /*contentPane.setLayout(new MigLayout(
                "hidemode 3",
                "[fill]" + "[fill]",
                "[]" + "[]" + "[]"));*/
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

        tabbedPane.setPreferredSize(new Dimension(280, 460));
        //======== panelNormalSearch ========
        tabbedPane.addTab("Normal Search", panelNormalSearch);
        //======== panelMultimediaSearch ========
        tabbedPane.addTab("Multimedia Search", panelMultimediaSearch);
        //======== panelTerminalSearch ========
       /* panelTerminalSearch.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));*/
        //tabbedPane.addTab("Terminal Search", panelTerminalSearch);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        //======== panelTabbedPane ========
        //panelTabbedPane.setLayout(new BorderLayout());
        //contentPane.add(panelTabbedPane, BorderLayout.CENTER);
        setVisible(true);
        pack();
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(725,470);
        setResizable(false);

        panelResults.add(panelSearchResult);
        panelResults.setBorder(new EmptyBorder(10,390,10,100));
        contentPane.add(panelResults, BorderLayout.CENTER);

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
}
