package com.booksell.dao;

import com.booksell.modele.Annonce;
import com.booksell.modele.AnnonceDTO;
import com.booksell.modele.Livre;
import com.booksell.modele.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnonceDAO extends DAO<Annonce> {
    PreparedStatement stm;
    ResultSet res;

    public AnnonceDAO(Connection cnx) {
        super(cnx);
    }

    public List<AnnonceDTO> trouverAnnonceInfoParUser(Utilisateur utilisateur) {
        List<AnnonceDTO> listeAnnonceDTO = new LinkedList<>();
        Annonce annonce;
        Livre livre;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce INNER JOIN livres ON (annonce.ID_LIVRE=livres.ID) WHERE ID_UTILISATEUR=?");
            stm.setInt(1, utilisateur.getId());
            res = stm.executeQuery();
            while (res.next()) {
                annonce = new Annonce(
                        res.getString("ID"),
                        res.getString("ETAT"),
                        res.getDouble("PRIX"),
                        res.getInt("ID_LIVRE"),
                        res.getInt("ID_UTILISATEUR"));
                livre = new Livre(
                        res.getInt("ID_LIVRE"),
                        res.getString("Titre"),
                        res.getString("Auteur"),
                        res.getString("Editeur"),
                        Integer.parseInt(res.getString("Annee")),
                        res.getString("Description"),
                        res.getString("Categorie"),
                        res.getString("Image"),
                        res.getInt("Valide"));
                AnnonceDTO annonceDTO = new AnnonceDTO(annonce, livre);
                listeAnnonceDTO.add(annonceDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeAnnonceDTO;
    }

    public List<AnnonceDTO> trouverAnnonceInfoParTitreLivre(Utilisateur utilisateur, String titre) {
        List<AnnonceDTO> listeAnnonceDTO = new LinkedList<>();
        Annonce annonce;
        Livre livre;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce INNER JOIN livres ON (annonce.ID_LIVRE=livres.ID) WHERE TITRE LIKE ? AND ID_UTILISATEUR=?");
            stm.setString(1, "%" + titre + "%");
            stm.setInt(2, utilisateur.getId());
            res = stm.executeQuery();
            while (res.next()) {
                annonce = new Annonce(
                        res.getString("ID"),
                        res.getString("ETAT"),
                        res.getDouble("PRIX"),
                        res.getInt("ID_LIVRE"),
                        res.getInt("ID_UTILISATEUR"));
                livre = new Livre(
                        res.getInt("ID_LIVRE"),
                        res.getString("Titre"),
                        res.getString("Auteur"),
                        res.getString("Editeur"),
                        Integer.parseInt(res.getString("Annee")),
                        res.getString("Description"),
                        res.getString("Categorie"),
                        res.getString("Image"),
                        res.getInt("Valide"));
                AnnonceDTO annonceDTO = new AnnonceDTO(annonce, livre);
                listeAnnonceDTO.add(annonceDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeAnnonceDTO;
    }

    public List<AnnonceDTO> trouverAnnonceParTitreLivre(String titre) {
        List<AnnonceDTO> listeAnnonceDTO = new LinkedList<>();
        Annonce annonce;
        Livre livre;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce INNER JOIN livres ON (annonce.ID_LIVRE=livres.ID) WHERE TITRE LIKE ?");
            stm.setString(1, "%" + titre + "%");
            res = stm.executeQuery();
            while (res.next()) {
                annonce = new Annonce(
                        res.getString("ID"),
                        res.getString("ETAT"),
                        res.getDouble("PRIX"),
                        res.getInt("ID_LIVRE"),
                        res.getInt("ID_UTILISATEUR"));
                livre = livre = new Livre(
                        res.getInt("ID_LIVRE"),
                        res.getString("Titre"),
                        res.getString("Auteur"),
                        res.getString("Editeur"),
                        Integer.parseInt(res.getString("Annee")),
                        res.getString("Description"),
                        res.getString("Categorie"),
                        res.getString("Image"),
                        res.getInt("Valide"));
                AnnonceDTO annonceDTO = new AnnonceDTO(annonce, livre);
                listeAnnonceDTO.add(annonceDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (LinkedList) listeAnnonceDTO;
    }


    @Override
    public boolean ajouter(Annonce annonce) {
        try {
            stm = cnx.prepareStatement("INSERT INTO annonce(ID,ETAT, PRIX, ID_LIVRE, ID_UTILISATEUR) values (?,?,?,?,?)");
            stm.setString(1, annonce.getId());
            stm.setString(2, annonce.getEtat());
            stm.setDouble(3, annonce.getPrix());
            stm.setInt(4, annonce.getLivreId());
            stm.setObject(5, annonce.getUtilisateurID());
            if (0 < stm.executeUpdate()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Annonce trouverParId(String id) {
        Annonce annonce = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce where ID=?");
            stm.setString(1, id);
            res = stm.executeQuery();
            while (res.next()) {
                annonce = new Annonce(
                        res.getString("ID"),
                        res.getString("ETAT"),
                        res.getDouble("PRIX"),
                        res.getInt("ID_LIVRE"),
                        res.getInt("ID_UTILISATEUR"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return annonce;
    }

    public ArrayList<Annonce> trouverParUtilisateur(int utilisateurID) {
        ArrayList<Annonce> listeAnnonce = new ArrayList<Annonce>();
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce where ID_UTILISATEUR=?");
            stm.setInt(1, utilisateurID);
            res = stm.executeQuery();
            while (res.next()) {
                Annonce annonce = new Annonce(
                        res.getString("ID"),
                        res.getString("ETAT"),
                        res.getDouble("PRIX"),
                        res.getInt("ID_LIVRE"),
                        res.getInt("ID_UTILISATEUR"));
                listeAnnonce.add(annonce);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeAnnonce;
    }

    @Override
    public boolean supprimer(Annonce annonce) {
        try {
            stm = cnx.prepareStatement("DELETE FROM annonce WHERE id= ?");
            stm.setString(1, annonce.getId());
            int n = stm.executeUpdate();
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Annonce> trouverTout() {
        return null;
    }

    @Override
    public boolean modifier(Annonce annonce) {
        try {
            stm = cnx.prepareStatement("UPDATE annonce SET ETAT=?,PRIX=? WHERE id= ?");
            stm.setString(1, annonce.getEtat());
            stm.setDouble(2, annonce.getPrix());
            stm.setString(3, annonce.getId());
            if (0 < stm.executeUpdate()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}


