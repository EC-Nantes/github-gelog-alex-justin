/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentants des paysans
 * Des personnages par défauts, faibles, ils ne sont pas spécialisés pour le combat
 * 
 * @author jujus
 */
public class Paysan extends Personnage {

	/**
	 * Constructeur complet des paysans
	 * @param n le nom
	 * @param pV les points de vie
	 * @param dA les dégâts
	 * @param pPar les points de parade
	 * @param paAtt le pourcentage de réussite d'attaque
	 * @param paPar le pourcentage de réussite de parade
	 * @param dMax la portée
	 * @param p la posiiton
	 */
	public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
		super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
	}

	/**
	 * Constructeur de copie
	 * @param pa le paysan copié
	 */
	public Paysan(Paysan pa) {
		super(pa);
	}

	/**
	 * Constructeur par défaut
	 */
	public Paysan() {
		setNom("Peons");
	}
}
