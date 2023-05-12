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
public class ProdutoModel {
  private int id;
  private final String nome;
  private final String descricao;
  private final double preco;
  private final int qntEstoque;


  //Constructor
  public ProdutoModel(String nome, String descricao, double preco, int qntEstoque) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.qntEstoque = qntEstoque;
  }

  //Getter e Setter

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
public static class ProdutoDAO {
    
    private Connection conexao;
    
    public ProdutoDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/inventoryControl", "root", "123");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao tentar conectar-se ao banco de dados " + e.getMessage());
        }
    }
    
    public void adicionarProduto(ProdutoModel produtoModel) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO produtoModel (nome,descricao,preco,qntEstoque) VALUES (?,?,?,?)");
            stmt.setString(1, produtoModel.getNome());
            stmt.setString(2, produtoModel.getDescricao());
            stmt.setDouble(3, produtoModel.getPreco());
            stmt.setInt(4, produtoModel.getQntEstoque());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produtoModel " + e.getMessage());
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
        
        
    




