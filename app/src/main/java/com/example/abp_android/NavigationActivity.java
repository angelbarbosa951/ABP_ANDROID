package com.example.abp_android;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.abp_android.fragments.ActividadFragment;
import com.example.abp_android.fragments.HabitacionFragment;
import com.example.abp_android.fragments.ReservasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import androidx.appcompat.widget.Toolbar;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView main_nav;
    private FrameLayout main_frame;

    private ActividadFragment activityFragment;
    private HabitacionFragment habitacionFragment;
    private ReservasFragment reservaFragment;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        //hooks
        main_nav= findViewById(R.id.main_nav);
        main_frame=findViewById(R.id.main_frame);
        //Toolbar Hooks
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Instaciamos fragments
        activityFragment = new ActividadFragment();
        habitacionFragment = new HabitacionFragment();
        reservaFragment = new ReservasFragment();

        main_nav.setItemBackgroundResource(R.color.home);
        setFragment(habitacionFragment);
        main_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.Activity){
                    main_nav.setItemBackgroundResource(R.color.home);
                    Toast.makeText(NavigationActivity.this,"Activity",Toast.LENGTH_SHORT).show();
                    setFragment(activityFragment);
                    return true;
                }else  if(item.getItemId()==R.id.Habitacion){
                    main_nav.setItemBackgroundResource(R.color.profile);
                    Toast.makeText(NavigationActivity.this,"Habitacion",Toast.LENGTH_SHORT).show();
                    setFragment(habitacionFragment);
                    return true;
                }else  if(item.getItemId()==R.id.Reserva){
                    main_nav.setItemBackgroundResource(R.color.settings);
                    Toast.makeText(NavigationActivity.this,"Reserva",Toast.LENGTH_SHORT).show();
                    setFragment(reservaFragment);
                    return true;
                }else{
                    return false;
                }
            }

        });

    }
    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.profile){
            Toast.makeText(this,"profile",Toast.LENGTH_SHORT).show();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }
}