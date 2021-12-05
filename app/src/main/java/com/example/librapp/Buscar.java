package com.example.librapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Buscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    //Metodo para el boton Buscar_Sesion
    public void volver_buscar(View view2){
        Intent volverbuscar = new  Intent(this,MainActivity.class);
        startActivity(volverbuscar);
    }
}