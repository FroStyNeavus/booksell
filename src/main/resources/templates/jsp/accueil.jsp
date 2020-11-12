<%-- 
    Document   : accueil
    Created on : 11-Oct-2019, 12:07:16 AM
    Author     : PC
--%>
<%@page import="com.booksell.modele.ConnectionManager" %>
<%@page import="java.util.Random" %>
<%@page import="com.booksell.dao.LivreDAO" %>
<%@page import="com.booksell.modele.Livre" %>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Le meilleur endroit pour acheter vos manuels
                    scolaires</h1>
                <hr class="divider my-4">
            </div>
            <div class="col-lg-8 align-self-baseline">
                <p class="text-white-75 font-weight-light mb-5">Booksell vous permet d'acheter vos manuels scolaires
                    moins chers et de les revendre quand vous n'en
                    avez plus besoins!</p>
                <a class="btn btn-primary btn-xl js-scroll-trigger" href="?ac=nav&page=apropos">En savoir plus</a>
            </div>
        </div>
    </div>
</header>
<%
    Livre livre1, livre2, livre3, livre4;
    LivreDAO dao = new LivreDAO(ConnectionManager.getConnection());
    Random r = new Random();
    int nombre1, nombre2, nombre3, nombre4;

    nombre1 = r.nextInt(25) + 1;
    nombre2 = r.nextInt(25) + 1;
    nombre3 = r.nextInt(25) + 1;
    nombre4 = r.nextInt(25) + 1;
    while (nombre1 == nombre2 || nombre1 == nombre3 || nombre1 == nombre4) {
        nombre1 = r.nextInt(25);
    }
    while (nombre2 == nombre3 || nombre2 == nombre4) {
        nombre2 = r.nextInt(25);
    }
    while (nombre3 == nombre4) {
        nombre3 = r.nextInt(25);
    }
    livre1 = dao.trouverParId(nombre1);
    livre2 = dao.trouverParId(nombre2);
    livre3 = dao.trouverParId(nombre3);
    livre4 = dao.trouverParId(nombre4);
%>
<section class="page-section" id="populaires">
    <div class="container">
        <h2 class="text-center mt-0">Quelques ouvrages</h2>
        <hr class="divider my-4">
        <div class="row">
            <div class="col-lg-3 cold-md-6 text-center">
                <div class="mt-5">
                    <img style="max-height: 250px" style="max-width: 100px" src=<%=livre1.getImage()%> alt="">
                    <h3 class="h4 mb-2"><%=livre1.getTitre()%>
                    </h3>
                    <p class="text-muted mb-0"><%=livre1.getAuteur()%>
                    </p>
                </div>
            </div>
            <div class="col-lg-3 cold-md-6 text-center">
                <div class="mt-5">
                    <img style="max-height: 250px" style="max-width: 100px" src=<%=livre2.getImage()%> alt="">
                    <h3 class="h4 mb-2"><%=livre2.getTitre()%>
                    </h3>
                    <p class="text-muted mb-0"><%=livre2.getAuteur()%>
                    </p>
                </div>
            </div>
            <div class="col-lg-3 cold-md-6 text-center">
                <div class="mt-5">
                    <img style="max-height: 250px" style="max-width: 100px" src=<%=livre3.getImage()%> alt="">
                    <h3 class="h4 mb-2"><%=livre3.getTitre()%>
                    </h3>
                    <p class="text-muted mb-0"><%=livre3.getAuteur()%>
                    </p>
                </div>
            </div>
            <div class="col-lg-3 cold-md-6 text-center">
                <div class="mt-5">
                    <img style="max-height: 250px" style="max-width: 100px" src=<%=livre4.getImage()%> alt="">
                    <h3 class="h4 mb-2"><%=livre4.getTitre()%>
                    </h3>
                    <p class="text-muted mb-0"><%=livre4.getAuteur()%>
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="categories">
    <div class="container-fluid p-0">
        <div class="row no-gutters">
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" href="?ac=catalogueCategorie&categorie=Mathematiques">
                    <img class="img-fluid" src="./static/img/portfolio/categories/1.jpg" alt="Mathématiques">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Mathématiques
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" href="?ac=catalogueCategorie&categorie=Physique">
                    <img class="img-fluid" src="./static/img/portfolio/categories/2.jpg" alt="Physique">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Physique
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" href="?ac=catalogueCategorie&categorie=Chimie">
                    <img class="img-fluid" src="./static/img/portfolio/categories/3.jpg" alt="Chimie">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Chimie
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" href="?ac=catalogueCategorie&categorie=Francais">
                    <img class="img-fluid" src="./static/img/portfolio/categories/4.jpg" alt="Français">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Français
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" href="?ac=catalogueCategorie&categorie=Philosophie">
                    <img class="img-fluid" src="./static/img/portfolio/categories/5.jpg" alt="Philosophie">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Philosophie
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="categories-box" name="anglais" href="?ac=catalogueCategorie&categorie=Anglais">
                    <img class="img-fluid" src="./static/img/portfolio/categories/6.jpg" alt="Anglais">
                    <div class="categories-box-caption">
                        <div class="project-category text-white-50">
                            Catégorie
                        </div>
                        <div class="project-name">
                            Anglais
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</section>

<section class="page-section bg-dark text-white">
    <div class="container text-center">
        <h2 class="mb-4">Explorez notre catalogue!</h2>
        <a class="btn btn-light btn-xl" href="action?ac=catalogue">Explorez maintenant!</a>
    </div>
</section>
</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
