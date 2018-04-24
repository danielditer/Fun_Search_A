package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchName implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setName(inputCommands[i + 1]);
    }
}
