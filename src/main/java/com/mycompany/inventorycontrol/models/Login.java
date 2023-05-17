package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private static String usuario;
    private static String senha;

    public Login(String usuario, String senha) {
        Login.usuario = usuario;
        Login.senha = senha;
    }


    public static String getUsuario() {
        return usuario;
    }

    public static String getSenha() {
        return senha;
    }


    public static class ValidarLogin {
        public boolean validarLogin(Login login) {
            try {
                Connection conexao = Produto.conexaoDAO.getInstancia().getConexao();
                String query = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
                PreparedStatement stmt = conexao.prepareStatement(query);
                stmt.setString(1, getUsuario());
                stmt.setString(2, getSenha());
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                System.out.println("Erro ao validar senha: " + e.getMessage());
                return false;
            }
        }
    }
}
