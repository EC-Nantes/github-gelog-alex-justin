/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant un Bulbizarre (du jeu pokémon) dans le jeu WorldofECn, référence à notre liste BDAù
 * Classe spécifique, liée au attaque à moyenne distance, ne frappe pas fort mais ne peut pas rater
 * 
 * @author jujus
 * 
 * L'objectif c'est que les bulbis soient une espèce de mage avec une attaque fouet liane qui peut évoluer pour devenir une tempete verte.
 * les bulbis ont un nombre de PP par défaut, ils en utilisent 1 à chaque attaque 
 */
public class Bulbi extends Personnage {
    private int PP;

    /**
     *
     * @param PP
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Bulbi(int PP, String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.PP = PP;
    }

    /**
     *
     * @param PP
     * @param perso
     */
    public Bulbi(int PP, Personnage perso) {
        super(perso);
        this.PP = PP;
    }

    /**
     *
     * @param PP
     */
    public Bulbi(int PP) {
        this.PP = PP;
        setNom("Bulbizart");
    }

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Bulbi(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     *
     * @param perso
     */
    public Bulbi(Personnage perso) {
        super(perso);
    }

    /**
     *
     */
    public Bulbi() {
        setNom("Bulbizart");
    }
    
    
    
}
