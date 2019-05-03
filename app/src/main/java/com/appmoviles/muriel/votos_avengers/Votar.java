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

import static com.appmoviles.muriel.votos_avengers.Pregunta_Segmento.H_ADOLESCENTES;
import static com.appmoviles.muriel.votos_avengers.Pregunta_Segmento.H_ADULTOS;
import static com.appmoviles.muriel.votos_avengers.Pregunta_Segmento.M_ADOLESCENTES;
import static com.appmoviles.muriel.votos_avengers.Pregunta_Segmento.M_ADULTAS;
import static com.appmoviles.muriel.votos_avengers.Pregunta_Segmento.NINIOS;

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
    public final static String ESTADISTICAS = "Estadisticas_Totales";
    public final static String TOTAL_VOTOS = "Total_Votos";

    /**
    public final static String TOTAL_SPIDERMAN = "total_spiderman";
    public final static String TOTAL_IRONMAN = "total_iron_man";
    public final static String TOTAL_CAPITAN = "total_capitan_america";
    public final static String TOTAL_CAPITANA = "total_capitana america";
    public final static String TOTAL_HULK = "total_hulk";
    public final static String TOTAL_VIUDA = "total_viuda_negra";
    public final static String TOTAL_THOR = "total_thor";
    public final static String TOTAL_DOCTOR = "total_doctor_strange";

    public final static String TOTAL_M_ADULTAS = "total_m_adultas";
    public final static String TOTAL_H_ADULTOS = "total_h_adultos";
    public final static String TOTAL_M_ADOLESCENTES = "total_m_adolescentes";
    public final static String TOTAL_H_ADOLESCENTES = "total_h_adolescentes";
    public final static String TOTAL_NINIOS = "total_ninios";
     */

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

         //Solo para crear la estructura de la DB - SOLO SE USA UNA VEZ

        /**
         database.getReference().child(ESTADISTICAS).child(TOTAL_VOTOS).child(CANTIDAD).setValue("0");

         database.getReference().child(ESTADISTICAS).child(CAPITAN).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(CAPITANA).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(DOCTOR).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(HULK).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(IRONMAN).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(SPIDERMAN).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(THOR).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(VIUDA).child(CANTIDAD).setValue("0");

         database.getReference().child(ESTADISTICAS).child(H_ADOLESCENTES).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(M_ADOLESCENTES).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(H_ADULTOS).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(M_ADULTAS).child(CANTIDAD).setValue("0");
         database.getReference().child(ESTADISTICAS).child(NINIOS).child(CANTIDAD).setValue("0");

         database.getReference().child(SUPERHEROES).child(SPIDERMAN).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(SPIDERMAN).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(CAPITAN).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(CAPITANA).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(HULK).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(VIUDA).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(THOR).child(segmento_escogido).child(CANTIDAD).setValue("0");
         database.getReference().child(SUPERHEROES).child(DOCTOR).child(segmento_escogido).child(CANTIDAD).setValue("0");
         */

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.votar_btn_registrar:

                //Mira cual RadioButton esta seleccionado
                if (votar_rb_spiderman.isChecked()) {
                    sumarMasUno(SPIDERMAN);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_ironman.isChecked()) {
                    sumarMasUno(IRONMAN);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_capitan_america.isChecked()) {
                    sumarMasUno(CAPITAN);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_capitana_marvel.isChecked()) {
                    sumarMasUno(CAPITANA);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_hulk.isChecked()) {
                    sumarMasUno(HULK);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_viuda_negra.isChecked()) {
                    sumarMasUno(VIUDA);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);

                } else if (votar_rb_thor.isChecked()) {
                    sumarMasUno(THOR);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else if (votar_rb_doctor_strange.isChecked()) {
                    sumarMasUno(DOCTOR);
                    Intent i = new Intent(Votar.this, Estadisticas.class);
                    startActivity(i);
                    mostrarMensaje("Se registró el voto con éxito");

                } else {
                    mostrarMensaje("Debe seleccionar un superhéroe");
                }

                break;
        }

    }

    //Suma +1 al superheroe pasado por parametro en un segmento específico
    public void sumarMasUno(final String superheroe) {

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

        //Suma +1 al supeheroe , al total y al segmento respectivo (los siguientes métodos)
        sumarMasUnoSuperheroe(superheroe);
        sumarMasUnoSegmento(segmento_escogido);
        sumarMasUnoTotal();
    }


    //Suma +1 al segmento pasado por parametro
    public void sumarMasUnoSegmento(final String segmento_para) {

        database.getReference().child(ESTADISTICAS).child(segmento_para).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int cantidad = 0;
                cantidad = Integer.parseInt(dataSnapshot.getValue().toString());
                cantidad += 1;
                database.getReference().child(ESTADISTICAS).child(segmento_para).child(CANTIDAD).setValue("" + cantidad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //Suma +1 al total de votos de un superheroe
    public void sumarMasUnoSuperheroe(final String superheroe) {

        database.getReference().child(ESTADISTICAS).child(superheroe).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int cantidad = 0;
                cantidad = Integer.parseInt(dataSnapshot.getValue().toString());
                cantidad += 1;
                database.getReference().child(ESTADISTICAS).child(superheroe).child(CANTIDAD).setValue("" + cantidad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    //Le suma +1 a el total de votos guardados en la DB
    public void sumarMasUnoTotal() {

        database.getReference().child(ESTADISTICAS).child(TOTAL_VOTOS).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int cantidad = 0;
                cantidad = Integer.parseInt(dataSnapshot.getValue().toString());
                cantidad += 1;
                database.getReference().child(ESTADISTICAS).child(TOTAL_VOTOS).child(CANTIDAD).setValue("" + cantidad);
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
