/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * La classe qui représente tous les "êtres" de WoE
 * 
 * @author jujus
 */
public class Creature {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    /**
     * Constructeur de la classe Créature
     * @param pV Nombre de points de vie du personnage
     * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
     * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
     * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
     * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
     * @param pos position de la Créature
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
	ptVie = pV;
	degAtt = dA;
	ptPar = pPar;
	pageAtt = paAtt;
	pagePar = paPar;
	this.pos = new Point2D(pos);
    }
    
    /**
     * Constructeur de copie de la classe créature
     * @param c 
     */
    public Creature(Creature c) {
	ptVie = c.ptVie;
	degAtt = c.degAtt;
	ptPar = c.ptPar;
	pageAtt = c.pageAtt;
	pagePar = c.pagePar;
    }
    
    /**
     * Constructeur par défaut de la classe créature
     */
    public Creature() {
	ptVie = 100;
	degAtt = 10;
	ptPar = 10;
	pageAtt = 10;
	pagePar = 10;
	pos = new Point2D(0, 0);
    }
    
    /**
     * Méthode de déplacement de la classe Monstre
     * Déplacement aléatoire sur une des cases adjacente au monstre (équiprobable)
     */
    public void deplace() {
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
     * Méthode affichage des informations importantes de la créature : Points de vie et position
     */
    public void affiche() {
	System.out.print("Pt Vie :" + ptVie + "/ position :" );
        pos.affiche();
        System.out.println("");
    }
    
    /**
     * Guetteur de points vie
     * @return le nombre de points de vie
     */
    public int getPtVie() {
	return ptVie;
    }
    
    /** 
     * Setter de point de vie
     * @param pV le nouveau nombre de points de vie
     */
    public void setPtVie(int pV) {
	ptVie = pV;
    }

    /**
     * Guetteur de la quantité de dégâts
     * @return le nombre de dégâts infligés
     */
    public int getDegAtt() {
	return degAtt;
    }

    /**
     * Getter du nombre de points de parade
     * @return les points de parade
     */
    public int getPtPar() {
	return ptPar;
    }

    /**
     * le gettter du pourcentage d'attaque
     * @return le pourcentage de réussite d'attaque
     */
    public int getPageAtt() {
	return pageAtt;
    }

    /**
     * le gettter du pourcentage de parade
     * @return le pourcentage de réussite de parade
     */
    public int getPagePar() {
	return pagePar;
    }

    /**
     * le gettter de la position
     * @return la position de la créature
     */
    public Point2D getPos() {
	return pos;
    }

    /**
     * le setter de la quantité de dégâts infligés
     * @param degAtt la quantité de dégâts
     */
    public void setDegAtt(int degAtt) {
	this.degAtt = degAtt;
    }

    /**
     * le setter de la quantité de dégâts parés
     * @param ptPar les points de parade
     */
    public void setPtPar(int ptPar) {
	this.ptPar = ptPar;
    }

    /**
     * le setter du pourcentage d'attaque réussie
     * @param pageAtt le pourcentage d'attaque réussie
     */
    public void setPageAtt(int pageAtt) {
	this.pageAtt = pageAtt;
    }

    /** 
     * le setteur du pourcentage de parade réussie
     * @param pagePar le pourcentage de parade réussie
     */
    public void setPagePar(int pagePar) {
	this.pagePar = pagePar;
    }

    /**
     * le setter de la position
     * @param pos la nouvelle position
     */
    public void setPos(Point2D pos) {
	this.pos = pos;
    }
    
}
