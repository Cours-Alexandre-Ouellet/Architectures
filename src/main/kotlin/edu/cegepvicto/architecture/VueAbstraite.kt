package edu.cegepvicto.architecture

/**
 * Classe de base qui gère l'affichage des différentes vues du système. Fournit des
 * méthodes pour lancer un contrôleur dans le système ou obtenir un service à partir
 * du contexte d'application.
 */
abstract class VueAbstraite(val controleur: ControleurAbstrait) {

    /**
     * Appelle la méthode nommée [nomMethode] d'un contrôleur de type [T]. Le tableau des [donnees] est transmis
     * à la méthode.
     */
    protected inline fun <reified T> appeler(
        nomMethode : String,
        donnees: Map<String, Any>
    ) where T : ControleurAbstrait {

        // Construit une nouvelle instance d'un contrôleur en appelant le constructeur qui possède
        // 1 paramètre
        val instance = T::class.constructors.find { c -> c.parameters.size == 1 }!!.call(controleur.contexte)

        //Exécute la méthode nommée nomMethode sur le contrôleur
        instance.executer(nomMethode, donnees)
    }

    /**
     * Retrouve un service dans le conteneur de services du système à partir du contexte du contrôleur
     * actif.
     *
     * (Commentaire pédagogique) Excellent exemple d'une façade
     */
    protected inline fun <reified T> obtenirService() : T where T : IService {
        return controleur.contexte.services.obtenirService<T>()
    }

    /**
     * Affiche la vue dans l'interface du système
     */
    abstract fun afficher(donnees: Map<String, Any>)
}