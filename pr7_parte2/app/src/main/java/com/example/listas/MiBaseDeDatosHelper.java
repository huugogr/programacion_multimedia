package com.example.listas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MiBaseDeDatosHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "miBaseDeDatos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "elementos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_URL = "url";

    public MiBaseDeDatosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOMBRE + " TEXT,"
                + COLUMN_URL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertarRegistro(String nombre, String url) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_URL, url);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Elemento> obtenerTodosLosElementos() {
        List<Elemento> elementos = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Elemento elemento = new Elemento();
                int id = cursor.getColumnIndex(COLUMN_ID);
                int nombre = cursor.getColumnIndex(COLUMN_NOMBRE);
                int url = cursor.getColumnIndex(COLUMN_URL);
                elemento.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID) < 0 ? 0: id));
                elemento.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE) < 0 ? 0: nombre));
                elemento.setUrl(cursor.getString(cursor.getColumnIndex(COLUMN_URL) < 0 ? 0: url));
                elementos.add(elemento);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return elementos;
    }
}

