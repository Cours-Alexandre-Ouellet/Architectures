package edu.cegepvicto.architectures.activites

import edu.cegepvicto.architectures.architecture.ControleurAbstrait
import edu.cegepvicto.architectures.architecture.VueAbstraite
import edu.cegepvicto.nonstructure.Activite

class AjouterActivite(controleur : ControleurAbstrait) : VueAbstraite(controleur) {

    override fun afficher(donnees: Map<String, Any>) {
        println("Saisie d'une activite [appuyez sur # pour annuler]")

        // Saisie du nom
        println("Quel est le nom de l'activite ?")
        val nom = readln()

        if(nom == "#") {
            println("Ajout d'activité annulée")
            appeler<ControleurActivite>("listerActivites", mapOf())
            return
        }


        println("Combien de temps l'activité a-t-elle durée (1.5 ou 1h30) ?")
        val duree = readln()


        appeler<ControleurActivite>("enregistrerActivite", mapOf(Pair("nom", nom), Pair("duree", duree)))
    }
}