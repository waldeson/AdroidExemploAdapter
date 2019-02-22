package com.example.wdeson.androidexemploadapter.actvities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.wdeson.androidexemploadapter.R;
import com.example.wdeson.androidexemploadapter.adapters.AdapterListaProdutos;
import com.example.wdeson.androidexemploadapter.controller.ProdutoController;
import com.example.wdeson.androidexemploadapter.dbHelper.ConexaoSQLite;
import com.example.wdeson.androidexemploadapter.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ActivityListarProdutos extends AppCompatActivity {

    private ListView listarProdutos;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        //TODO buscar os produtos do banco

        ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityListarProdutos.this));
        produtoList = produtoController.getListaProdutoControle();


        this.produtoList = new ArrayList<>();

        this.listarProdutos = (ListView) findViewById(R.id.lsvProdutos);

        this.adapterListaProdutos = new AdapterListaProdutos(ActivityListarProdutos.this, this.produtoList);

        this.listarProdutos.setAdapter(this.adapterListaProdutos);


    }
}
