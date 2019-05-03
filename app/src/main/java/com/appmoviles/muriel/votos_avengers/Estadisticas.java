package com.appmoviles.muriel.votos_avengers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.appmoviles.muriel.votos_avengers.Votar.CANTIDAD;
import static com.appmoviles.muriel.votos_avengers.Votar.CAPITAN;
import static com.appmoviles.muriel.votos_avengers.Votar.CAPITANA;
import static com.appmoviles.muriel.votos_avengers.Votar.DOCTOR;
import static com.appmoviles.muriel.votos_avengers.Votar.ESTADISTICAS;
import static com.appmoviles.muriel.votos_avengers.Votar.HULK;
import static com.appmoviles.muriel.votos_avengers.Votar.IRONMAN;
import static com.appmoviles.muriel.votos_avengers.Votar.SPIDERMAN;
import static com.appmoviles.muriel.votos_avengers.Votar.THOR;
import static com.appmoviles.muriel.votos_avengers.Votar.TOTAL_VOTOS;
import static com.appmoviles.muriel.votos_avengers.Votar.VIUDA;

public class Estadisticas extends AppCompatActivity implements View.OnClickListener {

    private TextView estadisticas_tv_banner;

    public final static String banner_1 = "PORCENTAJES PARA:";

    public final static String TODO_PUBLICO = "TODO PÚBLICO";


    private TextView estadisticas_tv_spiderman;
    private TextView estadisticas_tv_ironman;
    private TextView estadisticas_tv_capitan;
    private TextView estadisticas_tv_capitana;
    private TextView estadisticas_tv_hulk;
    private TextView estadisticas_tv_viuda;
    private TextView estadisticas_tv_thor;
    private TextView estadisticas_tv_doctor;


    private RadioButton estadisticas_rb_m_adultas;
    private RadioButton estadisticas_rb_h_adultas;
    private RadioButton estadisticas_rb_m_adolescentes;
    private RadioButton estadisticas_rb_h_adolescentes;
    private RadioButton estadisticas_rb_ninos;


    //FireBase
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        database = FirebaseDatabase.getInstance();

        estadisticas_tv_spiderman = findViewById(R.id.estadisticas_tv_spiderman);
        estadisticas_tv_ironman = findViewById(R.id.estadisticas_tv_ironman);
        estadisticas_tv_capitan = findViewById(R.id.estadisticas_tv_capitan);
        estadisticas_tv_capitana = findViewById(R.id.estadisticas_tv_capitana);
        estadisticas_tv_hulk = findViewById(R.id.estadisticas_tv_hulk);
        estadisticas_tv_viuda = findViewById(R.id.estadisticas_tv_viuda);
        estadisticas_tv_thor = findViewById(R.id.estadisticas_tv_thor);
        estadisticas_tv_doctor = findViewById(R.id.estadisticas_tv_doctor);

        estadisticas_rb_m_adultas = findViewById(R.id.estadisticas_rb_m_adultas);
        estadisticas_rb_h_adultas = findViewById(R.id.estadisticas_rb_h_adultas);
        estadisticas_rb_m_adolescentes = findViewById(R.id.estadisticas_rb_m_adolescentes);
        estadisticas_rb_h_adolescentes = findViewById(R.id.estadisticas_rb_h_adolescentes);
        estadisticas_rb_ninos = findViewById(R.id.estadisticas_rb_ninos);


        cantidad_auxiliar = 0;

        //SE MUESTRA LOS PORCENTAJES PARA TODO PÚBLICO

        //problemas aquí
        //cambiarInformacion(TODO_PUBLICO, totalVotos(), totalSpiderman(), totalThor(), totalViuda(), totalIronMan(), totalHulk(), totalDoctor(), totalCapitan(), totalCapitana());

        //PROBLEMAS CON LA SINCRONÍA DE CANTIDAD AUXILIAR, DABA 0, CUANDO SE HACE LA CONSULTA CORRECTAMENTE, PERO POR COSAS DE SINCRONÍA SE OBTENÍA 0

    }

    public void cambiarInformacion(String texto, int total, int spiderman, int thor, int viuda, int ironman, int hulk, int doctor, int capitan, int capitana) {

        estadisticas_tv_banner.setText(banner_1 + texto);

        estadisticas_tv_spiderman.setText((spiderman / total) + "");
        estadisticas_tv_ironman.setText((ironman / total) + "");
        estadisticas_tv_capitan.setText((capitan / total) + "");
        estadisticas_tv_capitana.setText((capitana / total) + "");
        estadisticas_tv_hulk.setText((hulk / total) + "");
        estadisticas_tv_viuda.setText((viuda / total) + "");
        estadisticas_tv_thor.setText((thor / total) + "");
        estadisticas_tv_doctor.setText((doctor / total) + "");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.estadisticas_btn_filtrar:


                break;
        }
    }

    //TOCA USAR ESTA VARIABLE PARA QUE SE PUEDA OBTENER UN VALOR DE UN DATO DENTRO DEL onDataChange
    private int cantidad_auxiliar;


    public int totalVotos() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(TOTAL_VOTOS).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalSpiderman() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(SPIDERMAN).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalDoctor() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(DOCTOR).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalCapitan() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(CAPITAN).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalCapitana() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(CAPITANA).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalHulk() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(HULK).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalViuda() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(VIUDA).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public int totalThor() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(THOR).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }


    public int totalIronMan() {

        int total = 0;
        cantidad_auxiliar = 0;

        database.getReference().child(ESTADISTICAS).child(IRONMAN).child(CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        total = cantidad_auxiliar;
        return total;

    }

    public void mostrarMensaje(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }

}
