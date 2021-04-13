package com.bluecodesystems.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bluecodesystems.health.adapters.DBAdapter;
import com.bluecodesystems.health.adapters.DBAdapter2;
import com.bluecodesystems.health.models.Children;
import com.bluecodesystems.health.models.Mothers;
import com.bluecodesystems.health.utils.DatabaseHelper;

import java.util.ArrayList;

public class SingleMother extends AppCompatActivity {

    TextView tvName, tvAge, tvNrc, tvWeight, tvPressure, tvTitle;
    private DatabaseHelper db;
    private RecyclerView recyclerView;
    private TextView emptyView;
    RecyclerView.Adapter recyclerViewadapter;
    private ArrayList<Children> childList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mother);

        recyclerView = findViewById(R.id.recyclerView);
        emptyView = findViewById(R.id.empty);

        db = new DatabaseHelper(this);


        Mothers mDetails = (Mothers) getIntent().getSerializableExtra("mothers");

        tvName = findViewById(R.id.name);
        tvName.setText(mDetails.getName());

        tvAge = findViewById(R.id.age);
        tvAge.setText("Age : " + mDetails.getAge());

        tvNrc = findViewById(R.id.nrc);
        tvNrc.setText("NRC : " + mDetails.getNrc());

        tvWeight = findViewById(R.id.weight);
        tvWeight.setText("Weight : " + mDetails.getWeight() + " Kg");

        tvPressure = findViewById(R.id.pressure);
        tvPressure.setText("Blood Pressure :" + mDetails.getPressure() + " mmHg");

        tvTitle = findViewById(R.id.title);
        tvTitle.setText(mDetails.getName() + "'s Children");

        childList.addAll(db.getAllChildren(mDetails.getUid()));
        int size = childList.size();

        if (size < 1) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }

        RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(eLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerViewadapter = new DBAdapter2(childList, SingleMother.this);
        recyclerView.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();
    }
}