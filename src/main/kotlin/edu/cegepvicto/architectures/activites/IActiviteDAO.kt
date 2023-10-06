package edu.cegepvicto.architectures.activites

/**
 * Interface de manipulation des sauvegardes d'activités
 */
interface IActiviteDAO  {

    /**
     * Enregistre une [activite] dans le conteneur de données.
     */
    fun enregistrer(activite: Activite)

    /**
     * Retourne toutes les activités du conteneur de données.
     */
    fun listerTout() : List<Activite>

}