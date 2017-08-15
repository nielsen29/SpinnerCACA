package com.amihealth.cacadespinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amihealthmel on 08/15/17.
 */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

    /**
     * Created by amihealthmel on 08/09/17.
     */

    public class ProvinciasDatos{
        private Configuracion CON;
        private ArrayList<Provincia> arrayList;
        private Context activity;


        public ProvinciasDatos(Context activ){
            this.activity = activ;
            this.arrayList = new ArrayList<>();
            CON = new Configuracion();
        }

        public void getDataApi(){
            StringRequest st = new StringRequest(Request.Method.GET, CON.URL_GET_PROVINCIA, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    getJSON(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(activity,"No tiene Conexion", Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue rq = Volley.newRequestQueue(activity);
            rq.add(st);
        }

        public void getJSON(String response){
            Provincia provincia;

            try{
                JSONObject JsonObj = new JSONObject(response);
                JSONArray provincias = JsonObj.getJSONArray("data");
                for (int i = 0; i < provincias.length(); i++){
                    JSONObject prov = provincias.getJSONObject(i);
                    provincia = new Provincia();
                    provincia.setId(prov.getInt("id_provincia"));
                    provincia.setNombre(prov.getString("nombre"));
                    arrayList.add(provincia);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        public ArrayList getData(){
            if(arrayList.isEmpty()){
                arrayList = new ArrayList<>();
                getDataApi();
                return arrayList;
            }else{
                return arrayList;
            }
        }
    }

