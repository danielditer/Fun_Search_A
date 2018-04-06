package com.fundation.search.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAttributes extends JPanel{
    private JCheckBox checkBoxReadOnly;
    private JCheckBox checkBoxHidden;

    /**
     * Class constructor.
     */
    public PanelAttributes() {
        initComponents();
    }

    public void initComponents(){
        checkBoxReadOnly = new JCheckBox();
        checkBoxHidden = new JCheckBox();
        setBorder(new TitledBorder("Attributes"));
        setLayout(new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
                {TableLayout.PREFERRED}}));
        //---- checkBoxReadOnly ----
        checkBoxReadOnly.setText("Read-only");
        add(checkBoxReadOnly, new TableLayoutConstraints(0, 0, 0, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        //---- checkBoxHidden ----
        checkBoxHidden.setText("Hidden");
        add(checkBoxHidden, new TableLayoutConstraints(2, 0, 2, 0,
                TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
    }
}
