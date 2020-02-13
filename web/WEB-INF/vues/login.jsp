<%-- 
    Document   : login
    Created on : Oct 11, 2019, 9:33:01 AM
    Author     : PC-WMT
--%>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <header class="masthead" id="Se connecter">
            <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
            <div id="loginForm">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                            <div class="card card-signin my-5">
                                <div class="card-body">
                                    <h5 class="card-title text-center">Connexion</h5>
                                    <form class="form-signin" method="get">
                                        <input type="hidden" name="ac" value="login">

                                        <div class="form-label-group">
                                            <input type="text" id="username" name="pseudo" class="form-control" placeholder="Username" required autofocus>
                                            <label for="username">Nom d'utilisateur</label>
                                            <%
                                            if(request.getAttribute("messageErreurUser")!=null){
                                            %>
                                            <div class="form-text text-muted" role="alert">
                                            <%
                                                out.print(request.getAttribute("messageErreurUser"));
                                            %>  
                                            </div>
                                            <%
                                            }
                                            %>
                                        </div>

                                        <div class="form-label-group">
                                            <input type="password" id="password" name="mdp" class="form-control " placeholder="Password" required>
                                            <label for="password">Mots de passe</label>
                                            <%
                                            if(request.getAttribute("messageErreurMdp")!=null){
                                            %>
                                            <div class="form-text text-muted" role="alert">
                                            <%
                                                out.print(request.getAttribute("messageErreurMdp"));
                                            %>  
                                            </div>
                                            <%
                                            }
                                            %>
                                        </div>
                                        <div class="custom-control custom-checkbox mb-3">
                                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">Se souvenir de mon mot de passe</label>
                                        </div>
                                        <button class="btn btn-lg btn-primary btn-block text-uppercase" value=" OK " type="submit">Connecter</button>
                                        <button class="btn btn-lg btn-primary btn-block text-uppercase" onclick="window.location.href = '?ac=nav&page=signup';">Créer un compte</button>
                                        <hr class="my-4">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
         <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
     </div>
    </body>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</html>
