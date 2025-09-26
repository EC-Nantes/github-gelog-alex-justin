/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

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
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
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
    
    
    
    
    
}
