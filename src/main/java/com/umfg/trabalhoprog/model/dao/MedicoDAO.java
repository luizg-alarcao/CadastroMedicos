package com.umfg.trabalhoprog.model.dao;

import com.umfg.trabalhoprog.model.Medico;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO {
    private Connection connection;

    public MedicoDAO (Connection connection) {
        this.connection = connection;
    }

    public void create(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (nome, crm, especialidade) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, medico.getNome());
        ps.setString(2, medico.getCrm());
        ps.setString(3, medico.getEspecialidade());
        ps.execute();
    }

    public ArrayList<Medico> read() throws SQLException {
        String sql = "SELECT * FROM medico";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Medico> medicos = new ArrayList<>();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setId(rs.getInt("id"));
            medico.setNome(rs.getString("nome"));
            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medicos.add(medico);
        }
        return medicos;
    }

    public void update(Medico medico) throws SQLException {
        String sql = "UPDATE medico SET nome = ?, crm = ?, especialidade = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, medico.getNome());
        ps.setString(2, medico.getCrm());
        ps.setString(3, medico.getEspecialidade());
        ps.setInt(4, medico.getId());
        ps.execute();
    }

    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM medico WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
}
