/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author jujus
 */
public class Archer extends Personnage{
    private int nbFleches;

    public Archer(int nbFleches, String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }

    public Archer(int nbFleches, Personnage perso) {
        super(perso);
        this.nbFleches = nbFleches;
    }

    public Archer(int nbFleches) {
        this.nbFleches = nbFleches;
        setNom("Robin");
    }
    
    public Archer(){
        super();
        setNom("Robin");
        this.nbFleches = 0;
    }

    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    public Archer(Personnage perso) {
        super(perso);
    }
    
    
    
    
}
