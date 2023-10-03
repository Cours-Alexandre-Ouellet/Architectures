package edu.cegepvicto.architecture

abstract class VueAbstraite(val controleur: ControleurAbstrait) {

    protected inline fun <reified T> appeler(
        nomMethode : String,
        donnees: Map<String, Any>
    ) where T : ControleurAbstrait {
        val instance = T::class.constructors.find { c -> c.parameters.size == 1 }!!.call(controleur.contexte)
        instance.executer(nomMethode, donnees)
    }

    protected inline fun <reified T> obtenirService() : T where T : IService {
        return controleur.contexte.services.obtenirService<T>()
    }

    abstract fun afficher(donnees: Map<String, Any>)
}