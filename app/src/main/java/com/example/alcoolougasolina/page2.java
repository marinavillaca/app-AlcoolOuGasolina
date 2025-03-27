package com.example.alcoolougasolina;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity implements View.OnClickListener {
    public EditText txtConsumoGasolina, txtConsumoAlcool;
    private Button btnEnviar1, btnEnviar2, btnAvancar, btnVoltar;
    private boolean consumoGasolinaValidado = false, consumoAlcoolValidado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        btnAvancar = findViewById(R.id.btn_avancar);
        btnVoltar = findViewById(R.id.btn_voltar);
        btnEnviar1 = findViewById(R.id.btn_enviar_1);
        btnEnviar2 = findViewById(R.id.btn_enviar_2);

        txtConsumoGasolina = findViewById(R.id.txt_1);
        txtConsumoAlcool = findViewById(R.id.txt_2);

        if (savedInstanceState != null) {
            txtConsumoGasolina.setText(savedInstanceState.getString("CONSUMO_GASOLINA"));
            txtConsumoAlcool.setText(savedInstanceState.getString("CONSUMO_ALCOOL"));
            consumoGasolinaValidado = savedInstanceState.getBoolean("GASOLINA_VALIDADO");
            consumoAlcoolValidado = savedInstanceState.getBoolean("ALCOOL_VALIDADO");

        }

        btnAvancar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);
        btnEnviar1.setOnClickListener(this);
        btnEnviar2.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("CONSUMO_GASOLINA", txtConsumoGasolina.getText().toString());
        outState.putString("CONSUMO_ALCOOL", txtConsumoAlcool.getText().toString());

        outState.putBoolean("GASOLINA_VALIDADO", consumoGasolinaValidado);
        outState.putBoolean("ALCOOL_VALIDADO", consumoAlcoolValidado);
    }

    @Override
    public void onClick(View view) {
        if (view == btnEnviar1) {
            String consumoGasolinaStr = txtConsumoGasolina.getText().toString().trim();

            if (consumoGasolinaStr.isEmpty()) {
                Toast.makeText(this, "Preencha o consumo da Gasolina.", Toast.LENGTH_SHORT).show();
                consumoGasolinaValidado = false;
                return;
            } else {
                try {
                    Float.parseFloat(consumoGasolinaStr);
                    consumoGasolinaValidado = true;
                    Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Valor inválido. Use ponto como separador decimal.", Toast.LENGTH_SHORT).show();
                    consumoGasolinaValidado = false;
                }
            }
        }

        if (view == btnEnviar2) {
            String consumoAlcoolStr = txtConsumoAlcool.getText().toString().trim();

            if (consumoAlcoolStr.isEmpty()) {
                Toast.makeText(this, "Preencha o consumo do Álcool.", Toast.LENGTH_SHORT).show();
                consumoAlcoolValidado = false;
                return;
            } else {
                try {
                    Float.parseFloat(consumoAlcoolStr);
                    consumoAlcoolValidado = true;
                    Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Valor inválido. Use ponto como separador decimal.", Toast.LENGTH_SHORT).show();
                    consumoAlcoolValidado = false;
                }
            }
        }

        if (view == btnAvancar) {
            if (!consumoGasolinaValidado || !consumoAlcoolValidado) {
                Toast.makeText(this, "Preencha os consumos antes de avançar.", Toast.LENGTH_SHORT).show();
                return;
            }

            String consumoGasolinaStr = txtConsumoGasolina.getText().toString().trim();
            String consumoAlcoolStr = txtConsumoAlcool.getText().toString().trim();

            Intent intent = new Intent(page2.this, page3.class);
            intent.putExtra("PRECO_GASOLINA", getIntent().getStringExtra("PRECO_GASOLINA"));
            intent.putExtra("PRECO_ALCOOL", getIntent().getStringExtra("PRECO_ALCOOL"));
            intent.putExtra("CONSUMO_GASOLINA", consumoGasolinaStr);
            intent.putExtra("CONSUMO_ALCOOL", consumoAlcoolStr);
            startActivity(intent);
        }

        if (view == btnVoltar) {
            finish();
        }
    }
}