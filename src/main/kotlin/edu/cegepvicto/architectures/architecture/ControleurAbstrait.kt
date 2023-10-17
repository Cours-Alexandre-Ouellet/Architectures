package edu.cegepvicto.architectures.architecture

import edu.cegepvicto.architectures.services.Authentificateur
import kotlin.reflect.full.declaredMemberFunctions

abstract class ControleurAbstrait(val contexte : Contexte) {

    fun executer(nomMethode : String, donnees : Map<String, Any>) {
        val methode = this::class.declaredMemberFunctions.find{m -> m.name == nomMethode}!!

           if(contexte.services.obtenirService<Authentificateur>().authentifier(donnees["utilisateur"] as String, donnees["mdp"] as String)) {

               methode.call(this, donnees)
           } else {
               //  403
           }
    }

    protected fun rendre(vue: VueAbstraite, donnees: Map<String, Any>) {
        vue.afficher(donnees)
    }
}