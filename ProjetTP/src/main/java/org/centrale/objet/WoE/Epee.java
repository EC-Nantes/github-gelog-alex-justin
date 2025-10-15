    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe d'une épée
 * @author Catherine
 */
public class Epee extends Objet implements Utilisable {
    private int ptAttaque;
    private int ptDurabilite;
    
    /**
     * Constructeur de base d'une épée
     */
    public Epee() {
        super();
        ptAttaque = 100;
        ptDurabilite = 100;
        super.setNom("Epée");
    }
    
    /**
     * Constructeur pour spécifier les dégats et la position
     * @param nom nom de l'épée
     * @param ptA Nombre de dégats
     * @param pos position de l'objet
     */
    public Epee(String nom, int ptA, Point2D pos) {
        super(nom, pos);
        ptAttaque = ptA;
        ptDurabilite = 100;
    }
    
    /**
     * Constructeur d'épee pour le guerrier par défaut
     * @param nom Le nom de l'épée
     * @param ptA la quantité de dégâts
     */
    public Epee(String nom, int ptA) {
        super(nom);
        ptAttaque = ptA;
        ptDurabilite = 100000;
    }
    
    /**
     * Constructeur de l'épée à partir du nom et des stats
     * @param nom le nom de l'épée
     * @param ptA les points d'attaques de l'épée
     * @param ptD la durbabilité de l'épée
     */
    public Epee(String nom, int ptA, int ptD) {
        super(nom);
        ptAttaque = ptA;
        ptDurabilite = ptD;
    }
    
    /**
     * Constructeur d'épée en spécifiant les dégats et la durabilité
     * @param nom Nom de l'épée
     * @param ptA Nombre de dégats
     * @param ptD Point de durabilité
     * @param pos position de l'épée
     */
    public Epee(String nom, int ptA, int ptD, Point2D pos) {
        super(nom, pos);
        ptAttaque = ptA;
        ptDurabilite = ptD;
    }
    
    
    
    /**
     * Utilisation de l'objet
     * @param c La créature qui prend l'épée
     */
    @Override
    public void utilisation(Creature c) {
        switch (c.getClass().getSimpleName().toLowerCase()){
            case "guerrier" :
                ((Guerrier)c).setArme(this);
                break;
            default :
                System.out.println("\n Cette créature ne peut pas prendre cet objet");
                break;
        }
        
    }

    /**
     * Guetter de la quantité de dégâts de l'épée
     * @return les points de dégâts ingligés par l'épee
     */
    public int getPtAttaque() {
        return ptAttaque;
    }

    /**
     * Setteur de la quantité de dégâts infligés par l'épée
     * @param ptAttaque la nouvelle quantité de points de dégâts
     */
    public void setPtAttaque(int ptAttaque) {
        this.ptAttaque = ptAttaque;
    }

    /**
     * Guetter de la durabilité de l'épée
     * @return la durabilité de l'épee
     */
    public int getPtDurabilite() {
        return ptDurabilite;
    }

    /**
     * Setteur de la quantité de dégâts infligés par l'épée
     * @param ptDurabilite la nouvelle durabilité
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
        this.ptAttaque = baatonn.ptAttaque;
        this.ptDurabilite = baatonn.ptDurabilite;
    }
    
    
    
}
