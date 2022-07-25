package com.example.azizdentalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {

    private ArrayList<ExpandableItem> eItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterExpandable(eItems, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eItems.add(new ExpandableItem(R.drawable.scaling,getString(R.string.scaling_title),getString(R.string.scaling_desc)));
        eItems.add(new ExpandableItem(R.drawable.endodontik,getString(R.string.edondontik_title),getString(R.string.edondontik_desc)));
        eItems.add(new ExpandableItem(R.drawable.odontektomi,getString(R.string.odontektomi_title),getString(R.string.odontektomi_desc)));

    }
}