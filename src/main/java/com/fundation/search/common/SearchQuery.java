/**
 * @(#)SearchQuery.java  04/19/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */

package com.fundation.search.common;

import com.fundation.search.controller.LoggerCreator;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * This class allows to search for criteria in the DataBase.
 * @version
 * 19 Apr 2018  * @Daniel Caballero
 */
public class SearchQuery {
    private Connection con;

    /**
     * Class constructor.
     */
    public SearchQuery() {
        LoggerCreator.getInstance().info(this.getClass().getName(),"Class SearchQuery created");
        con = SearchConnection.getInstance().getConnection();
    }

    /**
     * This method allows to add a criteria in Database from a String.
     * @param criteriaJson
     * @return a message from success or error.
     */
    public String addCriteria(String criteriaJson) {
        try {
            String insertQuery = "INSERT INTO CRITERIA VALUES(?,?);";
            PreparedStatement prep = con.prepareStatement(insertQuery);
            prep.setString(2, criteriaJson);
            prep.execute();
        } catch (SQLException e) {
            LoggerCreator.getInstance().error(this.getClass().getName(),e.getMessage(),e);
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * @return all the criteria in Database.
     * @throws SQLException
     */
    public ResultSet getAllCriteria() throws SQLException {
        Statement state = con.createStatement();
        ResultSet set = state.executeQuery("SELECT ID, CRITERIAJSON FROM CRITERIA");
        return set;
    }
}
