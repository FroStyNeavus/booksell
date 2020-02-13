/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.AnnonceDAO;
import com.Booksell.dao.UtilisateurDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.Annonce;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;
import java.util.List;

/**
 *
 * @author 14389
 */
public class ProfilAfficherAction extends AbstractAction{
    @Override
    public String execute() {
        //Initialiser les paramètres de la requête
        String pseudo = this.request.getParameter("pseudo");
        
        //Trouver l'utilisateur
        UtilisateurDAO userDAO = new UtilisateurDAO(ConnectionManager.getConnection());
        Utilisateur user = userDAO.trouverParNom(pseudo);
        
        request.setAttribute("utilisateur", user);
        return "profilAffichage";
    }
    
}
