<%-- 
    Document   : erreur
    Created on : 2019-09-19, 09:38:45
    Author     : usager
--%>
<%@page import="java.util.ArrayList" buffer="64kb" errorPage="erreur.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="gabarit.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Erreur</title>
</head>
<body>
<div class="container">
    <section class="page-section" id="populaires">
        <div class="row">
            <div class="col-sm-11 col-md-11 col-lg-11 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h1>Une erreur s'est produite lors de l'exécution de la page web demandée.</h1><br>
                        <p>
                            Veuillez réessayer plus tard.
                            Si le problème persiste, veuillez contactez un administrateur.
                        </p>
                    </div>
                </div>
            </div>
        </div>
</div>
</section>
</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
