package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.ProdutoAdd;
import com.mycompany.inventorycontrol.models.ProdutoAdd.conexaoDAO;
import com.mycompany.inventorycontrol.views.ProdutoAddView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoAddController implements ActionListener {

  private ProdutoAddView view;
  private conexaoDAO dao;
  private ProdutoShowController ProdutoShowController;

  public ProdutoAddController(
          ProdutoAddView view,
          ProdutoShowController produtoShowController
  ) {
    this.view = view;
    this.dao = ProdutoAdd.conexaoDAO.getInstancia();
    this.ProdutoShowController = produtoShowController;
    this.view.getButtonAdd().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String nome = view.getTextProduto().getText();
    String descricao = view.getTextDescricao().getText();
    double preco = Double.parseDouble(view.getTextPreco().getText());
    int qntEstoque = Integer.parseInt(view.getTextQntEstoque().getText());
    ProdutoAdd produto = new ProdutoAdd(nome, descricao, preco, qntEstoque);
    adicionarProduto(produto);
    ProdutoShowController.limparTabela();
    ProdutoShowController.carregarProdutos();
    view.limparCampos();
    view.dispose();
  }

  public void adicionarProduto(ProdutoAdd produto) {
    dao.adicionarProduto(produto);
  }
}
