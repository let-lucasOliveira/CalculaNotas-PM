package com.example.calculanotas;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button calcBtn, clearBtn;
    EditText subjectTxt, nota1Txt, nota2Txt, faltasTxt;
    TextView averageTV, statusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Definindo campos do form como variáveis
        calcBtn = (Button) findViewById(R.id.calc_btn);
        clearBtn = (Button) findViewById(R.id.clearForm_btn);

        subjectTxt = (EditText) findViewById(R.id.subject_txt);
        nota1Txt = (EditText) findViewById(R.id.nota1_txt);
        nota2Txt = (EditText) findViewById(R.id.nota2_txt);
        faltasTxt = (EditText) findViewById(R.id.faltas_txt);

        averageTV = (TextView) findViewById(R.id.average_txtv);
        statusTV = (TextView) findViewById(R.id.status_txtv);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nota1, nota2, media;
                int faltas;
                String situacao;

                nota1 = Double.parseDouble(nota1Txt.getText().toString());
                nota2 = Double.parseDouble(nota2Txt.getText().toString());
                faltas = Integer.parseInt(faltasTxt.getText().toString());
                media = (nota1 + nota2) / 2;

                averageTV.setText(String.valueOf(media));

                if (media >= 7 && faltas <= 5) {
                    situacao = "Aprovado";
                    statusTV.setText(situacao);
                }else {
                    situacao = "Retido";
                    statusTV.setText(situacao);
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                subjectTxt.setText("");
                nota1Txt.setText("");
                nota2Txt.setText("");
                averageTV.setText("__________");
                statusTV.setText("__________");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}