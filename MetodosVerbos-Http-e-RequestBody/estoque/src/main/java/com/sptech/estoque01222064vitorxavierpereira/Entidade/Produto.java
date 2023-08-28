package com.sptech.estoque01222064vitorxavierpereira.Entidade;

public class Produto {

    // Atributos
    private String nome;
    private Double preco;
    private Integer qtdEstoque;

    // Construtor
    public Produto(String nome, Double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    // Sobrecarga
    public Produto() {
    }

    // Get e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    //Método
    public Double getEstoque(){
        return preco * qtdEstoque;
    }

}
