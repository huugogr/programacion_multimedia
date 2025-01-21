package com.example.pr9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText idMonumento;
    private LinearLayout caja, borde;
    private Button buscar, comprar;
    private ImageView monumentoImg;
    private WebView monumentowebView;
    private TextView titulo,latitud,longitud,fecha,monumentoText,mensajeText, ubicacion;


    @SuppressLint("MissingInflatedId")
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
        idMonumento = findViewById(R.id.MonumentId);
        buscar = findViewById(R.id.BotonBuscar);
        caja = findViewById(R.id.Caja);
        monumentoImg = findViewById(R.id.MonumentoImagen);
        monumentowebView = findViewById(R.id.MonumentoWebView);
        monumentoText = findViewById(R.id.MonumentoText);
        mensajeText = findViewById(R.id.MensajeText);
        titulo = findViewById(R.id.TituloText);
        fecha = findViewById(R.id.FechaText);
        latitud = findViewById(R.id.LatitudText);
        longitud = findViewById(R.id.LongitudText);
        comprar = findViewById(R.id.compras);
        borde = findViewById(R.id.Borde);
        ubicacion = findViewById( R.id.UbicacionText);

        buscar.setOnClickListener(this);

    }

    ControladorMonumento controlador = new ControladorMonumento(this);


    @Override
    public void onClick(View view) {

        String monumentId = idMonumento.getText().toString();

        if (monumentId.isEmpty()) {
            mensajeText.setText("Por favor, introduce un ID válido");
            mensajeText.setVisibility(View.VISIBLE);
        }
        else{
            try {
                mensajeText.setVisibility(View.GONE);
                controlador.obtenerMonumentoID(monumentId, new com.example.pr9.VolleyCallBack() {
                    @Override
                    public void onSuccess(Context context, ArrayList<Monumento> monumentos) {
                        Monumento monumento = monumentos.get(0);

                        caja.setVisibility(View.VISIBLE);
                        borde.setVisibility(View.VISIBLE);
                        titulo.setText(monumento.nombre);
                        fecha.setText("Construido: "+ monumento.fecha);
                        Picasso.get().load(monumento.imagen).into(monumentoImg);
                        monumentoText.setText(monumento.descripcion);
                        latitud.setText("Latitud: "+ monumento.latitud);
                        longitud.setText("Longitud: "+ monumento.longitud);
                        ubicacion.setText(monumento.ciudad);
                        comprar.setText("Comprar tu entrada desde: "+ monumento.precio + "€");
                        String html = monumento.video;
                        WebSettings settings = monumentowebView.getSettings();
                        settings.setJavaScriptEnabled(true);
                        monumentowebView.loadData(html,"text/html","UTF-8");
                    }
                });
            } catch (com.example.pr9.ServidorPHPException e) {
                throw new RuntimeException(e);
            }
      }





}
}