package com.mycompany.inventorycontrol.controllers;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import com.mycompany.inventorycontrol.models.ProdutoDelete;
import com.mycompany.inventorycontrol.views.ProdutoEditView;

public class ProdutoDeleteController {
    private ProdutoEditView view;
    private ProdutoShowController controller;

    public ProdutoDeleteController(ProdutoEditView view,ProdutoShowController controller) {
        this.view = view;
        this.controller = controller;
        this.view.getButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(view.getTextId().getText());
                ProdutoDelete excluir = new ProdutoDelete();
                try {
                    excluir.excluirProduto(id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                controller.limparTabela();
                controller.carregarProdutos();

            }
        });

    }

}
