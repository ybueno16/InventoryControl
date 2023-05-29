package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoShow {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int qntEstoque;

    public ProdutoShow(int id, String nome, String descricao, double preco, int qntEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }

    // Método para obter a lista de produtos do banco de dados
    public static List<ProdutoShow> getProdutos() {
        List<ProdutoShow> produtos = new ArrayList<>();
        try {
            Connection conexao = Produto.conexaoDAO.getInstancia().getConexao();
            Statement statement = conexao.createStatement();
            String query = "SELECT * FROM produto";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String desc = resultSet.getString("descricao");
                double preco = resultSet.getDouble("preco");
                int qntEstoque = resultSet.getInt("qntEstoque");
                ProdutoShow produto = new ProdutoShow(id,nome, desc, preco, qntEstoque);
                produtos.add(produto);
            }
            resultSet.close();
            statement.close();
            conexao.close();
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
