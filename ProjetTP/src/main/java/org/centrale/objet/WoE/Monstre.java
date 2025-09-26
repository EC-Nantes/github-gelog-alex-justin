/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
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
    
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
	ptVie = pV;
	degAtt = dA;
	ptPar = pPar;
	pageAtt = paAtt;
	pagePar = paPar;
	this.pos = new Point2D(pos);
    }
    
    public Monstre(Monstre m) {
	ptVie = m.ptVie;
	degAtt = m.degAtt;
	ptPar = m.ptPar;
	pageAtt = m.pageAtt;
	pagePar = m.pagePar;
    }
    
    public Monstre() {
	ptVie = 100;
	degAtt = 10;
	ptPar = 10;
	pageAtt = 10;
	pagePar = 10;
	pos = new Point2D(0, 0);
    }
    
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
    
    public void affiche() {
	System.out.print("Pt Vie :" + ptVie + "/ position :" );
        pos.affiche();
        System.out.println("");
    }
    
    public int getPtVie() {
	return ptVie;
    }
    
    public void setPtVie(int pV) {
	ptVie = pV;
    }

    public int getDegAtt() {
	return degAtt;
    }

    public int getPtPar() {
	return ptPar;
    }

    public int getPageAtt() {
	return pageAtt;
    }

    public int getPagePar() {
	return pagePar;
    }

    public Point2D getPos() {
	return pos;
    }

    public void setDegAtt(int degAtt) {
	this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
	this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
	this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
	this.pagePar = pagePar;
    }

    public void setPos(Point2D pos) {
	this.pos = pos;
    }
    
    
    
    
    
   
   
    
    
    
}
