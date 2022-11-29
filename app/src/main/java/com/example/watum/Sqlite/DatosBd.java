package com.example.watum.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosBd extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE ="proyecto.bd";
    public static final String TABLA_USUARIO ="usuarios";
    public static  final String TABLA_PRODUCTO = "productos";

    public DatosBd(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        // crear en la base de dato la tabla usuario
        sql.execSQL("CREATE TABLE "+TABLA_USUARIO+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "apellido TEXT NOT NULL,"+
                "celular TEXT NOT NULL,"+
                "clave TEXT NOT NULL)");

        // crear en la base de datos la tabla productos
        sql.execSQL("CREATE TABLE "+TABLA_PRODUCTO+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "estado TEXT NOT NULL,"+
                "fecha DateTime NOT NULL,"+
                "imagen TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int i, int i1) {
        // metodo para eliminar la tabla y luego crearla de nuevo
        sql.execSQL("DROP TABLE "+TABLA_PRODUCTO);
        onCreate(sql);
    }

}
