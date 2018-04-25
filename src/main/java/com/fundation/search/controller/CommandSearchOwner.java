package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchOwner implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setOwner(inputCommands[i + 1]);
    }
}
