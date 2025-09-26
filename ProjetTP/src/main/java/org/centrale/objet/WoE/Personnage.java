/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * La classe principale de Woe
 * Ils affrontent des monstres
 *
 * @author jujus
 */
public class Personnage {
    private String nom; //Nom du personnage
    private int ptVie; //Nombre de Points de vie du personnage
    private int degAtt; //Nombre de dégâts que le personnage inflige en cas d'attaque réussie
    private int ptPar; //Nombre de dégâts que le personnage peut parer en cas de parade réussie
    private int pageAtt; //Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
    private int pagePar; //Pourcentage de chance de réussite d'une parade (entre 0 et 100)
    private int distAttMax; //distance maximale entre le personnage et sa cible
    private Point2D pos; //position du personnage
    
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
        this.ptVie = pV;
        this.nom = n;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = new Point2D(p);
    }
    /**
     * Constructeur de copie de la classe Personnage
     * @param perso 
     */
    
    public Personnage(Personnage perso){
        this.ptVie = perso.ptVie;
        this.nom = perso.nom;
        this.degAtt = perso.degAtt;
        this.ptPar = perso.ptPar;
        this.pageAtt = perso.pageAtt;
        this.pagePar = perso.pagePar;
        this.distAttMax = perso.distAttMax;
        this.pos = new Point2D(perso.pos);
    }
    
    /**
     * Constructeur par défaut
     */
    public Personnage(){
        this.ptVie = 100;
        this.nom = "Perso";
        this.degAtt = 10;
        this.ptPar = 99;
        this.pageAtt = 42;
        this.pagePar = 10;
        this.distAttMax = 10;
        this.pos = new Point2D();
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Méthode de déplacement des objets de la classe personnage
     * Déplacement aléatoire (équiprobable) entre les différentes cases adjacentes à l'objet
     */
    public void deplace(){
        Random rand = new Random();
	
	// Pour avoir un vecteur dont les valeurs sont entre -1 et 1
	int dx = 0;
	int dy = 0;
	while (dx == 0 && dy == 0) {
	    dx = rand.nextInt(3) - 1;
	    dy = rand.nextInt(3) - 1;
	}
	pos.translate(dx, dy);
    }
    
    /**
     * Affiche les informations importantes du personnage : Nom, points de vie et la position
     */
    public void affiche(){
        System.out.print("Nom :" +nom + "/ Pt Vie :" + ptVie + "/ position :" );
        pos.affiche();
        System.out.println("");
    }
}
