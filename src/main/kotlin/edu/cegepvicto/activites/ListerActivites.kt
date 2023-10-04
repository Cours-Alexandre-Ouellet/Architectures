package edu.cegepvicto.activites

import edu.cegepvicto.architecture.ControleurAbstrait
import edu.cegepvicto.architecture.VueAbstraite
import edu.cegepvicto.services.ConvertisseurFormatHeure

/**
 * Vue qui affiche la liste des activités
 */
class ListerActivites(controleur : ControleurAbstrait) : VueAbstraite(controleur) {

    override fun afficher(donnees: Map<String, Any>) {
        val activites = donnees.getOrDefault("activites"){ listOf<Activite>() } as List<*>

        println("=== Liste des activites ===")
        if(activites.isEmpty()) {
            println("Aucune activite trouvee")
        } else {
            // Pour chaque activité
            val serviceFormattageHeure = obtenirService<ConvertisseurFormatHeure>()

            for(a in activites) {
               val activite = a as Activite
                println("${activite.nom} : ${serviceFormattageHeure.formatter(activite.duree)}")
            }
        }
        println()
        afficherMenu()
    }

    /**
     * Affiche et gère la saisie du menu textuel dans la liste d'activités.
     */
    private fun afficherMenu() {
        var choixValide = false

        while(!choixValide) {
            println("Que souhaitez-vous faire ?")
            println("1) Ajouter une activite")
            println("0) Quitter le systeme")

            when (readln().toInt()) {
                0 -> {
                    choixValide = true
                }
                1 -> {
                    appeler<ControleurActivite>("ajouterActivite", mapOf<String, Any>())
                    choixValide = true
                }
                else -> {
                    println("Veuillez entrer un choix valide")
                }
            }
        }
    }
}