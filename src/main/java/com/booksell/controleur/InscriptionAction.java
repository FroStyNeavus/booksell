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

import javax.servlet.http.HttpSession;

/**
 * @author PC-WMT
 */
public class InscriptionAction extends AbstractAction {

    @Override
    public String execute() {
        String pseudo = this.request.getParameter("pseudo");
        String mdp = this.request.getParameter("mdp");
        String email = this.request.getParameter("email");
        String telephone = this.request.getParameter("tele");
        HttpSession session = request.getSession(true);

        UtilisateurDAO dao = new UtilisateurDAO(ConnectionManager.getConnection());
        Utilisateur user = new Utilisateur(pseudo, mdp, email, telephone);
        dao.ajouter(user);
        user = dao.trouverParNom(pseudo);
        if (user == null) {
            String message = "Une Erreur s'est produite lors de l'inscription, veuiller vérifier les information et réessayer.";
            request.setAttribute("messageErreurSignup", message);
            return "signup";
        }
        session.setAttribute("session", user);

        return "accueil";
    }

}
