/**
 * @(#)PanelMultimediaSearch.java 04/13/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Class that creates a panel in Multimedia Search tab.
 *
 * @version Apr 13 2018  * @Daniel Caballero.
 */
public class PanelMultimediaSearch extends JPanel {
    private JPanel panelNamePath;
    private JPanel panelDuration;
    private JLabel labelMoreThan;
    private JSpinner spinnerMoreThan;
    private JLabel labelLessThan;
    private JSpinner spinnerLessThan;
    private JPanel panelFrameRate;
    private JLabel labelMoreThan2;
    private JSpinner spinnerMoreThan2;
    private JLabel labelLessThan2;
    private JSpinner spinnerLessThan2;
    private JPanel panelCodec;
    private JLabel labelVideoCodec;
    private JTextField textFieldVideoCodec;
    private JLabel labelAudioCodec;
    private JTextField textFieldAudioCodec;
    private JPanel panelResolution;
    private JComboBox comboBoxResolution;
    private PanelDate panelDate;
    private PanelButtonSearch panelButtonSearch;
    private PanelAttributes panelAttributes;

    /**
     * Class constructor.
     */
    public PanelMultimediaSearch() {
        initComponents();
    }

    /**
     * Initializes the components.
     */
    private void initComponents() {
        panelNamePath = new PanelNamePath();
        panelDuration = new JPanel();
        labelMoreThan = new JLabel();
        spinnerMoreThan = new JSpinner();
        labelLessThan = new JLabel();
        spinnerLessThan = new JSpinner();
        panelFrameRate = new JPanel();
        labelMoreThan2 = new JLabel();
        spinnerMoreThan2 = new JSpinner();
        labelLessThan2 = new JLabel();
        spinnerLessThan2 = new JSpinner();
        panelCodec = new JPanel();
        labelVideoCodec = new JLabel();
        textFieldVideoCodec = new JTextField();
        labelAudioCodec = new JLabel();
        textFieldAudioCodec = new JTextField();
        panelResolution = new JPanel();
        comboBoxResolution = new JComboBox();
        panelDate = new PanelDate();
        panelAttributes = new PanelAttributes();
        panelButtonSearch = new PanelButtonSearch();
        //======== this ========
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //======== panelNamePath ========
        add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelDuration ========
        panelDuration.setBorder(new TitledBorder("Duration"));
        panelDuration.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- labelMoreThan ----
        labelMoreThan.setText("More than");
        panelDuration.add(labelMoreThan, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelDuration.add(spinnerMoreThan, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelLessThan ----
        labelLessThan.setText("Less than");
        panelDuration.add(labelLessThan, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelDuration.add(spinnerLessThan, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelDuration, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelFrameRate ========
        panelFrameRate.setBorder(new TitledBorder("Frame rate"));
        panelFrameRate.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        ((TableLayout) panelFrameRate.getLayout()).setHGap(5);
        ((TableLayout) panelFrameRate.getLayout()).setVGap(5);

        //---- labelMoreThan2 ----
        labelMoreThan2.setText("More than");
        panelFrameRate.add(labelMoreThan2, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelFrameRate.add(spinnerMoreThan2, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelLessThan2 ----
        labelLessThan2.setText("Less than");
        panelFrameRate.add(labelLessThan2, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelFrameRate.add(spinnerLessThan2, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelFrameRate, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelCodec ========
        panelCodec.setBorder(new TitledBorder("Codec"));
        panelCodec.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        ((TableLayout) panelCodec.getLayout()).setHGap(5);
        ((TableLayout) panelCodec.getLayout()).setVGap(5);
        //---- labelVideoCodec ----
        labelVideoCodec.setText("Video codec");
        panelCodec.add(labelVideoCodec, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(textFieldVideoCodec, new TableLayoutConstraints(1, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelAudioCodec ----
        labelAudioCodec.setText("Audio codec");
        panelCodec.add(labelAudioCodec, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(textFieldAudioCodec, new TableLayoutConstraints(5, 0, 7, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelCodec, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelResolution ========
        panelResolution.setBorder(new TitledBorder("Resolution"));
        panelResolution.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        ((TableLayout) panelResolution.getLayout()).setHGap(5);
        ((TableLayout) panelResolution.getLayout()).setVGap(5);
        panelResolution.add(comboBoxResolution, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelResolution, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelDate ========
        add(panelDate, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelAttributes ========
        add(panelAttributes, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelButtonSearch ========
        add(panelButtonSearch, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
}