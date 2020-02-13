/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.dao.LivreDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Livre;

/**
 *
 * @author PC-WMT
 */
public class AjouterLivreAction extends AbstractAction{

    @Override
    public String execute() {
        
        String titre = this.request.getParameter("titre");
        String auteur = this.request.getParameter("auteur");
        String editeur = this.request.getParameter("editeur");
        String annee = this.request.getParameter("annee");
        String description = this.request.getParameter("description");
        String categorie = this.request.getParameter("categorie");
        String image = this.request.getParameter("image");
        int anneeInt = Integer.parseInt(annee);

        LivreDAO dao = new LivreDAO(ConnectionManager.getConnection());
        Livre livre = new Livre(0,titre,auteur,editeur,anneeInt,description,categorie,image, 0);
        dao.ajouter(livre);
        
        return "accueil";
    }
    
}
