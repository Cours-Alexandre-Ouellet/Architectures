package edu.cegepvicto.architectures.activites

import edu.cegepvicto.architectures.architecture.Contexte
import edu.cegepvicto.architectures.architecture.ControleurAbstrait
import edu.cegepvicto.architectures.services.ConvertisseurFormatHeure

/**
 * Contrôleur qui gère les différentes activités dans le système.
 * L'exécution du contrôleur s'appuie sur un [contexte] précisé.
 */
class ControleurActivite(contexte: Contexte) : ControleurAbstrait(contexte) {

    /**
     * Affiche le formulaire pour ajouter une nouvelle activite.
     *
     * Le paramètre [donnees] est ignoré.
     */
    fun ajouterActivite(donnees : Map<String, Any>) {
        rendre(AjouterActivite(this), mapOf())
    }

    /**
     * Enregistre une nouvelle activité dans le système selon les [donnees] reçues
     */
    fun enregistrerActivite(donnees : Map<String, Any>) {

        // TODO: Inclure un service de validation

        val nom = donnees.getOrDefault("nom"){""} as String
        val duree = contexte.services.obtenirService<ConvertisseurFormatHeure>().extraireTemps(
            donnees.getOrDefault("duree"){""} as String
        )

        val activite = Activite(nom, duree)
        val dao = if(contexte.modeSauvegarde == "SQL") {
            contexte.services.obtenirService<ActiviteDAO_SQL>()
        } else {
            contexte.services.obtenirService<ActiviteDAO_Json>()
        }
        dao.enregistrer(activite)

        // Redirection après enregistrement vers la liste d'activité
        listeActivite(donnees)
    }

    /**
     * Affiche la liste de toutes les activités du système
     *
     * Le paramètre [donnees] est ignoré.
     */
    fun listeActivite(donnees: Map<String, Any>) {
        // Code copié  :'(
        val dao = if(contexte.modeSauvegarde == "SQL") {
            contexte.services.obtenirService<ActiviteDAO_SQL>()
        } else {
            contexte.services.obtenirService<ActiviteDAO_Json>()
        }

        val activites : List<Activite> = dao.listerTout()
        rendre(ListerActivites(this), mapOf(Pair("activites", activites)))
    }
}