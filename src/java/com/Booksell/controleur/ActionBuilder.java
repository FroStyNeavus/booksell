/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.controleur;

import com.Booksell.modele.Action;

/**
 *
 * @author PC
 */
public class ActionBuilder {
    public static Action getAction(String nom){
        Action action;
        switch(nom){
            case "nav":
                action = new NavigationAction();
                break;
            case "login":
                action = new ConnexionAction();
                break;
            case "catalogue":
                action = new CatalogueLivreAction();
                break;
            case "recherche":
                action = new CatalogueParTitre();
                break;
            case "signup":
                action = new InscriptionAction();
                break;
            case "logout":
                action = new DeconnexionAction();
                break;
            case "ajoutAnnonce":
                action= new AjoutAnnonceAction();
                break;
            case "catalogueCategorie":
                action = new CatalogueParCategorieAction();
                break;
            case "ajoutAnnonceButton":
                action= new AjoutAnnonceButtonAction();
                break;
            case "profil":
                action= new ProfilAfficherAction();
                break;
            case "ajoutLivre":
                action= new AjouterLivreAction();
                break;
            case "venteAnnonce":
                action = new VenteAnnonceAction();
                break;
            case "modifierannonce":
                action = new ModifierAnnonceAction();
                break;
            case "supprimerannonce":
                action = new SupprimerAnnonceAction();
                break;
            case "annonceLivre":
                action = new AnnonceLivreAction();
                break;
            case "profilModifier":
                action=new ProfilModifierAction();
                break;
            case "validerAnnonce":
                action=new ValiderAnnonceAction();
                break;
            default:
                action = new DefautAction();
                break;   
        }   
        return action;
    }
}
