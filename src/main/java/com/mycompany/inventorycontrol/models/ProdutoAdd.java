/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.models;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author yuri
 */
public class ProdutoAdd {

  private int id;
  private final String nome;
  private final String descricao;
  private final double preco;
  private final int qntEstoque;
  private static conexaoDAO instancia;

  //Constructor
  public ProdutoAdd(
    String nome,
    String descricao,
    double preco,
    int qntEstoque
  ) {
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

    private HikariDataSource ds;

    private conexaoDAO() {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl("jdbc:mysql://172.17.0.2:3306/inventoryControl");
      config.setUsername("root");
      config.setPassword("123");
      ds = new HikariDataSource(config);
    }

    private static conexaoDAO instancia = new conexaoDAO();

    public static conexaoDAO getInstancia() {
      return instancia;
    }

    public Connection getConexao() throws SQLException {
      return ds.getConnection();
    }

    public void adicionarProduto(ProdutoAdd produto) {
      try (
        Connection conn = getConexao();
        PreparedStatement stmt = conn.prepareStatement(
          "INSERT INTO produto (nome,descricao,preco,qntEstoque) VALUES (?,?,?,?)"
        )
      ) {
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());
        stmt.setDouble(3, produto.getPreco());
        stmt.setInt(4, produto.getQntEstoque());
        stmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("Erro ao adicionar o produto " + e.getMessage());
      }
    }

    public void fecharConexão() throws SQLException {
      Connection conn = getConexao();
      try {
        if (conn != null) {
          conn.close();
          System.out.println("Database connection closed.");
        }
      } catch (SQLException ex) {
        System.err.println("Cannot close connection: " + ex.getMessage());
      } finally {
        conn = null; // It's a good practice to null your Connection object after you close it.
      }
    }
  }
}
