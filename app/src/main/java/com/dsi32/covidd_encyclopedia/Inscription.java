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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Inscription extends AppCompatActivity {

    Button button;
    Button button2;
    EditText reg_email, reg_utilisateur, reg_nom, reg_prenom, reg_password, reg_confirm;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        reg_email =  findViewById(R.id.email);
        reg_utilisateur =  findViewById(R.id.utilisateur);
        reg_nom =  findViewById(R.id.nom);
        reg_prenom =  findViewById(R.id.prenom);
        reg_password =  findViewById(R.id.password);
        reg_confirm =  findViewById(R.id.confirm);
        button =  findViewById(R.id.button);
        button2 =  findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String email = reg_email.getText().toString();
                String utilisateur = reg_utilisateur.getText().toString();
                String nom = reg_nom.getText().toString();
                String prenom = reg_prenom.getText().toString();
                String password = reg_password.getText().toString();
                String confirm = reg_confirm.getText().toString();
                User user = new User(nom,prenom,email, password,utilisateur);

                if (nom.isEmpty()) {
                    reg_nom.setError("entrez votre nom!");
                    reg_nom.requestFocus();
                    return;
                }
                if (prenom.isEmpty()) {
                    reg_prenom.setError("entrez votre prenom!");
                    reg_prenom.requestFocus();
                    return;
                }
                if (utilisateur.isEmpty()) {
                    reg_utilisateur.setError("entrez votre nom d'utilisateur!");
                    reg_utilisateur.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    reg_password.setError("entrez votre mot de passe!");
                    reg_password.requestFocus();
                    return;
                }
                if (confirm.isEmpty()) {
                    reg_confirm.setError("confirmer votre mot de passe!");
                    reg_confirm.requestFocus();
                    return;
                }

                reference.child(utilisateur).setValue(user);
                openn();
            }
        });
    }

    private void openn() {
        Intent intentttaaa = new Intent(this, MainActivity.class);
        startActivity(intentttaaa);
    }

    private void openMain() {
        Intent intenttta = new Intent(this, MainActivity.class);
        startActivity(intenttta);
    }
}

