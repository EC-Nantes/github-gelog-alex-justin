/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe des monstres de WoE
 * Opposants des personnages
 * 
 * @author Alexandre
 * @version 1.0
 */
public class Monstre extends Creature{

	/**
	 * Constructeur de la classe Monstre
	 * @param pV Nombre de points de vie du personnage
	 * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
	 * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
	 * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
	 * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
	 * @param pos position du Monstre
	 */
	public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
		super(pV, dA, pPar, paAtt, paPar, pos);
	}
	
	/**
	 * Constructeur de copie de la classe Monstre
	 * @param m Le monstre copié
	 */
	public Monstre(Monstre m) {
		super(m);
	}
	
	/**
	 * Constructeur par défaut de la classe monstre
	 */
	public Monstre() {
		//
	}
	
}
