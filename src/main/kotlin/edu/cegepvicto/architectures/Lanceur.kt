package edu.cegepvicto.architectures

import edu.cegepvicto.architectures.activites.ControleurActivite
import edu.cegepvicto.architectures.architecture.Contexte
import edu.cegepvicto.architectures.architecture.LocalisateurServices

fun main() {
    val controleurActivite = ControleurActivite(Contexte(LocalisateurServices(), "Json"))
    controleurActivite.listeActivite(mapOf())
}