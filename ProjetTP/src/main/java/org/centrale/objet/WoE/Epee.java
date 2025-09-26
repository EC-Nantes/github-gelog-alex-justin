    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe d'une épée
 * @author Catherine
 */
public class Epee extends Objet {
    private int ptAttaque;
    private int ptDurabilite;
    
    /**
     * Constructeur de base d'une épée
     */
    public Epee() {
    ptAttaque = 100;
    ptDurabilite = 100;
    super.setNom("Epée");
    }
    
    /**
     * Constructeur pour spécifier les dégats
     * 
     * @param ptA Nombre de dégats
     */
    public Epee(String nom, int ptA) {
    ptAttaque = ptA;
    ptDurabilite = 100;
    super.setNom(nom);
    }
    
    /**
     * Constructeur d'épée en spécifiant les dégats et la durabilité
     * @param nom Nom de l'épée
     * @param ptA Nombre de dégats
     * @param ptD Point de durabilité
     */
    public Epee(String nom, int ptA, int ptD) {
    ptAttaque = ptA;
    ptDurabilite = ptD;
    super.setNom(nom);
    }
    
    
    
    /**
     * Utilisation de l'objet
     * @param g La créature qui attaque
     * @param c La créature attaquée
     */
    public void utilisation(Guerrier g, Creature c) {
    int degAtt_base = g.getDegAtt();
    g.setDegAtt(degAtt_base + ptAttaque);
    g.combattre(c);
    g.setDegAtt(degAtt_base);
    }

    /**
     *
     * @return
     */
    public int getPtAttaque() {
    return ptAttaque;
    }

    /**
     *
     * @param ptAttaque
     */
    public void setPtAttaque(int ptAttaque) {
    this.ptAttaque = ptAttaque;
    }

    /**
     *
     * @return
     */
    public int getPtDurabilite() {
    return ptDurabilite;
    }

    /**
     *
     * @param ptDurabilite
     */
    public void setPtDurabilite(int ptDurabilite) {
    this.ptDurabilite = ptDurabilite;
    }

    /**
     * Constructeur de copie
     * @param baatonn baaaaatooonnnn
     */
    public Epee(Epee baatonn) {
        super(baatonn);
    }
    
    
    
}
