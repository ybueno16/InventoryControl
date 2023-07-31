package com.mycompany.inventorycontrol.models;

import com.mycompany.inventorycontrol.controllers.ProdutoShowController;
import com.mycompany.inventorycontrol.models.ProdutoAdd.conexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoEdit {

  private final String nome;
  private final String descricao;
  private ProdutoShowController produtoShowController;
  private final double preco;
  private final int qntEstoque;
  private static conexaoDAO instancia;
  private int idShow;
  private String descShow;
  private String nomeShow;
  private Double precoShow;
  private int qntEstoqueShow;

  //Constructor
  public ProdutoEdit(
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

  public int getId() {
    return this.idShow;
  }

  public String getNome() {
    return this.nomeShow;
  }

  public String getDescricao() {
    return this.descShow;
  }

  public Double getPreco() {
    return this.preco; // Alterado para retornar 'preco' em vez de 'precoShow'
  }

  public int getQntEstoque() {
    return this.qntEstoqueShow;
  }

  public class EditarProduto {

    public void editarProduto(
      String nome,
      String descricao,
      Double preco,
      int qntEstoque,
      int id
    ) {
      try (
        Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao()
      ) {
        conexao.setAutoCommit(false);
        String query =
          "UPDATE produto SET nome = ?, descricao = ?, preco = ?, qntEstoque = ? WHERE id = ?";

        try (PreparedStatement statement = conexao.prepareStatement(query)) {
          statement.setString(1, nome);
          statement.setString(2, descricao);
          statement.setDouble(3, preco);
          statement.setInt(4, qntEstoque);
          statement.setInt(5, id);

          int rowsAffected = statement.executeUpdate();
          System.out.println("Rows affected: " + rowsAffected);

          if (rowsAffected > 0) {
            conexao.commit();

            PreparedStatement selectStatement = conexao.prepareStatement(
              "SELECT * FROM produto WHERE id = ?"
            );
            selectStatement.setInt(1, id);

            ResultSet rs = selectStatement.executeQuery();

            while (rs.next()) {
              System.out.println(
                "Nome: " +
                rs.getString("nome") +
                " Descricao: " +
                rs.getString("descricao") +
                " preco: " +
                rs.getDouble("preco") +
                " qntEstoque: " +
                rs.getInt("qntEstoque")
              );
            }
            rs.close();
            selectStatement.close();
          } else {
            conexao.rollback();
            System.out.println(
              "No rows updated. Check if product with provided ID exists."
            );
          }
        } catch (Exception e) {
          conexao.rollback();
        } finally {
          conexao.setAutoCommit(true);
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
