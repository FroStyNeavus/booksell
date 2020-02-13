package com.Booksell.controleur;

import com.Booksell.dao.UtilisateurDAO;
import com.Booksell.modele.AbstractAction;
import com.Booksell.modele.ConnectionManager;
import com.Booksell.modele.Utilisateur;

import javax.servlet.http.HttpSession;

public class ProfilModifierAction extends AbstractAction {
    @Override
    public String execute() {
        Utilisateur user;
        String pseudo = this.request.getParameter("pseudo");
        String mdp = this.request.getParameter("mdp");
        String email = this.request.getParameter("email");
        String telephone = this.request.getParameter("telephone");

        HttpSession session = request.getSession(true);
        user = (Utilisateur)session.getAttribute("session");

        boolean result = false;
        // Les entrees ne sont jamais nul dans ce cas
        if (!pseudo.isEmpty() && !mdp.isEmpty() && !email.isEmpty() && !telephone.isEmpty()){
            UtilisateurDAO dao = new UtilisateurDAO(ConnectionManager.getConnection());
            user.setMdp(mdp);
            user.setPseudo(pseudo);
            user.setCourriel(email);
            user.setTelephone(telephone);
            result = dao.modifier(user);
        }
        
        //Retourner des messages de rétroaction
        if(result==true){
            request.setAttribute("message", "Vous avez modifié votre profil");
        }else{
            request.setAttribute("message", "Erreur! Le profil n'est pas modifié");
        }
        request.setAttribute("result", result);
        request.setAttribute("utilisateur",user);
        
        AbstractAction action = new ProfilAfficherAction();
        action.setReponse(response);
        action.setRequest(request);
        return "profilAffichage";
    }
}
