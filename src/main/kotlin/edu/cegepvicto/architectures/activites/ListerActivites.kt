package edu.cegepvicto.architectures.activites

import edu.cegepvicto.architectures.architecture.ControleurAbstrait
import edu.cegepvicto.architectures.architecture.VueAbstraite
import edu.cegepvicto.architectures.services.ConvertisseurFormatHeure

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
                    /*
                     * Sans la methode appeler, le code serait :
                     * ControleurActivite(controleurActivite.contexte).ajouterActivite()
                     *
                     * On remarque l'absence de paramètre donnees, car les méthodes n'ont plus besoin d'avoir
                     * une interface commune. De plus, à chaque fois que l'on appelle un contrôleur, il faut
                     * lui passer le contexte. Cette opération peut sembler annodine, mais c'est simplement parce
                     * que notre façon d'initialiser le contrôleur est simple. Si les contrôleurs avaient besoin de
                     * plusieurs paramètres, il faudrait tous les passer à chaque (et s'assurer qu'ils soient toujours
                     * tous disponibles à chaque fois.)
                     */
                    choixValide = true
                }
                else -> {
                    println("Veuillez entrer un choix valide")
                }
            }
        }
    }
}