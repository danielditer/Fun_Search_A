package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchPath implements StrategyCommand {

    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setPath(inputCommands[i + 1]);
    }
}
