/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.controllers;

import com.mycompany.inventorycontrol.models.Login;
import com.mycompany.inventorycontrol.models.Login.ValidarLogin;
import com.mycompany.inventorycontrol.views.LoginView;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author yuri
 */
@SuppressWarnings("InstantiationOfUtilityClass")
public class LoginController implements ActionListener {

  private final LoginView view;
  private final ValidarLogin validaLogin;

  public LoginController(LoginView view) {
    this.view = view;
    this.validaLogin = new ValidarLogin();
    this.view.getCampoSenha()
      .addKeyListener(
        new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER) {
              System.out.println("Tecla pressionada");
              realizarLogin();
            } else {
              //Nada acontece se outra tecla for pressionada
            }
          }
        }
      );
    this.view.getBotaoEntrar().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    realizarLogin();
  }

  private void realizarLogin() {
    String usuario = view.getCampoUsuario().getText();
    String senha = view.getCampoSenha().getText();
    Login login = new Login(usuario, senha);

    if (validaLogin.validarLogin(login)) {
      // Login válido, fazer algo aqui, por exemplo, exibir uma mensagem de sucesso ou redirecionar para outra tela
      System.out.println("Login válido");
      ProdutoShowView PSview = new ProdutoShowView();
      PSview.setVisible(true);
      view.dispose();
    } else {
      // Login inválido, fazer algo aqui, por exemplo, exibir uma mensagem de erro
      System.out.println("Login inválido");
      view.exibirMensagemErro();
    }
  }
}
