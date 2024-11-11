package com.example.listas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MiBaseDeDatosHelper dbHelper;
    private MiAdaptador adaptador;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MiBaseDeDatosHelper(this);
        listView = findViewById(R.id.listView);

        actualizarLista();

        Button insertarButton = findViewById(R.id.insertarButton);
        insertarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarNuevoElemento();
            }
        });
    }

    private void insertarNuevoElemento() {
        EditText nombreEditText = findViewById(R.id.nombreEditText);
        EditText urlEditText = findViewById(R.id.urlEditText);

        String nombre = nombreEditText.getText().toString();
        String url = urlEditText.getText().toString();

        dbHelper.insertarRegistro(nombre, url);
        actualizarLista();
    }

    private void actualizarLista() {
        List<Elemento> elementos = dbHelper.obtenerTodosLosElementos();
        adaptador = new MiAdaptador(this, elementos);
        listView.setAdapter(adaptador);
    }
}
