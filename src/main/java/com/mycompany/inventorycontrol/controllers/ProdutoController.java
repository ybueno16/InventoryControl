package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.Produto;
import com.mycompany.inventorycontrol.models.Produto.conexaoDAO;
import com.mycompany.inventorycontrol.views.ProdutoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoController implements ActionListener {

    private ProdutoView view;
    private conexaoDAO dao;
    private ProdutoShowController PScontroller;

    public ProdutoController(ProdutoView pview, ProdutoShowController PScontroller) {
        this.view = pview;
        this.dao = new conexaoDAO();
        this.PScontroller = PScontroller;
        this.view.getButtonAdd().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = view.getTextProduto().getText();
        String descricao = view.getTextDescricao().getText();
        double preco = Double.parseDouble(view.getTextPreco().getText());
        int qntEstoque = Integer.parseInt(view.getTextQntEstoque().getText());
        Produto produto = new Produto(nome, descricao, preco, qntEstoque);
        adicionarProduto(produto);
        PScontroller.limparTabela();
        PScontroller.carregarProdutos();
        dao.fecharConexao();
        view.limparCampos();
        view.dispose();
    }

    public void adicionarProduto(Produto produto) {
        dao.adicionarProduto(produto);
    }
}
