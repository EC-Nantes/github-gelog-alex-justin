/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

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
	//
    }
}
