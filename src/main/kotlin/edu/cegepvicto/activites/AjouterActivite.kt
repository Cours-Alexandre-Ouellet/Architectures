package edu.cegepvicto.activites

import edu.cegepvicto.architecture.ControleurAbstrait
import edu.cegepvicto.architecture.VueAbstraite

class AjouterActivite(controleur : ControleurAbstrait) : VueAbstraite(controleur) {

    override fun afficher(donnees: Map<String, Any>) {
        println("Ajouter activite")
    }


}