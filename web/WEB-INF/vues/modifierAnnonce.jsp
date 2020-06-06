<%-- 
Document   : ajoutAnnonce
Created on : Oct 23, 2019, 9:03:31 AM
Author     : PC-WMT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier annonce</title>
</head>
<header class="masthead" id="ajout">
    <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

    <br><br>
    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Modification d'une annonce</h5>
                        <br>
                        <form class="form-signin" method="get">
                            <input type="text" id="inputPrix" name="prix" class="form-control m-2" placeholder="Prix"
                                   value="${requestScope.prix}" required autofocus>
                            <%
                                {
                                    if (request.getAttribute("ERREUR_DONNEE_NONNUMERIQUE") != null) {
                            %>
                            <div class="alert alert-warning" role="alert">
                                <strong>${requestScope.ERREUR_DONNEE_NONNUMERIQUE}</strong>
                            </div>
                            <%
                                    }
                                }
                            %>

                            <%
                                {
                                    if (request.getAttribute("ERREUR_ANNONCE_ANNONCENULL") != null) {
                            %>
                            <div class="alert alert-warning" role="alert">
                                <strong>${requestScope.ERREUR_ANNONCE_ANNONCENULL}</strong>
                            </div>
                            <%
                                    }
                                }
                            %>


                            <input type="hidden" name="id" value="${requestScope.id}">
                            <input type="hidden" name="prix" value="${requestScope.prix}">
                            <input type="hidden" name="ac" value="modifierannonce">
                            <select name="etat" class="custom-select m-2">
                                <option value="bon">Bonne état</option>
                                <option value="acceptable">État acceptable</option>
                                <option value="mauvaise">Mauvaise état</option>
                            </select>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase m-2" value="OK"
                                    type="submit">Modifier
                            </button>
                            <hr class="my-4">
                        </form>
                    </div>
                </div>
            </div>
        </div>
</header>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>