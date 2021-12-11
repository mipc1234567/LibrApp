package com.example.librapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //Metodo para el boton Buscar_Sesion
    public void volver_menu(View view2){
        Intent volverbuscar = new  Intent(this,MainActivity.class);
        startActivity(volverbuscar);
    }
}
