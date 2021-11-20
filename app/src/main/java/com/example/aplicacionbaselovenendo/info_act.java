package com.example.aplicacionbaselovenendo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void Marcado(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); //Accion de marcado.
        i.setData(Uri.parse("tel:"+"949584378"));
        startActivity(i);
    }

    public void Mapa(View view)
    {
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);

    }
}