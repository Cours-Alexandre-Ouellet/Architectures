package edu.cegepvicto.architecture

/**
 * Interface commune à tous les services du système
 */
interface IService {

    /**
     * Lance les opérations pour initialiser ou réinitialiser le service. Appelé à chaque fois que le service est
     * requis.
     */
    fun initialiser()

}