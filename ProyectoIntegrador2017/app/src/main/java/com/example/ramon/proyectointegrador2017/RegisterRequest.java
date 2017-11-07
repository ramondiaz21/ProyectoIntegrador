package com.example.ramon.proyectointegrador2017;

import android.net.sip.SipAudioCall;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ramon on 07/11/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://localhost/register.php";
    private Map<String, String> params;
    public RegisterRequest(String nombre_usuario, String usuario_usuario, String password_usuario, String email_usuario, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nombre_usuario", nombre_usuario);
        params.put("usuario_usuario", usuario_usuario);
        params.put("password_usuario", password_usuario);
        params.put("email_usuario", email_usuario);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
