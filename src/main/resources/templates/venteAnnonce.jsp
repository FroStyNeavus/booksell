<%-- 
    Document   : historiqueVente
    Created on : Nov 23, 2019, 3:20:25 PM
    Author     : PC-WMT
--%>

<%@page import="com.booksell.modele.AnnonceDTO" %>
<%@page import="java.util.LinkedList" %>
<%@page import="java.util.List" %>
<%@page import="com.booksell.modele.Annonce" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="gabarit.jsp" %>
<a href="navbar.jsp"></a>
<%@include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<section class="page-section" id="populaires">
    <div class="container">
        <h2 class="text-center mt-0">Mes annonces</h2>
        <div class="row bg-light">
            <form class="form-inline p-2 ">
                <input type="hidden" name="ac" value="venteAnnonce">
                <input type="text" name="nomlivre" class="form-control mr-4" placeholder="Nom du livre"
                       value="${requestScope.nomlivre}">
                <button type="submit" class="btn btn-primary ">Chercher</button>
            </form>
        </div>

        <div class="row mt-5">
            <table class="table table-strip border">
                <thead>
                <tr class="tablehead mb-3 text-white" style="background-color: #f4623a">
                    <th scope="col-2">Nom du livre</th>
                    <th scope="col-2">Prix</th>
                    <th scope="col-2">État</th>
                    <th scope="col-2">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    //Chercher la liste des projets
                    List<AnnonceDTO> annonces = new LinkedList();
                    if (request.getAttribute("listeannonces") != null) {
                        annonces = (List<AnnonceDTO>) request.getAttribute("listeannonces");
                    }
                    annonces.size();
                    for (AnnonceDTO annonce : annonces) {
                %>
                <tr>
                    <td>
                        <table class="table table-borderless p-0 m-0">
                            <tr class="p-0 m-0" width="">
                                <td width="100px" rowspan="4" class="p-0 m-0"><img height="100px"
                                                                                   src=<%=annonce.getLivre().getImage()%> alt="">
                                </td>
                            </tr>
                            <tr class="p-0 m-0">
                                <td class="p-0 m-0 font-weight-bold"><%=annonce.getLivre().getTitre()%><br></td>

                            </tr>
                            <tr class="p-0 m-0">
                                <td class="p-0 m-0 font-weight-lighter"><%=annonce.getLivre().getAuteur()%><br></td>
                            </tr>
                            <tr class="p-0 m-0">

                                <td class="p-0 m-0 font-weight-lighter"><%=annonce.getLivre().getEditeur()%><br></td>
                            </tr>
                        </table>
                    </td>
                    <td><%=annonce.getAnnonce().getPrix()%>$</td>
                    <td><%=annonce.getAnnonce().getEtat()%>
                    </td>
                    <td>
                        <form>
                            <input type="hidden" name="ac" value="modifierannonce">
                            <input type="hidden" name="id" value="<%=annonce.getAnnonce().getId()%>">
                            <input type="hidden" name="prix" value="<%=annonce.getAnnonce().getPrix()%>">
                            <input type="hidden" name="etat" value="<%=annonce.getAnnonce().getEtat()%>">
                            <input type="hidden" name="ext" value="redir">
                            <button type="submit" value="Modifier" class="btn-md btn-primary form-control">
                                Modifier</input>
                        </form>
                        <a href="?ac=supprimerannonce&idannonce=<%=annonce.getAnnonce().getId()%>">
                            <button class="btn-md btn-primary form-control my-2" type="button">Supprimer</button>
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
