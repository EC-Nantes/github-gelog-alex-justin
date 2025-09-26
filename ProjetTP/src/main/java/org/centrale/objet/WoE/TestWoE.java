/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe de tests des différentes classes
 * @author jujus
 */
public class TestWoE {

    /**
     *
     */
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
        Centrale.peon.affiche();
        Centrale.bugs0.affiche();
        Centrale.bugs1.affiche();
	
	System.out.println("\nTour de jeu pour tester la fonction deplace()");
	Centrale.tourDeJeu();
	Centrale.robin.affiche();
        Centrale.peon.affiche();
        Centrale.bugs0.affiche();
        Centrale.bugs1.affiche();
	
        
        Point2D pou1 = new Point2D();
        Bulbi Bulbizart = new Bulbi(24, "Bulbizarre", 100, 40, 30, 20, 20, 5, pou1);
        Bulbizart.affiche();
    }
    
}
