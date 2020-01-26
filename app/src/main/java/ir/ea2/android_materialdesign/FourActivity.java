package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import ir.ea2.android_materialdesign.bottom_navigation.HomeFragment;
import ir.ea2.android_materialdesign.bottom_navigation.SearchFragment;
import ir.ea2.android_materialdesign.bottom_navigation.SettingsFragment;
import ir.ea2.android_materialdesign.bottom_navigation.Test;

public class FourActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        setupToolbar();
        setupBottomNavigationView();
        loadFragments(new HomeFragment());
    }

    private void loadFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ac_activity4_fragment_container, fragment)
                .commit();
        System.out.println(fragment.isStateSaved());
    }

    private void setupBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.ac_activity4_bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.bottom_nav_home: {
                        Toast.makeText(FourActivity.this, getResources().getString(R.string.nav_home), Toast.LENGTH_SHORT)
                                .show();
                        loadFragments(new HomeFragment());
                        System.out.println(new Test(5));

                        return true;
                    }
                    case R.id.bottom_nav_search: {
                        Toast.makeText(FourActivity.this, getResources().getString(R.string.nav_search), Toast.LENGTH_SHORT)
                                .show();
                        loadFragments(new SearchFragment());
                        return true;
                    }
                    case R.id.bottom_nav_settings: {
                        Toast.makeText(FourActivity.this, getResources().getString(R.string.nav_settings), Toast.LENGTH_SHORT)
                                .show();
                        loadFragments(new SettingsFragment());
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_four_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
