package com.example.christianfranco.basedatos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.christianfranco.basedatos.ContadordePasos.IntSerBack;

public class Menu extends AppCompatActivity {
    ImageButton imaInfo,imaLo,imaAgregar,imaPasos,imaConsulta,imaLogros;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imaInfo=(ImageButton)findViewById(R.id.imaInfo);
        imaAgregar=(ImageButton)findViewById(R.id.imaAgregar);
        imaConsulta=(ImageButton)findViewById(R.id.imaConsulta);
        imaLo=(ImageButton)findViewById(R.id.imaLO);
        imaLogros=(ImageButton)findViewById(R.id.imaLogros);
        imaPasos=(ImageButton)findViewById(R.id.imaPasos);


        //inicio el servicio de background
        Intent intentservice = new Intent(this, IntSerBack.class);//inicio el servicio
        startService(intentservice);

        sp = getSharedPreferences("logged", MODE_PRIVATE);




        imaAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(Menu.this,AgregarDato.class);
                startActivity(add);
            }
        });

        imaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ver = new Intent(Menu.this,Consulta.class);
                //Intent ver = new Intent(Menu.this,Menu.class);//prueba borrarrrrrrrrrrrrrr
                startActivity(ver);
            }
        });


        imaPasos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verdatos = new Intent(Menu.this, Actividad.class);
                startActivity(verdatos);
            }
        });

        imaLo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("logged", false).apply();
                Intent salir = new Intent(Menu.this, MainActivity.class);
                startActivity(salir);
                finish();//evito que regresen al presionar el boto del celular
            }
        });


    }
}
