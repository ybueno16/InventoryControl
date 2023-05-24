package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.ProdutoShow;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import java.util.List;

public class ProdutoShowController {
    private ProdutoShowView PSview;
    public ProdutoShowController(ProdutoShowView PSview){
        this.PSview = PSview;
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

}
