/**
 * @(#)Controller.java 4/06/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.model.Asset;

import java.util.List;

/**
 * This class will display the search results, it is applied for command inputs.
 *
 * @version April, 6th 2018  * @Juan Manuel
 */
public class CommandResultView {
    private List<Asset> resultFileList;

    /**
     * Method to set resultFileList attribute.
     *
     * @param resultFileList this list contains the search results.
     */
    public void setResultFileList(List<Asset> resultFileList) {
        this.resultFileList = resultFileList;
    }

    /**
     * Method to display search result in command line (cmd).
     */
    public void printResults() {
        System.out.println("Search Results:");
        if (!resultFileList.isEmpty()) {
            String heading1 = "FilePath";
            String heading2 = "FileName";
            String heading3 = "Hidden";
            System.out.printf("%-15s %50s %30s %n", heading1, heading2, heading3);
            String divider = "---------------------------------------------------------------------------------------------------";
            System.out.println(divider);
            for (Asset results : resultFileList) {
                System.out.println("");
                System.out.printf("%-15s %30s %30s %n", results.getPath(), results.getFileName(), results.getHidden());

            }
            System.out.println(divider);
        }
    }
}