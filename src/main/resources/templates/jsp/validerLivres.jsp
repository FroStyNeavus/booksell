<%-- 
    Document   : ajoutlivre
    Created on : 2019-10-18, 09:56:45
    Author     : Christophe Muzadi et Gabriel Gaul
--%>

<%@page import="java.util.LinkedList" %>
<%@page import="com.booksell.modele.Livre" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="gabarit.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<section class="page-section bg-light text-white">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center text-dark">Validation d'un livre</h5>
                        <br>
                        <!--Message de rétroaction-->
                        <div class="row">
                            <div class="col-12">
                                <c:set var="result" value="${requestScope.result}"/>
                                <c:choose>
                                    <c:when test="${result==true}">
                                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                                            <c:out value="${requestScope.message}"/>
                                        </div>
                                    </c:when>
                                    <c:when test="${result=false}">
                                        <div class="alert alert-warning " role="alert">
                                            <c:out value="${requestScope.message}"/>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Titre</th>
                                    <th>Auteur</th>
                                    <th>Editeur</th>
                                    <th>Annee</th>
                                    <th>Description</th>
                                    <th>Categorie</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    LinkedList<Livre> livres = new LinkedList();
                                    if (request.getAttribute("livres") != null) {
                                        livres = (LinkedList<Livre>) request.getAttribute("livres");
                                    }
                                    for (Livre livre : livres) {
                                %>
                                <tr>
                                    <td>
                                        <button class="form-control-sm"
                                                onclick="window.location.href='<%=livre.getImage()%>'"><img
                                                height="100%" src="./static/open-iconic/svg/image.svg"/></button>
                                    </td>
                                    <td><%=livre.getTitre()%>
                                    </td>
                                    <td><%=livre.getAuteur()%>
                                    </td>
                                    <td><%=livre.getEditeur()%>
                                    </td>
                                    <td><%=livre.getAnnee()%>
                                    </td>
                                    <td><%=livre.getDescription()%>
                                    </td>
                                    <td><%=livre.getCategorie()%>
                                    </td>
                                    <td><a href="?ac=validerAnnonce&action=valider&id=<%=livre.getId()%>">Valider</a>
                                    </td>
                                    <td>
                                        <a href="?ac=validerAnnonce&action=supprimer&id=<%=livre.getId()%>">Supprimer</a>
                                    </td>
                                </tr>
                                <% } %>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    $('#image-modal').modal('show')
</script>

</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>

</html>
