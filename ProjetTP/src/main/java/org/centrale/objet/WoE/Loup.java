/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

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
	//
    }

}
