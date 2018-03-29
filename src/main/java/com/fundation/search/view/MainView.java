/**
 * @(#)MainView.java  03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import info.clearthought.layout.TableLayout;
import net.miginfocom.swing.MigLayout;

/**
 * @version
 * 27 Mar 2018  * @Daniel Caballero.
 */
public class MainView extends JFrame {
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
        panelMultimediaSearch = new JPanel();
        panelTerminalSearch = new JPanel();
        panelTabbedPane = new JPanel();
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                "[fill]" + "[fill]",
                "[]" + "[]" + "[]"));
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
        //======== panelNormalSearch ========
        // JFormDesigner evaluation mark

        tabbedPane.addTab("Normal Search", panelNormalSearch);

        //======== panelMultimediaSearch ========
        panelMultimediaSearch.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        tabbedPane.addTab("Multimedia Search", panelMultimediaSearch);
        //======== panelTerminalSearch ========
        panelTerminalSearch.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        tabbedPane.addTab("Terminal Search", panelTerminalSearch);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        //======== panelTabbedPane ========
        panelTabbedPane.setLayout(new BorderLayout());
        contentPane.add(panelTabbedPane, BorderLayout.CENTER);
        setVisible(true);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuView;
    private JMenu menuHelp;
    private JTabbedPane tabbedPane;
    private JPanel panelMultimediaSearch;
    private JPanel panelTerminalSearch;
    private JPanel panelTabbedPane;
    private PanelNormalSearch panelNormalSearch;
}
