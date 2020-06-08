/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;


import com.booksell.dao.AnnonceDAO;
import com.booksell.dao.LivreDAO;
import com.booksell.factories.ErreurManager;
import com.booksell.factories.ObjectFactory;
import com.booksell.modele.*;

import javax.servlet.http.HttpSession;

/**
 * @author usager
 */
public class AjoutAnnonceAction extends AbstractAction {
    @Override
    public String execute() {
        //Initialiser les paramètres de requête
        String nom = this.request.getParameter("titre");
        String prix = this.request.getParameter("prix");
        String etat = this.request.getParameter("etat");
        String ext = this.request.getParameter("ext");

        //Redirection d'une autre page
        if (ext != null && ext.equals("redir")) {
            request.setAttribute("nom", nom);
            return "ajoutAnnonce";
        }
        String titre = this.request.getParameter("nom");
        //Vérifier la validité des paramètres
        boolean erreur = false;
        try {
            double d = Double.parseDouble(prix);
        } catch (NumberFormatException | NullPointerException exp) {
            erreur = true;
            request.setAttribute("ERREUR_DONNEE_NONNUMERIQUE", ErreurManager.ERREUR_DONNEE_NONNUMERIQUE);
        }

        //Vérifier et instancier l'utilisateur
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur;
        utilisateur = (Utilisateur) session.getAttribute("session");
        if (utilisateur == null) {
            erreur = true;
            request.setAttribute("ERREUR_USER_PASCONNECTE", ErreurManager.ERREUR_USER_PASCONNECTE);
            return "login";
        }

        //Vérifier et instancier le livre
        LivreDAO daoL = new LivreDAO(ConnectionManager.getConnection());
        Livre livre;
        if ((livre = daoL.trouverParNom(titre)) == null) {
            erreur = true;
            request.setAttribute("ERREUR_ANNONCE_LIVRENULL", ErreurManager.ERREUR_LIVRE_LIVRENULL);
        }

        //Reprise des entrées
        if (erreur) {
            request.setAttribute("nom", nom);
            request.setAttribute("prix", prix);
            return "ajoutAnnonce";
        }
        //Créer l'annonce
        if (prix != null) {
            double prixDouble = Double.parseDouble(prix);
            Annonce annonce = ObjectFactory.getNewAnnonce();
            annonce.setEtat(etat);
            annonce.setPrix(prixDouble);
            annonce.setLivreId(livre.getId());
            annonce.setUtilisateurID(utilisateur.getId());
            AnnonceDAO dao = new AnnonceDAO(ConnectionManager.getConnection());
            dao.ajouter(annonce);
        }
        Action action = new VenteAnnonceAction();
        action.setReponse(response);
        action.setRequest(request);
        action.execute();
        return "venteAnnonce";
    }
}
