/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.inventorycontrol.views.LoginView;
import com.mycompany.inventorycontrol.models.Login;
import com.mycompany.inventorycontrol.models.Login.ValidarLogin;
import com.mycompany.inventorycontrol.views.ProdutoView;


/**
 *
 * @author yuri
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class LoginController implements ActionListener {
    private final LoginView view;
    private final ValidarLogin vLogin;

    public LoginController(LoginView view) {
        this.view = view;
        this.vLogin = new ValidarLogin();
        this.view.getBotaoEntrar().addActionListener(this);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        Login login = new Login(usuario, senha);

        if (vLogin.validarLogin(login)) {
            // Login válido, fazer algo aqui, por exemplo, exibir uma mensagem de sucesso ou redirecionar para outra tela
            System.out.println("Login válido");
            ProdutoView Pview = new ProdutoView();
            ProdutoController controller = new ProdutoController(Pview);
            view.dispose();
        } else {
            // Login inválido, fazer algo aqui, por exemplo, exibir uma mensagem de erro
            System.out.println("Login inválido");
            view.exibirMensagemErro();
        }
    }
}

