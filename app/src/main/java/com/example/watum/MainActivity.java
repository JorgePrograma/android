package com.example.watum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.watum.Sqlite.CrudSql;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, clave;
    private Button btnInicio, btnRegistrar;
    CrudSql consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.idLoginUsuario);
        clave = findViewById(R.id.idLoginClave);
        btnInicio = findViewById(R.id.idLoginBtnIniciarSesion);
        btnRegistrar = findViewById(R.id.idLoginBtnRegistrarse);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = usuario.getText().toString();
                String cla = clave.getText().toString();
                if(!usu.isEmpty() && !cla.isEmpty()){
                    consulta = new CrudSql(getApplicationContext());
                    long resultado = consulta.getBuscar(usu, cla);
                    if(resultado >0){
                        Toast.makeText(MainActivity.this, "Inicio con exito", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vista = new Intent(MainActivity.this, RegistrarUsuario.class);
                startActivity(vista);
                Toast.makeText(MainActivity.this, "Pasando a registrarse", Toast.LENGTH_SHORT).show();
            }
        });

    }
}