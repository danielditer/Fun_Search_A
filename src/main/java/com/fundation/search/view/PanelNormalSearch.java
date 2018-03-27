package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;

/**
 * Panel for tab normal search.
 */
public class PanelNormalSearch extends JPanel {
    /**
     * Class constructor.
     */
    public PanelNormalSearch() {
        initComponents();
        setVisible(true);
    }

    /**
     * Initializes panel components.
     */
    public void initComponents() {
        panelNamePath = new JPanel();
        labelName = new JLabel();
        textFieldName = new JTextField();
        labelPath = new JLabel();
        textFieldPath = new JTextField();
        panelCoincidences = new JPanel();
        panelFileContent = new JPanel();
        scrollPaneContent = new JScrollPane();
        textAreaContent = new JTextArea();
        checkBoxCaseSensitive = new JCheckBox();
        panelDate = new JPanel();
        checkBoxCreated = new JCheckBox();
        checkBoxModified = new JCheckBox();
        checkBoxAccessed = new JCheckBox();
        labelFrom = new JLabel();
        formattedTextFieldStart = new JFormattedTextField();
        labelTo = new JLabel();
        formattedTextFieldEnd = new JFormattedTextField();
        panelAttributes = new JPanel();
        checkBoxReadOnly = new JCheckBox();
        checkBoxHidden = new JCheckBox();

        //======== panelNamePath ========
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        panelNamePath.setBorder(new TitledBorder(null, "Name/Path", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));
        panelNamePath.setOpaque(false);
        panelNamePath.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- labelName ----
        labelName.setText("Name:");
        final Dimension preferredSize = new Dimension(120, 20);
        labelName.setPreferredSize(preferredSize);
        panelNamePath.add(labelName, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.RIGHT,
                TableLayoutConstraints.FULL));
        //---- textFieldName ----
        textFieldName.setPreferredSize(preferredSize);
        panelNamePath.add(textFieldName, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelPath ----
        labelPath.setText("Path:");
        panelNamePath.add(labelPath, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        //---- textFieldPath ----
        textFieldPath.setPreferredSize(preferredSize);
        panelNamePath.add(textFieldPath, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        add(panelNamePath, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelCoincidences ========
        panelCoincidences.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        add(panelCoincidences, new TableLayoutConstraints(1, 0, 1, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelFileContent ========
        panelFileContent.setBorder(new TitledBorder("File content"));
        panelFileContent.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));

        //======== scrollPaneContent ========
        //---- textAreaContent ----
        final Dimension preferredSizeTextArea = new Dimension(240, 20);
        textAreaContent.setPreferredSize(preferredSizeTextArea);
        scrollPaneContent.setViewportView(textAreaContent);
        panelFileContent.add(scrollPaneContent, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxCaseSensitive ----
        checkBoxCaseSensitive.setText("Case sensitive");
        panelFileContent.add(checkBoxCaseSensitive, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelFileContent, new TableLayoutConstraints(0, 1, 0, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelDate ========
        panelDate.setBorder(new TitledBorder("Date"));
        panelDate.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,
                        TableLayout.PREFERRED},
                {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        //---- checkBoxCreated ----
        checkBoxCreated.setText("Created");
        panelDate.add(checkBoxCreated, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxModified ----
        checkBoxModified.setText("Modified");
        panelDate.add(checkBoxModified, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxAccessed ----
        checkBoxAccessed.setText("Accesed");
        final int constraints2 = 4;
        panelDate.add(checkBoxAccessed, new TableLayoutConstraints(constraints2, 0, constraints2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelFrom ----
        labelFrom.setText("From:");
        panelDate.add(labelFrom, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL,
                TableLayoutConstraints.FULL));
        panelDate.add(formattedTextFieldStart, new TableLayoutConstraints(1, 1, 2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- labelTo ----
        labelTo.setText("To:");
        final int constraints1 = 3;
        panelDate.add(labelTo, new TableLayoutConstraints(constraints1, 1, constraints1, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        panelDate.add(formattedTextFieldEnd, new TableLayoutConstraints(constraints2, 1, constraints2, 1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelDate, new TableLayoutConstraints(0, 2, 0, 2,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //======== panelAttributes ========
        panelAttributes.setBorder(new TitledBorder("Attributes"));
        panelAttributes.setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- checkBoxReadOnly ----
        checkBoxReadOnly.setText("Read-only");
        panelAttributes.add(checkBoxReadOnly, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxHidden ----
        checkBoxHidden.setText("Hidden");
        panelAttributes.add(checkBoxHidden, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(panelAttributes, new TableLayoutConstraints(0, constraints1, 0, constraints1,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }

    private JPanel panelNamePath;
    private JLabel labelName;
    private JTextField textFieldName;
    private JLabel labelPath;
    private JTextField textFieldPath;
    private JPanel panelCoincidences;
    private JPanel panelFileContent;
    private JScrollPane scrollPaneContent;
    private JTextArea textAreaContent;
    private JCheckBox checkBoxCaseSensitive;
    private JPanel panelDate;
    private JCheckBox checkBoxCreated;
    private JCheckBox checkBoxModified;
    private JCheckBox checkBoxAccessed;
    private JLabel labelFrom;
    private JFormattedTextField formattedTextFieldStart;
    private JLabel labelTo;
    private JFormattedTextField formattedTextFieldEnd;
    private JPanel panelAttributes;
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxHidden;
}
