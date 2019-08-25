package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
private Button botaoReceber,botaoRetirar,botaoHisFer,botaoHisFun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        inicializarComponentes();

        botaoRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_retirar);
            }
        });
        botaoReceber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_retirar);
            }
        });
        botaoHisFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_historico__ferramenta);
            }
        });
        botaoHisFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_historico__funcionario);
            }
        });
    }
    private void inicializarComponentes() {
        botaoRetirar = findViewById(R.id.btRetirar2);
        botaoReceber = findViewById(R.id.btReceber2);
        botaoHisFun = findViewById(R.id.btHisFun2);
        botaoHisFer = findViewById(R.id.btHisFer2);
    }
}
