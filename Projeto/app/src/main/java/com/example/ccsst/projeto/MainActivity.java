package com.example.ccsst.projeto;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {
    private Map<String, String> params; //é um método q mapeia chaves com seus respectivos valores
    private RequestQueue rq;
    private String url;
    private ProgressDialog progressDialog;

    EditText nome;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        url = "http://192.168.140.0:3000/login"; //Setar url do servidor

        //EditText
        nome = (EditText) findViewById(R.id.editTextNome);
        senha = (EditText) findViewById(R.id.editTextSenha);


        rq = Volley.newRequestQueue(MainActivity.this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Recuperar(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.recupera_senha, null);
        Button cancelar = (Button) view2.findViewById(R.id.Cancelar);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(view2);
        dialog.setTitle("Recuperar Senha");
        dialog.show();

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    public static String md5(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }


    //CHAMAR O VOLLEY
    public void StringRequest(View view){
        //Inicia o dialogo de progresso
        progressDialog = ProgressDialog.show(MainActivity.this, "", "Entrando...", false, true);
        final Intent intent = new Intent(this, navegation.class);
        final String Dosenha = md5(senha.getText().toString());

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String Response){
                //Log.i("Script", "SUCESSO" + Response);
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "SUCESSO: " + Response, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Erro: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                params = new HashMap<String, String>();
                params.put("Nome", nome.getText().toString());
                params.put("Senha", Dosenha);

                return params;
            }
        };
        request.setTag("tag");//segundo o cara é pra permitir cancelamento :v
        rq.add(request);

    }
}
