/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Alexandre
 * @version 1.1
 */
public class World {
    public Archer robin;
    public Paysan peons;
    public Lapin bugs0;
    public Lapin bugs1;
    
    private const int x_max = 100;
    private const int y_max = 100;
    
    public World() {
	robin = new Archer();
	peons = new Paysan();
	bugs0 = new Lapin();
	bugs1 = new Lapin();
    }
    
    public void creerMondeAlea() {
	Random rand = new Random();
	
	// rand.nextInt(100);
	
	Point2D pos_list = new Point2D[4];
	
	
	
	int x = rand.nextInt(x_max);
	int y = rand.nextInt(y_max);
	
    }
}
