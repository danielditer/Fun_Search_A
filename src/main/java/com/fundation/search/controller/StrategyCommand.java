package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public interface StrategyCommand {
    void commandHandler(String command, String[] inputCommands, int i, SearchCriteria searchCriteria);
}
