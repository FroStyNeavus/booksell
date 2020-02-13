/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.AnnonceDAO;
import com.Booksell.factories.ErreurManager;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.AnnonceDTO;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mu Tian Wang
 * 
 */
public class VenteAnnonceAction extends AbstractAction{
    @Override
    public String execute() {
        //Initialiser les paramètres de la requête
        String idAnnonce = request.getParameter("idannonce");
        String nomLivre = request.getParameter("nomlivre");
        HttpSession session = request.getSession(true);
        
        //Vérifier l'authentification de l'utilisateur
        Utilisateur utilisateur = (Utilisateur)session.getAttribute("session");
        if(utilisateur==null){
            request.setAttribute("ERREUR_USER_PASCONNECTE",ErreurManager.ERREUR_USER_PASCONNECTE);
            return "login";
        }
        
        
        List<AnnonceDTO> listeAnnonces;
        AnnonceDTO annonceDTO;
        AnnonceDAO daoAnnonce = new AnnonceDAO(ConnectionManager.getConnection());
        
        if(!(("").equals(nomLivre)) && nomLivre!=null){
            listeAnnonces = daoAnnonce.trouverAnnonceInfoParTitreLivre(utilisateur,nomLivre);
        }else{
            listeAnnonces = daoAnnonce.trouverAnnonceInfoParUser(utilisateur);
        }
        
        request.setAttribute("listeannonces", listeAnnonces);
        request.setAttribute("nomlivre",nomLivre);
        return "venteAnnonce";
        
    }
    
}
