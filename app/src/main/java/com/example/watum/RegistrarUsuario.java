package com.example.watum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.watum.Sqlite.CrudSql;

public class RegistrarUsuario extends AppCompatActivity {
    private EditText nombre, apellido, celular , clave;
    private Button btnRegistrar;
    CrudSql consultas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        nombre = findViewById(R.id.idRegistroUsuarioNombre);
        apellido = findViewById(R.id.idRegistroUsuarioApellido);
        celular  = findViewById(R.id.idRegistroUsuarioCelular);
        clave  = findViewById(R.id.idRegistroUsuarioClave);
        btnRegistrar = findViewById(R.id.idRegistroUsuarioBtnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String cel = celular.getText().toString();
                String cla = clave.getText().toString();
                if(!nom.isEmpty() && !ape.isEmpty() && !cel.isEmpty() && !cla.isEmpty()){
                    consultas = new CrudSql(getApplicationContext());
                    long resultado = consultas.setAddUsuario(nom, ape, cel, cla);
                    if(resultado>0){
                        Toast.makeText(RegistrarUsuario.this, "Se registro con exito", Toast.LENGTH_SHORT).show();
                        Intent vista = new Intent(RegistrarUsuario.this, MainActivity.class);
                        startActivity(vista);
                    }else{
                        Toast.makeText(RegistrarUsuario.this, "Hubo un error al registrarse", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistrarUsuario.this, "tiene campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}