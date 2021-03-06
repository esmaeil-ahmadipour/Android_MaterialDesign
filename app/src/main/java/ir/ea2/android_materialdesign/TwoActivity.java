package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_android);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_ios);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(TwoActivity.this, R.color.primaryColor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(TwoActivity.this, R.color.primaryDarkColor));
                    }
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.secondaryColor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(TwoActivity.this, R.color.secondaryDarkColor));
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
        toolbar = findViewById(R.id.ac_two_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
