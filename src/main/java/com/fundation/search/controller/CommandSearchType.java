package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchType implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setTypeFile(Integer.parseInt(inputCommands[i + 1]));
    }
}
