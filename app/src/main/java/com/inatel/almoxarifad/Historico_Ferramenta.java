package com.inatel.almoxarifad;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Historico_Ferramenta extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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

                String nome2 = nome.getText().toString();

                ArrayList<Ferramenta> ferramenta = null;  //Pegar Array do BD

                List<Ferramenta> lista2= new ArrayList<Ferramenta>();

                for(Ferramenta us: ferramenta){
                    if (nome2.equals(us.getNome())){
                        lista2.add(us);
                        ArrayAdapter<Ferramenta> adapter = new ArrayAdapter<Ferramenta>(Historico_Ferramenta.this, android.R.layout.simple_list_item_2, lista2);
                        lista.setAdapter(adapter);
                    }
                }

            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Historico_Ferramenta.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
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