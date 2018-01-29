package org.esiea.cam_gidon.pokedex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailsActivity extends AppCompatActivity {
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getBaseContext();
        Intent intent = getIntent();
        value = intent.getStringExtra("key");
        setContentView(R.layout.activity_details);
        TextView textView1;
        ImageView image;
        //in your OnCreate() method
        textView1  = (TextView) findViewById(R.id.data);
        textView1.setText(value);
        image  = (ImageView) findViewById(R.id.image);
        Picasso.with(context).load("http://assets22.pokemon.com/assets/cms2/img/pokedex/full/" + get3DigitPokeId() + ".png").into(image);
    }

    public String get3DigitPokeId() {
        String threeDigitId = "" + value;
        while (threeDigitId.length() < 3) {
            threeDigitId = '0' + threeDigitId;
        }
        return threeDigitId;
    }


}
