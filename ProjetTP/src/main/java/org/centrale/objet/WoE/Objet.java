/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe abstraite pour générer des objets
 * @author Catherine
 */
public class Objet {

    /**
     * Nom de l'objet
     */
    private String nom;
    
    /**
     * Constructure définissant le nom de l'objet
     * @param nom
     */
    public Objet(String nom) {
	this.nom = nom; 
    }
    
    /**
     * Constructeur par défaut donnant 'Objet' à l'objet
     */
    public Objet() {
	this.nom = "Objet";
    }
    
    /**
     * Constructeur de copie
     * @param o
     */
    public Objet(Objet o) {
	this.nom = o.nom;
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
     * @param nom
     */
    public void setNom(String nom) {
	this.nom = nom;
    }
    
    
    
    
}
