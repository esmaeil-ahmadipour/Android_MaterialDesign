package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.utils.AppbarChangeListener;

public class DetailEightActivity extends AppCompatActivity {
    public static final String USER_KEY = "USER";
    private Toolbar toolbar;
    private ImageView avatar;
    private TextView name;
    private AppBarLayout appBarLayout;
    private LinearLayout userLayout;
    private CollapsingToolbarLayout.LayoutParams userLayoutParams;
    private LinearLayout.LayoutParams avatarLayoutParams;
    private SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_eight);
        setupToolbar();
        setupAppbar();
        setupViews();
        setupSwitch();
        bindData();
    }

    private void setupSwitch() {
        switchCompat = findViewById(R.id.ac_detailEight_switch);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(DetailEightActivity.this, "Switch is: "+isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupAppbar() {
        userLayout = findViewById(R.id.ac_detailEight_userLayout);
        userLayoutParams = (CollapsingToolbarLayout.LayoutParams) userLayout.getLayoutParams();
        avatarLayoutParams = (LinearLayout.LayoutParams) avatar.getLayoutParams();
        appBarLayout = findViewById(R.id.ac_detailEight_appbar);
        appBarLayout.addOnOffsetChangedListener(new AppbarChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state.name().equals("MINI")) {
                    updataUserLayoutParams(4, 4, 56, Gravity.TOP);
                    updataAvatarLayoutParams(48, 48);
                } else {
                    updataUserLayoutParams(0, 16, 16, Gravity.BOTTOM);
                    updataAvatarLayoutParams(64, 64);
                }
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

    private void updataUserLayoutParams(int marginTop, int marginBottom, int marginStart, int gravity) {
        userLayoutParams.setMargins(0, dpToPx(marginTop), 0, dpToPx(marginBottom));
        userLayoutParams.setMarginStart(dpToPx(marginStart));
        userLayoutParams.gravity = gravity;
        userLayout.setLayoutParams(userLayoutParams);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        int pixels = (int) (dp * density + 0.5f);

        return pixels;
    }

    private void updataAvatarLayoutParams(int width, int height) {
        avatarLayoutParams.width = dpToPx(width);
        avatarLayoutParams.height = dpToPx(height);
        avatar.setLayoutParams(avatarLayoutParams);
    }
}
