package com.example.aplicacionbaselovenendo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Figuras;

public class Home_act extends AppCompatActivity {

    private VideoView videoview;
    private Figuras fi = new Figuras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        videoview = findViewById(R.id.vw); //llamamos por id el elemento grafico.
        //obtener ruta del video
        String ruta = "android.resource://" +getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta); //parseo la ruta.
        videoview.setVideoURI(uri); //le paso la ruta al videoview.

        //controles para el video

        MediaController media= new MediaController(this);
        videoview.setMediaController(media);

        videoview.start(); //Reproduce el video


    }

    public void Nendos(View view)
    {
        Intent i = new Intent(getBaseContext(), Figuras_act.class);
        Bundle bun = new Bundle();// Necesario para enviar arreglos.
        bun.putStringArray("figuras", fi.getFiguras());//Rellenar el bundle.
        i.putExtras(bun);// enviamos el bundle a tracés del intent.
        startActivity(i);

    }




}