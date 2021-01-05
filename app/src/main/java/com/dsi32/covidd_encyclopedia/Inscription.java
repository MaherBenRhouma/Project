package com.dsi32.covidd_encyclopedia;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Inscription extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    Button button;
    Button button2;
    private EditText emaill,utilisateurr,nomm,prenomm,passwordd,confirmm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mAuth = FirebaseAuth.getInstance();

        emaill = (EditText) findViewById(R.id.email);
        utilisateurr = (EditText) findViewById(R.id.utilisateur);
        nomm = (EditText) findViewById(R.id.nom);
        prenomm = (EditText) findViewById(R.id.prenom);
        passwordd = (EditText) findViewById(R.id.password);
        confirmm = (EditText) findViewById(R.id.confirm);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

    }


    public void openmaion() {
        Intent intent11 = new Intent(this, MainActivity.class);
        startActivity(intent11);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.button2:
                registeruser();
                break;


        }
    }

    private <RegisterUser> void registeruser() {
        String email = emaill.getText().toString().trim();
        String utilisateur = utilisateurr.getText().toString().trim();
        String nom = nomm.getText().toString().trim();
        String prenom = prenomm.getText().toString().trim();
        String password = passwordd.getText().toString().trim();
        String confirm = confirmm.getText().toString().trim();

        if (nom.isEmpty()) {
            nomm.setError("entrez votre nom!");
            nomm.requestFocus();
            return;
        }
        if (prenom.isEmpty()) {
            prenomm.setError("entrez votre prenom!");
            prenomm.requestFocus();
            return;
        }
        if (utilisateur.isEmpty()) {
            utilisateurr.setError("entrez votre nom d'utilisateur!");
            utilisateurr.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordd.setError("entrez votre mot de passe!");
            passwordd.requestFocus();
            return;
        }
        if (confirm.isEmpty()) {
            confirmm.setError("confirmer votre mot de passe!");
            confirmm.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(utilisateur, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            User user = new User(nom, prenom, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                }
                            });
                        }

                    }
                });

    }
}
