/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.JButton;
/**
 * Class to initialize panel for buttons.
 *
 * @version 27 Mar 2018  * @Daniel Caballero.
 */
public class PanelButtonSearch extends JPanel {

    JButton buttonSearch = new JButton();
    JButton buttonClear = new JButton();

    /**
     * Class constructor.
     */
    public PanelButtonSearch() {
        initComponents();
    }
    /**
     * Initializes panel components.
     */
    public void initComponents() {
        buttonSearch = new JButton();
        buttonClear = new JButton();


        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- buttonSearch ----
        buttonSearch.setText("Search");
        buttonClear.setText("Clear");

        add(buttonSearch, new TableLayoutConstraints(4, 0, 4, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(buttonClear, new TableLayoutConstraints(5, 0, 5, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    /**
     * @return buttonSearch.
     */
    public JButton getButtonSearch(){
        return buttonSearch;
    }
}
