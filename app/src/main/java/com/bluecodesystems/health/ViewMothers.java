package com.bluecodesystems.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bluecodesystems.health.adapters.DBAdapter;
import com.bluecodesystems.health.models.Mothers;
import com.bluecodesystems.health.utils.DatabaseHelper;

import java.util.ArrayList;

public class ViewMothers extends AppCompatActivity {

    private DatabaseHelper db;
    private RecyclerView recyclerView;
    private TextView emptyView;
    RecyclerView.Adapter recyclerViewadapter;
    private ArrayList<Mothers> motherList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mothers);

        recyclerView = findViewById(R.id.recyclerView);
        emptyView = findViewById(R.id.empty);

        db = new DatabaseHelper(this);

        motherList.addAll(db.getAllMothers());
        int size = motherList.size();

        if (size < 1) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }

        RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(eLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerViewadapter = new DBAdapter(motherList, ViewMothers.this);
        recyclerView.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();


    }
}