package com.example.pr9;

<<<<<<< HEAD
import static com.example.practica9.Utilidades.RESULTADO_ERROR;
import static com.example.practica9.Utilidades.RESULTADO_ERROR_DESCONOCIDO;
import static com.example.practica9.Utilidades.RESULTADO_OK;
import static com.example.practica9.Utilidades.URLSERVIDOR;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
=======
import static com.example.pr9.Utilidades.RESULTADO_ERROR;
import static com.example.pr9.Utilidades.RESULTADO_ERROR_DESCONOCIDO;
import static com.example.pr9.Utilidades.RESULTADO_OK;
import static com.example.pr9.Utilidades.URLSERVIDOR;

import android.content.Context;
import android.util.Log;

>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
<<<<<<< HEAD
import com.example.practica9.ServidorPHPException;
=======
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Date;
import java.util.HashMap;
import java.util.List;
=======
import java.util.HashMap;
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993

public class ControladorMonumento {

    private final String URLOBTENERMONUMENTOS = URLSERVIDOR + "obtenerTodosMonumentos.php";
    private final String URLOBTENERMONUMENTO = URLSERVIDOR + "obtenerMonumentoID.php";

    private Context contexto;
    private RecyclerView lista;

    public ControladorMonumento(Context contexto)
    {
        this.contexto = contexto;
    }

    /**
<<<<<<< HEAD
     * Obtiene todas los monumentos deal servidor
     */
    public void obtenerTodosMonumentos(com.example.practica9.VolleyCallBack callBack) throws com.example.practica9.ServidorPHPException
=======
     * Obtiene todas los monumentos del servidor
     */
    public void obtenerTodosMonumentos(com.example.pr9.VolleyCallBack callBack) throws com.example.pr9.ServidorPHPException
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
    {
        ArrayList<Monumento> monumentos = new ArrayList<>();
        try
        {
            RequestQueue colavolley = Volley.newRequestQueue(contexto);
            String url = URLOBTENERMONUMENTOS;

            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONArray>()
                    {
                        @Override
                        public void onResponse(JSONArray response)
                        {
                            try
                            {
                                if( response != null )
                                {
                                    int resultadoobtenido = response.getJSONObject(0).getInt("estado");

                                    switch(resultadoobtenido)
                                    {
                                        case RESULTADO_OK:
                                            JSONArray datosmonumentos = response.getJSONObject(0).getJSONArray("mensaje");
                                            for (int i = 0; i < datosmonumentos.length(); i++)
                                            {
                                                JSONObject per = datosmonumentos.getJSONObject(i);
                                                String id = per.getString("id");
                                                String nombre = per.getString("nombre");
                                                String descripcion = per.getString("descripcion");
                                                String fecha = per.getString("fecha");
                                                String latitud = per.getString("latitud");
                                                String longitud = per.getString("longitud");
                                                String ciudad = per.getString("ciudad");
                                                String visitable = per.getString("visitable");
                                                String precio = per.getString("precio");
                                                String moneda = per.getString("moneda");
                                                String video = per.getString("video");
                                                String imagen = per.getString("imagen");

                                                Monumento monumento = new Monumento(id, nombre, descripcion, fecha, latitud, longitud, ciudad, visitable, precio, moneda, video, imagen);
                                                monumentos.add(monumento);
<<<<<<< HEAD
                                                ArrayList<Monumento> monumentos = new ArrayList<>();
                                            }
                                            break;
                                        case RESULTADO_ERROR:
                                            throw new com.example.practica9.ServidorPHPException("Error, datos incorrectos.");
                                        case RESULTADO_ERROR_DESCONOCIDO:
                                            throw new com.example.practica9.ServidorPHPException("Error obteniendo los datos del servidor.");
=======
                                                callBack.onSuccess(contexto, monumentos);
                                            }
                                            break;
                                        case RESULTADO_ERROR:
                                            throw new com.example.pr9.ServidorPHPException("Error, datos incorrectos.");
                                        case RESULTADO_ERROR_DESCONOCIDO:
                                            throw new com.example.pr9.ServidorPHPException("Error obteniendo los datos del servidor.");
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
                                    }
                                }
                                else
                                {
<<<<<<< HEAD
                                    throw new ServidorPHPException("Error obteniendo los datos del servidor.");
                                }
                            }
                            catch (JSONException | ServidorPHPException error)
=======
                                    throw new com.example.pr9.ServidorPHPException("Error obteniendo los datos del servidor.");
                                }
                            }
                            catch (JSONException | com.example.pr9.ServidorPHPException error)
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
                            {
                                System.out.println("Error -> " + error.toString());
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            System.out.println("Error -> " + error.toString());
                        }
                    }
            );

