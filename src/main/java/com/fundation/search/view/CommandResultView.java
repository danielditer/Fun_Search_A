/**
 * @(#)Controller.java  4/06/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.model.Asset;
import com.fundation.search.model.ResultFile;
import dnl.utils.text.table.TextTable;
import dnl.utils.text.table.TextTreeTable;

import java.util.List;

/**
 * This class will display the search results, it is applied for command inputs.
 * @version
 * April, 6th 2018  * @Juan Manuel
 */
public class CommandResultView {
    private List<Asset> resultFileList;

    /**
     * Method to set resultFileList attribute.
     * @param resultFileList this list contains the search results.
     */
    public void setResultFileList(List<Asset> resultFileList) {
        this.resultFileList = resultFileList;
    }

    /**
     * Method to display search resultd in command line (cmd).
     */
    public void printResults() {
        System.out.println("Search Results:");
        if (!resultFileList.isEmpty()) {
            String[] tableTitles = {"File Name", "File Path", "Hidden"};
            for (String titles : tableTitles) {
                System.out.print(String.format("%s%s", titles, "\t"));
            }

//            for (Asset results : resultFileList) {
//                System.out.print(String.format("%s%s%s", "\n", results.getFileName(), "\t"));
//                System.out.print(String.format("%s%s", results.getPath(), "\t"));
//                System.out.print(results.getHidden());
//            }

//            for (int i = 0; i < resultFileList.size(); i++) {
//
//                values = new Object[][] {resultFileList.get(i).getFileName(), resultFileList.get(i).getPath(), resultFileList.get(i).getHidden()};
//
//            }
            Object[][] data = {
                    {"Kathy", "Smith",
                            "Snowboarding", new Integer(5), new Boolean(false)},
                    {"John", "Doe",
                            "Rowing", new Integer(3), new Boolean(true)}};


            TextTable tt = new TextTable(tableTitles, data);
            tt.printTable();
        }
    }

}
