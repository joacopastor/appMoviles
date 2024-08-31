package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    private TextView helloTextView;
    private EditText nombre;
    private boolean isBlack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView = findViewById(R.id.textoEj);
        nombre = findViewById(R.id.nombre);
        Button saludarBtn = findViewById(R.id.saludarBtn);
        Button colorChangeBtn = findViewById(R.id.colorChangeBtn);

        saludarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = nombre.getText().toString();
                helloTextView.setText("Hola " + name + ", bienvenido/a!!");
            }
        });

        // Cambiar de color el fondo
        colorChangeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (isBlack) {
                    v.getRootView().setBackgroundColor(Color.WHITE); // Cambia el fondo a blanco
                    helloTextView.setTextColor(Color.BLACK);
                    nombre.setTextColor(Color.BLACK);
                } else {
                    v.getRootView().setBackgroundColor(Color.BLACK);// Cambia el fondo a negro
                    helloTextView.setTextColor(Color.WHITE);
                    nombre.setTextColor(Color.WHITE);
                }
                isBlack = !isBlack; // Alterna el valor de isBlack
            }
        });

    }

}