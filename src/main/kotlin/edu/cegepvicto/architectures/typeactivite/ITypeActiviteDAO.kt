package edu.cegepvicto.architectures.typeactivite

/**
 * Interface pour les DAO de type d'activité
 */
interface ITypeActiviteDAO {

    fun listerTypeActivite() : List<TypeActivite>

    fun enregistrer(typeActivite: TypeActivite)
}