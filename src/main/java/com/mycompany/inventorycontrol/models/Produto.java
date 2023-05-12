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
public class Produto {
  private int id;
  private final String nome;
  private final String descricao;
  private final double preco;
  private final int qntEstoque;


  //Constructor
  public Produto(String nome, String descricao, double preco, int qntEstoque) {
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
            e.printStackTrace();
        }
    }
    
    public void adicionarProduto(Produto produto) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO produto (nome,descricao,preco,qntEstoque) VALUES (?,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4,produto.getQntEstoque());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarProduto(Produto produto) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, descricao = ?, preco = ?, qntEstoque = ?, WHERE id = ?");
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4,produto.getQntEstoque());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }
    public void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
} 
        
        
    




