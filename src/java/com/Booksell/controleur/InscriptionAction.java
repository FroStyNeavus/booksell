/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.UtilisateurDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC-WMT
 */
public class InscriptionAction extends AbstractAction{

    @Override
    public String execute() {
        String pseudo = this.request.getParameter("pseudo");
        String mdp = this.request.getParameter("mdp");
        String email = this.request.getParameter("email");
        String telephone = this.request.getParameter("tele");
        HttpSession session = request.getSession(true);
        
        UtilisateurDAO dao = new UtilisateurDAO(ConnectionManager.getConnection());
        Utilisateur user = new Utilisateur(pseudo,mdp,email,telephone);
        dao.ajouter(user);
        user = dao.trouverParNom(pseudo);
        if (user == null){
            String message = "Une Erreur s'est produite lors de l'inscription, veuiller vérifier les information et réessayer.";
            request.setAttribute("messageErreurSignup", message);
            return "signup";
        }
        session.setAttribute("session",user);

        return "accueil";
    }
    
}
