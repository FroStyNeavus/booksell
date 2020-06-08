/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;

import com.booksell.dao.AnnonceDAO;
import com.booksell.modele.AbstractAction;
import com.booksell.modele.Action;
import com.booksell.modele.Annonce;
import com.booksell.modele.ConnectionManager;

/**
 * @author gerto
 */
public class SupprimerAnnonceAction extends AbstractAction {

    @Override
    public String execute() {
        //Initialiser les paramètres de la requête
        String idAnnonce = this.request.getParameter("idannonce");
        AnnonceDAO dao = new AnnonceDAO(ConnectionManager.getConnection());
        Annonce annonce = dao.trouverParId(idAnnonce);
        if (annonce != null) {
            dao.supprimer(annonce);
        }
        Action action = new VenteAnnonceAction();
        action.setReponse(response);
        action.setRequest(request);
        action.execute();
        return "venteAnnonce";
    }

}
