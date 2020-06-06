<%-- 
    Document   : modifierProfilUtilisateur
    Created on : 26 nov. 2019, 16 h 51 min 51 s
    Author     : Pedro
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@include file="gabarit.jsp" %>
    <%@include file="navbar.jsp" %>
    <!-- Bootstrap CSS -->
    <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>
</head>
<body>
<section class="page-section" id="populaires">
    <div class='container'>
        <c:if test="${empty sessionScope.session}">
        <div class="card card-signin my-5">
            <div class="card-body">
                <div class="card-title h5 text-center">Vous n'�tes pas connect�.</div>
                <button class="justify-content-center form-control mb-1"
                        onclick="window.location.href='?ac=nav&page=login'" type="submit"/>
                Se connecter</button>
                <button class="justify-content-center form-control mt-1"
                        onclick="window.location.href='?ac=nav&page=signup'" type="submit"/>
                S'inscire</button>
                </c:if>

                <c:if test="${not empty sessionScope.session}">
                    <c:set var="user" value="${sessionScope.session}"/>
                    <form method="GET" class="was-validated">
                        <section id="details">
                            <div class="row">
                                <div class="col">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Modifier mon profil</h4>
                                        </div>
                                        <div class="card-body">
                                            <div class="form-group">
                                                <label for="pseudo">Nom</label>
                                                <input type="text" class="form-control" name="pseudo" id="pseudo"
                                                       value="${user.pseudo}" required/>
                                            </div>
                                            <div class="form-group">
                                                <label for="mdp">Mot de passe</label>
                                                <input type="password" class="form-control" id="mdp" name="mdp"
                                                       value="${user.mdp}" required/>
                                            </div>
                                            <div class="form-group">
                                                <label for="courriel">Courriel</label>
                                                <input type="email" class="form-control" id="courriel" name="email"
                                                       required value="${user.courriel}">
                                            </div>
                                            <div class="form-group">
                                                <label for="telephone">T�l�phone</label>
                                                <input type="tel" class="form-control" id="telephone" name="telephone"
                                                       required value="${user.telephone}">
                                            </div>
                                            <div class="col-md-3" style="float: right">
                                                <input type="hidden" name="ac" value="profilModifier">
                                                <button type="submit" class="btn btn-success btn-block">
                                                    <i class="fas fa-check"></i> Sauvegarder
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </form>

                    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                            crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                            crossorigin="anonymous"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                            crossorigin="anonymous"></script>
                </c:if>


            </div>
</section>
</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
