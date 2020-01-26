package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class TwoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        setupToolbar();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout = findViewById(R.id.ac_two_tabLayout);
        viewPager = findViewById(R.id.ac_two_viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addItems(new AndroidFragment(), getResources().getString(R.string.tab_title_android));
        viewPagerAdapter.addItems(new IosFragment(), getResources().getString(R.string.tab_title_ios));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_two_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
