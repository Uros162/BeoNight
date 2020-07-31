package com.example.beonight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {



    BottomNavigationView bottomNavigationView;

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem ponedeljak,utorak,sreda,cetvrtak,petak,subota,nedelja;
    PageAdapter pageAdapter;
    TextView temperatura;

    public static String temperaturaString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        bottomNavigationView.setSelectedItemId(R.id.program);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);






        tabLayout = (TabLayout) findViewById(R.id.daniuNdelejiTabovi);

        ponedeljak = (TabItem) findViewById(R.id.ponedeljak);

        utorak = (TabItem) findViewById(R.id.utorak);
        sreda = (TabItem) findViewById(R.id.sreda);
        cetvrtak = (TabItem) findViewById(R.id.cetvrtak);
        petak = (TabItem) findViewById(R.id.petak);
        subota = (TabItem) findViewById(R.id.subota);
        nedelja = (TabItem) findViewById(R.id.nedelja);
        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);

       tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               if (tab.getPosition() == 0) {
                   pageAdapter.notifyDataSetChanged();
               } else if (tab.getPosition() == 1) {
                   pageAdapter.notifyDataSetChanged();

               } else if (tab.getPosition() == 2) {
                   pageAdapter.notifyDataSetChanged();

               }

           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


       String weatherApi;
       Weather w = new Weather();


        try {
            weatherApi = w.execute("http://api.openweathermap.org/data/2.5/weather?q=Belgrade,rs&units=metric&appid=92861a4c3071f745f2243aeb32c43ca9").get();

            Log.i("weatherApi",weatherApi);

            JSONObject weatherJSON =  new JSONObject(weatherApi);
            String weatherData = weatherJSON.getString("weather");
            String weatherDataTemperature = weatherJSON.getString("main");

            JSONObject tempJson =  new JSONObject(weatherDataTemperature);
             temperaturaString = tempJson.getString("temp");
            double doubleemp = Double.parseDouble(temperaturaString);
             int inttemp = (int)Math.round(doubleemp);
            temperaturaString = Integer.toString(inttemp)+" C";
            temperatura.setText(temperaturaString);


            Log.i("weatherData",weatherData);
            Log.i("weatherDataTemperature",weatherDataTemperature);


            JSONArray weatherArray = new JSONArray(weatherData);

            String main="";
            String description="";



            /*for (int i = 0; i <weatherArray.length() ; i++) {
                JSONObject weatherPart = weatherArray.getJSONObject(i);
                main = weatherPart.getString("main");
                description = weatherPart.getString("description");
                temperatura.setText(main+" c");
            }

            Log.i("main",main);
            Log.i("description",description);*/

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    public void initComponents(){
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        temperatura = findViewById(R.id.temperaturaID);
        /*listaPregleda = PregledApi.getPregledList();
          mainSrolView = findViewById(R.id.MainLinearScrolView);
          inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
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
                return true;
            case R.id.check_in:
                startActivity(new Intent(getApplicationContext(),CheckIn.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                return true;

        }
        return false;
    }
}
