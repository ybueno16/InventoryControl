package com.mycompany.inventorycontrol.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProdutoAddView extends JFrame {

  private final JTextField textProduto;
  private final JTextField textDescricao;
  private final JTextField textPreco;
  private final JTextField textQntEstoque;
  private final JButton buttonAdd;

  public ProdutoAddView() {
    setTitle("Cadastro de Produtos");
    setSize(800, 600);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.WEST;
    constraints.insets = new Insets(20, 10, 10, 20);

    JLabel labelProduto = new JLabel("Nome do Produto:");
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.EAST;
    panel.add(labelProduto, constraints);

    textProduto = new JTextField(20);
    constraints.gridx = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    panel.add(textProduto, constraints);

    JLabel labelDescricao = new JLabel("Descrição:");
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.anchor = GridBagConstraints.EAST;
    panel.add(labelDescricao, constraints);

    textDescricao = new JTextField(20);
    constraints.gridx = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    panel.add(textDescricao, constraints);

    JLabel labelPreco = new JLabel("Preço:");
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.anchor = GridBagConstraints.EAST;
    panel.add(labelPreco, constraints);

    textPreco = new JTextField(20);
    constraints.gridx = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    panel.add(textPreco, constraints);

    JLabel labelQntEstoque = new JLabel("Quantidade em Estoque:");
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.anchor = GridBagConstraints.EAST;
    panel.add(labelQntEstoque, constraints);

    textQntEstoque = new JTextField(20);
    constraints.gridx = 1;
    constraints.anchor = GridBagConstraints.CENTER;
    panel.add(textQntEstoque, constraints);

    buttonAdd = new JButton("Adicionar");
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.gridwidth = 2;
    constraints.anchor = GridBagConstraints.CENTER;
    panel.add(buttonAdd, constraints);

    add(panel);
    setVisible(true);
  }

  public JTextField getTextProduto() {
    return textProduto;
  }

  public JTextField getTextDescricao() {
    return textDescricao;
  }

  public JTextField getTextPreco() {
    return textPreco;
  }

  public JButton getButtonAdd() {
    return buttonAdd;
  }

  public JTextField getTextQntEstoque() {
    return textQntEstoque;
  }

  public void limparCampos() {
    getTextProduto().setText("");
    getTextDescricao().setText("");
    getTextPreco().setText("");
    getTextQntEstoque().setText("");
  }
}
