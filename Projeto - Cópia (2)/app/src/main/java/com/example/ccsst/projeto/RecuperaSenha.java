package com.example.ccsst.projeto;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CCSST on 01/02/2016.
 */
public class RecuperaSenha extends Activity{
    private Map<String, String> params;
    RequestQueue rq;
    private String url;

    EditText Email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_senha);

        url = "http://192.168.1.5:3000/";//Setar url do servidor

        Email = (EditText) findViewById(R.id.email);

        rq = Volley.newRequestQueue(RecuperaSenha.this);


    }


    public void Recupera(View view){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String Response){
                Log.i("Script", "SUCESSO" + Response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(RecuperaSenha.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                params = new HashMap<String, String>();
                params.put("Email", Email.getText().toString());

                return params;
            }
        };
        request.setTag("tag");
        rq.add(request);
    }
}
