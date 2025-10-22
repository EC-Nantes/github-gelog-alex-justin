/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Interface des objets utilisables
 * @author jujus
 */
public interface Utilisable {
    /**
     * Utiliser l'objet sur une créature
     * @param c la cible
     */
	public void utilisation(Creature c);
}
