/**
 * @(#)Controller.java 4/06/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.model.Asset;
import com.fundation.search.model.ResultFile;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

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
//        System.out.println("Search Results:");
        LOGGER.info("Search Results: ");
        if (resultFileList!= null) {
            String heading1 = "FilePath";
            String heading2 = "FileName";
            String heading3 = "Hidden";
            String heading4 = "ReadOnly";
            String heading5 = "Owner";
            String heading6 = "CreationDate";
            String heading7 = "ModifiedDate";
            String heading8 = "AccessedDate";
            String heading9 = "Size";

            System.out.printf("%-15s %50s %15s %15s %15s %15s %15s %15s %15s %n", heading1, heading2, heading3, heading4, heading5, heading6, heading7, heading8, heading9);
            String divider = "---------------------------------------------------------------------------------------------------";
            System.out.println(divider);
            for (Asset results : resultFileList) {
                System.out.println("");
                if (results instanceof ResultFile) {
                    System.out.printf("%-15s %30s %15s %15s %15s %15s %15s %15s %15s",
                            results.getPath(), results.getFileName(), results.getHidden(), results.getReadOnly(), results.getOwner(), results.getCreationTime(), results.getLastModifiedTime(), results.getLastAccessTime(), results.getSize());

                } else {
                    System.out.printf("%-15s %30s %15s %15s %15s ",
                            results.getPath(), results.getFileName(), results.getHidden(), results.getReadOnly(), results.getOwner());

                }

            }
        }
    }
}