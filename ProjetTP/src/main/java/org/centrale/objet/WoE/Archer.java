/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe représentant un Archer dans le jeu World of ECN.
 * Hérite de la classe Personnage et ajoute des caractéristiques spécifiques liées aux attaques à distance.
 * @author jujus
 */
public class Archer extends Personnage implements Combattant{
	private int nbFleches;

	/**
	 * Constructeur de la classe Archer
	 * @param nbFleches Le nombre de flèches que possède l'Archer
	 * @param n le nom de l'Archer
	 * @param pV le nombre de points de vie de l'Archer
	 * @param dA le nombre de dégâts que fait l'Archer
	 * @param pPar la quantité de points de parade de l'Archer
	 * @param paAtt son pourcentage de réussite en attaque
	 * @param paPar son pourcentage de réussite de parade
	 * @param dMax sa portée
	 * @param p sa position
	 */
	public Archer(int nbFleches, String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.nbFleches = nbFleches;
	}
	
	/**
	 * Constructeur de la classe Archer
	 * @param n le nom de l'Archer
	 * @param pV le nombre de points de vie de l'Archer
	 * @param dA le nombre de dégâts que fait l'Archer
	 * @param pPar la quantité de points de parade de l'Archer
	 * @param paAtt son pourcentage de réussite en attaque
	 * @param paPar son pourcentage de réussite de parade
	 * @param dMax sa portée
	 * @param p sa position
	 * @param nbFleches Le nombre de flèches que possède l'Archer
	 */
	public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.nbFleches = nbFleches;
	}

	/**
	 * Constructeur de transformation de personnage en Archer
	 * @param nbFleches son nombre de flèches
	 * @param perso le personnage d'origine
	 */
	public Archer(int nbFleches, Personnage perso) {
		super(perso);
		this.nbFleches = nbFleches;
	}

	/**
	 * Constructeur de création par défaut à partir d'un nombre de flèches
	 * @param nbFleches le nombre de flèches
	 */
	public Archer(int nbFleches) {
		this.nbFleches = nbFleches;
		setNom("Robin");
	}
	
	/**
	 * Constructeur par défaut de la classe Archer
	 */
	public Archer(){
		super();
		setNom("Robin");
		this.nbFleches = 0;
	}


	/**
	 * Constructeur de copie des Archers
	 * @param a l'Archer copié
	 */
	public Archer(Archer a){
		super(a);
		this.nbFleches = a.nbFleches;
	}
	
	/**
	 * Fonction permettant d'attaquer une créature
	 * @param c la créature cible
	 */
	@Override
	public void combattre(Creature c) {
		if (this.getPtVie() == 0 || nbFleches == 0) return;
		
		float dist = this.getPos().distance(c.getPos());
		
		Random rand = new Random();
		
		// 1.5 pour accepter une créature sur une case en diagonal
		if (dist > 1.5 && dist < this.getDistAttMax()) { // Attaque à distance
			nbFleches--;
			int p_attaque = rand.nextInt(100)+1;
			if (p_attaque <= this.getPageAtt()) {
			System.out.println("L'attaque à distance est réussi");
			int vie = c.getPtVie() - this.getDegAtt();
			if (vie < 0) vie = 0;
			c.setPtVie(vie);
			}
		} else System.out.println("L'archer est trop proche ou trop loin");
	}
	
	/**
	 * Getter du nobre de flèches
	 * @return un entier : le nombre de flèches
	 */
	public int getNbFleches() {
		return nbFleches;
	}
	
	/**
	 * Setter du nombre de flèches
	 * @param nbFleches le nouveau nombre de flèches
	 */
	public void setNbFleches(int nbFleches) {
		this.nbFleches = nbFleches;
	}
	
	
	
	
}
