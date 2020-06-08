<%-- 
    Document   : navbar
    Created on : Oct 11, 2019, 9:06:12 AM
    Author     : PC-WMT
--%>

<%@page import="com.booksell.modele.Utilisateur" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 navbar-scrolled" id="mainNav">

    <!-- Navbar brand -->
    <!-- Le nom du site changer -->
    <a class="text-dark navbar-brand js-scroll-trigger" href="?ac=nav&page=accueil">Booksell</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive">
        <div class="navbar-toggler-icon"></div>
    </button>

    <!-- Contenue effondrable -->
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <!-- Menu -->
        <ul class="text-dark navbar-nav ml-auto my-2 my-lg-0">
            <li class="nav-item">
                <a class="text-dark nav-link js-scroll-trigger" href="?ac=nav&page=accueil">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="text-dark nav-link js-scroll-trigger" href="?ac=nav&page=apropos">À propos</a>
            </li>
            <li class="nav-item">
                <a class="text-dark nav-link js-scroll-trigger" href="?ac=catalogue">Catalogue</a>
            </li>
            <%
                if (session.getAttribute("session") != null) {
                    Utilisateur user = (Utilisateur) session.getAttribute("session");
                    if (user.getRole().equals("admin")) {

            %>

            <li class="nav-item"><a class="text-dark nav-link js-scroll-trigger" href="?ac=validerAnnonce">Valider
                Livres</a>
            </li>
            <%
                }
            %>
            <li class="nav-item"><a class="text-dark nav-link js-scroll-trigger" href="?ac=venteAnnonce">Annonce</a>
            </li>
            <li class="nav-item"><a class="text-dark nav-link js-scroll-trigger"
                                    href="?ac=profil&pseudo=<%=user.getPseudo()%>">Profil</a>
            </li>
            <li class="nav-item"><a class="text-dark nav-link js-scroll-trigger" href="?ac=logout">Se
                déconnecter (<%=user.getPseudo()%>)</a>
            </li>
            <%
            } else {
            %>
            <li class="nav-item">
                <a class="text-dark nav-link js-scroll-trigger" href="?ac=nav&page=login">Se connecter</a>
            </li>
            <li class="nav-item">
                <a class="text-dark nav-link js-scroll-trigger" href="?ac=nav&page=signup">S'inscrire</a>
            </li>
            <%
                }
            %>
        </ul>
        <!-- Formulaire de recherche -->
        <form method="get" class="form-inline ml-auto my-2 my-lg-0">
            <div class="md-form my-lg-0 my-2">
                <input type="text" name="titre" class="form-control" placeholder="Rechercher un manuel"
                       aria-label="Chercher">
                <input type="hidden" name="ac" value="recherche">
            </div>
            <button class="btn btn-primary btn-md my-0 ml-sm-2" type="submit">Search</button>
        </form>
    </div>
</nav>
</body>
</html>
