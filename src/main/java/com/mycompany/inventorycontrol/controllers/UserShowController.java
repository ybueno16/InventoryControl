package com.mycompany.inventorycontrol.controllers;

import static com.mycompany.inventorycontrol.models.UserShow.getUsuario;

import com.mycompany.inventorycontrol.models.UserShow;
import com.mycompany.inventorycontrol.views.UserShowView;
import java.util.List;

public class UserShowController {

  private UserShowView UserShowView;

  public UserShowController(UserShowView userShowView) {
    this.UserShowView = userShowView;
  }

  public void carregarUsuarios() {
    UserShowView.getTableModel().setRowCount(0);
    List<UserShow> usuarios = getUsuario();
    for (UserShow usuario : usuarios) {
      adicionarUsuarioTabela(usuario);
    }
  }

  public void adicionarUsuarioTabela(UserShow usuario) {
    Object[] row = new Object[] {
      usuario.getId(),
      usuario.getNome(),
      usuario.getSenha(),
      usuario.getNivel_Permissao(),
    };
    UserShowView.getTableModel().addRow(row);
  }

  public void limparTabela() {
    UserShowView.getTableModel().setRowCount(0);
  }
}
