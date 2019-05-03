package com.appmoviles.muriel.votos_avengers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Estadisticas extends AppCompatActivity {

    private TextView estadisticas_tv_banner;

    public final static String banner_1 = "Los superhéroes más populares para";
    public final static String banner_2 = "son";


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

    private int porcentaje_spiderman;
    private int porcentaje_ironman;
    private int porcentaje_hulk;
    private int porcentaje_viuda;
    private int porcentaje_capitan;
    private int porcentaje_capitana;
    private int porcentaje_doctor;
    private int porcentaje_thor;



    //FireBase
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

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


    }



    //HAY PROBLEMAS AQUÍ, POR CUESTIONES DE TIEMPO NO PUDE HACERLO MÁS EFICIENTE LA CONSULTA
    //Faltó hacer consultas más eficientes, para no gastar tanto código

    public int cantidadTotalTotal(){

        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.IRONMAN);
        total += cantidad_auxiliar;

        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.IRONMAN);
        total += cantidad_auxiliar;

        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.IRONMAN);
        total += cantidad_auxiliar;

        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.IRONMAN);
        total += cantidad_auxiliar;

        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.IRONMAN);
        total += cantidad_auxiliar;

        return total;
    }


    public int cantidadTotalVotos_H_ADOLESCENTES() {

        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADOLESCENTES, Votar.IRONMAN);
        total += cantidad_auxiliar;

        return total;

    }

    public int cantidadTotalVotos_M_ADOLESCENTES() {

        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADOLESCENTES, Votar.IRONMAN);
        total += cantidad_auxiliar;

        return total;
    }

    public int cantidadTotalVotos_H_ADULTOS() {

        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.H_ADULTOS, Votar.IRONMAN);
        total += cantidad_auxiliar;

        return total;
    }

    public int cantidadTotalVotos_M_ADULTAS() {
        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.M_ADULTAS, Votar.IRONMAN);
        total += cantidad_auxiliar;

        return total;
    }

    public int cantidadTotalVotos_NINIOS() {

        int total = 0;

        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.SPIDERMAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.THOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.CAPITANA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.CAPITAN);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.VIUDA);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.DOCTOR);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.HULK);
        total += cantidad_auxiliar;
        cantidadVotosPorHeroe(Pregunta_Segmento.NINIOS, Votar.IRONMAN);
        total += cantidad_auxiliar;


        return total;
    }


    private int cantidad_auxiliar;

    public void cantidadVotosPorHeroe(String segmento, String superheroe) {


        database.getReference().child(Votar.SUPERHEROES).child(superheroe).child(segmento).child(Votar.CANTIDAD).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cantidad_auxiliar = 0;
                cantidad_auxiliar = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
