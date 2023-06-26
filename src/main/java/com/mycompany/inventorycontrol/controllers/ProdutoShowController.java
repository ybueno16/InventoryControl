package com.mycompany.inventorycontrol.controllers;

import static com.mycompany.inventorycontrol.models.ProdutoShow.getProdutos;

import com.mycompany.inventorycontrol.models.ProdutoShow;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import com.mycompany.inventorycontrol.views.ProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    PSview
      .getSearchFieldButton()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            
            pesquisaProduto();
          }
        }
      );

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

    this.PSview.getSearchField()
      .addKeyListener(
        new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER) {
              System.out.println("Tecla pressionada");
              pesquisaProduto();
            } else{
              // Nada acontece se outra tecla for pressionada
            }
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

  public void pesquisaProduto() {
    limparTabela();
    String searchField = PSview.getSearchField().getText();
    List<ProdutoShow> produtos = ProdutoShow.PesquisaProduto(searchField);
    for (ProdutoShow produto : produtos) {
      adicionarProdutoTabela(produto);
    }
  }
}
