package com.example.appniceface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityTelaLogin extends AppCompatActivity {

    Button buttonEntrar;//Declaração do objeto botão
    Button buttonCadastrarLogin;
    TextView textEsqueciMinhaSenha;
    EditText editTextUsuario;
    EditText editTextSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEntrar = findViewById(R.id.buttonEntrar);//Atribuição do Objeto botão da activity
       //abrirTelaMenu();                                //Classe java.
        buttonCadastrarLogin = findViewById(R.id.buttonCadastrarLogin);
        abrirTelaCadastrar();
        textEsqueciMinhaSenha = findViewById(R.id.textEsqueciMinhaSenha);
        abrirTelaEsqueciMinhaSenha();
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenha = findViewById(R.id.editTextSenha);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUsuario.getText().toString().equals("olidio") && editTextSenha.getText().toString().equals("1234567")){
                    Intent intent = new Intent(ActivityTelaLogin.this, ActivityTelaMenu.class);
                    startActivity(intent);
                }
                else {
                    alert("Login ou senha incorretos");
                }
            }
        });
    }

    private void alert(String s){
        Toast.makeText(ActivityTelaLogin.this,s,Toast.LENGTH_SHORT).show();
    }


//    public  void abrirTelaMenu(){
//        buttonEntrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent telaMenu = new Intent(getApplicationContext(),ActivityTelaMenu.class);
//                startActivity(telaMenu);
//            }
//        });
//
//    }
    public void abrirTelaCadastrar(){
        buttonCadastrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaCadastrar = new Intent(getApplicationContext(),ActivityTelaCadastrar.class);
                startActivity(telaCadastrar);
            }
        });
    }

    public void abrirTelaEsqueciMinhaSenha(){
        textEsqueciMinhaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaEsqueciMinhaSenha = new Intent(getApplicationContext(),ActivityTelaEsqueciMinhaSenha.class);
                startActivity(telaEsqueciMinhaSenha);
            }
        });
    }



}