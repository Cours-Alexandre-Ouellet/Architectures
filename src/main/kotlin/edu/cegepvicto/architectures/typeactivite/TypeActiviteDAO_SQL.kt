package edu.cegepvicto.architectures.typeactivite

import edu.cegepvicto.architectures.architecture.IService

/**
 * DAO pour enregistrer ou charger des types d'activité en SQL.
 */
class TypeActiviteDAO_SQL : ITypeActiviteDAO, IService {

    // Émulation de BD
    val typesActivite = mutableListOf<TypeActivite>()

    override fun initialiser() {
        // Pas d'opération particulière
    }

    override fun listerTypeActivite(): List<TypeActivite> {
        // SELECT *
        return typesActivite.toList()
    }

    override fun enregistrer(typeActivite: TypeActivite) {
        typesActivite.add(typeActivite)
    }
}