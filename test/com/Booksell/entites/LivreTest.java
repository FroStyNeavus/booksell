/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.entites;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import com.Booksell.modele.Livre;
/**
 *
 * @author Danny
 */

public class LivreTest {
    
    // Valeurs attendues
    final static int id=1;
    final static String titre="Afrique";
    final static String auteur="Daniel";
    final static String editeur="Rosemont";
    final static int annee=2019;
    final static String description="Livre";
    final static String categorie="Sport";
    final static String image="http://www.axl.cefan.ulaval.ca/afrique/images/AFRIQUE-map-clic.png";
    final static int valide =1;
    static Livre livre;
    
    public LivreTest(){
        
    }
    
    @BeforeClass
    public static void setUpClass(){  
        livre = new Livre(id,titre,auteur,editeur,annee,description,categorie,image,valide);

    }
    
    @AfterClass
    public static void tearDownClass(){        
    }
  
    @After
    public void tearDown() {
    }  
    
    public void setUp() {
        // création de l'objet
        livre = new Livre(id,titre,auteur,editeur,annee,description,categorie,image,valide);
    }
    
     /**
     * Test du constructeur de la classe Livre.
     **/
    @Test
    public void testCreationLivre(){
        // validation du résultat
        assertEquals(livre.getId(),id);
        assertEquals(livre.getTitre(), titre);
        assertEquals(livre.getEditeur(), editeur);
        assertEquals(livre.getAnnee(),annee);
        assertEquals(livre.getDescription(),description);
        assertEquals(livre.getCategorie(),categorie);
        assertEquals(livre.getImage(),image);
        assertEquals(livre.getValide(),valide);
    }
    
     /**
     * Test des setters de la classe Livre
     **/
     @Test
    public void setId() {
        livre.setId(2);
        assertEquals(2, livre.getId());
    }

     @Test
    public void setTitre() {
        livre.setTitre("allo");
        assertEquals("allo", livre.getTitre());
    }

     @Test
    public void setAuteur() {
        livre.setAuteur("marc");
        assertEquals("marc", livre.getAuteur());
    }

     @Test
    public void setEditeur() {
        livre.setEditeur("mac");
        assertEquals("mac", livre.getEditeur());
    }

     @Test
    public void setAnnee() {
        livre.setAnnee(1677);
        assertEquals(1677, livre.getAnnee());
    }

     @Test
    public void setDescription() {
        livre.setDescription("bonjour");
        assertEquals("bonjour", livre.getDescription());
    }

     @Test
    public void setCategorie() {
        livre.setCategorie("Sport");
        assertEquals("Sport", livre.getCategorie());
    }

     @Test
    public void setImage() {
        livre.setImage("https://allo.com/image.png");
        assertEquals("https://allo.com/image.png", livre.getImage());
    }
    
    @Test
    public void setValide() {
        livre.setValide(0);
        assertEquals(0, livre.getValide());
    }
}