package com.umfg.trabalhoprog.controller;

import com.umfg.trabalhoprog.model.Medico;
import com.umfg.trabalhoprog.model.dao.MedicoDAO;
import com.umfg.trabalhoprog.view.MedicoView;

import java.sql.Connection;
import java.sql.SQLException;

public class MedicoController {
    private MedicoDAO medicoDAO;
    private MedicoView medicoView;

    public MedicoController(Connection connection) {
        this.medicoDAO = new MedicoDAO(connection);
        this.medicoView = new MedicoView();
    }

    public void menu() {
        int opcao;

        do {
            medicoView.printMenu();
            opcao = medicoView.menu();

            switch (opcao) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                case -1:
                    System.out.println("Tente novamente...\n");
                    break;
                default:
                    System.out.println("Desculpe, mais essa opção não existe na lista!\nTente outra.\n");
            }
        } while (opcao != 0);
    }

    private void create() {
        try {
            medicoView.printCreate();
            Medico medico = medicoView.create();
            medicoDAO.create(medico);
            medicoView.printSucess("cadastrar médico");
        } catch (SQLException e) {
            medicoView.printError("criar", e.getMessage());
        }
    }

    private void read() {
        try {
            medicoView.printRead();
            medicoView.read(medicoDAO.read());
        } catch (SQLException e) {
            medicoView.printError("ler cadastros", e.getMessage());
        }
    }

    private void update() {
        try {
            medicoView.printUpdate();
            var medicos = medicoDAO.read();

            if (medicos.isEmpty()) {
                System.out.println("\nNão há médicos cadastrados para atualizar.");
                return;
            }

            medicoView.read(medicos);

            Medico medico = medicoView.update();
            medicoDAO.update(medico);
            medicoView.printSucess("atualizar cadastro");

        } catch (SQLException e) {
            medicoView.printError("atualizar", e.getMessage());
        }
    }

    private void delete() {
        try {
            medicoView.printDelete();
            var medicos = medicoDAO.read();

            if (medicos.isEmpty()) {
                System.out.println("Não há médicos cadastrados para exclusão.");
                return;
            }

            medicoView.read(medicos);
            int id = medicoView.delete();
            medicoDAO.delete(id);
            medicoView.printSucess("exclusão");
        } catch (SQLException e) {
            medicoView.printError("deletar", e.getMessage());
        }
    }
}
