package com.example.wdeson.androidexemploadapter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wdeson.androidexemploadapter.R;
import com.example.wdeson.androidexemploadapter.model.Produto;

import java.util.List;

public class AdapterListaProdutos extends BaseAdapter {

    private Context context;
    private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return this.produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void removerProduto(int position){
        this.produtoList.remove(position);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(this.context, R.layout.layout_produto, null);

        TextView txtNomeProduto = (TextView) view.findViewById(R.id.txtNomeProduto);
        TextView txtPrecoProduto = (TextView) view.findViewById(R.id.txtPrecoProduto);
        TextView txtQuantidade = (TextView) view.findViewById(R.id.txtQuantidade);

        txtNomeProduto.setText(this.produtoList.get(position).getNome());
        txtPrecoProduto.setText(String.valueOf(this.produtoList.get(position).getPreco()));
        txtQuantidade.setText(String.valueOf(this.produtoList.get(position).getQuantidade()));

        return null;
    }
}
