package com.example.beonight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SkeniranjeKodaAktivnost extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public static String SHAREDPREFERENCES = "PRENOS_PODATAKA";
    public static String SHAREDPREFERENCES_BROJ_REZERVACIJA = "Broj_Rezervacija";
    public static String SHAREDPREFERENCES_BROJ_POENA = "Broj_Poena";

    int MY_PREMISSIONS_REQUEST_CAMERA = 0;
    ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

    }


    @Override
    public void handleResult(Result result) {



        SharedPreferences sharedPreferences = getSharedPreferences(SHAREDPREFERENCES,0);
        SharedPreferences.Editor editor =  sharedPreferences.edit();

       int brojRezervacija = sharedPreferences.getInt(SHAREDPREFERENCES_BROJ_REZERVACIJA,0);
       int brojPoena = sharedPreferences.getInt(SHAREDPREFERENCES_BROJ_POENA,0);

        switch (result.getText().trim()){
            case "REZERVACIJA ZA BARSKI STO":
                brojPoena += 200;
                brojRezervacija++;
                break;
            case "REZERVACIJA ZA VISOKO SEDENJE":
                brojPoena += 500;
                brojRezervacija++;
                break;
            case "REZERVACIJA ZA SEPARE":
                brojPoena += 1000;
                brojRezervacija++;
                break;
            default:
                brojPoena += 0;
        }



        editor.putInt(SHAREDPREFERENCES_BROJ_REZERVACIJA,brojRezervacija);
        editor.putInt(SHAREDPREFERENCES_BROJ_POENA,brojPoena);
        editor.commit();

        String textForButton = "";
        switch (result.getText()){
            case "REZERVACIJA ZA BARSKI STO":
                textForButton = "Uspesno ste ostvarili dodatnih 200 poena";

                break;
            case "REZERVACIJA ZA VISOKO SEDENJE":
                textForButton = "Uspesno ste ostvarili dodatnih 500 poena";
                break;
            case "REZERVACIJA ZA SEPARE":
                textForButton = "Uspesno ste ostvarili dodatnih 1000 poena";
                break;
            default: textForButton = "Greska!!!";

        }

        CheckIn.result.setText(textForButton);
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},MY_PREMISSIONS_REQUEST_CAMERA);
        }
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
