/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.entites;

import static org.junit.Assert.assertEquals;

import com.booksell.modele.Utilisateur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Danny
 */

public class UtilisateurTest {

    // Valeurs attendues
    final static int id = 2;
    final static String pseudo = "Mutian";
    final static String mdp = "mdp2";
    final static String courriel = "admin@gmail.com";
    final static String telephone = "6478884433";
    final static int rank = 50;
    final static String role = "admin";
    static Utilisateur utilisateur;

    public UtilisateurTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        utilisateur = new Utilisateur(id, pseudo, mdp, courriel, telephone, rank, role);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }


    /**
     * Test du constructeur de la classe Utilisateur.
     **/
    @Test
    public void testCreationUtilisateur() {
        // validation du résultat
        assertEquals(utilisateur.getId(), id);
        assertEquals(utilisateur.getPseudo(), pseudo);
        assertEquals(utilisateur.getMdp(), mdp);
        assertEquals(utilisateur.getTelephone(), telephone);
        assertEquals(utilisateur.getRank(), rank);
        assertEquals(utilisateur.getRole(), role);
    }

    /**
     * Test du constructeur de la classe Utilisateur avec une valeur négative.
     **/
    @Test(expected = IllegalArgumentException.class)
    public void testCreationRankValeurNegative() {
        utilisateur = new Utilisateur(id, pseudo, mdp, courriel, telephone, -rank, role);
    }


    /**
     * Test des setters de la classe Utilisateur
     **/
    @Test
    public void setId() {
        utilisateur.setId(02);
        assertEquals(02, utilisateur.getId());
    }

    @Test
    public void setPseudo() {
        utilisateur.setPseudo("Mutian");
        assertEquals("Mutian", utilisateur.getPseudo());
    }

    @Test
    public void setMdp() {
        utilisateur.setMdp("mdp2");
        assertEquals("mdp2", utilisateur.getMdp());
    }

    @Test
    public void setCourriel() {
        utilisateur.setRole("admin@gmail.com");
        assertEquals("admin@gmail.com", utilisateur.getCourriel());
    }

    @Test
    public void setTelephone() {
        utilisateur.setTelephone("6478884433");
        assertEquals("6478884433", utilisateur.getTelephone());
    }

    @Test
    public void setRank() {
        utilisateur.setRank(96);
        assertEquals(96, utilisateur.getRank());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRankNegatif() {
        // Modification prix
        int nvRank = -30;

        utilisateur.setRank(nvRank);
        assertEquals(nvRank, utilisateur.getRank());
    }

    @Test
    public void setRole() {
        utilisateur.setRole("Admin");
        assertEquals("Admin", utilisateur.getRole());

    }
}