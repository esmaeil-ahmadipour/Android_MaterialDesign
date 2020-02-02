package ir.ea2.android_materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;

public class TenActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);
        setupToolbar();
        setViews();
    }

    private void setViews() {

    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_ten_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
