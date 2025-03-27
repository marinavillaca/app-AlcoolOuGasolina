package com.example.alcoolougasolina;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class page3 extends AppCompatActivity {

    private TextView txtGasolinaPreco, txtAlcoolPreco, txtGasolinaConsumo, txtAlcoolConsumo, textBestChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        Button btnInicio = findViewById(R.id.btn_inicio);
        txtGasolinaPreco = findViewById(R.id.text1);
        txtAlcoolPreco = findViewById(R.id.text2);
        txtGasolinaConsumo = findViewById(R.id.text3);
        txtAlcoolConsumo = findViewById(R.id.text4);
        textBestChoice = findViewById(R.id.textBestChoice);

        if (savedInstanceState != null) {
            txtGasolinaPreco.setText(savedInstanceState.getString("TXT_GASOLINA_PRECO"));
            txtAlcoolPreco.setText(savedInstanceState.getString("TXT_ALCOOL_PRECO"));
            txtGasolinaConsumo.setText(savedInstanceState.getString("TXT_GASOLINA_CONSUMO"));
            txtAlcoolConsumo.setText(savedInstanceState.getString("TXT_ALCOOL_CONSUMO"));
            textBestChoice.setText(savedInstanceState.getString("BEST_CHOICE"));
        } else {
            processarDadosRecebidos();
        }

        btnInicio.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    private void processarDadosRecebidos() {
        String precoGasolina = getIntent().getStringExtra("PRECO_GASOLINA");
        String precoAlcool = getIntent().getStringExtra("PRECO_ALCOOL");
        String consumoGasolina = getIntent().getStringExtra("CONSUMO_GASOLINA");
        String consumoAlcool = getIntent().getStringExtra("CONSUMO_ALCOOL");

        txtGasolinaPreco.setText("Preço Gasolina: " + precoGasolina + " reais");
        txtAlcoolPreco.setText("Preço Álcool: " + precoAlcool + " reais");
        txtGasolinaConsumo.setText("Consumo Gasolina: " + consumoGasolina + " km/L");
        txtAlcoolConsumo.setText("Consumo Álcool: " + consumoAlcool + " km/L");

        float gasolinaP = Float.parseFloat(precoGasolina);
        float gasolinaC = Float.parseFloat(consumoGasolina);
        float alcoolP = Float.parseFloat(precoAlcool);
        float alcoolC = Float.parseFloat(consumoAlcool);

        float razaoGasolina = gasolinaP/gasolinaC;
        float razaoAlcool = alcoolP/alcoolC;

        if(razaoGasolina < razaoAlcool) {
            textBestChoice.setText("Melhor opção: Gasolina");
        } else if(razaoGasolina > razaoAlcool) {
            textBestChoice.setText("Melhor opção: Álcool");
        } else {
            textBestChoice.setText("Equivalentes");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TXT_GASOLINA_PRECO", txtGasolinaPreco.getText().toString());
        outState.putString("TXT_ALCOOL_PRECO", txtAlcoolPreco.getText().toString());
        outState.putString("TXT_GASOLINA_CONSUMO", txtGasolinaConsumo.getText().toString());
        outState.putString("TXT_ALCOOL_CONSUMO", txtAlcoolConsumo.getText().toString());
        outState.putString("BEST_CHOICE", textBestChoice.getText().toString());
    }
}