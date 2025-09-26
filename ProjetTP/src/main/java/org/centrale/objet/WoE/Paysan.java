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
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     *
     * @param perso
     */
    public Paysan(Personnage perso) {
        super(perso);
    }

    /**
     *
     */
    public Paysan() {
        setNom("Peons");
    }
}
