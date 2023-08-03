package com.mycompany.inventorycontrol.controllers;

import static com.mycompany.inventorycontrol.models.ProdutoShow.getProdutos;

import com.mycompany.inventorycontrol.models.ProdutoShow;
import com.mycompany.inventorycontrol.views.ProdutoAddView;
import com.mycompany.inventorycontrol.views.ProdutoEditView;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import com.mycompany.inventorycontrol.views.UserShowView;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProdutoShowController {

  private ProdutoShowView ProdutoShowView;
  private ProdutoEditView editView;
  private ProdutoEditController editController;

  public ProdutoShowController(ProdutoShowView produtoShowView) {
    this.ProdutoShowView = produtoShowView;

    produtoShowView
      .getAddProdutoButton()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            exibirTelaAdicionarProduto();
          }
        }
      );

    produtoShowView
      .getSearchFieldButton()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            pesquisaProduto();
          }
        }
      );

    produtoShowView
      .getUserConfig()
      .addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event) {
            UserShowView userShowView = new UserShowView();
            
          }
        }
      );

    this.ProdutoShowView.getSearchField()
      .addKeyListener(
        new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER) {
              System.out.println("Tecla pressionada");
              pesquisaProduto();
            }
          }
        }
      );

    this.ProdutoShowView.getTable()
      .addMouseListener(
        new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
              Point pnt = e.getPoint();
              int row = produtoShowView.getTable().rowAtPoint(pnt);
              if (row != -1) {
                int id = getIdFromTable();
                String nome = getNomeFromTable();
                String descricao = getDescricaoFromTable();
                Double preco = getPrecoFromTable();
                int qntEstoque = getQntEstoqueFromTable();

                System.out.println(id);
                System.out.println(nome);
                System.out.println(descricao);
                System.out.println(preco);
                System.out.println(qntEstoque);

                editarProduto();
                editView.setIdProduto(id);
                editView.setNomeProduto(nome);
                editView.setDescricaoProduto(descricao);
                editView.setPrecoProduto(preco);
                editView.setQntEstoque(qntEstoque);

                editView.setVisible(true);
                System.out.println(id);
                editarProduto();
                editView.setIdProduto(id);
                editView.setVisible(true);
                if (!editView.isVisible()) {
                  editView.setVisible(true);
                }
              }
            }
          }
        }
      );
  }

  public void carregarProdutos() {
    ProdutoShowView.getTableModel().setRowCount(0);
    List<ProdutoShow> produtos = getProdutos();
    for (ProdutoShow produto : produtos) {
      adicionarProdutoTabela(produto);
    }
  }

  public void limparTabela() {
    ProdutoShowView.getTableModel().setRowCount(0);
  }

  public void adicionarProdutoTabela(ProdutoShow produto) {
    Object[] row = new Object[] {
      produto.getId(),
      produto.getNome(),
      produto.getDescricao(),
      produto.getPreco(),
      produto.getqntEstoque(),
    };
    ProdutoShowView.getTableModel().addRow(row);
  }

  public void exibirTelaAdicionarProduto() {
    ProdutoAddView Pview = new ProdutoAddView();
    ProdutoAddController Pcontroller = new ProdutoAddController(Pview, this);
    Pview.setVisible(true);
  }

  public void pesquisaProduto() {
    limparTabela();
    String searchField = ProdutoShowView.getSearchField().getText();
    List<ProdutoShow> produtos = ProdutoShow.PesquisaProduto(searchField);
    for (ProdutoShow produto : produtos) {
      adicionarProdutoTabela(produto);
    }
  }

  public void editarProduto() {
    if (editView == null) {
      editView = new ProdutoEditView();
      ProdutoDeleteController delete = new ProdutoDeleteController(editView, this);
      ProdutoEditController editController = new ProdutoEditController(
        editView,
        this
      );
    }
  }

  public int getIdFromTable() {
    int selectedRow = ProdutoShowView.getTable().getSelectedRow();
    int selectedRowInModel = ProdutoShowView
      .getTable()
      .convertRowIndexToModel(selectedRow);
    int idColumnIndex = ProdutoShowView
      .getTable()
      .getColumnModel()
      .getColumnIndex("ID");
    return (int) ProdutoShowView
      .getTable()
      .getModel()
      .getValueAt(selectedRowInModel, idColumnIndex);
  }

  public String getNomeFromTable() {
    int selectedRow = ProdutoShowView.getTable().getSelectedRow();
    int selectedRowInModel = ProdutoShowView
      .getTable()
      .convertRowIndexToModel(selectedRow);
    int nomeColumnIndex = ProdutoShowView
      .getTable()
      .getColumnModel()
      .getColumnIndex("Nome");
    return (String) ProdutoShowView
      .getTable()
      .getModel()
      .getValueAt(selectedRowInModel, nomeColumnIndex);
  }

  public String getDescricaoFromTable() {
    int selectedRow = ProdutoShowView.getTable().getSelectedRow();
    int selectedRowInModel = ProdutoShowView
      .getTable()
      .convertRowIndexToModel(selectedRow);
    int descricaoColumnIndex = ProdutoShowView
      .getTable()
      .getColumnModel()
      .getColumnIndex("Descrição");
    return (String) ProdutoShowView
      .getTable()
      .getModel()
      .getValueAt(selectedRowInModel, descricaoColumnIndex);
  }

  public Double getPrecoFromTable() {
    int selectedRow = ProdutoShowView.getTable().getSelectedRow();
    int selectedRowInModel = ProdutoShowView
      .getTable()
      .convertRowIndexToModel(selectedRow);
    int precoColumnIndex = ProdutoShowView
      .getTable()
      .getColumnModel()
      .getColumnIndex("Preço");
    return (Double) ProdutoShowView
      .getTable()
      .getModel()
      .getValueAt(selectedRowInModel, precoColumnIndex);
  }

  public int getQntEstoqueFromTable() {
    int selectedRow = ProdutoShowView.getTable().getSelectedRow();
    int selectedRowInModel = ProdutoShowView
      .getTable()
      .convertRowIndexToModel(selectedRow);
    int qntEstoqueColumnIndex = ProdutoShowView
      .getTable()
      .getColumnModel()
      .getColumnIndex("Quantidade em Estoque");
    return (int) ProdutoShowView
      .getTable()
      .getModel()
      .getValueAt(selectedRowInModel, qntEstoqueColumnIndex);
  }
}
