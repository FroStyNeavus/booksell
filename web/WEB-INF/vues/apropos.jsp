<%-- 
    Document   : apropos
    Created on : Dec 13, 2019, 8:31:22 AM
    Author     : Mu Tian Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<section class="page-section" id="populaires">
    <div class="container h-100">
        <div class="h2 text-center">Qui sommes-nous?</div>
        <div class="row mt-4 card-body">
            <div class="col-6">
                <img class="img-fluid" src="./static/img/team-picture.jpg"/>
                <div class="text-center h4 mt-1">Développeurs</div>
                <div class="row text-center border-light">
                    <div class="col-6">
                        Feune Ouambo Daniel<br>
                        Mu Tian Wang<br>
                        Dany Galarneau<br>
                        Dominik Dupuis<br>
                    </div>
                    <div class="col-6">
                        Gabriel Gaul<br>
                        Christophe<br>
                        Pedro Cabrera<br>
                        Sohbi El-Safady<br>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <p>
                    Booksell est un site créer par nous, élèves du collège de Rosemont,
                    dans le cadre de cours de projet afin de répondre à l’un des plus grands
                    besoins de notre collège. Il s’agissais de la difficulté des élèves pour
                    vendre leurs vieux livres et à trouver des bons livres usagés à acheter.
                    Pour remédier à ce problème, moi et mon équipe nous avons décider de créer
                    un site web de ventes de livre pour notre collège afin permettre aux étudiants de
                    Rosemont de pouvoir facilement acheter et vendre des livres entre eux. L’objectif du
                    site est d’offrir aux élèves du collège un interface fiable et sécuritaire où ils
                    pourront vendre ou acheter rapidement et facilement des livres chaque session.
                    Dans l’avenir, on voudrait pouvoir agrandir le site et son catalogue de livre pour pouvoir
                    l’implémenter dans d’autres cégep et peut être même dans d’autres établissements scolaires
                    tels que des écoles secondaires ou universitaires et rajouter un système de discussion instantanée
                    entre les utilisateurs.
                </p>
            </div>
        </div>
        <c:if test="${empty sessionScope.session}">
            <div class="pt-4 row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="d-flex justify-content-center"><input class="btn-primary btn-xl" type="button"
                                                                      onclick="window.location.href='?ac=nav&page=signup'"
                                                                      value="Essayer-le"/></div>
                </div>
                <div class="col-3"></div>
            </div>
        </c:if>
    </div>
</section>
</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
