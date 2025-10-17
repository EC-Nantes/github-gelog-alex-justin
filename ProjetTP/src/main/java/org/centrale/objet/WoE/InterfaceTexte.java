/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Scanner;

/**
 * Classe permettant de générer une interface minimaliste
 * @author jujus
 */
public class InterfaceTexte {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Affiche le monde sous forme de grille textuelle.
     * Chaque case du monde est représentée par une lettre :
     * G = Guerrier, A = Archer, M = Monstre, J = Joueur, N = Nuage toxique, . = vide
     * @param w le monde
     * @param joueur le joueur qui va jouer
     */
    public void afficherMonde(World w, Joueur joueur) {
        int maxX = w.world_max_x;
        int maxY = w.world_max_y;

        // Création du tableau du monde, rempli de '.'
        char[][] plateau = new char[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                plateau[y][x] = '.';
            }
        }

        // Placement du joueur
        Point2D pJoueur = joueur.getPerso().getPos();
        if (pJoueur != null) {
            int x = pJoueur.getX();
            int y = pJoueur.getY();
            if (x >= 0 && x < maxX && y >= 0 && y < maxY) {
                plateau[y][x] = 'J';
            }
        }

        // Placement des créatures
        for (Creature c : w.list_creature) {
            if (c == null || c.getPtVie() <= 0) continue;
            Point2D p = c.getPos();
            if (p == null) continue;
            int x = (int) p.getX();
            int y = (int) p.getY();
            if (x < 0 || x >= maxX || y < 0 || y >= maxY) continue;

            if (plateau[y][x] == 'J') continue; // le joueur a priorité et NORMALEMENT ils ne peuvent pas être sur la même case
            plateau[y][x] = symboleCreature(c);
        }

        // Placement des objets
        for (Objet o : w.list_objet) {
            if (o == null) continue;
            Point2D p = o.getPos();
            if (p == null) continue;
            int x = (int) p.getX();
            int y = (int) p.getY();
            if (x < 0 || x >= maxX || y < 0 || y >= maxY) continue;

            if (plateau[y][x] == '.') { //On évite ainsi les problèmes
                plateau[y][x] = symboleObjet(o);
            }
        }

        // Affichage final
        System.out.println("\n=== Plateau de jeu ===");
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                System.out.print(plateau[y][x] + " ");
            }
            System.out.println();
        }

        System.out.println("\nLégende : A = Archer ;"
                + " B = Bulbi ;"
                + " C = Creature Inconnue ;"
                + " E = Epee ;"
                + " G = Guerrier ;"
                + " J = Joueur ;"
                + " L = Loup ;"
                + " l = lapin ;"
                + " N = Nourriture ;"
                + " O = Objet Inconnu ;"
                + " S = Potion de Soin ;"
                + " T = Nuage Toxique ;"
                + " V = Villageois \n");
    }

    /**
     * Méthode qui renvoie le symbole sur la carte correspondant à la créature demandé
     * @param c la créature
     * @return renvoie le symbole (p.ex 'A' pour un Archer)
     */
    private char symboleCreature(Creature c) {
        return switch (c.getClass().getSimpleName()) {
            case "Guerrier" -> 'G';
            case "Archer" -> 'A';
            case "Paysan" -> 'V';
            case "Bulbi" -> 'B';
            case "Lapin" -> 'l';
            case "Loup" -> 'L';
            case "lapin" -> 'l';
            default -> 'C';
        };
    }
    
    /**
     * Méthode pour obtenir le symbole sur la carte correspondant à un objet
     * @param o l'objet
     * @return le symbole (p.ex 'E' pour une Epee)
     */
    private char symboleObjet(Objet o) {
        return switch (o.getClass().getSimpleName()) {
            case "Epee" -> 'E';
            case "Nourriture" -> 'N';
            case "NuageToxique" -> 'T';
            case "PotionSoin" -> 'S';
            default -> 'O';
        };
    }
    
    /**
     * Affiche le menu de tour de jeu et retourne le choix du joueur.
     * @param joueur Le joueur 
     * @return le menu
     */
    public String afficherMenuTour(Joueur joueur) {
        System.out.println("\n=== Tour de " + joueur.getNomJoueur() + " ===");
        System.out.println("1. Se déplacer");
        System.out.println("2. Combattre");
        System.out.println("3. Sauvegarder et quitter");
        System.out.print("Votre choix : ");
        return scanner.nextLine();
    }

    /**
     * Ferme le scanner (appelé à la fin du jeu)
     */
    public void fermer() {
        scanner.close();
    }
    
}
