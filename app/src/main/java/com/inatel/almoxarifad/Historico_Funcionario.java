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

public class Historico_Funcionario extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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

                String nome2 = nome.getText().toString();

                ArrayList<Funcionario> funcionario = null;  //Pegar Array do BD

                List<Funcionario> lista2= new ArrayList<Funcionario>();

                for(Funcionario us: funcionario){
                    if (nome2.equals(us.getNome())){
                        lista2.add(us);
                        ArrayAdapter<Funcionario> adapter = new ArrayAdapter<Funcionario>(Historico_Funcionario.this, android.R.layout.simple_list_item_2, lista2);
                        lista.setAdapter(adapter);
                    }
                }

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Historico_Funcionario.this);
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
