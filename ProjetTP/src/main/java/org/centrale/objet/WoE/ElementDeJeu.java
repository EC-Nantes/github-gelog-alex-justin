/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Regroupe tous les éléments du jeu
 * @author jujus
 */
public class ElementDeJeu {
	private Point2D pos; // la position de l'élement de jeu
	
	/**
	 * Constructeur d'un élément de Jeu
	 * @param posi la position de l'élement 
	 */
	public ElementDeJeu(Point2D posi){
		this.pos = posi;
	}
	
	/**
	 * Constructeur par défaut de l'élement de jeu
	 */
	public ElementDeJeu(){
		this.pos = new Point2D();
	}
	
	/**
	 * Constructeur de copie de l'élement de jeu
	 * @param edj élement de jeu copié
	 */
	public ElementDeJeu(ElementDeJeu edj){
		this.pos = edj.pos;
	}

	/**
	 * Getteur de la position
	 * @return la position
	 */
	public Point2D getPos() {
		return pos;
	}

	/**
	 * Setteur de la position
	 * @param pos la nouvelle position
	 */
	public void setPos(Point2D pos) {
		this.pos = pos;
	}
	
	
}
