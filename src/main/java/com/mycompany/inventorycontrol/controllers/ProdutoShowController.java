package com.mycompany.inventorycontrol.controllers;

import static com.mycompany.inventorycontrol.models.ProdutoShow.getProdutos;

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
    PSview
      .getAddProdutoButton()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            exibirTelaAdicionarProduto();
          }
        }
      );

    PSview.getSearchFieldButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        procuraProduto();
        System.out.println("Pesquisado");
      }
    });


    PSview
      .getUserConfig()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event) {
            System.out.println("Menu clicado"); // Instanciar tela usuario
          }
        }
      );
  }

  public void carregarProdutos() {
    PSview.getTableModel().setRowCount(0);
    List<ProdutoShow> produtos = getProdutos();
    for (ProdutoShow produto : produtos) {
      adicionarProdutoTabela(produto);
    }
  }

  public void limparTabela() {
    PSview.getTableModel().setRowCount(0);
  }

  public void adicionarProdutoTabela(ProdutoShow produto) {
    Object[] row = new Object[] {
      produto.getId(),
      produto.getNome(),
      produto.getDescricao(),
      produto.getPreco(),
      produto.getqntEstoque(),
    };
    PSview.getTableModel().addRow(row);
  }

  public void exibirTelaAdicionarProduto() {
    ProdutoView Pview = new ProdutoView();
    ProdutoController Pcontroller = new ProdutoController(Pview, this);
    Pview.setVisible(true);
  }

  public void procuraProduto(){
    limparTabela();
  }  
}
