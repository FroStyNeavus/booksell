/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;
/**
 * @author usager
 */
public class AjoutAnnonceButtonAction extends AbstractAction {
    @Override
    public String execute() {
        String titre = this.request.getParameter("titre");
        return "ajoutAnnonce";
    }

}