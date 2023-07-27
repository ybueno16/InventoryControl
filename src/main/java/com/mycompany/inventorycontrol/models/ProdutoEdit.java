package com.mycompany.inventorycontrol.models;

import com.mycompany.inventorycontrol.models.ProdutoAdd.conexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoEdit {

  private final String nome;
  private final String descricao;
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
    return this.precoShow;
  }

  public int getQntEstoque() {
    return this.qntEstoqueShow;
  }

  public class EditarProduto {

    public boolean editarProduto(EditarProduto editarProduto) {
      try {
        Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
        String query =
          "UPDATE produto SET nome = ?, descricao = ?, preco = ?, qntEstoque = ? WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(query);
        statement.setString(1, getNome());
        statement.setString(2, getDescricao());
        statement.setDouble(3, getPreco());
        statement.setInt(4, getQntEstoque());
        statement.setInt(5, getId());
        int rowsAffected = statement.executeUpdate();
        conexao.close();
      } catch (Exception e) {
        System.out.println("Erro ao adicionar o produto" + e.getMessage());
      }
      return false;
    }
  }
}
