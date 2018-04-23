package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelMultimediaSearch extends JPanel{
    private JPanel panelNamePath;
    private JPanel panelDuration;
    private JLabel labelMoreThan;
    private JSpinner spinner1;
    private JLabel labelLessThan;
    private JSpinner spinner2;
    private JPanel panelFrameRate;
    private JComboBox comboBoxFrameRate;
    private JLabel label5;
    private JSpinner spinner3;
    private JLabel labelFps;
    private JSpinner spinner4;
    private JPanel panelCodec;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JPanel panel5;
    private JComboBox comboBox1;
    private PanelDate panelDate;
    private JPanel panel8;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private PanelButtonSearch panelButtonSearch;

    public PanelMultimediaSearch() {
        initComponents();
    }

    private void initComponents() {
        panelNamePath = new PanelNamePath();
        panelDuration = new JPanel();
        labelMoreThan = new JLabel();
        spinner1 = new JSpinner();
        labelLessThan = new JLabel();
        spinner2 = new JSpinner();
        panelFrameRate = new JPanel();
        label5 = new JLabel();
        spinner3 = new JSpinner();
        labelFps = new JLabel();
        spinner4 = new JSpinner();
        panelCodec = new JPanel();
        label7 = new JLabel();
        textField3 = new JTextField();
        label8 = new JLabel();
        textField4 = new JTextField();
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        panelDate = new PanelDate();
        panel8 = new JPanel();
        checkBox5 = new JCheckBox();
        checkBox6 = new JCheckBox();
        comboBoxFrameRate = new JComboBox();
        panelButtonSearch = new PanelButtonSearch();

        //======== this ========
        setLayout(new TableLayout(new double[][] {
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));

        //======== panelNamePath ========
        add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelDuration ========
        {
            panelDuration.setBorder(new TitledBorder("Duration"));
            panelDuration.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));

            //---- labelMoreThan ----
            labelMoreThan.setText("More than");
            panelDuration.add(labelMoreThan, new TableLayoutConstraints(0, 0, 0, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panelDuration.add(spinner1, new TableLayoutConstraints(1, 0, 1, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- labelLessThan ----
            labelLessThan.setText("Less than");
            panelDuration.add(labelLessThan, new TableLayoutConstraints(2, 0, 2, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panelDuration.add(spinner2, new TableLayoutConstraints(3, 0, 3, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(panelDuration, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelFrameRate ========
        {
            panelFrameRate.setBorder(new TitledBorder("Frame rate"));
            panelFrameRate.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));
            ((TableLayout) panelFrameRate.getLayout()).setHGap(5);
            ((TableLayout) panelFrameRate.getLayout()).setVGap(5);

            //---- labelFps ----
            comboBoxFrameRate.addItem("All");
            comboBoxFrameRate.addItem("23.97");
            comboBoxFrameRate.addItem("25");
            comboBoxFrameRate.addItem("29.97");
            comboBoxFrameRate.addItem("30");
            comboBoxFrameRate.addItem("60");
            labelFps.setText("fps");
            panelFrameRate.add(comboBoxFrameRate, new TableLayoutConstraints(1, 0, 1, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panelFrameRate.add(labelFps, new TableLayoutConstraints(2, 0, 2, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(panelFrameRate, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelCodec ========
        {
            panelCodec.setBorder(new TitledBorder("Codec"));
            panelCodec.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                            TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
            ((TableLayout) panelCodec.getLayout()).setHGap(5);
            ((TableLayout) panelCodec.getLayout()).setVGap(5);

            //---- label7 ----
            label7.setText("Video codec");
            panelCodec.add(label7, new TableLayoutConstraints(0, 0, 0, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panelCodec.add(textField3, new TableLayoutConstraints(1, 0, 3, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label8 ----
            label8.setText("Audio codec");
            panelCodec.add(label8, new TableLayoutConstraints(4, 0, 4, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panelCodec.add(textField4, new TableLayoutConstraints(5, 0, 7, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(panelCodec, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));

        //======== panel5 ========
        {
            panel5.setBorder(new TitledBorder("Resolution"));
            panel5.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));
            ((TableLayout)panel5.getLayout()).setHGap(5);
            ((TableLayout)panel5.getLayout()).setVGap(5);
            panel5.add(comboBox1, new TableLayoutConstraints(0, 0, 0, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(panel5, new TableLayoutConstraints(0, 4, 0, 4,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelDate ========
        add(panelDate, new TableLayoutConstraints(0, 5, 0, 5,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panel8 ========
        {
            panel8.setBorder(new TitledBorder("text"));
            panel8.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));
            ((TableLayout)panel8.getLayout()).setHGap(5);
            ((TableLayout)panel8.getLayout()).setVGap(5);

            //---- checkBox5 ----
            checkBox5.setText("Read-only");
            panel8.add(checkBox5, new TableLayoutConstraints(0, 0, 0, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- checkBox6 ----
            checkBox6.setText("Hidden");
            panel8.add(checkBox6, new TableLayoutConstraints(2, 0, 2, 0,
                    TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        add(panel8, new TableLayoutConstraints(0, 6, 0, 6,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelButtonSearch ========

        add(panelButtonSearch, new TableLayoutConstraints(0, 7, 0, 7,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
}