package com.booksell.modele;

public class Annonce {
    protected String id;
    protected String etat;
    protected double prix;
    protected int LivreID;
    protected int UtilisateurID;

    public Annonce(String id, String etat, double prix, int LivreID, int utilisateurID) {
        this.id = id;
        this.etat = etat;
        this.setPrix(prix);
        this.LivreID = LivreID;
        this.UtilisateurID = utilisateurID;
    }

    public Annonce() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
            this.prix = prix;
        }
    }

    public int getLivreId() {
        return LivreID;
    }

    public void setLivreId(int LivreId) {
        this.LivreID = LivreId;
    }

    public int getUtilisateurID() {
        return UtilisateurID;
    }

    public void setUtilisateurID(int utilisateurID) {
        UtilisateurID = utilisateurID;
    }
}
