package com.appmoviles.muriel.votos_avengers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Votar extends AppCompatActivity implements View.OnClickListener {

    private RadioButton votar_rb_spiderman;
    private RadioButton votar_rb_ironman;
    private RadioButton votar_rb_capitan_america;
    private RadioButton votar_rb_capitana_marvel;
    private RadioButton votar_rb_hulk;
    private RadioButton votar_rb_viuda_negra;
    private RadioButton votar_rb_thor;
    private RadioButton votar_rb_doctor_strange;

    private Button votar_btn_registrar;

    private String segmento_escogido;

    //CONSTANTES
    public final static String SPIDERMAN = "spiderman";
    public final static String IRONMAN = "iron_man";
    public final static String CAPITAN = "capitan_america";
    public final static String CAPITANA = "capitana america";
    public final static String HULK = "hulk";
    public final static String VIUDA = "viuda_negra";
    public final static String THOR = "thor";
    public final static String DOCTOR = "doctor_strange";

    public final static String CANTIDAD = "Cantidad";
    public final static String SUPERHEROES = "Superheroes";

    //FireBase
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votar);

        database = FirebaseDatabase.getInstance();

        Bundle bundle = getIntent().getExtras();

        segmento_escogido = "";
        segmento_escogido = bundle.get(Pregunta_Segmento.SEGMENTO).toString();

        votar_rb_spiderman = findViewById(R.id.votar_rb_spiderman);
        votar_rb_ironman = findViewById(R.id.votar_rb_ironman);
        votar_rb_capitan_america = findViewById(R.id.votar_rb_capitan_america);
        votar_rb_capitana_marvel = findViewById(R.id.votar_rb_capitana_marvel);
        votar_rb_hulk = findViewById(R.id.votar_rb_hulk);
        votar_rb_viuda_negra = findViewById(R.id.votar_rb_viuda_negra);
        votar_rb_thor = findViewById(R.id.votar_rb_thor);
        votar_rb_doctor_strange = findViewById(R.id.votar_rb_doctor_strange);

        votar_btn_registrar = findViewById(R.id.votar_btn_registrar);
        votar_btn_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.votar_btn_registrar:

                //Mira cual RadioButton esta seleccionado
                if (votar_rb_spiderman.isChecked()) {
                    sumarMasUno(SPIDERMAN);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_ironman.isChecked()) {
                    sumarMasUno(IRONMAN);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_capitan_america.isChecked()) {
                    sumarMasUno(CAPITAN);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_capitana_marvel.isChecked()) {
                    sumarMasUno(CAPITANA);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_hulk.isChecked()) {
                    sumarMasUno(HULK);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_viuda_negra.isChecked()) {
                    sumarMasUno(VIUDA);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_thor.isChecked()) {
                    sumarMasUno(THOR);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else if (votar_rb_doctor_strange.isChecked()) {
                    sumarMasUno(DOCTOR);
                    mostrarMensaje("Se registró el voto con éxito");
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                } else {
                    mostrarMensaje("Debe seleccionar un superhéroe");
                }

        }

    }


    public void sumarMasUno(final String superheroe){

        database.getReference().child(SUPERHEROES).child(superheroe).child(segmento_escogido).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int cantidad = 0;
                cantidad = Integer.parseInt(dataSnapshot.getValue().toString());
                cantidad += 1;
                database.getReference().child(SUPERHEROES).child(superheroe).child(segmento_escogido).child(CANTIDAD).setValue("" + cantidad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void mostrarMensaje(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}
