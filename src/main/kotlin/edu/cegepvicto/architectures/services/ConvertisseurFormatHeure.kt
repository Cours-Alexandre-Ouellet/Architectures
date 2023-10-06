package edu.cegepvicto.architectures.services

import edu.cegepvicto.architectures.architecture.ExceptionConversionHeure
import edu.cegepvicto.architectures.architecture.IService
import java.util.*
import kotlin.math.floor
import kotlin.math.round

/**
 * Service qui permet de gérer les conversions des différents formats temporels
 */
class ConvertisseurFormatHeure : IService {

    override fun initialiser() {
        // Aucun traitement particulier
    }

    /**
     * Formate en une chaîne de caractères une donnée temporelle sous forme de float. Le [temps] indiqué
     * sera représenté en utilisant le [separateur] pour séparer les heures des minutes. Si [zeroMeneur] est
     * vrai, alors les heures plus petites que 10 commencent par un zéro pour assurer un format ##.
     * */
    fun formatter(temps: Float, separateur : String = " h ", zeroMeneur : Boolean = false): String {
        // Extraction des données numériques
        val heures : Int = floor(temps).toInt()
        val minutes : Int = round((temps - heures) * 60.0f).toInt()

        // Conversion en chaîne de caractère
        val chaineHeure = if(zeroMeneur && heures < 10) "0$heures" else "$heures"
        val chaineMinute = if(minutes < 10) "0$minutes" else "$minutes"

        // Concaténation du tout
        return "$chaineHeure$separateur$chaineMinute"
    }

    /**
     * Convertit automatiquement une [chaine] de caractères contenant une heure en sa représentation
     * sous forme décimale. Les séparateurs h, H ou : doivent être utilisés. La fonction ignore les espaces blancs.
     */
    fun extraireTemps(chaine: String): Float {
        // Remplace les blancs par des vides et convertit de possibles lettres en majuscules
        val chaineNettoyee = chaine.replace(" ", "").uppercase(Locale.getDefault())

        // Brise la chaîne en testant les séparateurs "H" et ":"
        val chaineDecomposee = if (chaineNettoyee.contains("H")) {
            chaineNettoyee.split("H")
        } else if (chaineNettoyee.contains(":")) {
            chaineNettoyee.split(":")
        } else {
            null
        }

        // Un séparateur autre été utilisé, aucun ou plus d'un séparateur a été utilisé.
        if (chaineDecomposee == null || chaineDecomposee.size != 2) {
            throw ExceptionConversionHeure("Format d'heure non supporte. Les formats supportes sont ##:## ou ##h##")
        }

        // Conversion en représentation float, lance une erreur si la conversion en entier n'est pas possible.
        try {
            return calculerHeureDecimale(chaineDecomposee[0].toInt(), chaineDecomposee[1].toInt())
        } catch (exception: NumberFormatException) {
            throw ExceptionConversionHeure("Impossible de convertir les elements numerique de l'heure")
        }
    }

    /**
     * Calcule la représentation d'une heure en notation décimale à partir d'un nombre d'[heures] et de [minutes].
     */
    fun calculerHeureDecimale(heures: Int, minutes: Int): Float {
        return heures + minutes / 60.0f;
    }
}