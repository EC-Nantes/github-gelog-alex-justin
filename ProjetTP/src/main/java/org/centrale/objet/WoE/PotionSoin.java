/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Potion de régénération
 * @author Catherine
 */
public class PotionSoin extends Objet {
    private int ptRegen;
    
    /**
     * Constructeur d'une potion de soin avec une régénération par défaut de 10 points de vie
     */
    public PotionSoin() {
	ptRegen = 10;
	super.setNom("Potion de Soin");
    }
    
    /**
     * Constructeur pour fixer le nombre de point de régénération
     * @param ptV Points de vie régénérés par la potion
     * @param nom Le nom de la potion
     */
    public PotionSoin(String nom, int ptV) {
	ptRegen = ptV;
	super.setNom(nom);
    }
    
    /**
     * Régénère le personnage
     * @param c La créature à régénérer
     */
    public void utilisation(Creature c) {
	if (ptRegen == 0) return;
	c.setPtVie(c.getPtVie() + ptRegen);
	ptRegen = 0;
    }

    /**
     *
     * @return
     */
    public int getPtRegen() {
	return ptRegen;
    }

    /**
     *
     * @param ptRegen
     */
    public void setPtRegen(int ptRegen) {
	this.ptRegen = ptRegen;
    }

    public PotionSoin(PotionSoin PS) {
        super(PS);
        this.ptRegen = PS.ptRegen;
    }
    
    
    
    
}
