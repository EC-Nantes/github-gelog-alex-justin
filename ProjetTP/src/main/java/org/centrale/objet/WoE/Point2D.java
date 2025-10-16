/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.lang.Math;
/**
 * Définition des positions
 * @author Alexandre
 * @version 1.1
 */
public class Point2D {
	private int x = 0;
	private int y = 0;
	
	/**
	 * Constructeur par défaut 
	 */
	public Point2D() {
		//
	}
	
	/**
	 * Constructeur complet
	 * @param x position sur l'axe X
	 * @param y position sur l'axe Y
	 */
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructeur de copie
	 * @param p la position copié
	 */
	public Point2D(Point2D p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	/**
	 * Setteur de la position X
	 * @param v la position sur l'axe X
	 */
	public void setX(int v) {
		x = v;
	}
	
	/**
	 * Guetteur de la position X
	 * @return la position sur l'axe X
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Setteur de la position Y
	 * @param v la position sur l'axe Y
	 */
	public void setY(int v) {
		y = v;
	}
	
	/**
	 * Guetteur de la position Y
	 * @return la position sur l'axe Y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Setteur de la position
	 * @param x sur l'axe X
	 * @param y sur l'axe Y
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Méthode pour faire des translations
	 * @param dx de combien de pixels on se déplace sur l'axe X
	 * @param dy de combien de pixels on se déplace sur l'axe Y
	 */
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	/**
	 * Méthode pour afficher la position
	 */
	public void affiche() {
		System.out.print("[" + x + ", " + y + "]");
	}
	
	/**
	 * méthode pour calculer la distance entre le point et un autre
	 * @param p l'autre point
	 * @return la distance entre ce point et p
	 */
	public float distance(Point2D p) {
		float val = (x-p.x)*(x-p.x) + (y-p.y)*(y-p.y);
		return (float)Math.sqrt(val);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + this.x;
		hash = 37 * hash + this.y;
		return hash;
	}

	/**
	 * comparateur de points
	 * @param obj le points comparé
	 * @return True si ils sont égaux, False sinon
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Point2D other = (Point2D) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}
	
	
}
