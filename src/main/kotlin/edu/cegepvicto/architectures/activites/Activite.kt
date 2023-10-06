package edu.cegepvicto.architectures.activites

import kotlinx.serialization.Serializable

/**
 * Représente une activité physique qui possède un nom et une durée
 */
@Serializable
class Activite(val nom: String, val duree: Float) {
}