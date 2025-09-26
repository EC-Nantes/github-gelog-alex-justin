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
     * @param ptV 
     */
    public PotionSoin(int ptV) {
	ptRegen = ptV;
	super.setNom("Potion de Soin");
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
    
    
    
}
