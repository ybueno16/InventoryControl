/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.views;
import com.mycompany.inventorycontrol.models.Produto;
import com.mycompany.inventorycontrol.models.Produto.ProdutoDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yuri
 */
public class ProdutoView implements ActionListener{
    private JTextField textProduto;
    private JTextField textDescricao;
    private JTextField textPreco;

    public ProdutoView(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Adicionar Registro");
        textProduto = new JTextField(20);
        textDescricao = new JTextField(20);
        textPreco = new JTextField(20);
        JLabel produtoLabel = new JLabel("Produto:");
        JLabel descricaoLabel = new JLabel("Descrição:");
        JLabel precoLabel = new JLabel("Preço:");
        
        //Inicialização Interface Gráfica
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,2,5,5));
        panel.add(produtoLabel);
        panel.add(textProduto);
        panel.add(descricaoLabel);
        panel.add(textDescricao);
        panel.add(precoLabel);
        panel.add(textPreco);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(new JLabel());
        buttonPanel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Produto");
        frame.pack();
        frame.setVisible(true);
       
        //Fazer operação de adição de registro no BD
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Pegar os valores dos campos de texto
        String nome = textProduto.getText();
        String descricao = textDescricao.getText();
        double preco = Double.parseDouble(textPreco.getText());

        // Criar novo objeto Produto com os valores
        Produto novoProduto = new Produto(nome, descricao, preco);

        // Adicionar o novo produto no BD
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.adicionarProduto(novoProduto);
        produtoDAO.fecharConexao();
    }
}