/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant un Lapin dans le jeu WoE
 * Les lapins vont vite, sont inoffensifs (sauf on ajoutera peut être des killers bunny)
 * 
 * @author Alexandre
 * @version 1.0
 */
public class Lapin extends Monstre {

	/**
	 * Constructeur de la classe lapin
	 * @param pV points de vie
	 * @param dA dégâts
	 * @param pPar points de Parade
	 * @param paAtt pourcentage d'attaque réussie
	 * @param paPar pourcentage de parade réussie
	 * @param pos position
	 */
	public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
		super(pV, dA, pPar, paAtt, paPar, pos);
	}
	
	/**
	 * Constructeur de copie 
	 * @param l le lapin copié
	 */
	public Lapin(Lapin l) {
		super(l);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public Lapin() {
		super();
	}
	
	@Override
	public void affiche(){
		System.out.print("Lapin / Pt Vie :" + this.getPtVie() + "/ position :" );
		this.getPos().affiche();
		System.out.println("");
	}
}