<<<<<<< HEAD
=======
            // Agregamos la petición a la cola para que se ejecute
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
            colavolley.add(jsonObjectRequest);
        }
        catch(Exception error)
        {
<<<<<<< HEAD
            throw new ServidorPHPException(error.toString());
=======
            throw new com.example.pr9.ServidorPHPException(error.toString());
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
        }
    }

    /**
     * Obtiene un monumento del servidor según su ID
     */
<<<<<<< HEAD
    public void obtenerMonumentoID(String ID, com.example.practica9.VolleyCallBack callBack) throws ServidorPHPException
=======
    public void obtenerMonumentoID(String ID, com.example.pr9.VolleyCallBack callBack) throws com.example.pr9.ServidorPHPException
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
    {
        Monumento monumento = new Monumento();
        try
        {
<<<<<<< HEAD
            RequestQueue colavolley = Volley.newRequestQueue(contexto);

            HashMap<String, String> parametros = new HashMap<>();
            parametros.put("ID", ID);
            String urlfinal = com.example.practica9.Utilidades.buildURL(URLOBTENERMONUMENTO, parametros);
=======
            // Inicializo la cola de peticiones
            RequestQueue colavolley = Volley.newRequestQueue(contexto);

            // Declaro el array de los parámetros
            HashMap<String, String> parametros = new HashMap<>();
            // Meto los parámetros
            parametros.put("ID", ID);
            String urlfinal = com.example.pr9.Utilidades.buildURL(URLOBTENERMONUMENTO, parametros);
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
            Log.w("a", urlfinal);
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    urlfinal,
                    null,
                    new Response.Listener<JSONArray>()
                    {
                        @Override
                        public void onResponse(JSONArray response)
                        {
                            try
                            {
                                if( response != null )
                                {
                                    int resultadoobtenido = response.getJSONObject(0).getInt("estado");
<<<<<<< HEAD
=======
                                    //System.out.println("EL RESULTADO ES " + resultadoobtenido);
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993

                                    switch(resultadoobtenido)
                                    {
                                        case RESULTADO_OK:
                                            JSONArray datosmonumento = response.getJSONObject(0).getJSONArray("mensaje");
                                            JSONObject monumentoJSON = datosmonumento.getJSONObject(0);

                                            monumento.id = monumentoJSON.getString("id");
                                            monumento.nombre = monumentoJSON.getString("nombre");
                                            monumento.descripcion = monumentoJSON.getString("descripcion");
                                            monumento.fecha = monumentoJSON.getString("fecha");
                                            monumento.latitud = monumentoJSON.getString("latitud");
                                            monumento.longitud = monumentoJSON.getString("longitud");
                                            monumento.ciudad = monumentoJSON.getString("ciudad");
                                            monumento.visitable = monumentoJSON.getString("visitable");
                                            monumento.precio = monumentoJSON.getString("precio");
                                            monumento.moneda = monumentoJSON.getString("moneda");
                                            monumento.video = monumentoJSON.getString("video");
                                            monumento.imagen = monumentoJSON.getString("imagen");

                                            ArrayList<Monumento> monumentos = new ArrayList<>();
                                            monumentos.add(monumento);
<<<<<<< HEAD
                                            break;
                                        case RESULTADO_ERROR:
                                            throw new ServidorPHPException("Error, datos incorrectos.");
                                        case RESULTADO_ERROR_DESCONOCIDO:
                                            throw new ServidorPHPException("Error obteniendo los datos del servidor.");
=======
                                            callBack.onSuccess(contexto, monumentos);
                                            break;
                                        case RESULTADO_ERROR:
                                            throw new com.example.pr9.ServidorPHPException("Error, datos incorrectos.");
                                        case RESULTADO_ERROR_DESCONOCIDO:
                                            throw new com.example.pr9.ServidorPHPException("Error obteniendo los datos del servidor.");
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
                                    }
                                }
                                else
                                {
<<<<<<< HEAD
                                    throw new ServidorPHPException("Error obteniendo los datos del servidor.");
                                }
                            }
                            catch (JSONException | ServidorPHPException e)
=======
                                    throw new com.example.pr9.ServidorPHPException("Error obteniendo los datos del servidor.");
                                }
                            }
                            catch (JSONException | com.example.pr9.ServidorPHPException e)
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
                            {
                                System.out.println("Error -> " + e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            System.out.println("Error -> " + error.toString());
                        }
                    }
            );

<<<<<<< HEAD
=======
            // Agregamos la petición a la cola para que se ejecute
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
            colavolley.add(jsonObjectRequest);
        }
        catch(Exception e)
        {
<<<<<<< HEAD
            throw new ServidorPHPException("Error -> " + e.toString());
=======
            throw new com.example.pr9.ServidorPHPException("Error -> " + e.toString());
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993
        }
        Log.w("a", monumento.ciudad);
    }
}
