package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchCaseSensitive implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        boolean value = false;
        if ((inputCommands[i + 1]).equals("true")) {
            value = true;
        }
        searchCriteria.setNameFileCaseSensitive(value);
    }
}
