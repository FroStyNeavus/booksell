<%-- 
    Document   : newjsp
    Created on : 12-Dec-2019, 11:18:20 PM
    Author     : PC
--%>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-9 col-lg-9 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <%
                        if (session.getAttribute("session") != null) {
                            Boolean ownProfile = false;
                    %>
                    <h5 class="card-title text-center">Profil</h5>
                    <div>
                        <button onclick="window.location.href='?ac=nav&page=modifierProfilUtilisateur'" type="submit"
                                class="btn-md btn-primary">Modifier profil
                        </button>
                    </div>
                    <div class="col-sm-11 col-md-11 col-lg-11 mx-auto">
                        <%
                            Utilisateur user = (Utilisateur) request.getAttribute("utilisateur");
                            if (user.getId() == ((Utilisateur) session.getAttribute("session")).getId()) {
                                ownProfile = true;
                            }
                        %>
                        <p class="text-center"><%out.print(user.getPseudo());%></p>

                        <div class="row">
                            <div class="col-sm-4 text-right">
                                <p>Adresse couriel: </p>
                                <p>Telephone: </p>
                                <p>Rank: </p>
                                <p>Titre: </p>
                            </div>
                            <div class="col-sm-7">
                                <p><%out.print(user.getCourriel());%></p>
                                <p><%out.print(user.getTelephone());%></p>
                                <p><%out.print(user.getRank());%></p>
                                <p><%out.print(user.getRole());%></p>
                            </div>
                        </div>
                    </div>
                    <h5 class="card-title text-center">Commentaires</h5>
                    <div class="col-sm-11 col-md-11 col-lg-11 mx-auto">

                    </div>
                    <%} else {%>
                    <h5 class="card-title text-center"></h5>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</div>
</header>

