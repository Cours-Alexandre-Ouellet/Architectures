package edu.cegepvicto.architectures.services

import edu.cegepvicto.architectures.architecture.IService

class Authentificateur : IService {
    override fun initialiser() {
        TODO("Not yet implemented")
    }

    fun authentifier(nomUtilisateur : String, mdp : String) : Boolean
    {
        return true
    }
}