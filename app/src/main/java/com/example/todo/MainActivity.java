package com.example.todo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.models.Functions;

public class MainActivity extends AppCompatActivity implements Functions {

    // atributos

    private EditText nombre,datos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.entrada);
        datos = (EditText) findViewById(R.id.entrada2);
    }

    // metodos abstractos

    @Override
    public void guardar(View view) {
        String getNombre = nombre.getText().toString();
        String getDatos = datos.getText().toString();
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorObjeto = preferences.edit();
        editorObjeto.putString(getNombre, getDatos);
        editorObjeto.commit();
        Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void buscar(View view) {
        String getNombre = nombre.getText().toString();
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String getDatos = preferences.getString(getNombre, "");

        if (getDatos.length() == 0){
            Toast.makeText(this, "No se ha encontrado a " + getNombre, Toast.LENGTH_SHORT).show();

        }
        else {
            datos.setText(getDatos);
        }
    }

    @Override
    public void limpiar(View view) {
        nombre.setText("");
        datos.setText("Work");
    }
}