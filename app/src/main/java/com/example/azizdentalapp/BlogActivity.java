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

        eItems.add(new ExpandableItem(R.drawable.brightening,getString(R.string.scaling_title),getString(R.string.scaling_desc)));
        eItems.add(new ExpandableItem(R.drawable.brightening,getString(R.string.brightening_title),getString(R.string.brightening_desc)));
        eItems.add(new ExpandableItem(R.drawable.brightening,getString(R.string.scaling_title),getString(R.string.scaling_desc)));

    }
}