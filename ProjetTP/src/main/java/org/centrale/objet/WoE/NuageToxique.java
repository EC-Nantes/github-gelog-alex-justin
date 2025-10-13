/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author jujus
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    private Point2D pos;          // position du nuage
    private int rayon;            // rayon d’effet du nuage
    private int degats;           // dégâts infligés aux créatures proches

    public NuageToxique(Point2D pos, int rayon, int degats) {
        this.pos = pos;
        this.rayon = rayon;
        this.degats = degats;
    }

    public Point2D getPos() { return pos; }
    public void setPos(Point2D pos) { this.pos = pos; }

    @Override
    public void deplace(World w) {
        Random rand = new Random();
        
        int dx = rand.nextInt(5);
        int dy = rand.nextInt(5);
        
        dx = dx - 2;
        dy = dy - 2;
        
        // on s’assure qu’il ne bouge que d’une case ou deux casesà la fois
        if (Math.abs(dx) > 3 || Math.abs(dy) > 3) {
            throw new IllegalArgumentException("Le nuage ne peut se déplacer que d'une case à la fois !");
        }
        pos.translate(dx, dy);
        System.out.println("☁️  Le nuage toxique se déplace en " + pos);
    }

    @Override
    public void combattre(Creature c) {
        // Vérifie la distance entre le nuage et la créature
        double dist = this.pos.distance(c.getPos());

        if (dist <= rayon) {
            // Effet de poison ou dégât direct
            int vie = c.getPtVie() - degats;
            if (vie < 0) vie = 0;
            c.setPtVie(vie);
            System.out.println("☠️  Le nuage toxique inflige " + degats + " dégâts !");
        } else {
            System.out.println("Hors de portée du nuage.");
        }
    }

    @Override
    public String toString() {
        return "NuageToxique en " + pos + " (rayon=" + rayon + ", dégâts=" + degats + ")";
    }
}

