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
  private int id;

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
    return this.id;
  }



  public class EditarProduto {

    public boolean editarProduto(EditarProduto editarProduto) {
      try {
        Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao();
        String query =
          "UPDATE produto SET nome = ?, descricao = ?, preco = ?, qntEstoque = ? WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(query);
        statement.setString(1, nome);
        statement.setString(2, descricao);
        statement.setDouble(3, preco);
        statement.setInt(4, qntEstoque);
        statement.setInt(5, getId());
        int rowsAffected = statement.executeUpdate();
        conexao.close();
      } catch (Exception e) {
        // TODO: handle exception
      }
      return false;
    }
  }

}
