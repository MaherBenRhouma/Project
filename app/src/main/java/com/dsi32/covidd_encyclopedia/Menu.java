package com.dsi32.covidd_encyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

public class Menu extends AppCompatActivity {
private CardView déconnexion;
private ImageView contact;
private ImageView apropos;
private ImageView profi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView ima = (ImageView) findViewById(R.id.ima);
        ima.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intente = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.urmc.rochester.edu/encyclopedia/content.aspx?contenttypeid=134&contentid=243"));
                startActivity(intente);
            }
        });

        déconnexion = (CardView) findViewById(R.id.déconnexion);
        déconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                olo();
            }
        });

        contact = (ImageView) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aolo();
            }
        });

        apropos = (ImageView) findViewById(R.id.apropos);
        apropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aoloa();
            }
        });

        profi = (ImageView) findViewById(R.id.profi);
        profi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aoloaa();
            }
        });
    }
    public void olo() {
        Intent intent11 = new Intent(this, MainActivity.class);
        startActivity(intent11);
    }
    public void aolo() {
        Intent intent11 = new Intent(this, Contact.class);
        startActivity(intent11);
    }
    public void aoloa() {
        Intent intent11 = new Intent(this, Apropos.class);
        startActivity(intent11);
    }
    public void aoloaa() {
        Intent intent11 = new Intent(this, Profile.class);
        startActivity(intent11);
    }
}
