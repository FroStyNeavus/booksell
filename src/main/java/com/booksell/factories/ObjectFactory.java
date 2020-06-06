/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.factories;


import com.Booksell.modele.Annonce;

import java.util.UUID;

/**
 * @author usager
 */
public class ObjectFactory {
    public static Annonce getNewAnnonce() {
        Annonce objet = new Annonce();
        objet.setId(UUID.randomUUID().toString());
        return objet;
    }

}
