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
     * Instance d'un archer s'appelant Robin
     */
    public Archer robin;
    /**
     * Instance d'un archer s'appelant Guillaume Tell
     */
    public Archer GuillaumeT ;
    /**
     * Instance d'un guerrier s'appelant grosBill
     */
    public Guerrier grosBill;
    /**
     * Instance d'un paysan peon
     */
    public Paysan peon;
    /**
     * Instance de lapin
     */
    public Lapin bugs0;
    /**
     * Instance de lapin
     */
    public Lapin bugs1;
    /**
     * Instance d'un loup s'appelant wolfie
     */
    public Loup wolfie;
    
    
    
    /**
     * Limite du plateau selon x
     * Cela sera à changer en fonction des nouvelles contraintes
     */
    private int x_max = 100;
    /**
     * Limite du plateau selon y
     * Cela sera à changer en fonction des nouvelles contraintes
     */
    private int y_max = 100;
    
    /**
     * Constructeur du monde pour créer les instances de classe
     */
    public World() {
	robin = new Archer();
	peon = new Paysan();
	grosBill = new Guerrier();
	bugs0 = new Lapin();
	bugs1 = new Lapin();
	wolfie = new Loup();
    }
    
    /**
     * Place les entités dans le monde de façon aléatoire
     * Cette fonction ne doit être appelé qu'une seule fois pour l'initialisation
     */
    public void creerMondeAlea() {
	Random rand = new Random();
	
	// rand.nextInt(100);
	
	// Création d'une liste vide de Point2D
        List<Point2D> points = new ArrayList<>();

        while (points.size() < 6) {
            int x = rand.nextInt(x_max);
            int y = rand.nextInt(y_max);
            
            Point2D p = new Point2D(x,y);

            if (!points.contains(p)){
                points.add(p);
            }
        }
        robin.setPos(points.get(0));
        GuillaumeT = new Archer(robin);
        GuillaumeT.setNom("Guillaume Tell");
        peon.setPos(points.get(1));
        bugs0.setPos(points.get(2));
        bugs1.setPos(points.get(3));
	wolfie.setPos(points.get(4));
	grosBill.setPos(points.get(5));
    }
    
    /**
     * Itère le déplacement des entités
     */
    public void tourDeJeu() {
	robin.deplace();
	peon.deplace();
	grosBill.deplace();
	bugs0.deplace();
	bugs1.deplace();
	wolfie.deplace();
	
    }
    
    /**
     * afficher (vide)
     */
    public void aficheWorld() {
	//
    }
}
