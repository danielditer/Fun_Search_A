package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;

import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelMultimediaSearch extends JPanel {
    private PanelNamePath panelNamePath;
    private JPanel panelDuration;
    private JLabel labelMoreThan;
    private JSpinner spinnerMinorDuration;
    private JLabel labelLessThan;
    private JSpinner spinnerMajorDuration;
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
    private JComboBox comboBoxAspectRatio;

    public PanelMultimediaSearch() {
        initComponents();
    }

    private void initComponents() {
        panelNamePath = new PanelNamePath();
        panelDuration = new JPanel();
        labelMoreThan = new JLabel();
        spinnerMinorDuration = new JSpinner();
        labelLessThan = new JLabel();
        spinnerMajorDuration = new JSpinner();
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
        comboBoxAspectRatio = new JComboBox();

        //======== this ========
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));

        //======== panelNamePath ========
        /*add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));*/

        //======== panelDuration ========

        panelDuration.setBorder(new TitledBorder("Duration"));
        panelDuration.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));

        //---- labelMoreThan ----
        labelMoreThan.setText("More than");
        panelDuration.add(labelMoreThan, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelDuration.add(spinnerMinorDuration, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelLessThan ----
        labelLessThan.setText("Less than");
        panelDuration.add(labelLessThan, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelDuration.add(spinnerMajorDuration, new TableLayoutConstraints(3, 0, 3, 0,
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
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        ((TableLayout) panelCodec.getLayout()).setHGap(5);
        ((TableLayout) panelCodec.getLayout()).setVGap(5);

        //---- labelVideoCodec ----
        labelVideoCodec.setText("Video codec");
        comboBoxVideoCodec.setMaximumSize(new Dimension(60,25));
        comboBoxVideoCodec.addItem("All");
        comboBoxVideoCodec.addItem("None");
        comboBoxVideoCodec.addItem("FLV(flv1)");
        comboBoxVideoCodec.addItem("H.264(h264)");
        comboBoxVideoCodec.addItem("H.265(hevc)");
        comboBoxVideoCodec.addItem("MPEG-1 video(mpeg1video)");
        comboBoxVideoCodec.addItem("MPEG-2 video(mpeg2video)");
        comboBoxVideoCodec.addItem("VP8(vp8)");
        comboBoxVideoCodec.addItem("VP9(vp9)");
        comboBoxVideoCodec.addItem("Windows Media Video 7(wmv1)");
        comboBoxVideoCodec.addItem("Windows Media Video 8(wmv2)");
        comboBoxVideoCodec.addItem("Windows Media Video 9(wmv3)");
        panelCodec.add(labelVideoCodec, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(comboBoxVideoCodec, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- labelAudioCodec ----
        labelAudioCodec.setText("Audio codec");
        comboBoxAudioCodec.addItem("All");
        comboBoxAudioCodec.addItem("MP3(mp3)");
        comboBoxAudioCodec.addItem("AAC(aac)");
        comboBoxAudioCodec.addItem("AC3(ac3)");
        comboBoxAudioCodec.addItem("Windows Media Audio 2(wmav2)");
        comboBoxAudioCodec.addItem("FLAC(flac)");
        comboBoxAudioCodec.addItem("Vorbis(vorbis)");
        panelCodec.add(labelAudioCodec, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelCodec.add(comboBoxAudioCodec, new TableLayoutConstraints(1, 1, 1, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(panelCodec, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));

        //======== panelResolution ========
        panelResolution.setBorder(new TitledBorder("Resolution"));
        panelResolution.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED,TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        ((TableLayout) panelResolution.getLayout()).setHGap(5);
        ((TableLayout) panelResolution.getLayout()).setVGap(5);
        comboBoxResolution.addItem("All");
        comboBoxResolution.addItem("120x90");
        comboBoxResolution.addItem("320x240");
        comboBoxResolution.addItem("352x240");
        comboBoxResolution.addItem("352x288");
        comboBoxResolution.addItem("428x240");
        comboBoxResolution.addItem("480x480");
        comboBoxResolution.addItem("480x576");
        comboBoxResolution.addItem("640x480");
        comboBoxResolution.addItem("720x480");
        comboBoxResolution.addItem("854x480");
        comboBoxResolution.addItem("720x576");
        comboBoxResolution.addItem("1280x720");
        comboBoxResolution.addItem("1366x768");
        comboBoxResolution.addItem("1920x1080");
        comboBoxResolution.addItem("3840x2160");
		comboBoxAspectRatio.addItem("All");
        comboBoxAspectRatio.addItem("4:3");
        comboBoxAspectRatio.addItem("16:9");        
        panelResolution.add(comboBoxResolution, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelResolution.add(comboBoxAspectRatio, new TableLayoutConstraints(1, 0, 1, 0,
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
        spinnerAudioBitRate.setModel(new SpinnerNumberModel(0, 0, 1000.0, 1));
        panelAudioBitRate.add(spinnerAudioBitRate, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelAudioBitRate.add(labelKbps, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        add(panelAudioBitRate, new TableLayoutConstraints(0, 5, 0, 5,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelButtonSearch ========

        /*add(panelButtonSearch, new TableLayoutConstraints(0, 7, 0, 7,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));*/
    }

    public String getName() {
        return panelNamePath.getName();
    }
    public String getPath() {
        return panelNamePath.getPath();
    }
    public boolean getCaseSensitiveName() {
        return panelNamePath.getCaseSensitive();
    }
    public JButton getSearchMultimediaButton() {
        return panelButtonSearch.getButtonSearch();
    }
    public String getCodec() {
        return comboBoxVideoCodec.getSelectedItem().toString();
    }
    public String getAudioCodec(){
        return comboBoxAudioCodec.getSelectedItem().toString();
    }
    public String getResolution() {
        return comboBoxResolution.getSelectedItem().toString();
    }
    public String getFrameRate() {
        return comboBoxFrameRate.getSelectedItem().toString();
    }
    public String getBitRate() {
        return spinnerAudioBitRate.getValue().toString();
    }
    public String getAspectRatio(){return  comboBoxAspectRatio.getSelectedItem().toString();}
    public double getMinorDuration(){return Double.valueOf(String.valueOf(spinnerMinorDuration.getValue()));
    }
    public double getMajorDuration(){return Double.valueOf(String.valueOf(spinnerMajorDuration.getValue()));
    }
}