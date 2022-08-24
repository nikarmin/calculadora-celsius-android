package br.unicamp.conversorcelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ConversoesActivity extends AppCompatActivity {

    TextView tvResultado, tvText;
    Button btnVoltar;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversoes);
        setTitle("Conversor de Celsius");

        btnVoltar = findViewById(R.id.btnVoltar);
        view = findViewById(R.id.view);
        tvText = findViewById(R.id.textView2);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        Double valor = params.getDouble("chaveValor");
        String nome = params.getString("chaveNome");
        Boolean isDark = params.getBoolean("isDark");

        tvResultado = findViewById(R.id.tvResultado);

        if (isDark){
            view.setBackgroundColor(Color.parseColor("#2C3333"));
            tvText.setTextColor(Color.parseColor("#F2F2F2"));
            tvResultado.setTextColor(Color.parseColor("#F2F2F2"));
        }

        if (nome.toString().equals("FAHRENHEIT"))
            tvResultado.setText("Valor: " + valor.toString() + "F");
        else
            tvResultado.setText("Valor: " + valor.toString() + "K");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConversoesActivity.this, MainActivity.class);
                Bundle param = new Bundle();

                startActivity(intent);
            }
        });
    }
}