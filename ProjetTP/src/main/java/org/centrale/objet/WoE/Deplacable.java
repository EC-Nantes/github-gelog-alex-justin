/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Interface de tous les objets qui peuvent se déplacer
 * @author jujus
 */
public interface Deplacable {
	/**
	 * méthode pour se déplacer sans se marcher sur les pieds
	 * @param w Le monde dans lequel on se déplace
	 */
	public void deplace(World w);

}
