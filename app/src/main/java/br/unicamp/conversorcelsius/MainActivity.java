package br.unicamp.conversorcelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button fah, kel;
    EditText celsius;
    TextView error, txtUm, txtDois;
    Switch theme;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Conversor de Celsius");

        fah = findViewById(R.id.btnFahrenheit);
        kel = findViewById(R.id.btnKelvin);
        celsius = findViewById(R.id.edtCelsius);
        error = findViewById(R.id.tvErr);
        theme = findViewById(R.id.switchTheme);
        view = findViewById(R.id.view);
        txtUm = findViewById(R.id.textView);
        txtDois = findViewById(R.id.textView2);

        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (theme.isChecked()){
                    theme.setTextColor(Color.parseColor("#F2F2F2"));
                    txtUm.setTextColor(Color.parseColor("#F2F2F2"));
                    txtDois.setTextColor(Color.parseColor("#F2F2F2"));
                    view.setBackgroundColor(Color.parseColor("#2C3333"));
                }

                else{
                    theme.setTextColor(Color.BLACK);
                    txtUm.setTextColor(Color.BLACK);
                    txtDois.setTextColor(Color.BLACK);
                    view.setBackgroundColor(getResources().getColor(android.R.color.system_accent1_0));
                }
            }
        });

        fah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valor = celsius.getText().toString();

                if (!valor.equals(""))
                {
                    Intent intent = new Intent(MainActivity.this, ConversoesActivity.class);
                    Bundle param = new Bundle();

                    Double valorF = 0.0;

                    valorF = (Double.parseDouble(valor) * 9) / 5 + 32;
                    String nome =  fah.getText().toString();

                    param.putDouble("chaveValor", valorF);
                    param.putString("chaveNome", nome);

                    intent.putExtras(param);
                    startActivity(intent);
                }
                else
                    error.setVisibility(View.VISIBLE);

            }
        });

        kel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String valor = celsius.getText().toString();

                    if (!valor.equals(""))
                    {
                        Intent intent = new Intent(MainActivity.this, ConversoesActivity.class);
                        Bundle param = new Bundle();

                        Double valorK = 0.0;

                        valorK = (Double.parseDouble(valor)) + 273.15;
                        String nome =  kel.getText().toString();

                        param.putDouble("chaveValor", valorK);
                        param.putString("chaveNome", nome);

                        intent.putExtras(param);
                        startActivity(intent);
                    }
                    else
                        error.setVisibility(View.VISIBLE);
            }
        });
    }
}