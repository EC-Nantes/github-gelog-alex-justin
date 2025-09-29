/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant un Bulbizarre (du jeu pokémon) dans le jeu WorldofECn, référence à notre liste BDAù
 * Classe spécifique, liée aux attaques à moyenne distance, ne frappe pas fort mais ne peut pas rater
 * 
 * @author jujus
 * 
 * L'objectif c'est que les bulbis soient une espèce de mage avec une attaque fouet liane qui peut évoluer pour devenir une tempete verte.
 * les bulbis ont un nombre de PP par défaut, ils en utilisent 1 à chaque attaque 
 */
public class Bulbi extends Monstre {
    private int PP; // PP de Bulbi

    /**
     * Constructeur de la classe Bulbi
     * @param PP Nombre de PP de Bulbi
     * @param pV Nombre de Points de Vie de Bulbi
     * @param dA Dégâts de Bulbis
     * @param pPar Points de Parade
     * @param paAtt Pourcentage de réussite d'attaque
     * @param paPar Pourcentage de réussite de parade
     * @param p Position de Bulbi
     */
    public Bulbi(int PP, int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
        this.PP = PP;
    }

    /**
     * Constructeur de transformation d'un monstre en Bulbi
     * @param PP PP
     * @param m Le monstre
     */
    public Bulbi(int PP, Monstre m) {
        super(m);
        this.PP = PP;
    }

    /**
     * Constructeur par défaut avec les PP
     * @param PP
     */
    public Bulbi(int PP) {
        this.PP = PP;
    }

    /**
     * Constructeur de copie de Bulbis
     * @param Bulbizarre Le bulbi copié
     */
    public Bulbi(Bulbi Bulbizarre) {
        super(Bulbizarre);
    }

    /**
     * Constructeur par défaut de Bulbi
     */
    public Bulbi() {
        super();
    }
    
    @Override
    public void affiche(){
        System.out.print("Bulbiz'art" + "PP :" +PP + "/ Pt Vie :" + this.getPtVie() + "/ position :" );
        this.getPos();
        System.out.println("");
    }
    
}
