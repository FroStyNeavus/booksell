/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.dao;

import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny
 */
public class LivreDAO extends DAO<Livre>{
    PreparedStatement stm = null;
    ResultSet res;

    public LivreDAO(Connection cnx) {
        super(cnx);
    }
    
    public Livre trouverParNom(String titre){
       Livre livre;
       try{
            stm = cnx.prepareStatement("SELECT * FROM LIVRES WHERE TITRE=?");
            stm.setString(1, titre);
            res = stm.executeQuery();
            if(res.next()){
               livre = new Livre(Integer.parseInt(res.getString("Id")),res.getString("Titre"),res.getString("Auteur"),res.getString("Editeur"),Integer.parseInt(res.getString("Annee")),res.getString("Description"),res.getString("Categorie"),res.getString("Image"), res.getInt("Valide"));
               return livre;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Livre trouverParId(int id){
        Livre livre;
        try{
            stm = cnx.prepareStatement("SELECT * FROM LIVRES WHERE ID=?");
            stm.setInt(1, id);
            res = stm.executeQuery();
            while(res.next()){
               livre = new Livre(id,res.getString("Titre"),res.getString("Auteur"),res.getString("Editeur"),Integer.parseInt(res.getString("Annee")),res.getString("Description"),res.getString("Categorie"),res.getString("Image"),res.getInt("Valide"));
               return livre;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Livre> trouverParCategorie(String categorie){
        List<Livre> listeLivres = new LinkedList();
        try{
            cnx = ConnectionManager.getConnection();
            stm = cnx.prepareStatement("Select * from livres where CATEGORIE = ?");
            stm.setString(1,categorie);
            res = stm.executeQuery();
            while(res.next()){
                Livre livre = new Livre(Integer.parseInt(res.getString("Id")),res.getString("Titre"),res.getString("Auteur"),res.getString("Editeur"),Integer.parseInt(res.getString("Annee")),res.getString("Description"),categorie,res.getString("Image"), res.getInt("Valide"));
                listeLivres.add(livre);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (LinkedList)listeLivres;
    }
    
    public LinkedList trouverParTitrePourRecherche(String titre){
        List<Livre> listeLivres = new LinkedList();
        try{
            stm = cnx.prepareStatement("Select * from livres where titre like ?");
            stm.setString(1, "%" + titre + "%");
            res = stm.executeQuery();
            while(res.next()){
                Livre livre = new Livre(Integer.parseInt(res.getString("Id")),res.getString("Titre"),res.getString("Auteur"),res.getString("Editeur"),Integer.parseInt(res.getString("Annee")),res.getString("Description"),res.getString("Categorie"),res.getString("Image"), res.getInt("Valide"));
                listeLivres.add(livre);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (LinkedList)listeLivres;
    }
    

    @Override
    public boolean ajouter(Livre livre) {
        try{
            stm = cnx.prepareStatement("INSERT INTO livres(Id, Titre, Auteur, Editeur, Annee, Description, Categorie, Image, Valide) values (?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, livre.getId());
            stm.setString(2, livre.getTitre());
            stm.setString(3, livre.getAuteur());
            stm.setString(4, livre.getEditeur());
            stm.setInt(5, livre.getAnnee());
            stm.setString(6, livre.getDescription());
            stm.setString(7, livre.getCategorie());
            stm.setString(8, livre.getImage());
            stm.setInt(9, livre.getValide());
            stm.executeUpdate();
        }   catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return true;
    }

    @Override
    public Livre trouverParId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Livre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Livre livre) {
        try{
            stm = cnx.prepareStatement("DELETE FROM livres WHERE ID=?");
            stm.setInt(1, livre.getId());
            res = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
        public boolean supprimer(String idLivre) {
        try{
            stm = cnx.prepareStatement("DELETE FROM livres WHERE ID=?");
            stm.setInt(1, Integer.parseInt(idLivre));
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public List<Livre> trouverTout() {
        List<Livre> listeLivres = new LinkedList();
        try{
            stm = cnx.prepareStatement("SELECT * FROM livres");
            res = stm.executeQuery();
            while (res.next()){
                Livre livre = new Livre(Integer.parseInt(res.getString("Id")),res.getString("Titre"),res.getString("Auteur"),res.getString("Editeur"),Integer.parseInt(res.getString("Annee")),res.getString("Description"),res.getString("Categorie"),res.getString("Image"),res.getInt("Valide"));
                listeLivres.add(livre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (LinkedList)listeLivres;
    }

    public void validerLivre(String idLivre){
        int resultat;
        try{
            stm = cnx.prepareStatement("UPDATE livres SET VALIDE = 1 WHERE ID = ?");
            stm.setInt(1, Integer.parseInt(idLivre));
            resultat = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
