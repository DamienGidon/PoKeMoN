package org.esiea.cam_gidon.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        value = intent.getStringExtra("key");
        setContentView(R.layout.activity_details);
        TextView textView1;
        //in your OnCreate() method
        textView1  = (TextView) findViewById(R.id.data);
        textView1.setText(value);
    }
}
