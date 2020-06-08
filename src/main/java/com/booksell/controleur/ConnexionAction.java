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
 * @author Danny
 */
public class ConnexionAction extends AbstractAction {

    @Override
    public String execute() {
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");
        UtilisateurDAO dao = new UtilisateurDAO(ConnectionManager.getConnection());

        Utilisateur user = dao.trouverParNom(pseudo);
        String message;
        if (user == null) {
            message = "Le nom d'utilisateur est incorrect";
            request.setAttribute("messageErreurUser", message);
            return "login";
        }
        if (!mdp.equals(user.getMdp())) {
            message = "Le mot de passe est incorrect";
            request.setAttribute("messageErreurMdp", message);
            return "login";
        }


        HttpSession session = request.getSession(true);

        session.setAttribute("session", user);
        return "accueil";
    }

}
