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
     * @param ptA Nombre de dégats
     */
    public Epee(int ptA) {
    ptAttaque = ptA;
    ptDurabilite = 100;
    super.setNom("Epée");
    }
    
    /**
     * Constructeur d'épée en spécifiant les dégats et la durabilité
     * @param ptA Nombre de dégats
     * @param ptD Point de durabilité
     */
    public Epee(int ptA, int ptD) {
    ptAttaque = ptA;
    ptDurabilite = ptD;
    super.setNom("Epée");
    }
    
    /**
     * Utilisation de l'objet
     * @param ca La créature qui attaque
     * @param cb La créature attaquée
     */
    public void utilisation(Creature ca, Creature cb) {
    int degAtt_base = ca.getdegAtt();
    ca.setdegAtt(degAtt_base + ptAttaque);
    ca.combattre(cb);
    ca.setdegAtt(degAtt_base);
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
    
}
