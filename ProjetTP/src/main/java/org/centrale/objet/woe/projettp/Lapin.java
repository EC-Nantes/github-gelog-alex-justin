/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp;

/**
 *
 * @author Alexandre
 * @version 1.0
 */
public class Lapin extends Monstre {
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
	super(pV, dA, pPar, paAtt, paPar, pos);
    }
    
    public Lapin(Lapin l) {
	super(l);
    }
    
    public Lapin() {
	super();
    }
}
