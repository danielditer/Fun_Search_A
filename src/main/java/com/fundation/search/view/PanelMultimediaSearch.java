package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelMultimediaSearch extends JPanel {
    private JPanel panelNamePath;
    private JPanel panelDuration;
    private JLabel labelMoreThan;
    private JSpinner spinner1;
    private JLabel labelLessThan;
    private JSpinner spinner2;
    private JPanel panelFrameRate;
    private JComboBox comboBoxFrameRate;
    private JLabel labelFps;
    private JPanel panelCodec;
    private JLabel labelVideoCodec;
    private JLabel labelAudioCodec;
    private JPanel panelResolution;
    private JComboBox comboBoxResolution;
    private JComboBox comboBoxVideoCodec;
    private JComboBox comboBoxAudioCodec;
    private PanelDate panelDate;
    private JPanel panelAudioBitRate;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private PanelButtonSearch panelButtonSearch;
    private JSpinner spinnerAudioBitRate;
    private JLabel labelKbps;

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
        spinnerAudioBitRate = new JSpinner();
        panelFrameRate = new JPanel();
        labelFps = new JLabel();
        labelKbps = new JLabel();
        panelCodec = new JPanel();
        labelVideoCodec = new JLabel();
        labelAudioCodec = new JLabel();
        panelResolution = new JPanel();
        comboBoxResolution = new JComboBox();
        comboBoxVideoCodec = new JComboBox();
        comboBoxAudioCodec = new JComboBox();
        panelDate = new PanelDate();
        panelAudioBitRate = new JPanel();
        checkBox5 = new JCheckBox();
        checkBox6 = new JCheckBox();
        comboBoxFrameRate = new JComboBox();
        panelButtonSearch = new PanelButtonSearch();

        //======== this ========
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));

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

        add(panelDuration, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelFrameRate ========

        panelFrameRate.setBorder(new TitledBorder("Frame rate"));
        panelFrameRate.setLayout(new TableLayout(new double[][]{
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

        add(panelFrameRate, new TableLayoutConstraints(0, 4, 0, 4,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelCodec ========

        panelCodec.setBorder(new TitledBorder("Codec"));
        panelCodec.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        ((TableLayout) panelCodec.getLayout()).setHGap(5);
        ((TableLayout) panelCodec.getLayout()).setVGap(5);

        //---- labelVideoCodec ----
        labelVideoCodec.setText("Video codec");
        comboBoxVideoCodec.addItem("All");
        comboBoxVideoCodec.addItem("MPEG-4 Video(*.mp4)");
        comboBoxVideoCodec.addItem("H.264 Video(*.mp4)");
        comboBoxVideoCodec.addItem("H.265 Video(*.mp4)");
        comboBoxVideoCodec.addItem("Flash Video(*.flv)");
        comboBoxVideoCodec.addItem("WebM Video Format(*.webm)");
        comboBoxVideoCodec.addItem("MPEG-1 Video(*.mpg)");
        comboBoxVideoCodec.addItem("MPEG-2 Video(*.mpg)");
        comboBoxVideoCodec.addItem("MOV - QuickTime(*.mov)");
        comboBoxVideoCodec.addItem("Windows Media Video(*.wmv)");
        panelCodec.add(labelVideoCodec, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(comboBoxVideoCodec, new TableLayoutConstraints(1, 0, 3, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelAudioCodec ----
        labelAudioCodec.setText("Audio codec");
        comboBoxAudioCodec.addItem("All");
        comboBoxAudioCodec.addItem("MP3 - MPEG Layer-3 Audio(*.mp3)");
        comboBoxAudioCodec.addItem("WAV - Waveform Audio(*.wav)");
        comboBoxAudioCodec.addItem("M4A - MPEG-4 Audio(*.m4a)");
        comboBoxAudioCodec.addItem("AAC - Advanced Audio Coding(*.aac)");
        comboBoxAudioCodec.addItem("OGG - Ogg Vorbis Audio(*.ogg)");
        comboBoxAudioCodec.addItem("AC3 - Dolby Digital AC-3(*.ac3)");
        comboBoxAudioCodec.addItem("WMA - Windows Media Audio(*.wma)");
        comboBoxAudioCodec.addItem("FLAC - Free Lossless Audio Codec(*.flac)");
        comboBoxAudioCodec.addItem("AIFF - Audio Interchange File Format(*.aiff)");
        panelCodec.add(labelAudioCodec, new TableLayoutConstraints(4, 0, 4, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(comboBoxAudioCodec, new TableLayoutConstraints(5, 0, 7, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(panelCodec, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));

        //======== panelResolution ========
        panelResolution.setBorder(new TitledBorder("Resolution"));
        panelResolution.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        ((TableLayout) panelResolution.getLayout()).setHGap(5);
        ((TableLayout) panelResolution.getLayout()).setVGap(5);
        comboBoxResolution.addItem("All");
        comboBoxResolution.addItem("120x90");
        comboBoxResolution.addItem("320x240");
        comboBoxResolution.addItem("352x240");
        comboBoxResolution.addItem("352x288");
        comboBoxResolution.addItem("480x480");
        comboBoxResolution.addItem("480x576");
        comboBoxResolution.addItem("640x480");
        comboBoxResolution.addItem("720x480");
        comboBoxResolution.addItem("720x576");
        comboBoxResolution.addItem("1280x720");
        comboBoxResolution.addItem("1366x768");
        comboBoxResolution.addItem("1920x1080");
        comboBoxResolution.addItem("3840x2160");
        panelResolution.add(comboBoxResolution, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(panelResolution, new TableLayoutConstraints(0, 3, 0, 3,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelDate ========
        add(panelDate, new TableLayoutConstraints(0, 6, 0, 5,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelAudioBitRate ========

        panelAudioBitRate.setBorder(new TitledBorder("Audio Bit Rate"));
        panelAudioBitRate.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        ((TableLayout) panelAudioBitRate.getLayout()).setHGap(5);
        ((TableLayout) panelAudioBitRate.getLayout()).setVGap(5);

        labelKbps.setText("Kbps");
        panelAudioBitRate.add(spinnerAudioBitRate, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelAudioBitRate.add(labelKbps, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(panelAudioBitRate, new TableLayoutConstraints(0, 5, 0, 5,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelButtonSearch ========

        add(panelButtonSearch, new TableLayoutConstraints(0, 7, 0, 7,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
}