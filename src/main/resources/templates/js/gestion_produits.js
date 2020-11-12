const SUPPRIMER = "?action=supprimer&id=";
const MODIFIER = "?action=edit&id=";
const AJOUTER = "?action=ajouterajax&nom=";

function getSomething($id) {
    console.log(SUPPRIMER + $id);
    ajaxGet(SUPPRIMER + $id, function (reponse) {
        location.reload();
        document.getElementById("supprimerHeader").removeAttribute("hidden");
    });
}

function modifySomething($id, $price) {
    console.log(MODIFIER + $id + $price);
    ajaxGet(MODIFIER + $id + "&prix=" + $price, function (reponse) {
        location.reload();
        document.getElementById("modifierHeader").removeAttribute("hidden");
    });
}

function addSomething($nom, $auteur, $editeur, $matiere, $price, $image) {
    console.log(AJOUTER + $price);
    if(validerFormulaire){
        ajaxGet(AJOUTER + $nom + "&auteur=" + $auteur + "&editeur=" + $editeur + "&matiere=" + $matiere + "&prix=" + $price + "&image=" + $image, function (reponse) {
        }); 
        alert("L'oeuvre a ete ajouter !");
    }
}

function validerFormulaire() {

    var valide = true;

    var listeChampsSaisis = document.getElementsByTagName("myForm");
    
    // la boucle forEach ne peut pas être utilisée sur un tableau d'objets html (HTMLCollection)
    for (var i = 0; i < listeChampsSaisis.length; i++) {

         if (!listeChampsSaisis[i].validity.valid) {
             listeChampsSaisis[i].className = "erreur";
             listeChampsSaisis[i].parentNode.className = "forminput tooltip tooltipvisible";

             listeChampsSaisis[i].addEventListener("input", function(e) {
                // ici this fait référence à l'objet listeChampsSaisis[i] sur lequel on a appliqué la méthode
                // addEventListerner
                 if (!this.validity.valid) {
                     this.className = "erreur";
                     this.parentNode.className = "forminput tooltip tooltipvisible";
                 } else {
                     this.className = "";
                     this.parentNode.className = "forminput tooltip";
                }   
             });

             valide = false;
         }

    }

    return valide;  
}

function envoyerFormServeur(produit) {
    ajaxPost(ENVOYER, produit,
        function (reponse, status) {
            if (status === 'success') {
                afficherProduit(produit);
                afficherMessage("Le produit " + produit['denomination'] + " a été ajouté.");
            } else {
                afficherMessage("Le produit " + produit['denomination'] + " n'a pas pu être ajouté.");
            }
        },
        true // Valeur du paramètre isJson
    );
}

function afficherMessage(message) {
    // creation du message
    var messageElt = FabriqueNoeud("div", {id: "message", textContent: message});

    // ajoute le message avant le tableau
    document.getElementById('content').insertBefore(messageElt, document.getElementById('produits'));

    // fait disparaître le message après 2 secondes
    setTimeout(function () {
            document.getElementById('content').removeChild(document.getElementById("message"));
    }, 2000);
}