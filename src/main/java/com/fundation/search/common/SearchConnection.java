/**
 * @(#)SearchConnection.java  04/19/18
 *
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 *
 * Project Search for Prog102.
 */

package com.fundation.search.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class allows create a DataBase connection
 * and creates the DataBase search.db.
 * @version
 * 19 Apr 2018  * @Daniel Caballero
 */
public class SearchConnection {
    private static SearchConnection searchConn;
    private static Connection con;

    /**
     * Constructor method.
     */
    private SearchConnection() {
        try {
            init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the instance of the connection.
     */
    public static SearchConnection getInstance() {
        if (searchConn == null) {
            searchConn = new SearchConnection();
        }
        return searchConn;
    }

    /**
     * Create the Database connection and creates the Database ´search.db´ if not exists.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:search.db");
        Statement state = con.createStatement();
        state.execute("CREATE TABLE IF NOT EXISTS CRITERIA(ID INTEGER,CRITERIAJSON VARCHAR (200), PRIMARY KEY(ID));");
    }

    /**
     * @return the Database connection;
     */
    public Connection getConnection() {
        return con;
    }
}
