package com.fundation.search.view;

import com.fundation.search.model.ResultFile;
import com.fundation.search.model.SearchCriteria;
import com.fundation.search.model.SearchFiles;

import java.util.List;

public class CommandResultView {
    private List<ResultFile> resultFileList;

    public CommandResultView() {
    }

    public void setResultFileList(List<ResultFile> resultFileList) {
        this.resultFileList = resultFileList;
    }
    public void printResults() {
        System.out.println("Search Results:");
        if (!resultFileList.isEmpty()) {
            String[] tableTitles = {"File Name", "File Path", "Hidden"};
            for (String titles : tableTitles) {
                System.out.print(String.format("%s%s", titles, "\t"));
            }

            for (ResultFile results : resultFileList) {
                System.out.print(String.format("%s%s%s", "\n", results.getFileName(), "\t"));
                System.out.print(String.format("%s%s", results.getFileName(), "\t"));
                System.out.print(results.getFileName());
            }
        }
    }

}
