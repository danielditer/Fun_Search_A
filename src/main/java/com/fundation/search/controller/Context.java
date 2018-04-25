package com.fundation.search.controller;

import com.fundation.search.model.SearchCriteria;

public class Context {
    private StrategyCommand strategyCommand;

    public Context(StrategyCommand strategyCommand) {
        this.strategyCommand = strategyCommand;
    }

    public void executeCommand(String command, String[] inputCommands, int i, SearchCriteria searchCriteria) {
        strategyCommand.commandHandler(command, inputCommands, i, searchCriteria);
    }
}
