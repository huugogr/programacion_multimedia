package com.example.pr9;

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
