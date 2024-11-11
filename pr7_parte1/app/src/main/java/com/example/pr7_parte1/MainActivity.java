package com.example.pr7_parte1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button reproducir;
    private Button pausar;
    private TextView titulo;
    private TextView texto;
    private MediaPlayer jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        reproducir = findViewById(R.id.reproducir);
        pausar = findViewById(R.id.pausar);
        titulo = findViewById(R.id.titulo);
        texto = findViewById(R.id.texto);
        jump = MediaPlayer.create(this, R.raw.nocturne);

        reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setVisibility(View.VISIBLE);
                texto.setVisibility(View.VISIBLE);
                jump.start();
            }
        });

        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setVisibility(View.INVISIBLE);
                texto.setVisibility(View.INVISIBLE);
            }
        });
    }
}
