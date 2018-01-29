package org.esiea.cam_gidon.pokedex;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListViewPokemons extends AppCompatActivity {
    String value;
    JSONArray jsonobject;
    List<String> names;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_pokemons);
        names = new ArrayList<String>();
        Intent intent = getIntent();
        value = intent.getStringExtra("key");
        try {
            jsonobject = new JSONArray(value);
            for(int i=0; i<151; i++){
                JSONObject json = jsonobject.optJSONObject(i);
                String name = json.optString("name");
                names.add(name);
            }
            mListView = (ListView) findViewById(R.id.listView);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewPokemons.this,
                    android.R.layout.simple_list_item_1, names);
            mListView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
