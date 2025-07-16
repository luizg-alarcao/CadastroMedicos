package com.umfg.trabalhoprog.model;

public class Medico {
    private int id;
    private String nome;
    private String crm;
    private String especialidade;

    public Medico(){}

    public Medico(int id, String nome, String crm, String especialidade){
        setId(id);
        setNome(nome);
        setCrm(crm);
        setEspecialidade(especialidade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("O ID não pode ser 0.");
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vázio.");
        }
        if (nome.length() < 2 || nome.length() > 100) {
            throw new IllegalArgumentException("O nome deve conter entre 2 e 100 caracteres.");
        }
        if (!nome.matches("^[A-Za-zÀ-ÿ\\s'-]+$")) {
            throw new IllegalArgumentException("Nome inválido! Utilize apenas letras e espaços.");
        }

        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        if (crm == null || !crm.matches("\\d{1,6}/[A-Z]{2}")) {
            throw new IllegalArgumentException("CRM inválido! Use o formato: 123456/UF (ex: 24191/PR)");
        }

        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
