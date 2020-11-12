const FabriqueNoeud = function(type, attributs, elements = {}) {

    // création du noeud
    const noeud = document.createElement(type);

    // Ajouter les attributs
    for (var attribut in attributs) {
        if(attribut === 'style') {
            for (var param in attributs[attribut]) {
                noeud[attribut][param] = attributs[attribut][param];
            }
        } else {
            noeud[attribut] = attributs[attribut];
        }
    }

    // Ajouter les éléments
    for (var element in elements) {
        noeud.appendChild(elements[element]);
    }

    return noeud;
}