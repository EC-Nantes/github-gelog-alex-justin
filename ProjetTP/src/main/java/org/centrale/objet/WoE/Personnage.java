/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * La classe principale de Woe
 * Ils affrontent des monstres
 *
 * @author jujus
 */
public class Personnage extends Creature{
    private String nom; //Nom du personnage
    private int distAttMax; //distance maximale entre le personnage et sa cible
    /**
     * Constructeur de la classe Personnage
     * @param n Nom du personnage
     * @param pV Nombre de points de vie du personnage
     * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
     * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
     * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
     * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
     * @param dMax distance maximale entre le personnage et sa cible
     * @param p position du personnage
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
        this.nom = n;
        this.distAttMax = dMax;
    }
    /**
     * Constructeur de copie de la classe Personnage
     * @param perso Le personnage copié
     */
    
    public Personnage(Personnage perso){
        super(perso);
        this.nom = perso.nom;
        this.distAttMax = perso.distAttMax;
    }
    
    /**
     * Constructeur par défaut
     */
    public Personnage(){
        super();
        this.nom = "Perso";
        this.distAttMax = 1;
    }

    /**
     * Setteur du nom du personnage
     * @param nom le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Guetteur du nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * getteur de la portée du personnage
     * @return la portée du personnage (c'est le rayon d'un cercle représentant sa portée)
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Setteur de la portée du perosnnage
     * @param distAttMax la nouvelle portée du personnage (c'est le rayon d'un cercle représentant sa portée)
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    @Override
    public void affiche(){
        System.out.print("Nom :" +nom + "/ Pt Vie :" + this.getPtVie() + "/ position :" );
        this.getPos().affiche();
        System.out.println("");
    }
}
