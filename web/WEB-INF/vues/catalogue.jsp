<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Booksell.modele.Livre" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: dead
  Date: 10/23/19
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<html>
<section class="page-section" id="populaires">
    <div class="container" align="center">
        <h2 class="text-center mt-0">Listes des ouvrages</h2>
        <br>
        <br>
        <form id="categorie" method="get">
            <label for="selectCategorie">Afficher les livres de </label>
            <input type="hidden" name="ac" value="catalogueCategorie">
            <select style="text-align: center" id="categorie" class="form-control" name="categorie"
                    onchange="this.form.submit()" autofocus>
                <%if (request.getParameter("categorie") != null) {%>
                <option selected disabled hidden><%=request.getParameter("categorie")%>
                </option>
                <%
                } else {%>
                <option selected disabled hidden>-Veuillez choisir une cat�gorie-</option>
                <%}%>
                <option value="Francais">Fran�ais</option>
                <option value="Mathematiques">Math�matiques</option>
                <option value="Physique">Physique</option>
                <option value="Philosophie">Philosophie</option>
                <option value="Chimie">Chimie</option>
                <option value="Anglais">Anglais</option>
            </select>
        </form>
        <c:if test="${not empty sessionScope.session}">
            <button onclick="window.location.href='?ac=nav&page=ajoutLivre'" class="btn btn-primary mt-5">Ajouter un
                livre
            </button>
        </c:if>
        <br>
        <h3 id="supprimerHeader" hidden="" class="text-center mt-0" style="color: red">L'ouvrage a ete supprimer !!</h3>
        <h3 id="modifierHeader" hidden="" class="text-center mt-0" style="color: red">L'ouvrage a ete modifier !!</h3>
        <hr class="divider my-4">
        <div class="shop-product-wrap grid with-pagination row space-db--30 shop-border">
            <%
                LinkedList<Livre> livres = new LinkedList();
                if (request.getAttribute("livres") != null) {
                    livres = (LinkedList<Livre>) request.getAttribute("livres");
                }
                for (Livre livre : livres) {
            %>
            <div class="col-lg-4 col-sm-6" style="border-style: solid;border-color: #f4623a;border-width: medium;">
                <div class="product-card">
                    <div class="product-grid-content">
                        <div style="height: 2ex" class="my-2 product-header">
                            <a>
                                Titre:
                            </a>
                            <a style="color:gray">
                                <%=livre.getTitre()%>
                            </a>
                        </div>
                        <br>
                        <div class=" m-2 product-card--body">
                            <div class="card-image">
                                <img style="height: 140px" src=<%=livre.getImage()%> alt="">
                                <div class="hover-contents">
                                    <a href="" class="hover-image">
                                    </a>
                                    <div class="hover-btns "><br>
                                        <div style="height: 2em" class="my-4">
                                            <a>
                                                Auteur:
                                            </a>
                                            <a style="color:gray">
                                                <%=livre.getAuteur()%>
                                            </a>
                                        </div>

                                        <%
                                            if (session.getAttribute("session") != null) {
                                        %>
                                        <form method="get">
                                            <input type="hidden" name="ac" value="ajoutAnnonce">
                                            <button name="titre" id="titre" class="btn-md btn-primary form-control m-2"
                                                    value="<%=livre.getTitre()%>" type="submit">Cr�er une annonce
                                            </button>
                                            <input type="hidden" name="ext" value="redir">
                                        </form>
                                        <form method="get">
                                            <input type="hidden" name="ac" value="annonceLivre">
                                            <button name="titre" id="titre" class="btn-md btn-primary form-control m-2"
                                                    value="<%=livre.getTitre()%>" type="submit">Voir annonces de ce
                                                livre
                                            </button>
                                        </form>
                                        <%
                                            }
                                        %>
                                        <script>
                                            id

                                        </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>


        <!-- The Modal -->
        <div class="modal" id="editPrixModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modifier le prix de l'oeuvre</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        Modifier le prix du livre
                        <form>
                            <label for="id">Id de l'oeuvre</label>
                            <input type="text" id="id" name="id" class="form-control" placeholder="Id"
                                   value="" required autofocus disabled>

                            <label for="id">Prix</label>
                            <input type="text" id="prix" name="prix" class="form-control" placeholder="Prix"
                                   required autofocus>
                            <br>
                            <button type="button" class="btn btn-success"
                                    onclick="modifySomething(getElementById('id').value, getElementById('prix').value)">
                                Valider
                            </button>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
