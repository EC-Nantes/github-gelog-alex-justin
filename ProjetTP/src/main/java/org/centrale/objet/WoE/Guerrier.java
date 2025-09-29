/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.lang.Math;

/**
 * Classe d'un guerrier
 * @author Catherine
 */
public class Guerrier extends Personnage {
    /**
     * Constructeur complet d'un guerrier
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     * Constructeur de copie
     * @param pa le guerrier copié
     */
    public Guerrier(Guerrier gu) {
        super(gu);
    }

    /**
     * Constructeur par défaut d'un guerrier
     */
    public Guerrier() {
        setNom("grosBill");
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
		System.out.println("Le guerrier a réussi à toucher sa cible.");
		int p_defense = rand.nextInt(100)+1;
		int degat = this.getDegAtt();
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
}
