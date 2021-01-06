package com.dsi32.covidd_encyclopedia;

public class User {
    public String nom, prenom, email, utilisateur;

    public User() {

    }
    public User(String nom, String prenom, String email, String utilisateur){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.utilisateur = utilisateur;

    }

    public User(String email, String utilisateur, String nom, String prenom, String confirm) {
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

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}
