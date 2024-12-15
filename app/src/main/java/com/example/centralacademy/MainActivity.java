package com.example.centralacademy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white));
        toggle.syncState();

        // Load HomeFragment when the activity starts
        if (savedInstanceState == null) {
            loadFrag(new HomeFragment(), false); // Load HomeFragment by default without adding to back stack
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if ( R.id.home == id) {
                    loadFrag(new HomeFragment(), false);
                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                } else if (R.id.about == id) {
                    loadFrag(new AboutUsFragment(), true);
                    Toast.makeText(MainActivity.this, "about us", Toast.LENGTH_SHORT).show();
                } else if (R.id.blog == id) {
                    loadFrag(new BlogFragment(), true);
                    Toast.makeText(MainActivity.this, "school life", Toast.LENGTH_SHORT).show();
                } else if (R.id.school_life == id) {
                    loadFrag(new SchoolLifeFragment(), true);
                    Toast.makeText(MainActivity.this, "school life", Toast.LENGTH_SHORT).show();
                } else if (R.id.contact_us == id) {
                    loadFrag(new ContactUsFragment(), true);
                    Toast.makeText(MainActivity.this, "contact us", Toast.LENGTH_SHORT).show();
                } else if (R.id.contact_list == id) {
                    loadFrag(new ContactListFragment(), true);
                    Toast.makeText(MainActivity.this, "contact us", Toast.LENGTH_SHORT).show();
                }


                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container, fragment); // Replace current fragment in container

        if (addToBackStack) {
            ft.addToBackStack(null); // Add to back stack only if specified
        }

        ft.commit();
    }

}