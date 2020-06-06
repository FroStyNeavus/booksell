/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.modele;

/**
 * @author usager
 */
public class Utilisateur {
    protected int id;
    private static int idCounter;
    protected String pseudo;
    protected String mdp;
    protected String courriel;
    protected String telephone;
    protected int rank;
    protected String role;

    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String mdp, String courriel, String telephone) {
        this.id = 1;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.courriel = courriel;
        this.telephone = telephone;
        this.setRank(0);
        this.role = "user";
    }

    public Utilisateur(int id, String pseudo, String mdp, String courriel, String telephone, int rank, String role) {
        this.id = id;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.courriel = courriel;
        this.telephone = telephone;
        this.setRank(rank);
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank < 0 || rank > 100) {
            throw new IllegalArgumentException("Rank cannot be negative or above 100");
        } else {
            this.rank = rank;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return ("Nom: " + pseudo + "\nCourriel: " + courriel + "Téléphone: " + telephone);
    }


}
