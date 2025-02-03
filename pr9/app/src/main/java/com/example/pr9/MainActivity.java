package com.example.pr9;

<<<<<<< HEAD
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText editTextId;
    private Button buttonBuscar;
    private TextView textViewNombre, textViewDescripcion, textViewFecha, textViewCiudad, textViewPrecio;
    private ImageView imageViewMonumento;
    private WebView webViewVideo;

    private final String BASE_URL = "http://10.128.109.67/monumentos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId = findViewById(R.id.editTextId);
        buttonBuscar = findViewById(R.id.buttonBuscar);
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewDescripcion = findViewById(R.id.textViewDescripcion);
        textViewFecha = findViewById(R.id.textViewFecha);
        textViewCiudad = findViewById(R.id.textViewCiudad);
        textViewPrecio = findViewById(R.id.textViewPrecio);
        imageViewMonumento = findViewById(R.id.imageViewMonumento);
        webViewVideo = findViewById(R.id.webViewVideo);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese un ID", Toast.LENGTH_SHORT).show();
                } else {
                    buscarMonumento(id);
                }
            }
        });
    }

    private void buscarMonumento(String id) {
        String url = BASE_URL + "obtenerMonumentoID.php?ID=" + id;

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String nombre = response.getString("nombre");
                            String descripcion = response.getString("descripcion");
                            String fecha = response.getString("fecha");
                            String ciudad = response.getString("ciudad");
                            String precio = response.getString("precio");
                            String imagenUrl = response.getString("imagen");
                            String videoUrl = response.getString("video");

                            textViewNombre.setText(nombre);
                            textViewDescripcion.setText(descripcion);
                            textViewFecha.setText(fecha);
                            textViewCiudad.setText(ciudad);
                            textViewPrecio.setText(precio);
                            Picasso.get().load(imagenUrl).into(imageViewMonumento);
                            webViewVideo.loadData(videoUrl, "text/html", "utf-8");

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Error al procesar los datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Monumento no encontrado", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}
=======
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
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
