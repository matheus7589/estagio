package com.example.ccsst.projeto;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.util.Log;
import com.android.volley.Request.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Cadastro extends Activity {

    final Context context = this;
    private Button botao;
    private static final String[] Estados = new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR",
    "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"};
    public static ArrayList<String> Cidade = new ArrayList<String>();
    private Map<String, String> params;
    RequestQueue rq;
    ProgressDialog progressDialog;
    private String url;
    RequestQueue rq2;

    EditText nomeEntrada;
    EditText senhaEntrada;
    EditText estadoEntrada;
    EditText cidadeEntrada;
    EditText cpf_cnpjEntrada;
    AutoCompleteTextView Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //VOLLEY(CONEXÃO)
        url = "http://192.168.1.5:3000/";//Setar url do servidor
        //EditText
        nomeEntrada = (EditText) findViewById(R.id.editTextNome);
        senhaEntrada = (EditText) findViewById(R.id.editTextSenha);
        cidadeEntrada = (EditText) findViewById(R.id.editTextCidade);
        cpf_cnpjEntrada = (EditText) findViewById(R.id.editTextCPF);

        rq = Volley.newRequestQueue(Cadastro.this);
        rq2 = Volley.newRequestQueue(Cadastro.this);
        //VOLLEY(CONEXÃO)

        //AUTO COMPLETE BOX
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Estados);//adapter da autocomplete box
        final AutoCompleteTextView UF = (AutoCompleteTextView) findViewById(R.id.autoCompleteUF);//acessa o layout
        UF.setAdapter(adp);

        UF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(UF.getText().toString().equals("TO")){

                    //Toast.makeText(getBaseContext(), "Entrou Satanás!!!!!", Toast.LENGTH_SHORT).show();

                    //progressDialog = ProgressDialog.show(Cadastro.this, "", "Entrando...", false, true);
                    getCidades();
                    //progressDialog.dismiss();

                    // TODO Arrumar isso (PS: não ta funcoinando ainda)
                    ArrayAdapter<String> adp2 = new ArrayAdapter<String>(Cadastro.this, android.R.layout.simple_dropdown_item_1line, Cidade);//adapter da autocomplete box
                    AutoCompleteTextView City = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextCidade);//acessa o layout
                    City.setAdapter(adp2);
                    //
                }
            }
        });

    }

    public void Dialogcidade(View view){

        //CRIA O LAYOUT PERSONALIZADO DO ARQUIVO "dialog_cidade"
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.dialog_cidade, null);
        Button adicionar = (Button) view2.findViewById(R.id.Adicionar);
        Button cancelar = (Button) view2.findViewById(R.id.Cancelar);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(view2);
        dialog.setTitle("Adicionar Cidade");
        dialog.show();

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Cidade Adicionada!", Toast.LENGTH_SHORT).show();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void Dialogbairro(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.dialog_bairro, null);

        Button adicionar = (Button) view2.findViewById(R.id.Adicionar);
        Button cancelar = (Button) view2.findViewById(R.id.Cancelar);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(view2);
        dialog.setTitle("Adicionar Bairro");
        dialog.show();

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Bairro Adicionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    //CHAMAR O VOLLEY
    public void callStringRequest(View view){


        StringRequest request = new StringRequest(Method.POST, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String Response){
                Log.i("Script", "SUCESSO" + Response);
            }
        },
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(Cadastro.this, "Error: " +error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        ){

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                params = new HashMap<String, String>();
                params.put("nome", nomeEntrada.getText().toString());
                params.put("senha", senhaEntrada.getText().toString());
                //params.put("Estado", estadoEntrada.getText().toString());
                //params.put("Cidade", cidadeEntrada.getText().toString());
                //params.put("CPF - CNPJ", cpf_cnpjEntrada.getText().toString());

                return params;
            }
        };
        request.setTag("tag");
        rq.add(request);
    }


    public void getCidades(){

        StringRequest request2 = new StringRequest(Method.POST, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String Response){
                Toast.makeText(Cadastro.this, "Sucesso: " + Response, Toast.LENGTH_LONG).show();
                pegaCidade(Response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(Cadastro.this, "Erro: " +error.getMessage(), Toast.LENGTH_LONG).show();
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
                params.put("Cidades", "cidade");

                return params;
            }
        };
        request2.setTag("tag");
        rq2.add(request2);
    }

    public void pegaCidade(String s){
        Cidade.add(s);
    }

}
