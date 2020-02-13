package com.Booksell.controleur;

import com.Booksell.dao.LivreDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Livre;

import java.util.LinkedList;
import java.util.List;

public class ValiderAnnonceAction extends AbstractAction {

    @Override
    public String execute() {
        List<Livre> listeLivres;
        LivreDAO dao = new LivreDAO(ConnectionManager.getConnection());
        String idLivre = this.request.getParameter("id");
        String action = this.request.getParameter("action");
        
        
        List<Livre> listeLivresNonValide = new LinkedList<Livre>();
        if (action != null && !(idLivre.isEmpty())) {
            Livre livre = dao.trouverParId(Integer.parseInt(idLivre));
            if (action.equals("valider")) {
                if (idLivre != null && !(idLivre.isEmpty())) {
                    dao.validerLivre(idLivre);
                    request.setAttribute("result", true);
                    request.setAttribute("message", "Le livre \"" + livre.getTitre() + "\" est validé!" );
                }
            } else if (!action.equals("valider")) {
                if (idLivre != null && !(idLivre.isEmpty())) {
                    dao.supprimer(idLivre);
                    request.setAttribute("result",true);
                    request.setAttribute("message", "Le livre \""+ livre.getTitre() + "\" est supprimé!");
                }
            }
        }

        listeLivres = dao.trouverTout();
        for (Livre unLivre : listeLivres) {
            if (unLivre.getValide() == 0) {
                listeLivresNonValide.add(unLivre);
            }
        }
        request.setAttribute("livres", listeLivresNonValide);
        return "validerLivres";
    }
}
