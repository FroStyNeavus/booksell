<%-- 
    Document   : signup
    Created on : Oct 11, 2019, 9:03:31 AM
    Author     : PC-WMT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <header class="masthead" id="S'inscrire">
    <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->


    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Inscription</h5>
                        <%
                            if(request.getAttribute("messageErreurUser")!=null){
                        %>
                        <div class="form-text text-muted" role="alert">
                            <%
                                out.print(request.getAttribute("messageErreurSignup"));
                            %>
                        </div>
                        <%
                            }
                        %>
                        <form class="form-signin" method="get">
                            <input type="hidden" name="ac" value="signup">
                            <div class="form-label-group">
                                <input type="text" id="inputUsername" name="pseudo" class="form-control" placeholder="Username" required autofocus>
                                <label for="inputUsername">Nom d'utilisateur</label>
                            </div>

                            <div class="form-label-group">
                                <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
                                <label for="inputEmail">Adresse courriel</label>
                            </div>

                            <div class="form-label-group">
                                <input type="password" id="inputPassword" name="mdp" class="form-control" placeholder="Password" required>
                                <label for="inputPassword">Mots de passe</label>
                            </div>

                            <div class="form-label-group">
                                <input type="tel" id="inputTelephone" name="tele" class="form-control" placeholder="Telephone" required>
                                <label for="inputTelephone">Téléphone</label>
                            </div>


                            <button class="btn btn-lg btn-primary btn-block text-uppercase" value="OK" type="submit">S'inscrire</button>

                            
                            <hr class="my-4">
                        </form>
                        <a href="action?ac=nav&page=login" class="float-right">Déja inscrit? Connecter vous</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</html>
