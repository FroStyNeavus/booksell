<%-- 
    Document   : Profil
    Created on : Oct 11, 2019, 9:33:01 AM
    Author     : Gabriel Gaul
--%>
<%@include file="gabarit.jsp" %>
<%@include file="navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <section class="page-section bg-light" id="populaires">
        <div class="container">
            <div class="col-sm-9 col-md-9 col-lg-9 mx-auto">
                <!--Utilisateur non-connecté-->
                <c:if test="${empty sessionScope.session}">
                    <div class="card card-signin my-5">
                    <div class="card-body">
                    <div class="card-title h5 text-center">Vous n'êtes pas connecté.</div>
                    <button class="justify-content-center form-control mb-1" onclick="window.location.href='?ac=nav&page=login'" type="submit"/>Se connecter</button>
                    <button class="justify-content-center form-control mt-1" onclick="window.location.href='?ac=nav&page=signup'" type="submit"/>S'inscire</button>
                </c:if>
                <!--Utilisateur connecté-->
                <c:if test="${not empty sessionScope.session}">
                    
                    <c:set var="user" value="${requestScope.utilisateur}"/>
                    <!--Contenue du profil-->
                    <div class="card card-signin my-5">
                    <div class="card-body">
                        <!--Message de rétroaction-->
                        <div class="row">
                            <div class="col-12">
                            <c:set var="result" value="${requestScope.result}"/>
                            <c:choose >
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
                        <div class="row">
                            <div class="col-4" ><img class="img-fluid" src="./static/img/default-profile.png"/></div>
                            <div td class="col-8">
                                <div class="row">
                                    <div class="mb-0 pb-0 col-12 display-2"><c:out value="${user.pseudo}"/></div>
                                    <div class="pl-2">
                                        <div class="mb-0 pb-0 col-12"><c:out value="${user.role}"/></div>
                                        <div class="col-12">Téléphone: <c:out value="${user.telephone}"/></div>
                                        <div class="col-12">Courriel: <a href="mailto:${user.courriel}"><c:out value="${user.courriel}"/></a></div>
                                    </div>
                                </div>
                            </div>
                            
                            <c:if test="${sessionScope.session.id==user.id}">
                            <div class="col-4 mt-2"><button class="form-control" onclick="window.location.href='?ac=nav&page=profilModification'">Modifier le profil</button></div>
                            </c:if>
                            <div class="col-12 mt-2 pt-2">
                                <h5 class="card-title text-center">Commentaires</h5>
                            </div>
                        </div>
                    </div>
                    </div>
                    <!--[FIN] Contenue du profil-->
                </c:if>
                    
                </div>
            </div>
                
        </div>
        </section>
             
                                        
    </body>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</html>