package org.example;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private int id;

    public Utilisateur(String prenom, String nom, String email,int id) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.id=id;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getEmail() {
        return this.email;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int idUtilisateur) {
    }

    // Getters / setters si besoin
}
