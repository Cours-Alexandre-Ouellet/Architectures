package edu.cegepvicto.architectures.activites

import edu.cegepvicto.architectures.architecture.IService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileNotFoundException

/**
 * DAO qui enregistre et charge de fichier Json locaux
 */
class ActiviteDAO_Json : IService, IActiviteDAO {

    private val nomFichier = "activites.json"

    override fun enregistrer(activite: Activite) {
        val listeActivites = listerTout().toMutableList()
        listeActivites.add(activite)

        val json = Json.encodeToString(listeActivites)
        File(nomFichier).printWriter().use { out -> out.println(json) }
    }

    override fun listerTout(): List<Activite> {

        try {
            val contenuFichier = File(nomFichier).readText()
            return Json.decodeFromString<List<Activite>>(contenuFichier)
        }
        catch (exception : FileNotFoundException) {
            return listOf()
        }
    }

    override fun initialiser() {
        // Aucun traitement particulier
    }
}