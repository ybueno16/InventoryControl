package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.controllers.ProdutoShowController;
import com.mycompany.inventorycontrol.models.ProdutoAdd;
import com.mycompany.inventorycontrol.models.ProdutoAdd.conexaoDAO;
import com.mycompany.inventorycontrol.models.ProdutoEdit;
import com.mycompany.inventorycontrol.views.ProdutoEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProdutoEditController implements ActionListener {

  private ProdutoEditView view;
  ProdutoAdd.conexaoDAO dao = ProdutoAdd.conexaoDAO.getInstancia();
  private ProdutoEdit edit;
  private ProdutoShowController produtoShowController;

  public ProdutoEditController(
    ProdutoEditView view,
    ProdutoShowController produtoShowController
  ) {
    this.view = view;
    this.edit = edit;
    this.produtoShowController = produtoShowController;
    this.view.getButtonEdit().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nome = view.getTextProduto().getText();
    String descricao = view.getTextDescricao().getText();
    double preco = Double.parseDouble(view.getTextPreco().getText());
    int qntEstoque = Integer.parseInt(view.getTextQntEstoque().getText());
    int id = Integer.parseInt(view.getTextId().getText());

    ProdutoEdit.EditarProduto produtoEdit = new ProdutoEdit(
      nome,
      descricao,
      preco,
      qntEstoque
    )
      .new EditarProduto();
    try {
      produtoEdit.editarProduto(nome, descricao, preco, qntEstoque, id);
    } finally {
      try {
        dao.fecharConexão();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    }
    produtoShowController.limparTabela();
    produtoShowController.carregarProdutos();
    view.limparCampos();
    view.dispose();
  }

  public void editarProduto(
    ProdutoEdit editarProduto,
    String nome,
    String descricao,
    double preco,
    int qntEstoque,
    int id
  ) throws SQLException {
    ProdutoEdit.EditarProduto editor = editarProduto.new EditarProduto();
    editor.editarProduto(nome, descricao, preco, qntEstoque, id);
  }
}
