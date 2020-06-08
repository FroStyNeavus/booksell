/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;

import com.booksell.dao.AnnonceDAO;
import com.booksell.modele.AbstractAction;
import com.booksell.modele.AnnonceDTO;
import com.booksell.modele.ConnectionManager;

import java.util.List;

/**
 * @author Dany
 */
public class AnnonceLivreAction extends AbstractAction {
    @Override
    public String execute() {
        //Initialiser les paramètres de requête
        String nom = this.request.getParameter("titre");

        //Trouver les annonces du livre
        List<AnnonceDTO> listeAnnonces;
        AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionManager.getConnection());
        listeAnnonces = annonceDAO.trouverAnnonceParTitreLivre(nom);

        request.setAttribute("annonces", listeAnnonces);
        return "annonceLivre";
    }
}
