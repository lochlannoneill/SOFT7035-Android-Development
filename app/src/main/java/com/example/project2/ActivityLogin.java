//Student Name:     Lochlann O Neill
//Student Number:   R00175741
//Date:             20/12/2020
//Module:           Programming Mobile Devices
//Assignment:       Programming Mobile Devices Project2

package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ActivityLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawerLayout;
        ActionBarDrawerToggle toggle;
        NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        final TextView txtRegisterLink = this.findViewById(R.id.textviewRegisterLink);
        txtRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityLogin.this.startActivity(new Intent(ActivityLogin.this, ActivityRegister.class));
            }
        });


//
//      TO-DO ------ VERIFY USER BEFORE PROCEEDING WITH THIS ACTION ----------
//
        final Button buttonLogin = this.findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityLogin.this.startActivity(new Intent(ActivityLogin.this, MainActivity.class));
                Toast.makeText(getApplicationContext(), "Welcome, {Username}", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        //            setContentView(R.layout.activity_login);

        if (item.getItemId() == R.id.menu_home) {
            setContentView(R.layout.activity_main);
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_login_or_register) {
            Intent newIntent = new Intent(this, ActivityLogin.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_logout) {
            Toast.makeText(this, "Goodbye {Username}", Toast.LENGTH_SHORT).show();
            Intent newIntent = new Intent(this, ActivityLogin.class);
            startActivity(newIntent);
        }
//        else if (item.getItemId() == R.id.menu_register) {
//            Intent newIntent = new Intent(this, ActivityRegister.class);
//            startActivity(newIntent);
//        }
        else if (item.getItemId() == R.id.menu_basket) {
            Intent newIntent = new Intent(this, ActivityBasket.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_wishlist) {
            Intent newIntent = new Intent(this, ActivityWishlist.class);
            startActivity(newIntent);
        }
        return false;
    }

}