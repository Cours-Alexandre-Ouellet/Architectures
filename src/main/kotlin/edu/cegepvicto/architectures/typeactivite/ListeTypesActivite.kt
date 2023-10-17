package edu.cegepvicto.architectures.typeactivite

import edu.cegepvicto.architectures.architecture.ControleurAbstrait
import edu.cegepvicto.architectures.architecture.VueAbstraite

/**
 * Classe de vue qui affiche les types d'activités disponibles qu'elles reçoit
 * d'un [controleur].
 */
class ListeTypesActivite(controleur : ControleurAbstrait) : VueAbstraite(controleur) {

    override fun afficher(donnees: Map<String, Any>) {
        val typesActivite = donnees.getOrDefault("typesActivite") { listOf<TypeActivite>() } as List<*>

        if(typesActivite.size == 0) {
            println("Aucun type a afficher")
        } else {
            for(type in typesActivite) {
                val typeActivite = type as TypeActivite
                println("${typeActivite.nom} ${typeActivite.intensite}")
            }
        }

        appeler<ControleurTypeActivite>("afficherMenu", mapOf())
    }


}