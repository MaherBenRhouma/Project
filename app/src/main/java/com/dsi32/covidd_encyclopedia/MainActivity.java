package com.dsi32.covidd_encyclopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button textView2;
    private Button textView;
    private Button buy;
    private TextView U,P;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        P = (TextView) findViewById(R.id.password);
        U = (TextView) findViewById(R.id.user);
        textView2 = (Button) findViewById(R.id.textView2);
        firebaseAuth = FirebaseAuth.getInstance();
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
                ppp();
                String pass = P.getText().toString().trim();
                String userr = U.getText().toString().trim();

                if (TextUtils.isEmpty(userr)) {
                    Toast.makeText(MainActivity.this, "entrer nom utilisateur!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "enter mot de passe!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() < 6) {
                    Toast.makeText(MainActivity.this, "mot de passe courte!", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(userr,pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intenttt = new Intent(MainActivity.this, Menu.class);
                                    startActivity(intenttt);
                                } else {
                                    Toast.makeText(MainActivity.this, "impossible de connecter!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }

    private void ppp() {
        Intent intenttt = new Intent(this, Menu.class);
        startActivity(intenttt);
    }

    private void opaae() {
        Intent intenttt = new Intent(this, Restoration.class);
        startActivity(intenttt);
    }

    private void openInscription() {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }
}
