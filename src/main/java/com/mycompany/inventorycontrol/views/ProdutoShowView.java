package com.mycompany.inventorycontrol.views;

import com.mycompany.inventorycontrol.controllers.ProdutoShowController;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.MediaTracker;

public class ProdutoShowView extends JFrame {

  private JTable table;
  private DefaultTableModel tableModel;
  private JTextField searchField;
  private ProdutoShowController ProdutoShowController;
  private JButton addProdutoButton;
  private JButton searchFieldButton;
  private JMenu configMenu;
  private JMenuItem userConfig;

  public ProdutoShowView() {
    initComponents();
    ProdutoShowController = new ProdutoShowController(this);
    ProdutoShowController.carregarProdutos();
  }

  private void initComponents() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Lista de Produtos");
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    tableModel = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tableModel.addColumn("ID");
    tableModel.addColumn("Nome");
    tableModel.addColumn("Descrição");
    tableModel.addColumn("Preço");
    tableModel.addColumn("Quantidade em Estoque");

    table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    JPanel topPanel = new JPanel();
    getContentPane().add(topPanel, BorderLayout.NORTH);

    searchField = new JTextField(20);
    topPanel.add(new JLabel("Pesquisar:"));
    topPanel.add(searchField);

    searchFieldButton = new JButton("Pesquisar");
    topPanel.add(searchFieldButton);

    addProdutoButton = new JButton("Adicionar Produto");

    topPanel.add(addProdutoButton);
    setLocationRelativeTo(null);

    JMenuBar menuBar = new JMenuBar();
    configMenu = new JMenu("Configurações");
    userConfig = new JMenuItem("Criar/Alterar Usuário");
    configMenu.add(userConfig);
    menuBar.add(configMenu);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }

  public JTable getTable() {
    return table;
  }

  public DefaultTableModel getTableModel() {
    return tableModel;
  }

  public JButton getSearchFieldButton() {
    return searchFieldButton;
  }

  public JTextField getSearchField() {
    return searchField;
  }

  public JButton getAddProdutoButton() {
    return addProdutoButton;
  }

  public JMenu getConfigMenu() {
    return configMenu;
  }

  public JMenuItem getUserConfig() {
    return userConfig;
  }
}
