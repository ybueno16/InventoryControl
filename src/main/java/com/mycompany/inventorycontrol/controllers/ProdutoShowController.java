package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.ProdutoShow;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import com.mycompany.inventorycontrol.views.ProdutoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoShowController {
    private ProdutoShowView PSview;

    public ProdutoShowController(ProdutoShowView PSview) {
        this.PSview = PSview;
        PSview.getAddProdutoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaAdicionarProduto();
            }
        });
    }

    public void carregarProdutos() {
        List<ProdutoShow> produtos = ProdutoShow.getProdutos();
        for (ProdutoShow produto : produtos) {
            adicionarProdutoTabela(produto);
        }
    }

    // Método para adicionar um produto à tabela
    public void adicionarProdutoTabela(ProdutoShow produto) {
        Object[] row = new Object[]{produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getqntEstoque()};
        PSview.getTableModel().addRow(row);
    }

    public void limparTabela() {
        PSview.getTableModel().setRowCount(0);
    }

    public void exibirTelaAdicionarProduto() {
        ProdutoView Pview = new ProdutoView();
        ProdutoController Pcontroller = new ProdutoController(Pview);

        Pview.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar o produto e atualizar a tabela do ProdutoShow
                ProdutoShow novoProduto = criarProdutoShow(Pview);
                adicionarProdutoTabela(novoProduto);
                Pview.dispose();
            }
        });

        Pview.setVisible(true);
    }

    private ProdutoShow criarProdutoShow(ProdutoView produtoView) {
        // Obter os dados do produto a partir da tela ProdutoView e criar um objeto ProdutoShow correspondente
        String nome = produtoView.getTextProduto().getText();
        String descricao = produtoView.getTextDescricao().getText();
        double preco = Double.parseDouble(produtoView.getTextPreco().getText());
        int qntEstoque = Integer.parseInt(produtoView.getTextQntEstoque().getText());
        return new ProdutoShow(nome, descricao, preco, qntEstoque);
    }
}
