package com.mycompany.inventorycontrol.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDelete {
    public void excluirProduto(int id) throws SQLException {
        try (Connection conexao = ProdutoAdd.conexaoDAO.getInstancia().getConexao()) {
            String delete = "DELETE FROM produto where id = ?";
            PreparedStatement statement = conexao.prepareStatement(delete);
            statement.setInt(1, id); // Set the id parameter
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registro foi deletado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}