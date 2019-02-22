package com.example.wdeson.androidexemploadapter.model;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DefaulAtctivity extends AppCompatActivity {
    public EditText edtNomeProduto;
    public EditText edtQuantidade;
    public EditText edtPreco;
    public List<Produto> lista = new ArrayList<>();
    public ListView minhaLista;
}
