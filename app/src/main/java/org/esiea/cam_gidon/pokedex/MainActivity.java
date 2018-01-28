package org.esiea.cam_gidon.pokedex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import org.esiea.cam_gidon.pokedex.Api.PokedexClient;
import org.esiea.cam_gidon.pokedex.Api.Service.PokedexService;
import org.esiea.cam_gidon.pokedex.models.Pokedex.PokedexHeader;
import org.esiea.cam_gidon.pokedex.models.Pokedex.PokedexPokemon;;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import retrofit.Callback;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PokedexPokemon> pokedexList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.CreateButton();

    }

    public void CreateButton(){
        RelativeLayout ll = (RelativeLayout) findViewById(R.id.mainLayout);
        for(int i = 1; i <= 151; i++){
            Button button = new Button(this);
            button.setText("Pokemon " + i);
            button.setTextSize(20);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = 300*(i-1);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            button.setLayoutParams(params);
            button.setTag(i);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);
                    myIntent.putExtra("key", v.getTag().toString());
                    Toast.makeText(getApplicationContext(),getString(R.string.toast) + v.getTag().toString(), Toast.LENGTH_LONG).show();
                    MainActivity.this.startActivity(myIntent);
                }
            });
            ll.addView(button);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
