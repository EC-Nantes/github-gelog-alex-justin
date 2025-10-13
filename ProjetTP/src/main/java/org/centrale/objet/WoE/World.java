/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Création du monde et initialisation des personnage
 * @author Alexandre
 * @version 1.1
 */
public class World {
    /**
     * Largeur du monde
     */
    public int world_max_x = 50;
    /**
     * Longueur du monde
     */
    public int world_max_y = 50;
    
    /**
     * Liste des créatures du monde
     */
    public List<Creature> list_creature;
    
    /**
     * Liste des objets du monde
     */
    public List<Objet> list_objet;
    
    /**
     * Constructeur du monde pour créer les instances de classe
     * La taille par défaut est de 50x50
     */
    public World() {
	world_max_x = 50;
	world_max_y = 50;
	list_creature = new ArrayList<>();
	list_objet = new ArrayList<>();
    }
    
    /**
     * Constructeur du monde pour créer les instances de classe
     * @param max_x Largeur du monde
     * @param max_y Longueur du monde
     */
    public World(int max_x, int max_y) {
	world_max_x = max_x;
	world_max_y = max_y;
	list_creature = new ArrayList<>();
	list_objet = new ArrayList<>();
    }
    
 
    
    /**
     * Crée un nombre aléatoire de créatures et les place les entités dans le monde de façon aléatoire
     * Cette fonction ne doit être appelé qu'une seule fois pour l'initialisation
     */
    public void creerMondeAlea() {
	Random rand = new Random();
	creerMondeAlea(rand.nextInt(50));
    }
    
    /**
     * Crée un nombre n de créatures et les place les entités dans le monde de façon aléatoire
     * Cette fonction ne doit être appelé qu'une seule fois pour l'initialisation
     * @param n 
     */
    public void creerMondeAlea(int n) {
	/* *************************************************** */
	/* **** Problème lorsque n tend vers world_size^2 **** */
	/* *************************************************** */
	Random rand = new Random();

	// Création d'une liste vide de Point2D
        List<Point2D> pos = new ArrayList<>();
	
	// Répartition des mobs dans le monde
        while (pos.size() < n) {
            int x = rand.nextInt(world_max_x);
            int y = rand.nextInt(world_max_y);
            
            Point2D p = new Point2D(x,y);

            if (!pos.contains(p)) pos.add(p);
        }
	

	// Création d'une répartition aléatoire de différents type de créature
	int[] nb = new int[6];
	int s = 0;
        if (n != 0) {
            for (int i = 0; i < 5; i++) {
                int a = rand.nextInt(n-s);
                s += a;
                nb[i] = a;
            }
            nb[5] = n - s;
        }
	
	// Création des différentes créatures
	for (int i = 0; i < nb[0]; i++) list_creature.add(new Archer());
	for (int i = 0; i < nb[1]; i++) list_creature.add(new Guerrier());
	for (int i = 0; i < nb[2]; i++) list_creature.add(new Paysan());
	for (int i = 0; i < nb[3]; i++) list_creature.add(new Loup());
	for (int i = 0; i < nb[4]; i++) list_creature.add(new Lapin());
	for (int i = 0; i < nb[5]; i++) list_creature.add(new Bulbi());
	
	// Placement des mobs
	for (int i = 0; i < list_creature.size(); i++) {
	    list_creature.get(i).setPos(pos.get(i));
	}
	
	
    }
    
    /**
     * Itère le déplacement des entités
     */
    public void tourDeJeu() {
	for (Creature c : list_creature) c.deplace(this);
    }
    
    /**
     * Affiche chaque creature du monde
     */
    public void afficheWorld() {
	for (Creature c : list_creature) {
	    c.affiche();
	}
    }
    
    /**
     * Valide la position d'un mob sur le jeu
     * @param pos
     * @return 
     */
    public boolean validPos(Point2D pos) {
	// Pour ne pas allez hors de la zone de jeu
	if (pos.getX() < 0 || pos.getX() >= world_max_x) return false;
	if (pos.getY() < 0 || pos.getY() >= world_max_y) return false;
	
	// On se prémunit du cas ou list_creature n'est pas définit
	if (list_creature == null) return true;
	
	// Pour ne pas se placer sur un autre mob
	for (Creature c : list_creature) {
	    if (c.getPos().equals(pos)) return false;
	}
	
	
	// Si aucune restriction n'a été enfrein, la position est validée
	return true;
    }
       
    /**
     * Méthode permettant de trouver une des créature du monde à partir du nom de sa classe
     * @param nomClasse String du nom de la classe
     * @return une créature correspondante
     */
    public Creature trouverCreatureParClasse(String nomClasse) {
        nomClasse = nomClasse.toLowerCase(); // pour ignorer la casse

        for (Creature c : list_creature) {
            if (c.getPtVie() > 0) { // ignorer les morts
                String classeC = c.getClass().getSimpleName().toLowerCase();
                if (classeC.equals(nomClasse)) {
                    return c; // renvoie la première créature correspondante
                }
            }
        }
        return null; // aucune trouvée
    }
}
