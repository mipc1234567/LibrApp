package com.example.librapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Busqueda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }


    //Metodo para el boton Buscar_Sesion
    public void volver_buscar(View view2){
        Intent volverbuscar = new  Intent(this,Busqueda.class);
        startActivity(volverbuscar);
    }
}
