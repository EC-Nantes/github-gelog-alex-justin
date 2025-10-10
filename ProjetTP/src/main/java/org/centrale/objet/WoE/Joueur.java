/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * La classe Joueur est la classe servant à un joueur humain d'avoir un personnage jouable
 * @author jujus
 */
public class Joueur {
    public Personnage perso; // personnage du joueur
    private String nomJoueur; // Nom du joueur

    /**
     * Constructeur complet de la classe joueur
     * @param perso Le personnage du joueur
     * @param nomj Le nom du joueur
     */
    public Joueur(Personnage perso, String nomj) {
        this.perso = perso;
        this.nomJoueur = nomj;
    }
    
    /**
     * Constructeur par défaut de la classe joueur
     */
    public Joueur() {
        this.perso = new Personnage();
        this.nomJoueur = "J1";
    }
    
    /**
     * Constructeur de copie de la classe Joueur
     * @param J joueur copié
     */
    public Joueur(Joueur J){
        this.perso = J.perso;
        this.nomJoueur = J.nomJoueur;
    }
    
    /**
     * getteur du personnage
     * @return le personnage du Joueur
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     * Setteur du personnage
     * @param perso Le nouveau personnage
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    /**
     * Getteur du nom du joueur
     * @return le nom du joueur
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * Le setteur du nom du joueur
     * @param nomJoueur le nouveau nom du joueur
     */
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }
    
    /**
     * Méthode pour choisir le personnage et le nom du joueur
     * @param nomClass le nom de la nouvelle classe du personnage
     * @param nomPerso le nom du personnage
     * @return true si la génération du personnage a réussie, false sinon
     */
    public boolean choisirPersonnage(String nomClass, String nomPerso){
        if (nomClass.equals("Archer")){
            this.perso = new Archer();
            this.perso.setNom(nomPerso);
        } else if (nomClass.equals("Guerrier")){
                this.perso = new Guerrier();
                this.perso.setNom(nomPerso);
        } else {
            System.out.println("La classe choisie n'est pas disponible");
            return false;
        }
        return true;
    }
}
