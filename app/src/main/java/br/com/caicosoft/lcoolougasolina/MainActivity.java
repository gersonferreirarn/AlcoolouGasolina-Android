package br.com.caicosoft.lcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPrecoAlcool, etPrecoGasolina;
    Button btnCalcular;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrecoAlcool = findViewById(R.id.etPrecoAlcool);
        etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPreco();
            }
        });
    }

    public void calcularPreco(){
        String precoAlcool = etPrecoAlcool.getText().toString();
        String precoGasolina = etPrecoGasolina.getText().toString();

        if(validaCampos(precoAlcool, precoGasolina)){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            tvResultado.setText(R.string.campos_nao_preenchidos);
        }
    }

    public Boolean validaCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if((pAlcool == null || pAlcool.equals("")) || (pGasolina == null) || pGasolina.equals(""))
            camposValidados = false;

        return camposValidados;
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        if(precoAlcool/precoGasolina >= 0.7){
            tvResultado.setText(R.string.melhor_gasolina);
        }else{
            tvResultado.setText(R.string.melhor_alcool);
        }
    }
}
