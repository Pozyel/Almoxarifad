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

                int idFer = 0;
                int qtd = 0;
                int cont = 0;

                String nomeFerramenta = null;

                ArrayList<Ferramenta> ferramenta = null;  //Pegar Array do BD
                for (Ferramenta us : ferramenta) {
                    if (serie.equals(us.getNumero_serie())) {
                        cont++;
                        idFer = us.getIdFerramenta();
                        qtd = us.getQuantidade();
                        nomeFerramenta = us.getNome();
                    }
                }
                ArrayList<Funcionario> funcionario = null;  //Pegar Array do BD
                for (Funcionario user : funcionario) {

                    if ((nome).equals(user.getNome())) {
                        cont++;
                    }

                }

                if (cont == 2) {

                    if (qtd > 0) {
                        qtd = qtd - 1;
                        fer2.setIdFerramenta(idFer);
                        fer2.setQuantidade(qtd);
                        // Ferramenta
                        fer2.setNome(nomeFerramenta); // Nome ferramenta
                        fer2.setNomefuncionario(nome);
                        fer2.setData_retirado(data);
                        fer2.setNumero_serie(serie);
                        // Funcionario
                        fun2.setNome(nome);
                        fun2.setNomeferramenta(nomeFerramenta); // Nome ferramenta
                        fun2.setData_retirado(data);
                        // ->FALTA Adicionar a informação no BD

                    }

                }
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
        botaoEntrar = findViewById(R.id.bottom);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

}