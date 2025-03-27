/*
    Autora: Marina Laura Villaça e Melo
    Data: 27/02/2025
    Trabalho 2
    Disciplina: Android
 */

package com.example.alcoolougasolina;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtValorGasolina, txtValorAlcool;
    private Button btnEnviar1, btnEnviar2, btnAvancar;
    private boolean gasolinaValidada = false, alcoolValidado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorGasolina = findViewById(R.id.txt_1);
        txtValorAlcool = findViewById(R.id.txt_2);
        btnEnviar1 = findViewById(R.id.btn_enviar_1);
        btnEnviar2 = findViewById(R.id.btn_enviar_2);
        btnAvancar = findViewById(R.id.btn_avancar);

        if (savedInstanceState != null) {
            txtValorGasolina.setText(savedInstanceState.getString("VALOR_GASOLINA"));
            txtValorAlcool.setText(savedInstanceState.getString("VALOR_ALCOOL"));
            gasolinaValidada = savedInstanceState.getBoolean("GASOLINA_VALIDADA");
            alcoolValidado = savedInstanceState.getBoolean("ALCOOL_VALIDADO");

        }

        btnEnviar1.setOnClickListener(this);
        btnEnviar2.setOnClickListener(this);
        btnAvancar.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("VALOR_GASOLINA", txtValorGasolina.getText().toString());
        outState.putString("VALOR_ALCOOL", txtValorAlcool.getText().toString());
        outState.putBoolean("GASOLINA_VALIDADA", gasolinaValidada);
        outState.putBoolean("ALCOOL_VALIDADO", alcoolValidado);
    }

    @Override
    public void onClick(View view) {
        if (view == btnEnviar1) {
            String valorGasolinaStr = txtValorGasolina.getText().toString().trim();

            if (valorGasolinaStr.isEmpty()) {
                Toast.makeText(this, "Preencha o valor da Gasolina.", Toast.LENGTH_SHORT).show();
                gasolinaValidada = false;
                return;
            }
            else {
                gasolinaValidada = true;
                Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == btnEnviar2) {
            String valorAlcoolStr = txtValorAlcool.getText().toString().trim();

            if (valorAlcoolStr.isEmpty()) {
                Toast.makeText(this, "Preencha o valor do Álcool.", Toast.LENGTH_SHORT).show();
                alcoolValidado = false;
                return;
            } else {
                alcoolValidado = true;
                Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == btnAvancar) {
            if (!gasolinaValidada || !alcoolValidado) {
                Toast.makeText(this, "Preencha os valores antes de avançar.", Toast.LENGTH_SHORT).show();
                return;
            }

            String precoGasolinaStr = txtValorGasolina.getText().toString();
            String precoAlcoolStr = txtValorAlcool.getText().toString();

            Intent intent = new Intent(this, page2.class);
            intent.putExtra("PRECO_GASOLINA", precoGasolinaStr);
            intent.putExtra("PRECO_ALCOOL", precoAlcoolStr);
            startActivity(intent);
        }
    }
}