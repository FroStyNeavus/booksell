/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.modele;

/**
 *
 * @author PC-WMT
 */
public class AnnonceDTO {
    private Annonce annonce;
    private Livre livre;

    public AnnonceDTO() {
    }

    public AnnonceDTO(Annonce annonce, Livre livre) {
        this.annonce = annonce;
        this.livre = livre;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
    
    
    
}
