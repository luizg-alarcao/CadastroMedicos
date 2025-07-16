package com.umfg.trabalhoprog;

import com.umfg.trabalhoprog.controller.MedicoController;
import com.umfg.trabalhoprog.model.dao.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getConnection();
            MedicoController medicoController = new MedicoController(connection);
            medicoController.menu();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                Database.closeConnection();
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}