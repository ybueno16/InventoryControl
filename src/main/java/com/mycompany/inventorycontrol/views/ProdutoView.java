/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.views;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yuri
 */
public class ProdutoView {
    private JTextField textProduto;
    private JTextField textDescricao;
    private JTextField textPreco;
    private JButton buttonAdd;

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

    public ProdutoView(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Adicionar Registro");
        JTextField produto = new JTextField(20);
        JTextField descricao = new JTextField(20);
        JTextField preco = new JTextField(20);
        JLabel produtoLabel = new JLabel("Produto:");
        JLabel descricaoLabel = new JLabel("Descrição:");
        JLabel precoLabel = new JLabel("Preço:");
        
        //Inicialização Interface Gráfica
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,2,5,5));
        panel.add(produtoLabel);
        panel.add(produto);
        panel.add(descricaoLabel);
        panel.add(descricao);
        panel.add(precoLabel);
        panel.add(preco);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(new JLabel());
        buttonPanel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Produto");
        frame.pack();
        frame.setVisible(true);
     
        
    }


  /*  public void clique() {

        String nome = view.getTextProduto().getText();
        String descricao = view.getTextDescricao().getText();
        double preco = Double.parseDouble(view.getTextPreco().getText());

        Produto produto = new Produto(ProdutoView.produto, descricao, preco)
    }*/
}

