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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author usager
 */
public class CatalogueParCategorieAction extends AbstractAction{
    
    @Override
    public String execute() {
        //Initialiser les paramètres de requête
        String categorie = this.request.getParameter("categorie");
        
        List<Livre> listeLivres;
        LivreDAO dao = new LivreDAO(ConnectionManager.getConnection());
        listeLivres = dao.trouverParCategorie(categorie);
        List<Livre> listeLivresValide = new LinkedList<Livre>();

        for (Livre livre : listeLivres){
            if (livre.getValide() > 0 ){
                listeLivresValide.add(livre);
            }
        }
        request.setAttribute("livres", listeLivresValide);
        return "catalogue";
    } 
}
