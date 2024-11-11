package com.example.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MiAdaptador extends ArrayAdapter<Elemento> {

    private Context context;
    private List<Elemento> elementos;

    public MiAdaptador(Context context, List<Elemento> elementos) {
        super(context, R.layout.item_elemento, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener el inflador de diseño
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Si la vista no está inflada, inflarla. Esto es para reutilizar vistas y mejorar el rendimiento.
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_elemento, parent, false);
        }

        // Obtener las referencias a los elementos de la vista
        TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
        ImageView imagenImageView = convertView.findViewById(R.id.imagenImageView);

        // Obtener el elemento actual
        Elemento elemento = elementos.get(position);

        // Establecer los valores en la vista
        nombreTextView.setText(elemento.getNombre());
        Picasso.get().load(elemento.getUrl()).into(imagenImageView);

        return convertView;
    }
}
