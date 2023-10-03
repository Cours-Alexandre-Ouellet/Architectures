package edu.cegepvicto

import edu.cegepvicto.activites.ControleurActivite
import edu.cegepvicto.architecture.Contexte
import edu.cegepvicto.architecture.LocalisateurServices

fun main() {
    val controleurActivite = ControleurActivite(Contexte(LocalisateurServices(), "SQL"))
    controleurActivite.listeActivite(mapOf())
}