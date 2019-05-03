package com.appmoviles.muriel.votos_avengers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pregunta_Segmento extends AppCompatActivity implements View.OnClickListener {

    private RadioButton pregunta_segmento_rb_m_adultas;
    private RadioButton pregunta_segmento_rb_h_adultas;
    private RadioButton pregunta_segmento_rb_m_adolescentes;
    private RadioButton pregunta_segmento_rb_h_adolescentes;
    private RadioButton pregunta_segmento_rb_ninos;

    private Button pregunta_segmento_btn_registrar;


    //CONSTANTES SEGMENTOS
    public final static String SEGMENTO = "Segmentos";

    public final static String M_ADULTAS = "m_adultas";
    public final static String H_ADULTOS = "h_adultos";
    public final static String M_ADOLESCENTES = "m_adolescentes";
    public final static String H_ADOLESCENTES = "h_adolescentes";
    public final static String NINIOS = "ninios";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_segmento);

        pregunta_segmento_rb_m_adultas = findViewById(R.id.pregunta_segmento_rb_m_adultas);
        pregunta_segmento_rb_h_adultas = findViewById(R.id.pregunta_segmento_rb_h_adultas);
        pregunta_segmento_rb_m_adolescentes = findViewById(R.id.pregunta_segmento_rb_m_adolescentes);
        pregunta_segmento_rb_h_adolescentes = findViewById(R.id.pregunta_segmento_rb_h_adolescentes);
        pregunta_segmento_rb_ninos = findViewById(R.id.pregunta_segmento_rb_ninos);

        pregunta_segmento_btn_registrar = findViewById(R.id.pregunta_segmento_btn_registrar);
        pregunta_segmento_btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.pregunta_segmento_btn_registrar:

                Intent i = new Intent(Pregunta_Segmento.this, Votar.class);

                //Mira cual RadioButton está seleccionado
                if (pregunta_segmento_rb_m_adultas.isChecked()) {
                    i.putExtra(SEGMENTO, M_ADULTAS);
                    startActivity(i);
                } else if (pregunta_segmento_rb_h_adultas.isChecked()) {
                    i.putExtra(SEGMENTO, H_ADULTOS);
                    startActivity(i);
                } else if (pregunta_segmento_rb_m_adolescentes.isChecked()) {
                    i.putExtra(SEGMENTO, M_ADOLESCENTES);
                    startActivity(i);
                } else if (pregunta_segmento_rb_h_adolescentes.isChecked()) {
                    i.putExtra(SEGMENTO, H_ADOLESCENTES);
                    startActivity(i);
                } else if (pregunta_segmento_rb_ninos.isChecked()) {
                    i.putExtra(SEGMENTO, NINIOS);
                    startActivity(i);
                } else {
                    mostrarMensaje("Debe seleccionar un segmento");
                }
                break;

        }

    }

    public void mostrarMensaje(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}
