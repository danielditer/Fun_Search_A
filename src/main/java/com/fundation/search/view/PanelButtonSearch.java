/**
 * @(#)PanelNormalSearch.java 03/27/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.controller.LoggerCreator;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


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
        LoggerCreator.getInstance().info(this.getClass().getName(),"Panel button search created");

        Icon icon = new ImageIcon(System.getProperty("user.dir")+"/resources/icons/search.png");
        Icon iconEraser = new ImageIcon(System.getProperty("user.dir")+"/resources/icons/eraser.png");
        buttonSearch = new JButton();
        buttonClear = new JButton();

        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- buttonSearch ----
        /*buttonSearch.setBackground(Color.BLUE);
        buttonSearch.setForeground(Color.WHITE);*/
        buttonSearch.setText("Search");
        buttonSearch.setIcon(icon);

        buttonClear.setText("Clear");
        buttonClear.setIcon(iconEraser);


        add(buttonSearch, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(buttonClear, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    /**
     * @return buttonSearch.
     */
    public JButton getButtonSearch(){
        return buttonSearch;
    }
    /**
     * @return getButtonClear.
     */
    public JButton getButtonClear(){
        return buttonClear;
    }

}
