package com.example.wdeson.androidexemploadapter.controller;

import android.content.ContentValues;

import com.example.wdeson.androidexemploadapter.DAO.ProdutoDAO;
import com.example.wdeson.androidexemploadapter.dbHelper.ConexaoSQLite;
import com.example.wdeson.androidexemploadapter.model.Produto;

import java.util.List;


public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    public ProdutoController(ConexaoSQLite pConexaoSQLite) {

        produtoDAO = new ProdutoDAO(pConexaoSQLite);
    }

    public long salvarProdutoController(Produto pproduto){
        return this.produtoDAO.salvarProdutoDAO(pproduto);
    }

    public List<Produto> getListaProdutoControle(){
        return this.produtoDAO.getProdutoList();
    }
}
