package com.umfg.trabalhoprog.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/medicos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try { connection.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
        }
    }
}
