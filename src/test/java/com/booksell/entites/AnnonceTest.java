
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.entites;

import com.Booksell.modele.Annonce;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Danny
 */
public class AnnonceTest {
    // Valeurs attendues
    final static String ID_ANNONCE = "321";
    final static String ETAT_ANNONCE = "Bon état";
    final static double PRIX_ANNNONCE = 50;
    final static int IDLIVRE_ANNONCE = 190;
    final static int IDUTILISATEUR_ANNONCE = 4;

    Annonce annonce;

    public AnnonceTest() {
        this.setUp();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public void setUp() {
        // création de l'objet
        annonce = new Annonce(ID_ANNONCE, ETAT_ANNONCE, PRIX_ANNNONCE, IDLIVRE_ANNONCE, IDUTILISATEUR_ANNONCE);
    }

    @After
    public void tearDown() {
    }


    /**
     * Test du constructeur de la classe Annonce.
     **/
    @Test
    public void testCreationAnnonce() {
        // validation du résultat
        assertEquals(annonce.getId(), ID_ANNONCE);
        assertEquals(annonce.getEtat(), ETAT_ANNONCE);
        assertEquals(annonce.getPrix(), PRIX_ANNNONCE, 0.01);
        assertEquals(annonce.getLivreId(), IDLIVRE_ANNONCE);
        assertEquals(annonce.getUtilisateurID(), IDUTILISATEUR_ANNONCE);
    }

    /**
     * Test du constructeur de la classe Annonce avec une valeur négative.
     **/
    @Test(expected = IllegalArgumentException.class)
    public void testCreationTauxMonnaieValeurNegative() {

        annonce = new Annonce(ID_ANNONCE, ETAT_ANNONCE, -PRIX_ANNNONCE, IDLIVRE_ANNONCE, IDUTILISATEUR_ANNONCE);
    }

    /**
     * Test setPrix de la classe Annonce
     **/
    @Test
    public void testSetPrix() {
        // Modification du prix
        double nvPrix = 30;

        annonce.setPrix(nvPrix);

        // validation du résultat
        assertEquals(annonce.getPrix(), nvPrix, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPrixNegatif() {
        // Modification prix
        double nvPrix = -30;

        annonce.setPrix(nvPrix);

        // validation du résultat
    }

    @Test
    public void setId() {
        annonce.setId("1");
        assertEquals("1", annonce.getId());
    }

    @Test
    public void setEtat() {
        annonce.setEtat("acceptable");
        assertEquals("acceptable", annonce.getEtat());
    }

    @Test
    public void setLivreID() {
        annonce.setLivreId(3);
        assertEquals(3, annonce.getLivreId());
    }

    @Test
    public void setUtilisateurID() {
        annonce.setUtilisateurID(10);
        assertEquals(10, annonce.getUtilisateurID());
    }
}
