package com.example.librapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }
    //Metodo para el boton Cerrar Sesion
    public void cerrar_sesion(View view){
        Intent cerrar = new  Intent(this,Main.class);
        startActivity(cerrar);
    }
}