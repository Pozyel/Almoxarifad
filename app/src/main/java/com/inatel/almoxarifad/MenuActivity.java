package com.inatel.almoxarifad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
private Button botaoReceber,botaoRetirar,botaoHisFer,botaoHisFun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        botaoRetirar = findViewById(R.id.btRetirar2);
        inicializarComponentes();
        botaoRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MenuActivity.this,Retirar.class);
                startActivity(intent1);
            }
        });
        botaoReceber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuActivity.this,Receber.class);
                startActivity(intent2);
            }
        });
        botaoHisFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MenuActivity.this,Historico_Ferramenta.class);
                startActivity(intent3);
            }
        });
        botaoHisFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MenuActivity.this,Historico_Funcionario.class);
                startActivity(intent4);
            }
        });


    }


    private void inicializarComponentes() {

        botaoReceber = findViewById(R.id.btReceber2);
        botaoHisFun = findViewById(R.id.btHisFun2);
        botaoHisFer = findViewById(R.id.btHisFer2);
    }

}
