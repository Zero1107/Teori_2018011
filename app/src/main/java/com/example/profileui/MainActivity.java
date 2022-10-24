package com.example.profileui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.profile_username);


// kita set default nya Home Fragment
        loadFragment(new ProfileGridFragment());
// inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.posts_layout_type_navigation);
// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    // method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.profile_nav_grid:
//fragment = new ProfileGridFragment();
                break;
            case R.id.profile_nav_linear:
//fragment = new ProfileLinearFragment();
                break;
        }
        return loadFragment(fragment);
    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_cont, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}