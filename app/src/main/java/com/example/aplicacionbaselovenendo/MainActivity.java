package com.example.aplicacionbaselovenendo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.ADMINISTRADOR;
import Objetos.Figuras;

public class MainActivity extends AppCompatActivity {

    private EditText user,pass;
    private TextView msj;
    private Button btn;
    private ProgressBar pb;
    private ADMINISTRADOR us = new ADMINISTRADOR();
    private Figuras fi = new Figuras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtuser);
        pass = findViewById(R.id.txtpass);
        msj = findViewById(R.id.tvmsj);
        btn = findViewById(R.id.btn);
        pb = findViewById(R.id.pb);

        pb.setVisibility(View.INVISIBLE);
        msj.setVisibility(View.INVISIBLE);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
                //Correr mi tarea asincrona...

            }
        });

    }

    class Task extends AsyncTask<String, Void, String>
    {
        //define la configuracion inicial de la tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }
        //realiza el proceso en segundo plano o mi tarea pesada

        @Override
        protected String doInBackground(String... strings) {
            try
            {
                for(int i = 0; i<= 10; i++)
                {
                    Thread.sleep(500);
                }
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        //Finaliza nuestra tarea
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);
            //valores que ingresa el cliente en los edittext
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            //valores del objeto ADMINISTRADOR
            String userObj = us.getUser().trim();
            String passObj = us.getPass().trim();


            switch (usuario)
            {
                case "Joao":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        //Vaciar campos...
                        user.setText("");
                        pass.setText("");


                        //Inicia sesión...
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        //Preparo Extras
                        Bundle bun = new Bundle();// Necesario para enviar arreglos.
                        bun.putStringArray("figuras", fi.getFiguras());//Rellenar el bundle.
                        i.putExtras(bun);// enviamos el bundle a tracés del intent.
                        startActivity(i);


                    }
                    break;
                case "":
                    if(usuario.equals("") && contrasena.isEmpty())
                    {
                        //Campos vacios...
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacíos intente nuevamente.");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos erroneos porfavor ingresa nuevamente.");
                    }




            }
        }
    }
    public void Info(View view)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);

    }
    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);

    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);

    }
    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);

    }

}