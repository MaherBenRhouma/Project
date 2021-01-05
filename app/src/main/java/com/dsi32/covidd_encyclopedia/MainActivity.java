package com.dsi32.covidd_encyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button textView2;
    private Button textView;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = (Button) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInscription();
            }
        });
        buy = (Button) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opaae();
            }
        });
        textView = (Button) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInscri();
            }
        });
    }

    public void openInscription() {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }
    public void opaae() {
        Intent intenttt = new Intent(this, Restoration.class);
        startActivity(intenttt);
    }

    public void openInscri() {
        Intent intenttt = new Intent(this, Menu.class);
        startActivity(intenttt);
    }
}