/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.modele.AbstractAction;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danny
 */
public class DeconnexionAction extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if( session != null){
            session.invalidate();
            return "accueil";
        }
        return null;
    }
    
}
