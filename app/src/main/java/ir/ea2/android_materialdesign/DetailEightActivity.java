package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.utils.AppbarChangeListener;

public class DetailEightActivity extends AppCompatActivity {
    public static final String USER_KEY = "USER";
    private Toolbar toolbar;
    private ImageView avatar;
    private TextView name;
    private AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_eight);
        setupToolbar();
        setupAppbar();
        setupViews();
        bindData();
    }

    private void setupAppbar() {
        appBarLayout = findViewById(R.id.ac_detailEight_appbar);
        appBarLayout.addOnOffsetChangedListener(new AppbarChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.e("APPBAR_TEST", state.name() );
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home): {
                Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();

            }
            break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {
        MessageModel messageModel = (MessageModel) getIntent().getExtras()
                .getSerializable(USER_KEY);
        avatar.setImageResource(messageModel.getAvatarItem());
        name.setText(messageModel.getNameItem());
    }

    private void setupViews() {

    }

    private void setupToolbar() {
        avatar = findViewById(R.id.ac_detailEight_avatar);
        name = findViewById(R.id.ac_detailEight_name);
        toolbar = findViewById(R.id.ac_detailEight_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
