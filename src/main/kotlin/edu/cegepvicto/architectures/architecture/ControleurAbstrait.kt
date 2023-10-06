package edu.cegepvicto.architectures.architecture

import kotlin.reflect.full.declaredMemberFunctions

abstract class ControleurAbstrait(val contexte : Contexte) {

    fun executer(nomMethode : String, donnees : Map<String, Any>) {
        this::class.declaredMemberFunctions.find{m -> m.name == nomMethode}!!.call(this, donnees)
    }

    protected fun rendre(vue: VueAbstraite, donnees: Map<String, Any>) {
        vue.afficher(donnees)
    }
}