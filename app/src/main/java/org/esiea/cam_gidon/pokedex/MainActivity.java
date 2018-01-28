package org.esiea.cam_gidon.pokedex;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.CreateButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.notif:
                createNotification();
                return true;
            case R.id.actualize:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private final void createNotification(){

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
            button.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { OnClickPokemon(v);}});
            ll.addView(button);
        }
    }

    public void OnClickPokemon(View v){
        final View tag = v;
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Pokemon")
            .setMessage(getString(R.string.dialog) + " " +tag.getTag().toString() + " ?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);
                    myIntent.putExtra("key", tag.getTag().toString());
                    Toast.makeText(getApplicationContext(),getString(R.string.toast) + tag.getTag().toString(), Toast.LENGTH_LONG).show();
                    MainActivity.this.startActivity(myIntent);
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),getString(R.string.canceled), Toast.LENGTH_LONG).show();
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }
}
