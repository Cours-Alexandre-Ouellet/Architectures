package edu.cegepvicto.nonstructure;

import kotlin.math.floor
import kotlin.math.round

class GererActivite()
{
    /**
     * Affiche le menu principal du système
     */
    fun menu() {
        var quitter = false

        while(!quitter) {
            println("Que souhaitez-vous faire ?")
            println("1) Ajouter une activite")
            println("2) Lister les activités")
            println("0) Quitter le systeme")


            when (readln().toInt()) {
                0 -> {
                    quitter = true
                }
                1 -> {
                    ajouterActivite()
                }
                2 -> {
                    listerActivites()
                }
                else -> {
                    println("Veuillez entrer un choix valide")
                }
            }
        }
    }

    /**
     * Affiche la liste des activités
     */
    private fun listerActivites() {
        val activites = listOf<Activite>() // "SELECT * FROM Activite ... "

        println("=== Liste des activites ===")
        if(activites.isEmpty()) {
            println("Aucune activite trouvee")
        } else {
            // Pour chaque activité
            for(activite in activites) {
                println("${activite.nom} : ${formatterHeure(activite.duree)}")
            }
        }
        println()
    }

    /**
     * Ajoute une activité
     */
    private fun ajouterActivite() {
        println("Saisie d'une activite [appuyez sur # pour annuler]")

        // Saisie du nom
        println("Quel est le nom de l'activite ?")
        val nom = readln()

        if(nom == "#") {
            println("Ajout d'activité annulée")
            return
        }

        var saisieValide = false;
        var duree = 0.0f

        // Saisie de la durée (redemandée tant que non valide)
        while(!saisieValide) {
            println("Combien de temps l'activité a-t-elle durée (entrer 1.5 pour 1 heure 30 par exemple) ?")
            val dureeSaisie = readln()

            if (dureeSaisie == "#") {
                println("Ajout d'activité annulée")
                return
            }

            try {
                duree = dureeSaisie.toFloat()
                saisieValide = true
            } catch (exception : NumberFormatException) {
                println("Format de durée invalide")
            }
        }

        val activite = Activite(nom, duree)
        // INSERT INTO activite (nom, duree) VALUES (activite.nom, activite.duree)
        println("Activite correctement ajoutee")
    }

    /**
     * Formatte l'heure représentée par [temps] en une chaîne de caractère
     */
    private fun formatterHeure(temps : Float) : String {
        val heures : Int = floor(temps).toInt()
        val minutes : Int = round((temps - heures) * 60.0f).toInt()

        return "$heures h $minutes"
    }

}
