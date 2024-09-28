package com.example.trabalho1bimestre;

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

    private EditText edNome;
    private EditText edEmail;
    private EditText edIdade;
    private EditText edDisciplina;
    private EditText edNota1;
    private EditText edNota2;
    private TextView tvErro;
    private Button btEnviar;
    private TextView tvResultado;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edIdade = findViewById(R.id.edIdade);
        edDisciplina = findViewById(R.id.edDisciplina);
        edNota1 = findViewById(R.id.edNota1);
        edNota2 = findViewById(R.id.edNota2);
        tvErro = findViewById(R.id.tvErro);
        btEnviar = findViewById(R.id.btEnviar);
        tvResultado = findViewById(R.id.tvResultado);
        btLimpar = findViewById(R.id.btLimpar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNome = edNome.getText().toString();
                String strEmail = edEmail.getText().toString();
                String strIdade = edIdade.getText().toString();
                String strDisciplina = edDisciplina.getText().toString();
                String strNota1 = edNota1.getText().toString();
                String strNota2 = edNota2.getText().toString();

                String strCampoVazio = "";

                if (strNome.isEmpty()){
                    strCampoVazio += "Nome, ";
                }
                if (strEmail.isEmpty()){
                    strCampoVazio += "Email, ";
                }
                if (strIdade.isEmpty()){
                    strCampoVazio += "Idade, ";
                }
                if (strDisciplina.isEmpty()){
                    strCampoVazio += "Disciplina, ";
                }
                if (strNota1.isEmpty()){
                    strCampoVazio += "Nota 1, ";
                }
                if (strNota2.isEmpty()){
                    strCampoVazio += "Nota 2, ";
                }
                if (!strCampoVazio.isEmpty()){
                    tvErro.setText("Os campos "+ strCampoVazio+ " precisam ser preenchidos.");
                    return;
                }else {
                    tvErro.setText("");
                }

                String strCampoInvalido = "";

                if (strNome.length() > 60) {
                    strCampoInvalido += "\nNome deve ter no máximo 60 caracteres.";
                }
                if (!strEmail.contains("@")) {
                    strCampoInvalido += "\nEmail inválido.";
                }
                if (strEmail.length() > 100) {
                    strCampoInvalido += "\nEmail deve ter no máximo 100 caracteres.";
                }
                try {
                    int idade = Integer.parseInt(strIdade);

                    if (idade < 0 || idade > 150) {
                        strCampoInvalido += "\nIdade Inválida";
                    }
                } catch (NumberFormatException e) {
                    strCampoInvalido += "\nA idade deve ser um número inteiro.";
                }
                if (strDisciplina.length() > 60) {
                    strCampoInvalido += "\nDisciplina deve ter no máximo 60 caracteres.";
                }
                try {
                    double nota1 = Double.parseDouble(strNota1);

                    if (nota1 < 0 || nota1 > 10) {
                        strCampoInvalido += "\nNota 1 Inválida";
                    }
                } catch (NumberFormatException e) {
                    strCampoInvalido += "\nA nota 1 deve ser um número.";
                    tvErro.setText(strCampoInvalido);
                }
                try {
                    double nota2 = Double.parseDouble(strNota2);

                    if (nota2 < 0 || nota2 > 10) {
                        strCampoInvalido += "\nNota 2 Inválida";
                    }
                } catch (NumberFormatException e) {
                    strCampoInvalido += "\nA nota 2 deve ser um número.";
                    tvErro.setText(strCampoInvalido);
                }

                if (!strCampoInvalido.isEmpty()) {
                    tvErro.setText(strCampoInvalido);
                    return;
                } else {
                    tvErro.setText("");
                }

                double nota1 = Double.parseDouble(strNota1);
                double nota2 = Double.parseDouble(strNota2);
                double media = (nota1 + nota2) / 2;

                String msgMedia = "";

                if (media < 6) {
                    msgMedia += "\nAluno Reprovado";
                } else {
                    msgMedia += "\nAluno Aprovado";
                }


                    tvResultado.setText("Nome: " + strNome + "\nEmail: " + strEmail +
                            "\nIdade: " + strIdade + "\nDisciplina: " + strDisciplina +
                            "\nNota 1: " + strNota1 + "\nNota 2: " + strNota2 + "\nMédia: "+ media+ "\n"+ msgMedia);


            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNome.setText("");
                edEmail.setText("");
                edIdade.setText("");
                edDisciplina.setText("");
                edNota1.setText("");
                edNota2.setText("");
                tvErro.setText("");
                tvResultado.setText("");
            }
        });



    }
}