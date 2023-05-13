/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.Produto;
import com.mycompany.inventorycontrol.models.Produto.conexaoDAO;
import com.mycompany.inventorycontrol.views.ProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yuri
 */


public class ProdutoController implements ActionListener {

    private final ProdutoView view;
    private final conexaoDAO dao;

    public ProdutoController(ProdutoView view) {
        this.view = view;
        this.dao = new conexaoDAO();
        this.view.getButtonAdd().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = view.getTextProduto().getText();
        String descricao = view.getTextDescricao().getText();
        double preco = Double.parseDouble(view.getTextPreco().getText());
        int qntEstoque = Integer.parseInt(view.getTextQntEstoque().getText());
        Produto produto = new Produto(nome, descricao, preco, qntEstoque);
        dao.adicionarProduto(produto);
        dao.fecharConexao();
    }
}
