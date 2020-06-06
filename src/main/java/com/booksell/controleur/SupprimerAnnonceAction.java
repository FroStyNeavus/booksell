/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.AnnonceDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.Action;
import com.Booksell.modele.Annonce;
import com.Booksell.modele.ConnectionManager;

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
