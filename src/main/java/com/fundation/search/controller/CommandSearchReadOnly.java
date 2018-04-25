package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchReadOnly implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        searchCriteria.setReadOnly(inputCommands[i + 1]);
    }
}
