package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    /*
    Creating the two text view variables for the text views in activity detail xml
    */

    private TextView title;
    private TextView pml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title_tv);
        pml = findViewById(R.id.pml_tv);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String t = extra.getString("EXTRA_TITLE");
            String p = extra.getString("EXTRA_TDL");
        }


    }
}
