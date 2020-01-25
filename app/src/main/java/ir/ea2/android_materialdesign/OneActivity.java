package ir.ea2.android_materialdesign;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class OneActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Context context;
    private ImageView avatarImage;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        context = this;

        setupToolbar();
        setViews();
        setupNavigationView();

    }


    private void setupToolbar() {
        mainToolbar = findViewById(R.id.ac_main_toolbar);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        mainToolbar.setTitle("");
        setSupportActionBar(mainToolbar);
    }


    private void setViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mainToolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupNavigationView() {
        mainToolbar.setNavigationIcon(R.drawable.ic_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        setMenuCounter(R.id.nav_inbox, 10);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemSelected = menuItem.getItemId();

        switch (itemSelected) {
            case R.id.nav_inbox:
                Toast.makeText(this, R.string.nav_inbox, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_star:
                Toast.makeText(this, R.string.nav_starred, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_sent_email:
                Toast.makeText(this, R.string.nav_sent_email, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_drafts:
                Toast.makeText(this, R.string.nav_drafts, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_all_email:
                Toast.makeText(this, R.string.nav_all_email, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_trash:
                Toast.makeText(this, R.string.nav_trash, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_spam:
                Toast.makeText(this, R.string.nav_spam, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, getResources().getString(R.string.toast_select_item), Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    private void setMenuCounter(@IdRes int itemMenuId, int counter) {
        TextView counterView = (TextView) navigationView.getMenu()
                .findItem(itemMenuId)
                .getActionView();
        counterView.setText(counter > 0 ? String.valueOf(counter) : null);
    }
}













