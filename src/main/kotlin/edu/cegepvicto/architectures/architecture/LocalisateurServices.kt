package edu.cegepvicto.architectures.architecture

/**
 * CLasse responsable de la localisation des services dans le système et de la gestion de leur instance unique
 */
class LocalisateurServices {

    // Pour accéder à services dans une méthode inline, l'attribut doit être déclaré dans un objet companion
    companion object {
        val services = mutableMapOf<String, IService>()
    }

    /**
     * Retourne une instance du service [T] demandé.
     */
    inline fun <reified T> obtenirService(): T where T : IService {
        // Trouve le nom complet de la classe qui représente le service
        val nomService: String = T::class.qualifiedName!!

        // Retourne le service si déjà créé, ou le crée, l'ajoute à la liste puis le retourne
        return services.getOrPut(nomService) {
            // Cette ligne de code trouve le constructeur primaire de T et l'appel. Des exceptions sont
            // lancés en cas d'erreur.
            T::class.constructors.find { c -> c.parameters.isEmpty() }!!.call()
        } as T  // Converti le retour en T pour s'assurer de retourner le type du service requis
    }


}