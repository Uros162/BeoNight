package com.example.beonight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MestaZaProvod extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    TextView temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesta_za_provod);

        initComponents();

        bottomNavigationView.setSelectedItemId(R.id.promo);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        CardView splavovi = findViewById(R.id.splavoviID);
        splavovi.setOnClickListener(this);

        CardView kafane = findViewById(R.id.kafaneID);
        kafane.setOnClickListener(this);

        CardView klubovi = findViewById(R.id.kluboviID);
        klubovi.setOnClickListener(this);

        CardView kafici = findViewById(R.id.kaficiID);
        kafici.setOnClickListener(this);



    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.promo:
                return true;

            case R.id.profil:
                startActivity(new Intent(getApplicationContext(),Profil.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
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

    public void initComponents() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        temperatura = findViewById(R.id.temperaturaID);
        temperatura.setText(MainActivity.temperaturaString);
    }


    @Override
    public void onClick(View v) {

        AppCompatActivity app = (AppCompatActivity) v.getContext();

        switch (v.getId()){

            case R.id.splavoviID:

                sreda sr = new sreda();
                app.getSupportFragmentManager().beginTransaction().replace(R.id.container,sr).addToBackStack(null).commit();
                break;
            case R.id.kafaneID:

                Kafane kf = new Kafane();
                app.getSupportFragmentManager().beginTransaction().replace(R.id.container,kf).addToBackStack(null).commit();
                break;
            case R.id.kaficiID:

                Kafici ka = new Kafici();
                app.getSupportFragmentManager().beginTransaction().replace(R.id.container,ka).addToBackStack(null).commit();
                break;

            case R.id.kluboviID:

                Klubovi kl = new Klubovi();
                app.getSupportFragmentManager().beginTransaction().replace(R.id.container,kl).addToBackStack(null).commit();
                break;




        }


    }
}
