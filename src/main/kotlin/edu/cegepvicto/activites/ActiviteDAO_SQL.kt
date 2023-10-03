package edu.cegepvicto.activites

import edu.cegepvicto.architecture.IService

/**
 * Implémentation de la DAO pour les activités dans le contexte de données stockées en SQL.
 */
class ActiviteDAO_SQL : IActiviteDAO, IService {

    // Code bidon pour ne pas mettre une vraie BD
    val activites : MutableList<Activite> = mutableListOf()

    override fun enregistrer(activite: Activite) {
        // Exécuter INSERT INTO Activite (nom, duree) VALUES (activite.nom, activite.duree)

        activites.add(activite)
    }

    override fun listerTout(): List<Activite> {
        // Exécuter SELECT * FROM Activite;

        return activites
    }

    override fun initialiser() {
        // Connexion à la BD
    }


}