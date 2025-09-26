/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Les tests des points
 * @author Alexandre
 * @version 1.1
 */
public class TestPoint2D {

    /**
     *
     */
    public TestPoint2D() {
        //
    }
    
    /**
     *
     */
    public void main() {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(5, 9);
        Point2D p3 = new Point2D(p2);
        
        System.out.print("Test de la fonction affiche() sur p1 se trouvant � l'origine: ");
        p1.affiche();
        System.out.println("\n");
        
        System.out.println("Valeur de x et y sur p2 fix�es � 5 et 9");
        System.out.println("getX() et getY() sur p2: " + p2.getX() + " " + p2.getY() + "\n");
        
        System.out.println("setX(95) et setY(-5) sur p3");
        p3.setX(95);
        p3.setY(-5);
        System.out.print("R�sultat sur p3: ");
        p3.affiche();
        System.out.println("\n");
        
        System.out.println("setPosition(-98, 23) sur p1");
        p1.setPosition(-98, 23);
        System.out.print("R�sultat sur p1: ");
        p1.affiche();
        System.out.println("\n");
        
        System.out.println("translate(10, -9) sur p2");
        p2.translate(10, -9);
        System.out.print("La position devrait �tre [15, 0]: ");
        p2.affiche();
        System.out.println("\n");
        
        System.out.println("distance entre p1 et p3:");
        float d1 = p1.distance(p3);
        float d2 = p3.distance(p1);
        System.out.println("Le r�sultat doit �tre ~195,0205");
        System.out.println("p1.distance(p3): " + d1);
        System.out.println("p3.distance(p1): " + d2);
        System.out.println("");
    }
}
