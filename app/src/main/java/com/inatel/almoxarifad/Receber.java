package com.inatel.almoxarifad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Receber extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
    private List<Ferramenta> listFerramenta = new ArrayList<Ferramenta>();


    private EditText entradaNome;
    private EditText entradaSerie;
    private  EditText entradaData;
    private Button botaoEntrar;



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

                final String nome = entradaNome.getText().toString();
                final String serie = entradaSerie.getText().toString();
                final String data = entradaData.getText().toString();

                databaseReference.child("Historico_Funcionario").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        listFuncionario.clear();

                        String nome1;

                        for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                            Funcionario f = objSnapshot.getValue(Funcionario.class);
                            listFuncionario.add(f);
                        }

                       for(Funcionario fi :listFuncionario){
                           System.out.println(fi.getIdFuncionario());
                           nome1 = fi.getNome();
                           if(nome1.equals(serie)){
                               databaseReference.child("Historico_Funcionario").child(fi.getIdFuncionario()).child("data_enviado").setValue(data);
                               alerta("Ação concluida");
                               break;
                           }
                           else{
                               alerta("nome nao cadastrado");
                           }
                       }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                databaseReference.child("Historico_Ferramenta").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        listFerramenta.clear();

                        String nome1;

                        for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                            Ferramenta f = objSnapshot.getValue(Ferramenta.class);
                            listFerramenta.add(f);
                        }

                        for(Ferramenta fi :listFerramenta){
                            System.out.println(fi.getIdFerramenta());
                            nome1 = fi.getNome();
                            if(nome1.equals(serie)){
                                databaseReference.child("Historico_Ferramenta").child(fi.getIdFerramenta()).child("data_enviado").setValue(data);
                                alerta("Ação concluida");
                                break;
                            }
                            else{
                                alerta("nome nao cadastrado");
                            }
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
        botaoEntrar = findViewById(R.id.btDevolver);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

}

// Já esta dando certo