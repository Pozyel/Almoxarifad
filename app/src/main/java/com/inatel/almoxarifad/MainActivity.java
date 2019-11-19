package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private EditText entradaNome, entradaSenha;
    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializarComponentes();

        //Ações do Botao
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = entradaNome.getText().toString();
                String senha = entradaSenha.getText().toString();

                if (nome.equals("User")&& senha.equals("123")){
                    alerta("login Realizado com Sucesso");
                    Intent intent1 = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent1);
                }
                else {
                    alerta("Usuário ou Senha Incorretos");
                }

            }
        });
    }

    private void inicializarComponentes() {
        entradaNome = findViewById(R.id.edtUsuarioID);
        entradaSenha = findViewById(R.id.edtSenhaID);
        botaoEntrar = findViewById(R.id.btEntrarID);
    }
    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }
}
