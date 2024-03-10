package com.brito.conversormedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText txtDe;

    EditText txtPara;

    RadioButton rbPolegasCen;
    RadioButton rbCentimetroPol;
    RadioButton rbPesMetros;
    RadioButton rbMetrosPes;

    RadioButton rbMilhaKm;
    RadioButton rbQuilosLIbras;

    Button btnConverter;

    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDe = findViewById(R.id.txtDe);
        txtPara = findViewById(R.id.txtPara);

        rbPolegasCen = findViewById(R.id.rbPolegadasCen);
        rbCentimetroPol = findViewById(R.id.rbCentimetroPol);
        rbPesMetros = findViewById(R.id.rbPesMetros);
        rbMetrosPes = findViewById(R.id.rbMetrosPes);
        rbMilhaKm = findViewById(R.id.rbMilhaKm);
        rbQuilosLIbras = findViewById(R.id.rbQuilosLibras);

        btnConverter = findViewById(R.id.btnConverter);
        btnLimpar = findViewById(R.id.btnLimpar);


        btnConverter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float valorDe = Float.parseFloat(txtDe.getText().toString());
                float conta = 0;
                float resultado = 0;


                if(rbPolegasCen.isChecked()){
                    conta = (valorDe* (float) 2.54);
                    resultado = conta;
                } else if (rbCentimetroPol.isChecked()) {
                    conta = (valorDe  / (float) 2.54);
                    resultado = conta;
                } else if (rbPesMetros.isChecked()) {
                    conta = (valorDe / (float) 3.281);
                    resultado = conta;

                } else if (rbMetrosPes.isChecked()) {
                    conta = (valorDe * (float) 3.281);
                    resultado = conta;

                } else if (rbMilhaKm.isChecked()) {
                    conta = (valorDe * (float) 1609);
                    resultado = conta;

                } else if (rbQuilosLIbras.isChecked()) {
                            conta = (valorDe  * (float) 2.205);
                            resultado = conta;
                        }

                        txtPara.setText(String.valueOf(resultado));
                }
        });

        //Botão responsável por limpar campos
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                txtDe.getText().clear();
                txtPara.getText().clear();

                txtDe.requestFocus();
            }
        });

    }
}