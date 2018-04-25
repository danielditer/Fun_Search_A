package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchExtension implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setExtension(inputCommands[i + 1]);
    }
}
