/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorycontrol.models;

/**
 *
 * @author yuri
 */
public class Produto {
  private int id;
  private String nome;
  private String descricao;
  private double preco;
  private int qntEstoque;


  //Constructor
  public Produto(int id, String nome, String descricao, double preco, int qntEstoque) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.qntEstoque = qntEstoque;
  }

  //Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.desc = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
  

  
}
