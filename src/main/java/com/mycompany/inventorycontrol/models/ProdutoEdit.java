package com.mycompany.inventorycontrol.models;

import com.mycompany.inventorycontrol.models.ProdutoAdd.conexaoDAO;

public class ProdutoEdit {
  private int id;
  private final String nome;
  private final String descricao;
  private final double preco;
  private final int qntEstoque;
  private static conexaoDAO instancia;

  //Constructor
  public ProdutoEdit(String nome, String descricao, double preco, int qntEstoque) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.qntEstoque = qntEstoque;
  }
}
