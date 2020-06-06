/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.dao;

import com.Booksell.modele.Annonce;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mu Tian Wang
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
    PreparedStatement stm = null;
    ResultSet res = null;

    public UtilisateurDAO(Connection cnx) {
        super(cnx);
    }

    public Utilisateur trouverParNom(String nom) {
        Utilisateur user;
        try {
            stm = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE Pseudo=?");
            stm.setString(1, nom);
            res = stm.executeQuery();
            if (res.next()) {
                user = new Utilisateur(res.getInt("Id"), res.getString("Pseudo"), res.getString("Mdp"), res.getString("Courriel"), res.getString("Telephone"), res.getInt("Rank"), res.getString("Role"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Utilisateur verification(String pseudo, String mdp) {

        try {
            stm = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE Pseudo=? and Mdp=?");
            stm.setString(1, pseudo);
            stm.setString(2, mdp);
            res = stm.executeQuery();
            Utilisateur user;
            if (res.next()) {
                user = new Utilisateur();
                user.setPseudo(res.getString("Pseudo"));
                user.setMdp(res.getString("Mdp"));
                user.setCourriel(res.getString("Courriel"));
                user.setId(res.getInt("Id"));
                user.setRank(res.getInt("Rank"));
                user.setRole(res.getString("Role"));
                user.setTelephone((res.getString("Telephone")));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean ajouter(Utilisateur user) {
        try {
            cnx = ConnectionManager.getConnection();
            stm = cnx.prepareStatement("INSERT INTO utilisateurs (Pseudo, Mdp, Courriel, Telephone, Rank, Role) VALUES (?,?,?,?,?,?)");
            stm.setString(1, user.getPseudo());
            stm.setString(2, user.getMdp());
            stm.setString(3, user.getCourriel());
            stm.setString(4, user.getTelephone());
            stm.setInt(5, user.getRank());
            stm.setString(6, user.getRole());
            if (0 < stm.executeUpdate()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean supprimer(Utilisateur user) {
        try {
            cnx = ConnectionManager.getConnection();
            stm = cnx.prepareStatement("DELETE FROM utilisateurs WHERE id = ?");
            stm.setInt(1, user.getId());
            if (0 < stm.executeUpdate()) {
                stm.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean modifier(Utilisateur utilisateur) {
        try {
            cnx = ConnectionManager.getConnection();
            stm = cnx.prepareStatement("UPDATE utilisateurs SET Pseudo=?, Mdp=?, Courriel=?, Telephone=?, Rank=?, Role=? WHERE ID=?");
            stm.setString(1, utilisateur.getPseudo());
            stm.setString(2, utilisateur.getMdp());
            stm.setString(3, utilisateur.getCourriel());
            stm.setString(4, utilisateur.getTelephone());
            stm.setInt(5, utilisateur.getRank());
            stm.setString(6, utilisateur.getRole());
            stm.setInt(7, utilisateur.getId());
            if (0 < stm.executeUpdate()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Utilisateur> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur trouverParId(String id) {
        Utilisateur user;
        try {
            stm = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE ID=?");
            stm.setInt(1, Integer.parseInt(id));
            res = stm.executeQuery();
            if (res.next()) {
                user = new Utilisateur(res.getInt("Id"), res.getString("Pseudo"), res.getString("Mdp"), res.getString("Courriel"), res.getString("Telephone"), res.getInt("Rank"), res.getString("Role"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

