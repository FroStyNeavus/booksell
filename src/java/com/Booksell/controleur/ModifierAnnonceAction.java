/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.AnnonceDAO;
import com.Booksell.factories.ErreurManager;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.Action;
import com.Booksell.modele.Annonce;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mu Tian Wang
 */
public class ModifierAnnonceAction extends AbstractAction{
    @Override
    public String execute() {
        //Initialiser les paramètres de la requête
        String idAnnonce = this.request.getParameter("id");
        String etat = this.request.getParameter("etat");
        String prix = this.request.getParameter("prix");
        String ext = this.request.getParameter("ext");
        
        if(ext!=null && ext.equals("redir")){
            request.setAttribute("id", idAnnonce);
            request.setAttribute("etat", etat);
            request.setAttribute("prix", prix);
            return "modifierAnnonce";
        }
        
        boolean erreur = false;
        //Vérifier la validité des paramètres
        try {
            double d = Double.parseDouble(prix);
        } catch (NumberFormatException | NullPointerException exp) {
            erreur = true;
            request.setAttribute("ERREUR_DONNEE_NONNUMERIQUE", ErreurManager.ERREUR_DONNEE_NONNUMERIQUE);
            System.out.println("ERREUR_DONNEE_NONNUMERIQUE");
        }
        
        double prixDouble;
        int livreIdInt;

        //Vérifier et instancier l'utilisateur
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur;
        utilisateur = (Utilisateur)session.getAttribute("session");
        if(utilisateur==null){
            erreur = true;
            request.setAttribute("ERREUR_USER_PASCONNECTE",ErreurManager.ERREUR_USER_PASCONNECTE);
            return "login";
        }
        
        //Vérifier et instancier l'annonce
        AnnonceDAO daoAnnonce = new AnnonceDAO(ConnectionManager.getConnection());
        Annonce annonce;
        if ((annonce = daoAnnonce.trouverParId(idAnnonce))==null){
            erreur = true;
            request.setAttribute("ERREUR_ANNONCE_ANNONCENULL",ErreurManager.ERREUR_ANNONCE_ANNONCENULL);
        }
        
        System.out.println("ARRIVED BEFORE");
        if(erreur){
            request.setAttribute("id", idAnnonce);
            request.setAttribute("etat", etat);
            request.setAttribute("prix", prix);
            return "modifierAnnonce";
        }
        System.out.println("ARRIVED AFTER");
        
        if(prix != null){
            prixDouble = Double.parseDouble(prix);
            if(annonce != null){
                annonce = new Annonce(idAnnonce,etat,prixDouble,annonce.getLivreId(),annonce.getUtilisateurID()); 
                System.out.println(daoAnnonce.modifier(annonce));
                System.out.println("ARRIVED END");
            }
            Action action = new VenteAnnonceAction();
            action.setReponse(response);
            action.setRequest(request);
            action.execute();
        }
        return "venteAnnonce";
    }
    
}