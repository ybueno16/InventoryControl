
  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inventorycontrol;

import com.mycompany.inventorycontrol.controllers.ProdutoController;
import com.mycompany.inventorycontrol.views.ProdutoView;

/**
 *
 * @author yuri
 */
public class InventoryControl {

    public static void main(String[] args) {
        ProdutoView view = new ProdutoView();
        ProdutoController controller = new ProdutoController(view);
        view.setVisible(true);



    }
}

