package com.booksell.controleur;

import com.booksell.dao.LivreDAO;
import com.booksell.modele.AbstractAction;
import com.booksell.modele.ConnectionManager;
import com.booksell.modele.Livre;

import java.util.LinkedList;
import java.util.List;

public class CatalogueParTitre extends AbstractAction {

    @Override
    public String execute() {
        //Initialiser les paramètres de requête
        List<Livre> livres;
        LivreDAO dao = new LivreDAO(ConnectionManager.getConnection());
        String searchString = this.request.getParameter("titre");
        //String searchType = this.request.getParameter("search_type");
        livres = dao.trouverParTitrePourRecherche(searchString);
        List<Livre> listeLivresValide = new LinkedList<Livre>();


        for (Livre livre : livres) {
            if (livre.getValide() > 0) {
                listeLivresValide.add(livre);
            }
        }
        System.out.println(livres.size());
        request.setAttribute("livres", listeLivresValide);
        return "catalogue";
    }

}