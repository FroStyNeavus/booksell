<%-- 
    Document   : ajoutAnnonce
    Created on : Oct 23, 2019, 9:03:31 AM
    Author     : PC-WMT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout Annonce</title>
    </head>
    <body>
        <section class="page-section bg-dark text-white">
        <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <%if (session.getAttribute("session") != null) {
                                Boolean ownProfile = false;%>
                                <h5 class="card-title text-center text-dark">Ajout d'une annonce de livre</h5>
                                <br>
                                <form class="form-signin" method="get">
                                    <a href="ajoutAnnonce.jsp"></a>
                                    <%
                                        //Récupération des données
                                        String nom = request.getAttribute("nom")!=null?request.getAttribute("nom").toString():"";
                                        String prix = request.getAttribute("prix")!=null?request.getAttribute("prix").toString():"";
                                        String etat = request.getAttribute("etat")!=null?request.getAttribute("etat").toString():"L'état du livre";
                                    %>
                                    <input type="hidden" name="ac" value="ajoutAnnonce">
                                    <div>
                                        <input style="height: 60px" type="hidden" id="inputName" name="nom" value="<%=nom%>">
                                        <label class="form-control"  placeholder="Nom du livre"><%=nom%></label>
                                    </div>
                                    <%
                                        {
                                        if(request.getAttribute("ERREUR_ANNONCE_LIVRENULL")!=null){
                                    %>
                                    <div class="alert alert-warning" role="alert">
                                        <strong><%=(String)request.getAttribute("ERREUR_ANNONCE_LIVRENULL")%></strong>
                                    </div>
                                    <%
                                        }
                                        }       
                                    %>
                                    
                                    <div>
                                        <input type="text" id="inputPrix" name="prix" class="form-control" placeholder="Prix demandé" value="<%=prix%>" required>
                                    </div>
                                    <%
                                        {
                                        if(request.getAttribute("ERREUR_DONNEE_NONNUMERIQUE")!=null){
                                    %>
                                    <div class="alert alert-warning" role="alert">
                                        <strong><%=(String)request.getAttribute("ERREUR_DONNEE_NONNUMERIQUE")%></strong>
                                    </div>
                                    <%
                                        }
                                        }       
                                    %>
                                    <br><br>
                                    <div class="form-label-group">
                                        <select name="etat">
                                            <option value="bon">Bon état</option>
                                            <option value="acceptable">État acceptable</option>
                                            <option value="mauvaise">Mauvais état</option>
                                        </select>
                                    </div>
                                    <br><br>

                                    <button class="btn btn-lg btn-primary btn-block text-uppercase" value="OK" type="submit">Ajouter</button>
                                    <hr class="my-4">
                                </form>
                            <%} else {%>
                                <h5 class="card-title text-center">Vous devez être connecter pour visualiser un profil.</h5>
                            <%}%>
                    </div>
                </div>
            </div>
        </div>
    </div>
        </section>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</html>