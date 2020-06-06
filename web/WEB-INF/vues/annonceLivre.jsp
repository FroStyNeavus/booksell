<%-- 
    Document   : annonceLivre
    Created on : 2019-11-28, 15:30:21
    Author     : dany_
--%>

<%@page import="com.Booksell.modele.ConnectionManager" %>
<%@page import="com.Booksell.dao.UtilisateurDAO" %>
<%@page import="com.Booksell.modele.AnnonceDTO" %>
<%@page import="java.util.LinkedList" %>
<%@page import="java.util.List" %>
<%@page import="com.Booksell.modele.Annonce" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="gabarit.jsp" %>
<a href="navbar.jsp"></a>
<%@include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<%
    //Chercher la liste des projets
    List<AnnonceDTO> annonces = new LinkedList();
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO(ConnectionManager.getConnection());
    if (request.getAttribute("annonces") != null) {
        annonces = (List<AnnonceDTO>) request.getAttribute("annonces");
    }

    if (annonces.size() == 0) {
%>
<body>
<section class="page-section" id="populaires">
    <div class="container"><br><br>
        <h2 class="text-center mt-0">Aucune annonce trouvée pour le livre : <%=request.getParameter("titre")%>
        </h2>
    </div>
</section>
</body>
<%
} else {
%>
<body>
<section class="page-section" id="populaires">
    <div class="container">
        <h2 class="text-center mt-0">Annonces pour le livre : <%=request.getParameter("titre")%>
        </h2><br><br>
        <table class="table table-strip border">
            <thead>
            <tr class="tablehead mb-3 text-white" style="background-color: #f4623a">
                <th scope="col-2">Nom du livre</th>
                <th scope="col-2">Description du vendeur</th>
                <th scope="col-2">Prix</th>
                <th scope="col-2">État</th>
            </tr>
            </thead>
            <%
                annonces.size();
                for (AnnonceDTO annonce : annonces) {
            %>
            <tbody>
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
                <td>
                    <table class="table table-borderless p-0 m-0">
                        <tr class="p-0 m-0">
                            <c:set var="user" value="${annonce.livre}"/>
                            <td class="p-0 m-0">Nom: <a
                                    href="?ac=profil&pseudo=<%=utilisateurDAO.trouverParId(annonce.getAnnonce().getUtilisateurID()+"").getPseudo()%>"><%=utilisateurDAO.trouverParId(annonce.getAnnonce().getUtilisateurID()+"").getPseudo()%><br>
                            </td>
                        </tr>
                        <tr class="p-0 m-0">
                            <td class="p-0 m-0">
                                Courriel: <%=utilisateurDAO.trouverParId(annonce.getAnnonce().getUtilisateurID() + "").getCourriel()%>
                                <br></td>
                        </tr>
                        <tr class="p-0 m-0">

                            <td class="p-0 m-0">
                                Téléphone: <%=utilisateurDAO.trouverParId(annonce.getAnnonce().getUtilisateurID() + "").getTelephone()%>
                                <br></td>
                        </tr>
                    </table>
                </td>
                <td><%=annonce.getAnnonce().getPrix()%>$</td>
                <td><%=annonce.getAnnonce().getEtat()%>
                </td>
            </tr>
            <%
                    }
                }

            %>
            </tbody>
        </table>
    </div>
</section>
</body>


</html>
