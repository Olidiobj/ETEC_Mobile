package com.example.appniceface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClienteDAO extends SQLiteOpenHelper {
    private final String TABELA_LOGIN = "Tab_Login";
    private final String TABELA_CLIENTE = "Tab_Cliente";

    public ClienteDAO(@Nullable Context context) {
        super(context, "db_niceface", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da entidade tab_login
        String comando = "CREATE TABLE " + TABELA_LOGIN + " (" +
                "ID_LOGIN INTEGER PRIMARY KEY," +
                "ID_CLIENTE INTEGER," +
                "USUARIO VARCHAR(25)," +
                "SENHA VARCHAR(8))";
        db.execSQL(comando);
        // Criação da entidade tab_cliente
        String comandoCliente = "CREATE TABLE " + TABELA_CLIENTE + "(" +
                "ID_CLIENTE INTEGER PRIMARY KEY," +
                "CPF VARCHAR(14)," +
                "DATA_NASCIMENTO DATETIME NOT NULL," +
                "TELEFONE VARCHAR(15)," +
                "USUARIO VACHAR(60)," +
                "SENHA VARCHAR(30) NOT NULL," +
                "CONFIRME_SENHA VARCHAR(30) NOT NULL)";
        db.execSQL(comandoCliente);

    }
    public Long inserir(ClienteDTO clienteDTO){
        ContentValues values = new ContentValues();
        values.put("CPF",clienteDTO.getCpf());
        values.put("DATA_NASCIMENTO",clienteDTO.getNasc());
        values.put("TELEFONE",clienteDTO.getPhone());
        values.put("USUARIO",clienteDTO.getUsuarioCadastro());
        values.put("SENHA",clienteDTO.getSenhaCadastro());
        values.put("CONFIRME_SENHA",clienteDTO.getConfSenhaCadastro());


        long nLinhas = getWritableDatabase().insert(TABELA_CLIENTE, null, values);
        return nLinhas;
    }

    public ArrayList<ClienteDTO> meusDados(){
        String comando = "SELECT * FROM " + TABELA_CLIENTE;
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<ClienteDTO> listaCliente = new ArrayList<>();
        while (cursor.moveToNext()){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(cursor.getInt(0));
            clienteDTO.setCpf(cursor.getString(1));
            clienteDTO.setNasc(cursor.getString(2));
            clienteDTO.setPhone(cursor.getString(3));
            clienteDTO.setUsuarioCadastro(cursor.getString(4));
            listaCliente.add(clienteDTO);
        }
        return listaCliente;

    }
    public ClienteDTO dadosCliente(){
        String comando = "SELECT * FROM " + TABELA_CLIENTE + " WHERE ID_CLIENTE = 1 ";
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ClienteDTO Cliente = new ClienteDTO();
        while (cursor.moveToNext()){
            Cliente.setId(cursor.getInt(0));
            Cliente.setCpf(cursor.getString(1));
            Cliente.setNasc(cursor.getString(2));
            Cliente.setPhone(cursor.getString(3));
            Cliente.setUsuarioCadastro(cursor.getString(4));

        }
        return Cliente;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

//while (cursor.moveToNext()){
//        ClienteDTO clienteDTO = new ClienteDTO();
//        clienteDTO.setId(cursor.getInt(0));
//        clienteDTO.setUsuarioCadastro(cursor.getString(1));
//        clienteDTO.setCpf(cursor.getString(2));
//        clienteDTO.setNasc(cursor.getString(3));
//        clienteDTO.setPhone(cursor.getString(4));
//        listaCliente.add(clienteDTO);
//        }