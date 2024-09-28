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

    private EditText etWeight, etDimensions, etDestination;
    private Button btnCalculate;
    private LinearLayout llFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la vista
        etWeight = findViewById(R.id.etWeight);
        etDimensions = findViewById(R.id.etDimensions);
        etDestination = findViewById(R.id.etDestination);
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
        String peso = etWeight.getText().toString();
        String dimensiones = etDimensions.getText().toString();
        String destino = etDestination.getText().toString();

        // Lógica simplificada para estimar precio y tiempo
        double precioEstimado = calcularPrecio(peso, dimensiones);
        String fechaEntrega = calcularFechaEntrega(destino);

        // Crear y agregar TextView dinámico para mostrar resultados
        TextView tvResult = new TextView(this);
        tvResult.setText("Precio Estimado: $" + precioEstimado + "\nFecha Estimada de Entrega: " + fechaEntrega);
        tvResult.setTextSize(16);
        llFields.addView(tvResult);
    }

    // Función que simula el cálculo del precio basado en el peso y dimensiones
    private double calcularPrecio(String peso, String dimensiones) {
        // Simplificación: convertir peso a double y aplicar un factor de coste
        double pesoDouble = peso.isEmpty() ? 0 : Double.parseDouble(peso);
        return pesoDouble * 10; // Factor de coste arbitrario para el ejemplo
    }

    // Función que simula el cálculo de la fecha de entrega basada en el destino
    private String calcularFechaEntrega(String destino) {
        // Simplificación: retorno de fecha fija
        return "5-7 días hábiles";
    }
}
