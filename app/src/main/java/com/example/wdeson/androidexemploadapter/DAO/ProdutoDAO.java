package com.example.wdeson.androidexemploadapter.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.wdeson.androidexemploadapter.dbHelper.ConexaoSQLite;
import com.example.wdeson.androidexemploadapter.model.Produto;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;


    public ProdutoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarProdutoDAO(Produto pProduto) {

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("id", pProduto.getId());
            values.put("nome", pProduto.getNome());
            values.put("quantidade", pProduto.getQuantidade());
            values.put("preco",pProduto.getPreco());

            long idProdutoInserido = db.insert("produto", null, values);
            return idProdutoInserido;

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (db != null){
                db.close();
            }
        }
        return 0;
    }
    public List<Produto> getProdutoList(){

        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produtos;";

        try {

            db = this.conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){
                Produto produtoTemporario = null;
                do {

                    produtoTemporario = new Produto();
                    produtoTemporario.setId(cursor.getLong(0));
                    produtoTemporario.setNome(cursor.getString(1));
                    produtoTemporario.setQuantidade(cursor.getInt(2));
                    produtoTemporario.setPreco(cursor.getDouble(3));

                    listaProdutos.add(produtoTemporario);

                }while (cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRo LISTA PRODUTOS!!!", "ERRO!!! ao retorna os produtos!!!");
            return null;
        }finally {
            if(db != null){
                db.close();
            }
        }
        return listaProdutos;
    }
}
