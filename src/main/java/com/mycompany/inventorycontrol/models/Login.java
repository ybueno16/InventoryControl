package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycompany.inventorycontrol.models.Produto.conexaoDAO;

public class Login {
    private final int id;
    private final String usuario;
    private final String senha;

    public Login(int id, String usuario, String senha, Produto.conexaoDAO dao) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;

    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void validarLogin(Login login) throws SQLException {
        Connection conexao = null;
        try {
            // realiza a conexão e as operações desejadas no banco de dados
            conexao = conexaoDAO.getInstancia().getConexao();
            String query = "SELECT * from usuario where nome = ? and senha = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, getUsuario());
            stmt.setString(2,getSenha());
        } catch (SQLException e) {
            System.out.println("Erro ao validar senha" + e.getMessage());
        } finally {
            // fecha a conexão com o banco de dados
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}
