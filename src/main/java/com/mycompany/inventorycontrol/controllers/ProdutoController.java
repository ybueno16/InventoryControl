package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.produtoAdd;
import com.mycompany.inventorycontrol.models.produtoAdd.conexaoDAO;
import com.mycompany.inventorycontrol.views.ProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoController implements ActionListener {

  private ProdutoView view;
  private conexaoDAO dao;
  private ProdutoShowController ProdutoShowController;

  public ProdutoController(
    ProdutoView pview,
    ProdutoShowController produtoShowController
  ) {
    this.view = pview;
    this.dao = new conexaoDAO();
    this.ProdutoShowController = produtoShowController;
    this.view.getButtonAdd().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nome = view.getTextProduto().getText();
    String descricao = view.getTextDescricao().getText();
    double preco = Double.parseDouble(view.getTextPreco().getText());
    int qntEstoque = Integer.parseInt(view.getTextQntEstoque().getText());
    produtoAdd produto = new produtoAdd(nome, descricao, preco, qntEstoque);
    adicionarProduto(produto);
    ProdutoShowController.limparTabela();
    ProdutoShowController.carregarProdutos();
    dao.fecharConexao();
    view.limparCampos();
    view.dispose();
  }

  public void adicionarProduto(produtoAdd produto) {
    dao.adicionarProduto(produto);
  }
}
