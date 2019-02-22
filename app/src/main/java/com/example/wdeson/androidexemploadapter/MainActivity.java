package com.example.wdeson.androidexemploadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wdeson.androidexemploadapter.R;
import com.example.wdeson.androidexemploadapter.actvities.ActivityListarProdutos;
import com.example.wdeson.androidexemploadapter.actvities.ActivityProduto;
import com.example.wdeson.androidexemploadapter.controller.ProdutoController;
import com.example.wdeson.androidexemploadapter.dbHelper.ConexaoSQLite;
import com.example.wdeson.androidexemploadapter.model.Produto;

import static com.example.wdeson.androidexemploadapter.R.id.btnCadastroProduto;
import static com.example.wdeson.androidexemploadapter.R.id.info;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;
    private Button btnListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conexão com baco de dados
        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(this);

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProduto);

        this.btnListarProdutos = (Button) findViewById(R.id.btnListarProdutos);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });
        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityListarProdutos.class);
                startActivity(intent);
            }
        });

    }
}
