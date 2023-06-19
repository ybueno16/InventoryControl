package com.mycompany.inventorycontrol.views;

import com.mycompany.inventorycontrol.controllers.ProdutoController;
import com.mycompany.inventorycontrol.controllers.ProdutoShowController;


import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;

public class ProdutoShowView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private ProdutoShowController PScontroller;
    private JButton addProdutoButton;
    private JButton searchFieldButton;

    public ProdutoShowView() {

        initComponents();
        PScontroller = new ProdutoShowController(this);
        PScontroller.carregarProdutos();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Produtos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Criar o modelo de tabela com as colunas desejadas
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade em Estoque");

        // Criar a tabela com o modelo definido
        table = new JTable(tableModel);

        // Adicionar a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Painel superior para pesquisa e filtro
        JPanel topPanel = new JPanel();
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Campo de pesquisa
        searchField = new JTextField(20);
        topPanel.add(new JLabel("Pesquisar:"));
        topPanel.add(searchField);

        // Filtro
        searchFieldButton = new JButton("Pesquisar");
        topPanel.add(searchFieldButton);

        // Botão para realizar adição de produto
        addProdutoButton = new JButton("Adicionar Produto");
        topPanel.add(addProdutoButton);

        pack();
        setLocationRelativeTo(null);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getAddProdutoButton(){
        return addProdutoButton;
    }
}
