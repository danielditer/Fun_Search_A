/**
 * @(#)Controller.java 4/06/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.view;

import com.fundation.search.model.Asset;

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
        LOGGER.info("Search Results: ");
        if (resultFileList != null) {
            ConsoleStringTable table = new ConsoleStringTable();
            table.addString(0, 0, "FilePath");
            table.addString(0, 1, "FileName");
            table.addString(0, 2, "Hidden");
            table.addString(0, 3, "Read-Only");
            table.addString(0, 4, "Owner");
            table.addString(0, 5, "CreationDate");
            table.addString(0, 6, "ModifiedDate");
            table.addString(0, 7, "AccessedDate");
            table.addString(0, 8, "Size");
            int i = 1;
            for (Asset results : resultFileList) {
                table.addString(i, 0, results.getPath());
                table.addString(i, 1, results.getFileName());
                table.addString(i, 2, String.valueOf(results.getHidden()));
                table.addString(i, 3, String.valueOf(results.getReadOnly()));
                table.addString(i, 4, results.getOwner());
                table.addString(i, 5, results.getCreationTime());
                table.addString(i, 6, results.getLastModifiedTime());
                table.addString(i, 7, results.getLastAccessTime());
                table.addString(i, 8, String.valueOf(results.getSize()));
                i++;
            }
            System.out.println(table.toString());
        }
    }

    /**
     * method displayResult tp display an error message
     *
     * @param result that contains the error message
     **/
    public void displayResult(String result) {
        System.out.println(result);
    }
}
