/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe d'un guerrier
 * @author Catherine
 */
public class Guerrier extends Personnage implements Combattant {
	private Epee arme;
	
	/**
	 * Constructeur complet du guerrier avec spécification complète de l'épée
	 * @param n le nom du guerrier
	 * @param pV les points de vie du guerrier
	 * @param dA les dégâts par défauts du guerrier
	 * @param pPar les points de parade du guerrier
	 * @param paAtt le pourcentage de réussite en attaque
	 * @param paPar le pourcentage de réussite en parade
	 * @param dMax la distance max d'attaque
	 * @param nEpee le nom de l'épée du guerrier
	 * @param aEpee le bonus d'attaque apporté par l'épée du guerrier
	 * @param dEpee la durabilité de l'épée du guerrier
	 * @param p la position du guerrier
	 */
	public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, String nEpee, int aEpee, int dEpee, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.arme = new Epee(nEpee, aEpee, dEpee);
	}
	
	/**
	 * Constructeur complet du guerrier avec spécification de l'épée
	 * @param n le nom du guerrier
	 * @param pV les points de vie du guerrier
	 * @param dA les dégâts par défauts du guerrier
	 * @param pPar les points de parade du guerrier
	 * @param paAtt le pourcentage de réussite en attaque
	 * @param paPar le pourcentage de réussite en parade
	 * @param dMax la distance max d'attaque
	 * @param aEpee le bonus d'attaque apporté par l'épée du guerrier
	 * @param dEpee la durabilité de l'épée du guerrier
	 * @param p la position du guerrier
	 */
	public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, int aEpee, int dEpee, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.arme = new Epee("Epee du guerrier", aEpee, dEpee);
	}
	
	/**
	 * Constructeur complet à partir d'une épée existante
	 * @param n nom du guerrier
	 * @param pV points de vie du guerrier
	 * @param dA dégâts d'attaque du guerrier
	 * @param pPar point de parade du guerrier
	 * @param paAtt pourcentage de réussite en attaque
	 * @param paPar pourcentage de réussite en parade
	 * @param dMax distance maximale pour attaquer
	 * @param e l'épée existante
	 * @param p la position du guerrier
	 */
	public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Epee e, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.arme = new Epee(e);
	}
		
	/**
	 * Constructeur quasi-complet d'un guerrier
	 * @param n nom
	 * @param pV points de vie
	 * @param dA dégâts
	 * @param pPar points de Parade
	 * @param paAtt pourcentage de réussite d'Attaque
	 * @param paPar Pourcentage de réussite de parade
	 * @param dMax distance d'attaque max
	 * @param p position
	 */
	public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
		this.arme = new Epee("Épée par défaut", 0);
	}

	/**
	 * Constructeur de copie
	 * @param gu le guerrier copié
	 */
	public Guerrier(Guerrier gu) {
		super(gu);
	}

	/**
	 * Constructeur par défaut d'un guerrier
	 */
	public Guerrier() {
		setNom("grosBill");
		this.arme = new Epee("Épée par défaut", 0);
	}
	
	/**
	 * Fonction permettant d'attaquer une créature
	 * @param c la créature cible
	 */
	@Override
	public void combattre(Creature c) {
		if (this.getPtVie() == 0) return;
		
		float dist = this.getPos().distance(c.getPos());
		
		Random rand = new Random();
			
			float distMax = (float)(this.getDistAttMax()) + (float)(0.5);
		
		// 1.5 pour accepter une créature sur une case en diagonal
		if (dist < distMax) { // Attaque au corps à corps
			int p_attaque = rand.nextInt(100)+1;
			if (p_attaque <= this.getPageAtt()) {
			System.out.println("Le guerrier a réussi à toucher sa cible.");
			int p_defense = rand.nextInt(100)+1;
			int degat = this.getDegAtt() + this.arme.getPtAttaque();
			if (p_defense <= c.getPagePar()) {
				degat -= c.getPtPar();
				System.out.println("Mais sa cible fut assez rapide pour parrer le coup");
			}
			
			int vie = c.getPtVie() - Math.max(0, degat);
			if (vie < 0) vie = 0;
			c.setPtVie(vie);
			}
		} else System.out.println("Le guerrier est trop loin de sa cible");
	}

	/**
	 * getteur de l'arme du guerrier
	 * @return l'arme du guerrier
	 */
	public Epee getArme() {
		return arme;
	}

	/**
	 * La setteur de l'arme du guerrier
	 * @param arme la nouvelle arme du guerrier
	 */
	public void setArme(Epee arme) {
		this.arme = arme;
	}
}
