/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.lang.Math;

/**
 * Classe représentant un Archer dans le jeu World of ECN.
 * Hérite de la classe Personnage et ajoute des caractéristiques spécifiques liées aux attaques à distance.
 * @author jujus
 */
public class Archer extends Personnage{
    private int nbFleches;

    /**
     *
     * @param nbFleches
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Archer(int nbFleches, String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @param nbFleches
     * @param perso
     */
    public Archer(int nbFleches, Personnage perso) {
        super(perso);
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @param nbFleches
     */
    public Archer(int nbFleches) {
        this.nbFleches = nbFleches;
        setNom("Robin");
    }
    
    /**
     *
     */
    public Archer(){
        super();
        setNom("Robin");
        this.nbFleches = 0;
    }

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     * @param nb
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nb) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
	this.nbFleches = nb;
    }

    /**
     *
     * @param perso
     */
    public Archer(Personnage perso) {
        super(perso);
    }
    
    /**
     * Constructeur de copie des Archers
     * @param a
     */
    public Archer(Archer a){
        super(a);
        this.nbFleches = a.nbFleches;
    }
    
    /**
     * Fonction permettant d'attaquer une créature
     * @param c 
     */
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
    
    
    public int getNbFleches() {
	return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
	this.nbFleches = nbFleches;
    }
    
    
    
    
}
