package com.example.ramon.proyectointegrador2017;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrarse extends AppCompatActivity implements View.OnClickListener {

    EditText etNombre, etUsuario, etContrasena, etMail;
    Button btn_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        etMail = (EditText) findViewById(R.id.etMail);
        btn_registro = (Button) findViewById(R.id.btn_registro);

        btn_registro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final String nombre_usuario = etNombre.getText().toString();
        final String usuario_usuario = etUsuario.getText().toString();
        final String password_usuario = etContrasena.getText().toString();
        final String email_usuario = etMail.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Intent intent = new Intent(Registrarse.this, MainActivity.class);
                        Registrarse.this.startActivity(intent);
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registrarse.this);
                        builder.setMessage("Error en el registro!")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest registerRequest = new RegisterRequest(nombre_usuario,usuario_usuario,password_usuario,email_usuario, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Registrarse.this);
        queue.add(registerRequest);
    }
}
