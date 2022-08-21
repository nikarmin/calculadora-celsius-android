package br.unicamp.conversorcelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ConversoesActivity extends AppCompatActivity {

    TextView tvResultado;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversoes);
        setTitle("Conversor de Celsius");

        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        Double valor = params.getDouble("chaveValor");
        String nome = params.getString("chaveNome");

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText("Valor: " + valor.toString() + " " + nome.toString());

        //tvResultado.setText("Resultado "+ nome.toLowerCase(Locale.ROOT) + ": " + valor.toString());

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConversoesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}