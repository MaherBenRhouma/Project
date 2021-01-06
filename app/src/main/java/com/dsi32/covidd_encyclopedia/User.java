package com.dsi32.covidd_encyclopedia;

public class User {
    public String nom, prenom, email, password, utilisateur;

    public User(){
    }

    public User(String nom, String prenom, String email, String password, String utilisateur){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.utilisateur = utilisateur;

    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
