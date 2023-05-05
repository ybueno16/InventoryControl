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
  private String desc;
  private double preco;
  private int qntEstoque;


  //Constructor
  public Produto(int id, String nome, String desc, double preco, int qntEstoque) {
    this.id = id;
    this.nome = nome;
    this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
