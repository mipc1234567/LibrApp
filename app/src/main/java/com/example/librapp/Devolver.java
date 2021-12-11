package com.example.librapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.OnCompleteListener;

public class Devolver extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devolver);

    }


    //Metodo para el boton volver
    public void volver_sesion(View view){
        Intent volver;
        volver = new  Intent(this,MainActivity.class);
        startActivity(volver);
    }
}