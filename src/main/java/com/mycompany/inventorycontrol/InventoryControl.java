/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inventorycontrol;

import com.mycompany.inventorycontrol.controllers.LoginController;
import com.mycompany.inventorycontrol.views.LoginView;
import com.mycompany.inventorycontrol.views.ProdutoEditView;

/**
 *
 * @author yuri
 */
public class InventoryControl {

  public static void main(String[] args) {
    LoginView LoginView = new LoginView();
    LoginController LoginController = new LoginController(LoginView);
  }
}
