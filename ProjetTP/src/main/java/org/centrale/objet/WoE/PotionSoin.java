/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Potion de régénération
 * @author Catherine
 */
public class PotionSoin extends Objet implements Utilisable {
    private int ptRegen;
    
    /**
     * Constructeur d'une potion de soin avec une régénération par défaut de 10 points de vie
     */
    public PotionSoin() {
        super();
	ptRegen = 10;
	super.setNom("Potion de Soin");
    }
    
    /**
     * Constructeur pour fixer le nombre de point de régénération
     * @param ptV Points de vie régénérés par la potion
     * @param nom Le nom de la potion
     * @param pos La position de l'objet
     */
    public PotionSoin(String nom, int ptV, Point2D pos) {
        super(nom, pos);
	ptRegen = ptV;
    }
    
    /**
     * Constructeur de Potion à partir du nom et des pt de vie
     * @param nom le nom de la potion
     * @param ptV le nombre de pt de vie régénéré
     */
    public PotionSoin(String nom, int ptV){
        super(nom);
        ptRegen = ptV;
    }
    
    /**
     * Régénère le personnage
     * @param c La créature à régénérer
     */
    @Override
    public void utilisation(Creature c) {
	if (ptRegen == 0) return;
	c.setPtVie(c.getPtVie() + ptRegen);
	ptRegen = 0;
    }

    /**
     * Getter de la quantité de PV régénérés par la potion
     * @return la quantité de PV régénérés par la potion
     */
    public int getPtRegen() {
	return ptRegen;
    }

    /**
     * Setter de la quantité de PV régénérés par la potion
     * @param ptRegen la nouvelle quantité de PV régénérés par la potion
     */
    public void setPtRegen(int ptRegen) {
	this.ptRegen = ptRegen;
    }

    /**
     * Constructeur de copie
     * @param PS Potion copiée
     */
    public PotionSoin(PotionSoin PS) {
        super(PS);
        this.ptRegen = PS.ptRegen;
    }
    
    
    
    
}
