package com.bluecodesystems.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbart);
        setSupportActionBar(toolbar);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addmother:

                Intent intent2 = new Intent(MainActivity.this, AddMother.class);
                startActivity(intent2);

                break;

            case R.id.viewmothers:

                Intent i = new Intent(MainActivity.this, ViewMothers.class);
                startActivity(i);

                break;
        }
    }

}