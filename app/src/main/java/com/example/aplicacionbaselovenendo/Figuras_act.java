package com.example.aplicacionbaselovenendo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Figuras;

public class Figuras_act extends AppCompatActivity {

    private Spinner figuras;
    private TextView info;
    private ImageView figurauno, figurados,figuratres,figuracuatro;
    Figuras figuras1 = new Figuras();
    private RatingBar calificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figuras);

        figuras = findViewById(R.id.spnFiguras);
        figurauno = findViewById(R.id.figura1);
        figurados = findViewById(R.id.figura2);
        figuratres = findViewById(R.id.figura3);
        figuracuatro = findViewById(R.id.figura4);
        info = findViewById(R.id.txtdescripcion);

        figurauno.setVisibility(View.INVISIBLE);
        figurados.setVisibility(View.INVISIBLE);
        figuratres.setVisibility(View.INVISIBLE);
        figuracuatro.setVisibility(View.INVISIBLE);

        //Recibo los extras
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("figuras");

        ArrayAdapter adaptFiguras = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        figuras.setAdapter(adaptFiguras);


    }

    public void Calculo(View view)
    {
        String opcion = figuras.getSelectedItem().toString(); //obtengo la opcion del spinner
        int resultado = 0;
        for(int i = 0; i<opcion.length(); i++)
        {
            if(opcion.equals(figuras1.getFiguras()[1]))
            {
                resultado = figuras1.anadirAdicional(figuras1.getPrecios()[0], 350);
                figurauno.setVisibility(View.VISIBLE);
                info.setText("Nendo elegido: " + opcion + "\n Su precio es: "+ resultado);
                calificar.setRating(1);
                break;
            }else if(opcion.equals(figuras1.getFiguras()[2]))
            {
                resultado = figuras1.anadirAdicional(figuras1.getPrecios()[1], 350);
                figurados.setVisibility(View.VISIBLE);
                calificar.setRating(i);
                info.setText("Nendo elegido: " + opcion + "\n Su precio es: "+ resultado);
                break;
            }else if(opcion.equals(figuras1.getFiguras()[3])) {
                resultado = figuras1.anadirAdicional(figuras1.getPrecios()[2], 350);
                figuratres.setVisibility(View.VISIBLE);
                calificar.setRating(i);
                info.setText("Nendo elegido: " + opcion + "\n Su precio es: " + resultado);
                break;
            }else if(opcion.equals(figuras1.getFiguras()[4])) {
                resultado = figuras1.anadirAdicional(figuras1.getPrecios()[3], 350);
                figuracuatro.setVisibility(View.VISIBLE);
                calificar.setRating(i);
                info.setText("Nendo elegido: " + opcion + "\n Su precio es: " + resultado);
                break;
            }
        }
    }
}