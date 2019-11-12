package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Historico_Funcionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico__funcionario);

        ListView lista = (ListView) findViewById(R.id.lvHistorico2);
    }
}
