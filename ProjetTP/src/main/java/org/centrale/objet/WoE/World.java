/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 * @version 1.1
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs0;
    public Lapin bugs1;
    
    private int x_max = 100;
    private int y_max = 100;
    
    public World() {
	robin = new Archer();
	peon = new Paysan();
	bugs0 = new Lapin();
	bugs1 = new Lapin();
    }
    
    public void creerMondeAlea() {
	Random rand = new Random();
	
	// rand.nextInt(100);
	
	// Création d'une liste vide de Point2D
        List<Point2D> points = new ArrayList<>();

        while (points.size() < 4) {
            int x = rand.nextInt(x_max);
            int y = rand.nextInt(y_max);
            
            Point2D p = new Point2D(x,y);

            if (!points.contains(p)){
                points.add(p);
            }
        }
        robin.setPos(points.get(0));
        peon.setPos(points.get(1));
        bugs0.setPos(points.get(2));
        bugs1.setPos(points.get(3));
    }
    
    public void tourDeJeu() {
	robin.deplace();
	peon.deplace();
	bugs0.deplace();
	bugs1.deplace();
	
    }
}
