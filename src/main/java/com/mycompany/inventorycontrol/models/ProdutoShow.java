package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ProdutoShow {
    public static class ShowProducts {
        public static void showProducts(ProdutoShow Pshow) {
            try {
                Connection conexao = Produto.conexaoDAO.getInstancia().getConexao();
                Statement statement = conexao.createStatement();
                String query = "SELECT * FROM produto";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String descricao = resultSet.getString("descricao");
                    double preco = resultSet.getDouble("preco");
                    int quantidadeEstoque = resultSet.getInt("quantidade_estoque");
                }
                resultSet.close();
                statement.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
