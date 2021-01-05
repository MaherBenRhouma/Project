package com.dsi32.covidd_encyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Restoration extends AppCompatActivity {
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ress);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                qwxopeaa();
            }
        });
    }

    public void qwxopeaa() {
        Intent intent111 = new Intent(this, MainActivity.class);
        startActivity(intent111);
    }
}