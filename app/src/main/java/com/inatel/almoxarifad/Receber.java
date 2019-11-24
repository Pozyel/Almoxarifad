package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Receber extends AppCompatActivity {
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
        setContentView(R.layout.activity_receber);
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
                int idFer2 = 0;
                int idFun = 0;
                int qtd = 0;
                int cont = 0;

                ArrayList<Ferramenta> ferramenta = null;  //Pegar Array do BD
                // Percorrendo o Array de Objetos Ferramenta
                for (Ferramenta us : ferramenta) {
                    // Se o numero de serie for igual ao id da ferramenta
                    if (serie.equals(us.getNumero_serie())) {
                        // Se o funcionario esta com a ferramenta
                        if(nome.equals(us.getNomefuncionario())){
                            if(us.getData_enviado()==null){
                                idFer = us.getIdFerramenta();
                                alerta("Recebimento Concluido");
                                Intent intent1 = new Intent(Receber.this,MenuActivity.class);
                                startActivity(intent1);
                                break;
                            }
                        }

                    }

                }

                ArrayList<Ferramenta> ferramenta2 = null;  //Pegar Array do BD
                for (Ferramenta us : ferramenta2) {
                    if (serie.equals(us.getNumero_serie())) {
                        qtd = us.getQuantidade();
                        idFer2 = us.getIdFerramenta();

                    }
                }

                ArrayList<Funcionario> funcionario = null;  //Pegar Array do BD

                for (Funcionario user : funcionario) {

                    if (nome.equals(user.getNome())) {
                        if (nome.equals(user.getNomeferramenta())) {
                            if (user.getData_enviado() == null) {
                                cont++;
                                idFun = user.getIdFuncionario();
                                break;
                            }

                        }

                    }

                }
                System.out.println(cont);
                if (cont == 2) {
                    qtd++;
                    fer2.setIdFerramenta(idFer2);
                    fer2.setQuantidade(qtd);

                    fer2.setData_enviado(data);
                    fer2.setIdFerramenta(idFer);

                    fun2.setData_enviado(data);
                    fun2.setIdFuncionario(idFun);

                    // -> Falta Atualizar o Firebase
                }
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Receber.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void inicializarComponentes() {
        entradaNome = findViewById(R.id.edtRegistro2);
        entradaSerie = findViewById(R.id.edtNumero2);
        entradaData = findViewById(R.id.edtDataDevolvido);
        botaoEntrar = findViewById(R.id.btEntrarID);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

}
