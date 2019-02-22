package com.example.wdeson.androidexemploadapter.actvities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wdeson.androidexemploadapter.R;
import com.example.wdeson.androidexemploadapter.controller.ProdutoController;
import com.example.wdeson.androidexemploadapter.dbHelper.ConexaoSQLite;
import com.example.wdeson.androidexemploadapter.model.Produto;


public class ActivityProduto extends AppCompatActivity {

    private EditText edt_idProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidade;
    private EditText edtPreco;

    private Button btnSalvar;

    private Produto produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edt_idProduto = (EditText) findViewById(R.id.edt_idProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtPreco = (EditText) findViewById(R.id.edtPreco);
        edtQuantidade = (EditText) findViewById(R.id.edtQuantidade);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        this.clickNoBotaoListener();
    }

    private void clickNoBotaoListener(){

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Produto produtoACadastrar = getDadosProdutos();

                if (produtoACadastrar != null){

                    ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityProduto.this));
                    long idProduto = produtoController.salvarProdutoController(produtoACadastrar);

                    if (idProduto > 0) {
                        Toast.makeText(ActivityProduto.this, "Produto Salvo Com Sucesso!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(ActivityProduto.this,"Todos do campos são obrigatorios", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private Produto getDadosProdutos(){
        this.produtos = new Produto();
        if(this.edt_idProduto.getText().toString().isEmpty() == false){
            this.produtos.setId(Long.parseLong(this.edt_idProduto.getText().toString()));
        }else{
            return null;
        }
        if(this.edtNomeProduto.getText().toString().isEmpty() == false) {
            this.produtos.setNome(this.edtNomeProduto.getText().toString());
        }else {
            return null;
        }
        if (edtQuantidade.getText().toString().isEmpty() == false){
            int quantidadeDoProduto = Integer.parseInt(this.edtQuantidade.getText().toString());
            this.produtos.setQuantidade(quantidadeDoProduto);
        }else {
            return null;
        }
        if (edtPreco.getText().toString().isEmpty() == false){
            double precoProduto = Double.parseDouble(this.edtPreco.getText().toString());
            this.produtos.setPreco(precoProduto);
        }else {
            return null;
        }
        return produtos;
    }

}
