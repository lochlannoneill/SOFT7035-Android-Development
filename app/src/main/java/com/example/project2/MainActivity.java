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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout tabLayout;
    TabItem tabGroceries, tabInstruments, tabFashion;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check to see if the user is logged in first
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("placeholder");
//        toolbar.setTitleTextColor(Color.GREEN);
        toolbar.setTitle("");  // this is done to remove PROJECTNAME in the toolbar at the top
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabGroceries = findViewById(R.id.tabGroceries);
        tabInstruments = findViewById(R.id.tabInstruments);
        tabFashion = findViewById(R.id.tabFashion);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
        pager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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
            Toast.makeText(this, "Placeholder Text", Toast.LENGTH_SHORT).show();
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