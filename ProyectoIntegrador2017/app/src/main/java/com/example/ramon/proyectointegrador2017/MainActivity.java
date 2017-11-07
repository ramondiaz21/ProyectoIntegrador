package com.example.ramon.proyectointegrador2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro = (Button) findViewById(R.id.Registrarse);
    Button btnLogin = (Button) findViewById(R.id.InicioSesion);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mandar(View view) {
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }
}
