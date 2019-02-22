package com.example.wdeson.androidexemploadapter.model;

import java.util.List;

public class Pedido {

    private long id;
    private String nome;
    private List<Produto> produtos;
    private String date;

    public Pedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", produtos=" + produtos.toString() +
                ", date='" + date + '\'' +
                '}';
    }
}
