package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchAccessedDate implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        String[] date = inputCommands[i + 1].split("_");
        searchCriteria.setFromDate(date[0]);
        searchCriteria.setToDate(date[1]);
        searchCriteria.setAccessedDate(true);
    }
}
