package com.inatel.almoxarifad;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Historico_Funcionario extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Funcionario> listFuncionario = new ArrayList<Funcionario>();       // Lista principal
    private ArrayAdapter<Funcionario> arrayAdapterFuncionario;

    EditText nome;
    Button procurar;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico__funcionario);
        setContentView(R.layout.activity_historico__funcionario);
        inicializarFirebase();

        inicializar();


        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String que armazena o nome desejado
                final String nome2 = nome.getText().toString();

                databaseReference.child("Historico_Funcionario").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        listFuncionario.clear();

                        // String que auxiliar que armazena os nomes do BD
                        String nome2aux;

                        for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                            Funcionario f = objSnapshot.getValue(Funcionario.class);

                            nome2aux = f.getNome();

                            if (nome2aux.equals(nome2)) {
                                listFuncionario.add(f);
                            }
                        }
                        arrayAdapterFuncionario = new ArrayAdapter<Funcionario>(Historico_Funcionario.this, android.R.layout.simple_list_item_1, listFuncionario);
                        lista.setAdapter(arrayAdapterFuncionario);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Historico_Funcionario.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void inicializar(){
        nome = findViewById(R.id.editText2);
        procurar = findViewById(R.id.procurar2);
        lista = findViewById(R.id.lvHistorico2);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }
}
