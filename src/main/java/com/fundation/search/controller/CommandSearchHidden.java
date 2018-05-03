package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchHidden implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setHidden(inputCommands[i + 1]);
    }
}
