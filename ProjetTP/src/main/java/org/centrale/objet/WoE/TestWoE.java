/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author jujus
 */
public class TestWoE {
    public static void main(){
        Lapin Alexandre = new Lapin();
        Point2D p = new Point2D();
        Paysan Justin = new Paysan("Justin", 101, 50, 50, 50, 50, 50, p);
        Justin.affiche();
        Alexandre.affiche();
        for (int i=0 ; i<3; i++){    
            Justin.deplace();
            Alexandre.deplace();
        }
        Justin.affiche();
        Alexandre.affiche();
        
        World Centrale = new World();
        Centrale.creerMondeAlea();
        Centrale.robin.affiche();
        Centrale.peons.affiche();
        Centrale.bugs0.affiche();
        Centrale.bugs1.affiche();
    }
    
}
