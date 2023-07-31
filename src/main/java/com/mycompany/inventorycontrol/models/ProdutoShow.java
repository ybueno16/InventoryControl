package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoShow {

  private int id;
  private String nome;
  private String descricao;
  private double preco;
  private int qntEstoque;

  public ProdutoShow(
    int id,
    String nome,
    String descricao,
    double preco,
    int qntEstoque
  ) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.qntEstoque = qntEstoque;
  }

  // Método para obter a lista de produtos do banco de dados
  public static List<ProdutoShow> getProdutos() {
    List<ProdutoShow> produtos = new ArrayList<>();
    Connection conexao = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
      statement = conexao.createStatement();
      String query = "SELECT * FROM produto";
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String desc = resultSet.getString("descricao");
        double preco = resultSet.getDouble("preco");
        int qntEstoque = resultSet.getInt("qntEstoque");
        ProdutoShow produto = new ProdutoShow(
          id,
          nome,
          desc,
          preco,
          qntEstoque
        );
        produtos.add(produto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return produtos;
  }

  public static List<ProdutoShow> PesquisaProduto(String termoPesquisa) {
    List<ProdutoShow> produtos = new ArrayList<>();
    try {
      Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
      String query = "SELECT * FROM produto WHERE nome LIKE ?";
      PreparedStatement statement = conexao.prepareStatement(query);
      statement.setString(1, "%" + termoPesquisa + "%");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String desc = resultSet.getString("descricao");
        double preco = resultSet.getDouble("preco");
        int qntEstoque = resultSet.getInt("qntEstoque");
        ProdutoShow produto = new ProdutoShow(
          id,
          nome,
          desc,
          preco,
          qntEstoque
        );
        produtos.add(produto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return produtos;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getPreco() {
    return preco;
  }

  public int getqntEstoque() {
    return qntEstoque;
  }
}
