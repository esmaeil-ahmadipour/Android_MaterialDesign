package ir.ea2.android_materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ThreeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        setupToolbar();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout = findViewById(R.id.ac_three_tabLayout);
        viewPager = findViewById(R.id.ac_three_viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (int i = 0; i < 8 ; i++) {
            viewPagerAdapter.addItems(MainTabFragment.newInstance("Name:"+i),"Title:"+i);

        }

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(ThreeActivity.this, R.color.primaryColor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(ThreeActivity.this, R.color.primaryDarkColor));
                    }
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.secondaryColor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(ThreeActivity.this, R.color.secondaryDarkColor));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_three_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
