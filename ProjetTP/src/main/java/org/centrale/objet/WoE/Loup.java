/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.lang.Math;

/**
 * Classe d'un loup
 * @author Catherine
 */
public class Loup extends Monstre {

    /**
     * Constructeur complet d'un loup
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param pos
     */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
	super(pV, dA, pPar, paAtt, paPar, pos);
    }
    
    /**
     * Constructeur de copie
     * @param l
     */
    public Loup(Loup l) {
	super(l);
    }
    
    /**
     * Constructeur par défaut
     */
    public Loup() {
	super();
    }
    
    /**
     * Fonction permettant d'attaquer une créature
     * @param c
     */
    public void combattre(Creature c) {
	if (this.getPtVie() == 0) return;
	
	float dist = this.getPos().distance(c.getPos());
	
	Random rand = new Random();
	
	// 1.5 pour accepter une créature sur une case en diagonal
	if (dist < 1.5) { // Attaque au corps à corps
	    int p_attaque = rand.nextInt(100)+1;
	    if (p_attaque <= this.getPageAtt()) {
		System.out.println("Le loup a réussi à mordre sa cible.");
		int p_defense = rand.nextInt(100)+1;
		int degat = this.getDegAtt();
		if (p_defense <= c.getPagePar()) {
		    degat -= c.getPtPar();
		    System.out.println("Mais sa cible fut assez rapide pour se protéger du grand méchant loup");
		}
		
		int vie = c.getPtVie() - Math.max(0, degat);
		if (vie < 0) vie = 0;
		c.setPtVie(vie);
	    }
	} else System.out.println("Le guerrier est trop loin de sa cible");
    }

}
