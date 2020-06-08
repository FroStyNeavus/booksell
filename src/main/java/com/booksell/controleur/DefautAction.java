/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.controleur;

import com.booksell.modele.AbstractAction;

/**
 * @author PC
 */
public class DefautAction extends AbstractAction {
    @Override
    public String execute() {
        return "accueil";
    }


}
