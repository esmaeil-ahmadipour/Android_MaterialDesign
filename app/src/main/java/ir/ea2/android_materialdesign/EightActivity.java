package ir.ea2.android_materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.adapters.RecyclerViewAdapter;
import ir.ea2.android_materialdesign.models.MessageModel;
import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class EightActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView ;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<MessageModel> messageModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        setupToolbar();
        addNewMessage();
        setViews();

    }

    private void addNewMessage() {
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser","Hello Word !"));

    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_eight_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    private void setViews() {
        recyclerView = findViewById(R.id.ac_eight_recycler);
        recyclerViewAdapter = new RecyclerViewAdapter(messageModelList);
        // Show RecyclerView by Type: Default Type.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL , false );
        //Set ShowType to RecyclerView.
        recyclerView.setLayoutManager(linearLayoutManager);
        //Pass Adapter to RecyclerView .
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}