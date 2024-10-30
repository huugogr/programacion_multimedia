package com.example.pr6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonContinuar;
    private TextView textoOculto;
    private EditText cajaCorreo;
    private EditText cajaTextoPass;
    private Switch switch2;
    private TextView textoOculto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonContinuar = findViewById(R.id.switch1);
        textoOculto = findViewById(R.id.textView);
        cajaCorreo = findViewById(R.id.cajaTextoCorreo);
        cajaTextoPass = findViewById(R.id.cajaTextoPass);
        switch2 = findViewById(R.id.switch1);
        textoOculto2 = findViewById(R.id.textView2);

        botonContinuar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.botonContinuar){
            if (cajaCorreo.getText().toString().equals("correo@correo.com") && cajaTextoPass.getText().toString().equals("1234")){
                textoOculto.setVisibility(View.VISIBLE);
                textoOculto.setTextColor(getColor(R.color.green));
                textoOculto.setText("Usuario y contraseña correcto.");
                }
            } else {
                textoOculto.setVisibility(View.VISIBLE);
                textoOculto.setTextColor(getColor(R.color.red));
                textoOculto.setText("Usuario y/o contraseña incorrectos.");
            }

        }

    }
}