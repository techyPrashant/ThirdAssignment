package com.example.eapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.eapp.AboutUs.AboutUsFragment;
import com.example.eapp.AddStudent.AddStudentFragment;
import com.example.eapp.Home.HomeFragment;
import com.example.eapp.Model.Students;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<Students> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        studentsList = new ArrayList<>();
        studentsList.add(new Students("Uttam Tamang","Nuwakot","Male",22,R.drawable.boy));
        studentsList.add(new Students("Asmita Adhikari","Kathmandu","Female",21,R.drawable.girl));


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.nav_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.nav_add:
                            selectFragment = new AddStudentFragment();
                            break;
                        case R.id.nav_about:
                            selectFragment = new AboutUsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
}
