/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp;

/**
 *
 * @author Alexandre
 * @version 1.0
 */
public class World {
    public Archer robin;
    public Paysan peons;
    public Lapin bugs;
    
    public World() {
	robin = new Archer();
	peons = new Paysan();
	bugs = new Lapin();
    }
    
    public void creerMondeAlea() {
	//
    }
}
