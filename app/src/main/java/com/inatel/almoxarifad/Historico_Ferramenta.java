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

public class Historico_Ferramenta extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Ferramenta> listFerramenta = new ArrayList<Ferramenta>();
    private ArrayAdapter<Ferramenta> arrayAdapterFerramenta;

    EditText nome;
    Button procurar;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico__ferramenta);
        setContentView(R.layout.activity_historico__ferramenta);

        inicializarFirebase();
        inicializar();

        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nome1 = nome.getText().toString();
                databaseReference.child("Historico_Ferramenta").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        listFerramenta.clear();
                        String nomeAux;
                        for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                            Ferramenta f = objSnapshot.getValue(Ferramenta.class);

                            nomeAux = f.getNome();
                            if(nome1.equals(nomeAux)){
                                listFerramenta.add(f);
                            }
                        }
                        arrayAdapterFerramenta = new ArrayAdapter<Ferramenta>(Historico_Ferramenta.this,
                                android.R.layout.simple_list_item_1,listFerramenta);
                        lista.setAdapter(arrayAdapterFerramenta);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Historico_Ferramenta.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void inicializar(){
        nome = findViewById(R.id.editText);
        procurar = findViewById(R.id.procurar);
        lista = findViewById(R.id.lvHistorico1);
    }

    private void alerta(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }
}

// Ele vai funcionar