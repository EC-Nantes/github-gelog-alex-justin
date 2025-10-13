/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe abstraite pour générer des objets
 * @author Catherine
 */
public class Objet extends ElementDeJeu{

    /**
     * Nom de l'objet
     */
    private String nom;
    
    /**
     * Constructure définissant le nom de l'objet
     * @param nom nom de l'objet créé
     * @param pos la position de l'objet
     */
    public Objet(String nom, Point2D pos) {
        super(pos);
	this.nom = nom; 
    }
    
    /**
     * Constructeur par défaut donnant 'Objet' à l'objet
     */
    public Objet() {
        super();
	this.nom = "Objet";
    }
    
    /**
     * Constructeur de copie
     * @param o objet copié
     */
    public Objet(Objet o) {
        super(o);
	this.nom = o.nom;
    }

    /**
     * Méthode pour obtenir le nom de l'objet
     * @return le nom de l'objet
     */
    public String getNom() {
	return nom;
    }

    /**
     * Méthode pour définir le nom de l'objet
     * @param nom le nouveau nom de l'objet
     */
    public void setNom(String nom) {
	this.nom = nom;
    }
    
    
    
    
}
