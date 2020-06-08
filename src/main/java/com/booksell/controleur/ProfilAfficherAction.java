/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;

import com.booksell.dao.UtilisateurDAO;
import com.booksell.modele.AbstractAction;
import com.booksell.modele.ConnectionManager;
import com.booksell.modele.Utilisateur;

/**
 * @author 14389
 */
public class ProfilAfficherAction extends AbstractAction {
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
