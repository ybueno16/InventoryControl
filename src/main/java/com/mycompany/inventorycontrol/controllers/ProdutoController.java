/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.Produto;
import com.mycompany.inventorycontrol.models.Produto.ProdutoDAO;
import com.mycompany.inventorycontrol.views.ProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yuri
 */


public class ProdutoController implements ActionListener {


    private ProdutoView view;
    private ProdutoDAO dao;

    public ProdutoController(){
        this.view = view;
        this.dao = new ProdutoDAO();
        this.view.getButtonAdd().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
