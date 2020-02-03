package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.view_holders.MessageViewHolder;

public class DetailEightActivity extends AppCompatActivity {
    public static final String USER_KEY = "USER";
    private Toolbar toolbar;
    private ImageView avatar ;
    private TextView name ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_eight);
        setupToolbar();
        setupViews();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case(android.R.id.home):{
                Toast.makeText(this, name.getText().toString(), Toast.LENGTH_SHORT).show();

            }
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {
        MessageModel messageModel = (MessageModel) getIntent().getExtras().getSerializable(USER_KEY);
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
