package org.esiea.cam_gidon.pokedex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailsActivity extends AppCompatActivity {
    String value;
    JSONArray pokemonDetails;
    JSONObject detail;
    JSONArray array;
    String name;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getBaseContext();
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

                    //name = response.optString("name");

                    detail = response;
                    name = detail.optString("name");
                    TextView textView1;
        ImageView image;
                    textView1 = (TextView) findViewById( R.id.data );
                    textView1.setText( name );
        image  = (ImageView) findViewById(R.id.image);
        Picasso.with(context).load("http://assets22.pokemon.com/assets/cms2/img/pokedex/full/" + get3DigitPokeId() + ".png").into(image);
                    TextView textView2;
                    textView2 = (TextView) findViewById( R.id.id );
                    textView2.setText( "#"+value );
                    TextView textView3;
                    textView3 = (TextView) findViewById( R.id.weight );
                    textView3.setText( detail.optString("weight") );
                    TextView textView4;
                    textView4 = (TextView) findViewById( R.id.Size);
                    textView4.setText( detail.optString("height") );
                    if (pokemonDetails != null) {
                        Log.i("LOG", "test");
                    }
                        //CreateButton( pokemonDetails );
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG", error.toString());
                Toast.makeText(getApplicationContext(),getString(R.string.fail), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public String get3DigitPokeId() {
        String threeDigitId = "" + value;
        while (threeDigitId.length() < 3) {
            threeDigitId = '0' + threeDigitId;
        }
        return threeDigitId;
    }


}
