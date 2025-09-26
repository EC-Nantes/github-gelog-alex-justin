/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe des monstres de WoE
 * Opposants des personnages
 * 
 * @author Alexandre
 * @version 1.0
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    
    /**
     * Constructeur de la classe Monstre
     * @param pV Nombre de points de vie du personnage
     * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
     * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
     * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
     * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
     * @param pos position du Monstre
     */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
	ptVie = pV;
	degAtt = dA;
	ptPar = pPar;
	pageAtt = paAtt;
	pagePar = paPar;
	this.pos = new Point2D(pos);
    }
    
    /**
     * Constructeur de copie de la classe monstre
     * @param m 
     */
    public Monstre(Monstre m) {
	ptVie = m.ptVie;
	degAtt = m.degAtt;
	ptPar = m.ptPar;
	pageAtt = m.pageAtt;
	pagePar = m.pagePar;
    }
    
    /**
     * Constructeur par défaut de la classe monstre
     */
    public Monstre() {
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
     * Méthode affichage des informations importantes du monstre : Points de vie et position
     */
    public void affiche() {
	System.out.print("Pt Vie :" + ptVie + "/ position :" );
        pos.affiche();
        System.out.println("");
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
     * @param pV
     */
    public void setPtVie(int pV) {
	ptVie = pV;
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
     * @return
     */
    public int getPtPar() {
	return ptPar;
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
     * @return
     */
    public int getPagePar() {
	return pagePar;
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
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
	this.degAtt = degAtt;
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
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
	this.pageAtt = pageAtt;
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
     * @param pos
     */
    public void setPos(Point2D pos) {
	this.pos = pos;
    }
    
    
    
    
    
   
   
    
    
    
}
