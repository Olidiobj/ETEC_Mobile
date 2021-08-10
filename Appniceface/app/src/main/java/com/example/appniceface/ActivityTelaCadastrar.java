package com.example.appniceface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTelaCadastrar extends AppCompatActivity {
    EditText editTextNumberCPF;
    EditText editTextDateNasc;
    EditText editTextPhone;
    EditText editTextUsuarioCadastro;
    EditText editTextSenhaCadastro;
    EditText editTextConfSenhaCadastro;
    Button buttonCadastrar;
    Button buttonVoltarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        editTextNumberCPF = findViewById(R.id.editTextNumberCPF);
        editTextDateNasc = findViewById(R.id.editTextDateNasc);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextUsuarioCadastro = findViewById(R.id.editTextUsuarioCadastro);
        editTextSenhaCadastro = findViewById(R.id.editTextSenhaCadastro);
        editTextConfSenhaCadastro = findViewById(R.id.editTextConfSenhaCadastro);
        buttonCadastrar = findViewById(R.id.buttonCadastar);
        buttonVoltarCadastro = findViewById(R.id.buttonVoltarCadastro);

        //Evento botão Voltar
        buttonVoltarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityTelaLogin.class);
                startActivity(intent);
            }
        });

        //Evento botão Cadastrar
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClienteDTO clienteDTO = new ClienteDTO(
                        editTextNumberCPF.getText().toString(),
                        editTextDateNasc.getText().toString(),
                        editTextPhone.getText().toString(),
                        editTextUsuarioCadastro.getText().toString(),
                        editTextSenhaCadastro.getText().toString(),
                        editTextConfSenhaCadastro.getText().toString());
                ClienteDAO clienteDAO = new ClienteDAO(ActivityTelaCadastrar.this);
                try {
                    if (clienteDAO.inserir(clienteDTO) > 0) {
                        Toast.makeText(ActivityTelaCadastrar.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(ActivityTelaCadastrar.this, "Erro ao Inserir: ", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

}

