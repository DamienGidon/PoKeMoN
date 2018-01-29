package org.esiea.cam_gidon.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.System.in;

public class DetailsActivity extends AppCompatActivity {
    String value;
    JSONArray pokemonDetails;
    JSONObject detail;
    JSONArray array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();


        value = intent.getStringExtra("key");
        value = String.valueOf( Integer.parseInt( value )+1);

        setContentView(R.layout.activity_details);

        this.getPokemonDetails();
    }

    private void getPokemonDetails() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/pokemon/"+value;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    int resultCount = response.optInt("resultCount");

                   detail = response;
                    TextView textView1;
                    //in your OnCreate() method
                    textView1 = (TextView) findViewById( R.id.data );
                    String test = "aaa" + detail.toString();
                    textView1.setText( detail.toString() );
                    if (pokemonDetails != null) {
                        Log.i( "LOG", "test" );

                        //CreateButton( pokemonDetails );

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG", error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
