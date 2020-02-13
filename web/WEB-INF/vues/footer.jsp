<%-- 
    Document   : footer
    Created on : 26 nov. 2019, 16 h 46 min 48 s
    Author     : Pedro
--%>

<!-- Footer -->
<footer class="page-footer font-small stylish-color-dark pt-4">
    <!-- Footer Links -->
    <div class="container text-center text-md-left">
        <!-- Grid row -->
        <div class="row">
            <!-- Grid column -->
            <div class="col-md-4 mx-auto">
                <!-- Content -->
                <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Booksell</h5>
                <p>Booksell est un site pour vendre ou acheter des livres scolaires de niveau collégial à très bon prix.
                </p>
            </div>
            <!-- Grid column -->
            <hr class="clearfix w-100 d-md-none">
            <!-- Grid column -->
            <div class="col-md-2 mx-auto">
                <!-- Links -->
                <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Explorez</h5>
                <ul class="list-unstyled">
                    <li>
                        <a href="?ac=nav&page=accueil">Accueil</a>
                    </li>
                    <li>
                        <a href="?ac=catalogue">Catalogue</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Grid row -->
    </div>
    <!-- Footer Links -->
    
    <%
        if(session.getAttribute("session")==null){
    %>
    <hr>
        <!-- Call to action -->
        <ul class="list-unstyled list-inline text-center py-2">
            <li class="list-inline-item">
                <h5 class="mb-1">Inscrivez-vous gratuitement</h5>
            </li>
            <li class="list-inline-item">
                <a href="?ac=nav&page=signup" class="btn btn-danger btn-rounded">S'inscrire!</a>
            </li>
        </ul>
    <hr>
        <%
    }
    %>
    <!-- Call to action -->
    
    <!-- Social buttons -->
    <ul class="list-unstyled list-inline text-center">
        <li class="list-inline-item">
            <a class="btn-floating btn-fb mx-1">
                <i class="fab fa-facebook-f"> </i>
            </a>
        </li>
        <li class="list-inline-item">
            <a class="btn-floating btn-tw mx-1">
                <i class="fab fa-twitter"> </i>
            </a>
        </li>
        <li class="list-inline-item">
            <a class="btn-floating btn-gplus mx-1">
                <i class="fab fa-google-plus-g"> </i>
            </a>
        </li>
        <li class="list-inline-item">
            <a class="btn-floating btn-li mx-1">
                <i class="fab fa-linkedin-in"> </i>
            </a>
        </li>
        <li class="list-inline-item">
            <a class="btn-floating btn-dribbble mx-1">
                <i class="fab fa-dribbble"> </i>
            </a>
        </li>
    </ul>
    <!-- Social buttons -->
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <a href="?ac=nav&page=accueil">Booksell.com</a>
    </div>
    <!-- Copyright -->
</footer>