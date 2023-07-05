/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author yuri
 */
public class produtoAdd {

  private int id;
  private final String nome;
  private final String descricao;
  private final double preco;
  private final int qntEstoque;
  private static conexaoDAO instancia;

  //Constructor
  public produtoAdd(String nome, String descricao, double preco, int qntEstoque) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.qntEstoque = qntEstoque;
  }

  //Getter's

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

  public int getQntEstoque() {
    return qntEstoque;
  }

  //Connection on MySQL
  public static class conexaoDAO {

    private Connection conexao;

    public conexaoDAO() {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao =
          DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/inventoryControl",
            "root",
            "123"
          );
      } catch (ClassNotFoundException | SQLException e) {
        System.out.println(
          "Erro ao tentar conectar-se ao banco de dados " + e.getMessage()
        );
      }
    }

    public static conexaoDAO getInstancia() {
      if (instancia == null) {
        instancia = new conexaoDAO();
      }
      return instancia;
    }

    public Connection getConexao() {
      return conexao;
    }

    public void adicionarProduto(produtoAdd produto) {
      try {
        PreparedStatement stmt = conexao.prepareStatement(
          "INSERT INTO produto (nome,descricao,preco,qntEstoque) VALUES (?,?,?,?)"
        );
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());
        stmt.setDouble(3, produto.getPreco());
        stmt.setInt(4, produto.getQntEstoque());
        stmt.executeUpdate();
        stmt.close();
      } catch (SQLException e) {
        System.out.println("Erro ao adicionar o produto " + e.getMessage());
      }
    }

    public void fecharConexao() {
      try {
        conexao.close();
      } catch (SQLException e) {
        System.out.println("Erro ao fechar a conexão " + e.getMessage());
      }
    }
  }
}
