package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class CommandSearchSize implements StrategyCommand {
    @Override
    public void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        String[] size = inputCommands[i + 1].split(" ");
        searchCriteria.setSizeSign(size[0]);
        searchCriteria.setSizeRequired(size[1]);
        searchCriteria.setSizeMeasure(size[2]);
    }
}
