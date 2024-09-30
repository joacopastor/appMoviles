package com.example.practicas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private EditText weight, destination, adress, altura, longitud , width ;
    private Button btnCalculate;
    private LinearLayout llFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elementos
        weight = findViewById(R.id.weight);
        destination = findViewById(R.id.destination);
        altura = findViewById(R.id.alto);
        longitud = findViewById(R.id.largo);
        width = findViewById(R.id.ancho);
        adress = findViewById(R.id.adress);
        btnCalculate = findViewById(R.id.btnCalculate);
        llFields = findViewById(R.id.llFields);

        // Evento onClick para el botón de calcular
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEnvio();
            }
        });
    }

    // Método para calcular el envío y mostrar resultados
    private void calcularEnvio() {
        TextView error = new TextView(this);

        String peso = weight.getText().toString();
        String alto = altura.getText().toString();
        String largo = longitud.getText().toString();
        String ancho = width.getText().toString();
        String destino = destination.getText().toString();

        // Lógica simplificada para estimar precio y tiempo
        double precioEstimado = calcularPrecio(peso, alto,largo,ancho );
        String fechaEntrega = calcularFechaEntrega(destino);

        if(alto.isEmpty() || largo.isEmpty() || ancho.isEmpty()){
            // Crear y agregar TextView dinámico para mostrar resultados
            llFields.removeView(error);
            error.setText("Ingrese los datos faltantes");
            error.setTextSize(20);
            llFields.addView(error);
        }else{
            // TextView dinámico para mostrar resultados
            TextView tvResult = new TextView(this);
            tvResult.setText("Precio Estimado: $" + precioEstimado + "\nFecha Estimada de Entrega: " + fechaEntrega);
            tvResult.setTextSize(20);
            llFields.addView(tvResult);
        }

    }

    // Función que simula el cálculo del precio basado en el peso y dimensiones
    private double calcularPrecio(String peso, String alto, String largo, String ancho) {
        TextView error = new TextView(this);

        //  convertir a double y aplicar un factor de coste
        double pesoDouble = peso.isEmpty() ? 0 : Double.parseDouble(peso);
        double altoDouble = alto.isEmpty() ? 0 : Double.parseDouble(alto);
        double anchoDouble = ancho.isEmpty() ? 0 : Double.parseDouble(ancho);
        double largoDouble = largo.isEmpty() ? 0 : Double.parseDouble(largo);
        double precio;

        if (alto.isEmpty() || largo.isEmpty() || ancho.isEmpty() ){
          // llFields.removeView(error);
          // // Crear y agregar TextView dinámico para mostrar Error
          // error.setText("Ingrese los datos faltantes");
          // error.setTextSize(20);
          // llFields.addView(error);
            precio = 0;
        } else {
            double size = altoDouble * anchoDouble *  largoDouble;
            if (size < 1000) {
                precio = size * 10;
                return precio;
            }else {
                precio = size * 15;
                return precio;
            }
        }

        return precio;
    }

    // Función que simula el cálculo de la fecha de entrega basada en el destino
    private String calcularFechaEntrega(String destino) {
        // Simplificación: retorno de fecha fija
        return "5-7 días hábiles";
    }
}
