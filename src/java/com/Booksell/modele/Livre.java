/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.modele;

/**
 *
 * @author Danny
 */
public class Livre {
    protected int id;
    protected String titre;
    protected String auteur;
    protected String editeur;
    protected int annee;
    protected String description;
    protected String categorie;
    protected String image;
    protected int valide;

    public Livre() {
        
    }
   
    public Livre(int id, String titre, String auteur,String editeur, int annee, String description, String categorie, String image, int valide){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.annee = annee;
        this.description = description;
        this.categorie = categorie;
        this.image = image;
        this.valide = valide;
    }
    public Livre(String titre, String auteur,String editeur, int annee, String description, String categorie, String image){
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.annee = annee;
        this.description = description;
        this.categorie = categorie;
        this.image = image;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValide() {
        return this.valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }
    
}
