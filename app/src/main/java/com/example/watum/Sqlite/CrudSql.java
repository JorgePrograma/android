package com.example.watum.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CrudSql extends DatosBd {
    private SQLiteDatabase sql;
    Context context;

    public CrudSql(Context context) {
        super(context);
        this.context = context;
    }

    public long setAddUsuario(String nombre, String apellido, String celular, String clave) {
        long cantidad = 0;
        try {
            DatosBd basedato = new DatosBd(context);
            sql = basedato.getWritableDatabase();
            ContentValues dato = new ContentValues();
            dato.put("nombre", nombre);
            dato.put("apellido", apellido);
            dato.put("celular", celular);
            dato.put("clave", clave);
            cantidad = sql.insert(TABLA_USUARIO, null, dato);
            sql.close();
        } catch (Exception exception) {
            exception.toString();
        }
        return cantidad;
    }

    public long setUpdateUsuario(String nombre, String apellido, String celular, String clave, int id) {
        long cantidad = 0;
        try {
            DatosBd basedato = new DatosBd(context);
            sql = basedato.getWritableDatabase();
            ContentValues dato = new ContentValues();
            dato.put("nombre", nombre);
            dato.put("apellido", apellido);
            dato.put("celular", celular);
            dato.put("clave", clave);
            cantidad = sql.update(TABLA_USUARIO, dato, "id=" + id, null);
            sql.close();
        } catch (Exception exception) {
            exception.toString();
        }
        return cantidad;
    }

    public long setEliminarUsuario(int id) {
        long cantidad = 0;
        try {
            DatosBd clasehelper = new DatosBd(context);
            sql = getWritableDatabase();
            Cursor cursormodelo;
            cantidad = sql.delete(TABLA_USUARIO, "id=" + id, null);
        } catch (Exception ex) {
            ex.toString();
        }
        return cantidad;
    }

    public long getBuscar(String celular, String clave){
        long cantidad =0;
        String[] parametros = {celular, clave};
        try {
            DatosBd basedato = new DatosBd(context);
            sql = basedato.getReadableDatabase();
            Cursor cursor;
            cantidad = Integer.parseInt(""+sql.query(TABLA_USUARIO, null,"celular =?, clave=?", parametros,
                    null, null, null ));
        } catch (Exception exception) {
            exception.toString();
        }
        return cantidad;
    }

}
