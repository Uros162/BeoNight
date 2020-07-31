package com.example.beonight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profil extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    public static TextView brojRezervacija;
    public static TextView brojPoena;
    TextView temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        initComponents();

        bottomNavigationView.setSelectedItemId(R.id.profil);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    public void initComponents(){
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        brojPoena = findViewById(R.id.brojPoenaNumberId);
        brojRezervacija = findViewById(R.id.brojRezervacijaBrojID);
        temperatura = findViewById(R.id.temperaturaID);
        temperatura.setText(MainActivity.temperaturaString);

        SharedPreferences sharedPreferences = getSharedPreferences(SkeniranjeKodaAktivnost.SHAREDPREFERENCES,0);
        int broj_Rezervacija = sharedPreferences.getInt(SkeniranjeKodaAktivnost.SHAREDPREFERENCES_BROJ_REZERVACIJA,0);
        int broj_POena = sharedPreferences.getInt(SkeniranjeKodaAktivnost.SHAREDPREFERENCES_BROJ_POENA,0);

        brojPoena.setText(Integer.toString(broj_POena));
        brojRezervacija.setText(Integer.toString(broj_Rezervacija));

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.promo:
                startActivity(new Intent(getApplicationContext(),MestaZaProvod.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                return true;
            case R.id.profil:

                return true;
            case R.id.program:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                return true;
            case R.id.check_in:
                startActivity(new Intent(getApplicationContext(),CheckIn.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                return true;

        }
        return false;
    }


}
