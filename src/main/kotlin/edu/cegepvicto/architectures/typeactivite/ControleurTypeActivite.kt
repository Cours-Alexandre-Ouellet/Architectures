package edu.cegepvicto.architectures.typeactivite

import edu.cegepvicto.architectures.architecture.Contexte
import edu.cegepvicto.architectures.architecture.ControleurAbstrait

/**
 * Contrôleur pour la gestion des types d'activité qui accepte un [contexte] d'application
 */
class ControleurTypeActivite(contexte : Contexte) : ControleurAbstrait(contexte){

    // Définir un type (CREATE)

    /**
     * Affiche le menu avec un ensemble de paramètres reçus dans [donnees].
     */
    fun afficherMenu(donnees : Map<
            String, Any>) {
        rendre(MenuTypeActivite(), mapOf())
    }

    /**
     * Liste les type d'activités. Le paramètre [donnees] est ignoré.
     */
    fun listeTypesActivite(donnees : Map<
            String, Any>) {

        val dao = if(contexte.modeSauvegarde == "SQL") {
            contexte.services.obtenirService<TypeActiviteDAO_SQL>()
        } else {
            null
        }

        val typesActivite = dao!!.listerTypeActivite()

        rendre(ListeTypesActivite(this), mapOf(Pair("typesActivite" , typesActivite)))
    }
}