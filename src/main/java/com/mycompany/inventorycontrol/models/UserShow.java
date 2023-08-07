package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserShow {

  private int id;
  private String nome;
  private String senha;
  private int nivel_permissao;

  public UserShow(int id, String nome, String senha, int nivel_permissao) {
    this.id = id;
    this.nome = nome;
    this.senha = senha;
    this.nivel_permissao = nivel_permissao;
  }

  // Método para obter a lista de usuarios do banco de dados
  public static List<UserShow> getUsuario() {
    List<UserShow> usuarios = new ArrayList<>();
    Connection conexao = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
      statement = conexao.createStatement();
      String query = "SELECT * FROM usuario";
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String senha = resultSet.getString("senha");
        int nivel_permissao = resultSet.getInt("nivel_permissao");
        UserShow usuario = new UserShow(id, nome, senha, nivel_permissao);
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public static List<UserShow> PesquisaUsuario(String termoPesquisa) {
    List<UserShow> usuarios = new ArrayList<>();
    try {
      Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
      String query = "SELECT * FROM usuario WHERE nome LIKE ?";
      PreparedStatement statement = conexao.prepareStatement(query);
      statement.setString(1, "%" + termoPesquisa + "%");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String desc = resultSet.getString("senha");
        int nivel_permissao = resultSet.getInt("nivel_permissao");
        UserShow usuario = new UserShow(id, nome, desc, nivel_permissao);
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSenha() {
    return senha;
  }

  public double getNivel_Permissao() {
    return nivel_permissao;
  }
}
