package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.ProdutoShow;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import com.mycompany.inventorycontrol.views.ProdutoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.mycompany.inventorycontrol.models.ProdutoShow.getProdutos;

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
        List<ProdutoShow> produtos = getProdutos();
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
                ProdutoView Pview = new ProdutoView();
                ProdutoController Pcontroller = new ProdutoController(Pview);
                Pview.dispose();
            }
        });

        Pview.setVisible(true);
    }
}
