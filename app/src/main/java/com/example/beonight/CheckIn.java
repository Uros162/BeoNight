package com.example.beonight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.LinkedList;

public class CheckIn extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    public static TextView result;
    Button scan;
    TextView temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        initComonents();

        bottomNavigationView.setSelectedItemId(R.id.check_in);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);





    }

    public void initComonents(){
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        scan = findViewById(R.id.button_scan_qr);
        result = findViewById(R.id.Qr_code_text_id);
        temperatura = findViewById(R.id.temperaturaID);
        temperatura.setText(MainActivity.temperaturaString);
        scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,SkeniranjeKodaAktivnost.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.promo:
                startActivity(new Intent(getApplicationContext(),MestaZaProvod.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
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

                return true;

        }

        return false;
    }
}
