package ir.ea2.android_materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.adapters.RecyclerViewAdapter;
import ir.ea2.android_materialdesign.models.MessageModel;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_item){
            recyclerViewAdapter.addItem(new MessageModel(R.drawable.github,"NewUser14","Hello Word !"));
        }
        return super.onOptionsItemSelected(item);
    }

    private void addNewMessage() {
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser1","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser2","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser3","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser4","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser5","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser6","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser7","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser8","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser9","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser10","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser11","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser12","Hello Word !"));
        messageModelList.add(new MessageModel(R.drawable.github,"NewUser13","Hello Word !"));

    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_eight_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    private void setViews() {
        recyclerView = findViewById(R.id.ac_eight_recycler);
        recyclerViewAdapter = new RecyclerViewAdapter(messageModelList);
        DividerItemDecoration dividerItemDecoration =new DividerItemDecoration(this ,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.custom_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        // Show RecyclerView by Type: Default Type.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL , false );
        //Set ShowType to RecyclerView.
        recyclerView.setLayoutManager(linearLayoutManager);
        //Pass Adapter to RecyclerView .
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}