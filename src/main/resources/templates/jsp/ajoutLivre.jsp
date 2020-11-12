<%-- 
    Document   : ajoutlivre
    Created on : 2019-10-18, 09:56:45
    Author     : Christophe Muzadi et Gabriel Gaul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="gabarit.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<section class="page-section bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Ajouter un livre</h5>
                        <form class="form-signin" method="get">
                            <input type="hidden" name="ac" value="ajoutLivre">
                            <div class="form-label-group">
                                <input type="text" id="titre" name="titre" class="form-control" placeholder="Titre"
                                       required autofocus>
                                <label for="titre">Titre du livre</label>
                            </div>

                            <div class="form-label-group">
                                <input type="text" id="auteur" name="auteur" class="form-control"
                                       placeholder="Nom de l'auteur" required>
                                <label for="auteur">Nom de l'auteur</label>
                            </div>

                            <div class="form-label-group">
                                <input type="text" id="editeur" name="editeur" class="form-control"
                                       placeholder="Nom de l'editeur" required>
                                <label for="editeur">Nom de l'editeur</label>
                            </div>

                            <div class="form-label-group">
                                <input type="number" id="annee" name="annee" class="form-control"
                                       placeholder="Année de parution" required>
                                <label for="annee">Année de parution</label>
                            </div>

                            <div class="form-label-group">
                                <input type="text" id="description" name="description" class="form-control"
                                       placeholder="Description du livre" rows="3" required></textarea>
                                <label for="description">Description</label>
                            </div>
                            <select name="categorie" id="categorie" class="form-control">
                                <option value="Francais">Français</option>
                                <option value="Mathematiques">Mathématique</option>
                                <option value="Physique">Physique</option>
                                <option value="Philosophie">Philosophie</option>
                                <option value="Chimie">Chimie</option>
                                <option value="Anglais">Anglais</option>
                            </select><br>
                            <div class="form-label-group">
                                <input type="text" id="image" name="image" class="form-control"
                                       placeholder="Image de couverture" required>
                                <label for="image">Lien de l'image</label>
                            </div>

                            <button class="btn btn-lg btn-primary btn-block text-uppercase" value=" OK " type="submit">
                                Ajouter un livre
                            </button>

                            <hr class="my-4">
                        </form>
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
