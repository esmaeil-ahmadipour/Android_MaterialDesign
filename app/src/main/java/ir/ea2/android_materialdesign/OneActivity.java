package ir.ea2.android_materialdesign;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class OneActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Context context;
    private ImageView avatarImage;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar mainToolbar;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;
    private Snackbar snackbar;
    private View snackbarView;
    private TextView snakbarTextView;
    private ProgressBar circularProgressBar;
    private ProgressBar linearProgressBar;
    private Timer timer;
    private int timerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        context = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setupToolbar();
        setViews();
        setupProgressbar();
        setupNavigationView();
        setupListeners();
    }

    private void setupProgressbar() {
        linearProgressBar = findViewById(R.id.ac_one_progressBarLinear);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (timerNumber <= 100) {
                   linearProgressBar.setProgress(timerNumber);
                   timerNumber++;
                   linearProgressBar.setSecondaryProgress(timerNumber+15);

                }else{
                    timer.cancel();
                }
            }
        }, 2000, 1000);

        circularProgressBar = findViewById(R.id.ac_one_progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                circularProgressBar.setVisibility(View.GONE);
            }
        }, 5000);
    }

    private void setupSnackbar() {
        snackbar = Snackbar.make(coordinatorLayout, getResources().getString(R.string.toast_retry_action), Snackbar.LENGTH_INDEFINITE);
        snackbar.setDuration(6000);
        snackbar.setAction(getResources().getString(R.string.snackbar_btn_retry), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, getResources().getString(R.string.toast_retry_action), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        snackbar.setActionTextColor(getResources().getColor(R.color.colorWhite));
        snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getResources().getColor(R.color.errorColor));
        snakbarTextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        snakbarTextView.setTextColor(getResources().getColor(R.color.primaryColor));
    }

    private void setupListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupSnackbar();
                snackbar.show();
            }
        });
    }


    private void setupToolbar() {
        mainToolbar = findViewById(R.id.ac_main_toolbar);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        mainToolbar.setTitle("");
        setSupportActionBar(mainToolbar);
    }


    private void setViews() {
        coordinatorLayout = findViewById(R.id.ac_one_root_element);
        fab = findViewById(R.id.ac_one_fab);
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
                Toast.makeText(context, getResources().getString(R.string.toast_select_item), Toast.LENGTH_SHORT)
                        .show();
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













