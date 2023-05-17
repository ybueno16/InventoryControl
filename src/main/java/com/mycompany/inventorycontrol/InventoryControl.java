
  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inventorycontrol;

import com.mycompany.inventorycontrol.controllers.LoginController;
import com.mycompany.inventorycontrol.controllers.ProdutoController;
import com.mycompany.inventorycontrol.models.Login;
import com.mycompany.inventorycontrol.views.ProdutoView;
import com.mycompany.inventorycontrol.views.LoginView;

/**
 *
 * @author yuri
 */
public class InventoryControl {

    public static void main(String[] args) {
        //ProdutoView Pview = new ProdutoView();
        //ProdutoController controller = new ProdutoController(Pview);
        LoginView Lview = new LoginView();
        LoginController Lcontroller = new LoginController(Lview);
    }
}

