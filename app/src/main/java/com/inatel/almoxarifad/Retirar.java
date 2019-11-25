package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Retirar extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private EditText entradaNome;
    private EditText entradaSerie;
    private  EditText entradaData;
    private Button botaoEntrar;

    Ferramenta fer2 = new Ferramenta();
    Funcionario fun2 = new Funcionario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirar);
        inicializarFirebase();

        inicializarComponentes();


        //Ações do Botao
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = entradaNome.getText().toString();
                String serie = entradaSerie.getText().toString();
                String data = entradaData.getText().toString();
                Ferramenta fu = new Ferramenta();
                fu.setIdFerramenta(UUID.randomUUID().toString());
                fu.setNome(serie);
                fu.setNomefuncionario(nome);
                fu.setData_retirado(data);
                fu.setData_enviado("pendente");
                databaseReference.child("Historico_Ferramenta").child(fu.getIdFerramenta()).setValue(fu);
                Funcionario fun = new Funcionario();
                fun.setIdFuncionario(UUID.randomUUID().toString());
                fun.setNome(serie);
                fun.setNomeferramenta(nome);
                fu.setData_retirado(data);
                fu.setData_enviado("pendente");
                databaseReference.child("Historico_Funcionario").child(fu.getIdFerramenta()).setValue(fu);
                limparCampos();

            }

            private void limparCampos() {
                entradaNome.setText("");
                entradaData.setText("");
                entradaSerie.setText("");
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Retirar.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void inicializarComponentes() {
        entradaNome = findViewById(R.id.edtRegistro);
        entradaSerie = findViewById(R.id.edtNumero);
        entradaData = findViewById(R.id.edtDataRetirado);
        botaoEntrar = findViewById(R.id.button);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

}

// Vai dar tudo certo, acredite