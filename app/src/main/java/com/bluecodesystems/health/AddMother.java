package com.bluecodesystems.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluecodesystems.health.utils.DatabaseHelper;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.Random;
import java.util.UUID;

public class AddMother extends AppCompatActivity {

    public int numberOfLines = 1;
    EditText txtName, txtAge, txtNrc, txtWeight, txtPressure;
    TextView txtUid;
    private DatabaseHelper db;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mother);

        toolbar = findViewById(R.id.toolbart);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        Button button = findViewById(R.id.addchildview);
        button.setOnClickListener(v -> addline());

        String uid = UUID.randomUUID().toString().replace("-", "");

        txtUid = findViewById(R.id.uid);
        txtUid.setText(uid);
        txtName = findViewById(R.id.name);
        txtAge = findViewById(R.id.age);
        txtNrc = findViewById(R.id.nrc);
        txtWeight = findViewById(R.id.weight);
        txtPressure = findViewById(R.id.pressure);



        db = new DatabaseHelper(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.letsadd:

                addmother();
                addchildren();

                break;
        }
    }

    public void addmother (){

        String uid = txtUid.getText().toString();
        String name = txtName.getText().toString();
        String age = txtAge.getText().toString();
        String nrc = txtNrc.getText().toString();
        String weight = txtWeight.getText().toString();
        String pressure = txtPressure.getText().toString();


        if (!name.isEmpty() && !age.isEmpty() && !nrc.isEmpty() && !weight.isEmpty() && !pressure.isEmpty()) {

            db.saveMother(uid, name, age, nrc, weight, pressure);

            Intent intent2 = new Intent(AddMother.this, ViewMothers.class);
            startActivity(intent2);

            MDToast mdToast = MDToast.makeText(this, "Mother Saved", MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
            mdToast.show();

        } else {
            MDToast mdToast = MDToast.makeText(this, "Missing Fields", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }

    }

    public void addline() {
        LinearLayout ll = (LinearLayout)findViewById(R.id.mychildren);
        EditText et = new EditText(AddMother.this, null, R.attr.editTextStyle);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(p);
        et.setId(numberOfLines + 1);
        et.setHint("Childs Name");
        ll.addView(et);
        numberOfLines++;
    }

    private void addchildren()
    {
        LinearLayout ll = (LinearLayout)findViewById(R.id.mychildren);
        for(int i=0;i<ll.getChildCount();i++)
        {

            EditText childname = (EditText) ll.getChildAt(i);

            if(!childname.getText().toString().isEmpty()){

                db.saveChild(txtUid.getText().toString(), childname.getText().toString());

            }

        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}