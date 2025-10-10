/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Scanner;

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
        nomClass = nomClass.toLowerCase();
        if (nomClass.equals("archer")){
            this.perso = new Archer();
            this.perso.setNom(nomPerso);
        } else if (nomClass.equals("guerrier")){
                this.perso = new Guerrier();
                this.perso.setNom(nomPerso);
        } else {
            System.out.println("La classe choisie n'est pas disponible");
            return false;
        }
        return true;
    }
    
    /**
     * Méthode de déplacement des joueurs
     * @param dx déplacement sur l'axe X
     * @param dy déplacement sur l'axe Y
     */
    public void deplace(int dx, int dy) {
        try {
            // On vérifie la condition
            if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                // On lève une exception si le déplacement est trop grand
                throw new IllegalArgumentException("Déplacement trop grand : on ne peut bouger que d'une case à la fois !");
            }

            // Si tout va bien, on déplace le personnage
            Point2D pos = this.perso.getPos();
            pos.translate(dx, dy);
            this.perso.setPos(pos);

        } catch (IllegalArgumentException e) {
            // On gère l'erreur
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    
    /**
     * Méthode principale appelée à chaque tour
     * @param monde le monde de la partie
     */
    public void jouerTour(World monde) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--- Tour du joueur ---");
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Se déplacer");
        System.out.println("2 - Combattre");
        System.out.print("Choix : ");

        int choix = scanner.nextInt();
        
        switch (choix) {
            case 1:
                System.out.println(nomJoueur + " choisit de se déplacer");
                System.out.print("Déplacement en x (-1, 0, 1) : ");
                int dx = scanner.nextInt();
                System.out.print("Déplacement en y (-1, 0, 1) : ");
                int dy = scanner.nextInt();
                deplace(dx, dy);
                break;
            case 2:
                
                perso.combattre(monde);
                break;
            default:
                System.out.println("Choix invalide !");
                break;
        }
    }
}
    
