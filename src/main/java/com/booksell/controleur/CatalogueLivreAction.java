/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;

import com.booksell.dao.LivreDAO;
import com.booksell.modele.AbstractAction;
import com.booksell.modele.ConnectionManager;
import com.booksell.modele.Livre;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 14389
 */
public class CatalogueLivreAction extends AbstractAction {

    @Override
    public String execute() {
        List<Livre> listeLivres = new LinkedList();
        LivreDAO databaseService = new LivreDAO(ConnectionManager.getConnection());
        List<Livre> listeLivresValide = new LinkedList<Livre>();

        listeLivres = databaseService.trouverTout();
        for (Livre livre : listeLivres) {
            if (livre.getValide() > 0) {
                listeLivresValide.add(livre);
            }
        }
        request.setAttribute("livres", listeLivresValide);
        return "catalogue";
    }

}
