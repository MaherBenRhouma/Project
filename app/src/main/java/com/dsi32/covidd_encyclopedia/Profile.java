package com.dsi32.covidd_encyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    Button ddd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ddd = (Button) findViewById(R.id.ddd);
        ddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeaaa();
            }
        });
    }

    public void opeaaa() {
        Intent intent1 = new Intent(this, Menu.class);
        startActivity(intent1);
    }
}