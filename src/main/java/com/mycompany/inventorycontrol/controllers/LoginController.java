/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.inventorycontrol.views.LoginView;
import com.mycompany.inventorycontrol.models.Login;


/**
 *
 * @author yuri
 */
public class LoginController implements ActionListener {
    private final LoginView view;
    private Login.ValidarLogin vLogin;

    public LoginController(LoginView view) {
        this.view = view;
        this.vLogin = vLogin;
        this.view.getBotaoEntrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        Login login = new Login(usuario,senha);
        vLogin.validarLogin(login);
    }
}

