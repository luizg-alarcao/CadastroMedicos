package com.umfg.trabalhoprog.view;

import com.umfg.trabalhoprog.model.Medico;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MedicoView {
    public void printCreate() {
        System.out.println("\n\n<--- Cadastrar Médico --->");
    }
    public void printRead() {
        System.out.println("\n\n<--- Médicos Cadastrados --->");
    }
    public void printUpdate() {
        System.out.println("\n\n<--- Atualizar Médico --->");
    }
    public void printDelete() {
        System.out.println("\n\n<--- Excluir Médico --->\n");
    }

    public void printMenu() {
        System.out.println("\n<--- MENU PRINCIPAL --->");
        System.out.println("1 - Cadastrar Novo Médico");
        System.out.println("2 - Listar Médicos Cadastrados");
        System.out.println("3 - Alterar Cadastro");
        System.out.println("4 - Excluir Cadastro");
        System.out.println("0 - Sair");
    }

    public Medico create() {
    Scanner sc = new Scanner(System.in);
    Medico medico = new Medico();

        System.out.print("Nome: ");
        medico.setNome(sc.nextLine());

        System.out.print("CRM: ");
        medico.setCrm(sc.nextLine());

        System.out.print("Especialidade: ");
        medico.setEspecialidade(sc.nextLine());

        return medico;
    }

    public void read(ArrayList<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("\nNenhum médico cadastrado.");
            return;
        }

        for (Medico medico : medicos) {
            System.out.println("-------------------------------");
            System.out.println("ID: " + medico.getId());
            System.out.println("Nome: " + medico.getNome());
            System.out.println("CRM: " + medico.getCrm());
            System.out.println("Especialidade: " + medico.getEspecialidade());
            System.out.println("-------------------------------\n");
        }
    }

    public int delete() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ID do Médico a ser excluido: ");
        return sc.nextInt();
    }

    public Medico update() {
        Scanner sc = new Scanner(System.in);
        Medico medico = new Medico();

        System.out.print("Digite o ID do médico que precisa ser atualizado: ");
        medico.setId(sc.nextInt());
        sc.nextLine(); //Clean Buffer

        System.out.print("Novo Nome: ");
        medico.setNome(sc.nextLine());

        System.out.print("Novo CRM: ");
        medico.setCrm(sc.nextLine());

        System.out.print("Nova Especialidade: ");
        medico.setEspecialidade(sc.nextLine());

        return medico;
    }

    public int menu() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nEscolha uma opção: ");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Essa opção é inválida! Digite apenas números.");
            sc.nextLine();
            return -1; //Retornando valor que o Controller vai tratar
        }
    }

    public void printSucess(String operation) {
        System.out.println("Operação de " + operation + " realizada com sucesso!");
    }

    public void printError(String operation, String error) {
        System.out.println("Erro ao " + operation + ". Detalhes: " + error);
    }
}
