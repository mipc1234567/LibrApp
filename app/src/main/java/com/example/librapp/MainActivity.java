package com.example.librapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**public class ProviderType<BASIC> {
    BASIC
}
 */


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
    public void cerrar_sesion(View view) {
        Intent cerrar;
        cerrar = new Intent(this, Main.class);
        startActivity(cerrar);
    }

    //Metodo para el boton Buscar_Sesion
    public void buscar(View view2) {
        Intent buscar;
        buscar = new Intent(this, Buscar.class);
        startActivity(buscar);

    }
}
