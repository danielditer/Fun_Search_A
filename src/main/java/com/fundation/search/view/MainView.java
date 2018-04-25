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
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

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

    private JMenu menuHelp;
    private JTabbedPane tabbedPane;
    private JPanel panelMultimediaSearch;

    private JPanel panelResults;
    private JPanel panelSearchCrit;
    private JPanel panelSaveCrit;

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

        //contentPane.setSize(50, 600);

        //======== menuBar ========
        //======== menuHelp ========
        menuHelp.setText("Help");
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        tabbedPane.setPreferredSize(new Dimension(340, 490));
        tabbedPane.setBorder(new EmptyBorder(5,15,5,10));
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
        setResizable(false);

        EmptyBorder borderRes = new EmptyBorder(5,330,10,10);
        //======== panel Search Criterial ========
        panelSearchCrit.setBorder(borderRes);
        panelSearchCrit.add(panelSearchCriterial);
        contentPane.add(panelSearchCrit, BorderLayout.CENTER);

        //======== panel Search Results ========
        panelResults.setBorder(borderRes);
        panelResults.add(panelSearchResult);
        contentPane.add(panelResults, BorderLayout.SOUTH);
        //======== panel Search Results ========
        panelSaveCrit.setBorder(borderRes);
        panelSaveCrit.add(panelSaveCriterial);
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

    /*
    * method displayResult tp display an error message
    * @param result that contains the error message
    **/
    public void displayResult(String result){
        JOptionPane.showMessageDialog(null, result, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
