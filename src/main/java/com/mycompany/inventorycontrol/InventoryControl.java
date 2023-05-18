
  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inventorycontrol;

import com.mycompany.inventorycontrol.controllers.LoginController;
import com.mycompany.inventorycontrol.views.ProdutoShowView;
import com.mycompany.inventorycontrol.views.LoginView;

/**
 *
 * @author yuri
 */
public class InventoryControl {

    public static void main(String[] args) {
        /*ProdutoShowView PSview = new ProdutoShowView();
        PSview.setVisible(true); <- Remover Comentário para testar listagem de produto*/
        LoginView Lview = new LoginView();
        LoginController Lcontroller = new LoginController(Lview);

    }
}

