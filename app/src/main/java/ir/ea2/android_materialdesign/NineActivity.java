package ir.ea2.android_materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.adapters.RecyclerViewAdapter;
import ir.ea2.android_materialdesign.adapters.RecyclerViewAdapter2;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.models.UserModel;

import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class NineActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private RecyclerView recyclerView ;
    private RecyclerViewAdapter2 recyclerViewAdapter2;
    private List<Object> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        setupToolbar();
        addToList();
        setViews();

    }

    private void addToList() {
        items.add(new UserModel(R.drawable.human_male, "Male User"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new UserModel(R.drawable.human_male,"Male User"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));
        items.add(new MessageModel(R.drawable.human_female,"Female User","Hello Word !"));

    }


    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_nine_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
    private void setViews() {
        recyclerView = findViewById(R.id.ac_nine_recycler);
        recyclerViewAdapter2 = new RecyclerViewAdapter2(items);
        // Show RecyclerView by Type: Default Type.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , RecyclerView.VERTICAL , false );
        //Set ShowType to RecyclerView.
        recyclerView.setLayoutManager(linearLayoutManager);
        //Pass Adapter to RecyclerView .
        recyclerView.setAdapter(recyclerViewAdapter2);

    }

}
