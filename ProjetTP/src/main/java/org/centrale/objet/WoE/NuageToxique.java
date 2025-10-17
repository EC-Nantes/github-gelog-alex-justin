/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Classe des nuages toxiques, des nuages dangereux qui se déplacent et blessent les créatures qui respirent son air
 * @author jujus
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
	private int rayon;            // rayon d’effet du nuage
	private int degats;           // dégâts infligés aux créatures proches
	
	/**
	 * Constructeur d'un nuage toxique
	 * @param pos
	 * @param rayon
	 * @param degats
	 */
	public NuageToxique(Point2D pos, int rayon, int degats) {
		super();
                super.setNom("Nuage Toxique");
                super.setPos(pos);
		this.rayon = rayon;
		this.degats = degats;
	}
	
	/**
	 * Constructeur d'un nuage toxique
	 */
	public NuageToxique(){
		super();
                super.setNom("Nuage Toxique");;
		this.rayon = 1;
		this.degats = 5;
	}
	
	/**
	 * Constructeur de copie d'un nuage toxique
	 * @param nuto
	 */
	public NuageToxique(NuageToxique nuto){
		super(nuto);
		this.rayon = nuto.rayon;
		this.degats = nuto.degats;
	}

	/**
	 * Déplacement libre d'un nuage toxique
	 * Il peut passer sur des créatures, des objets ou à travers d'autres éléments
	 * @param w Le monde dans lequel il se déplace
	 */
	@Override
	public void deplace(World w) {
		Random rand = new Random();
		
		Point2D pos = super.getPos();
		int x = pos.getX();
		int y = pos.getY();
		int dx;
		int dy;
		int max_x = w.getWorld_max_x();
		int max_y = w.getWorld_max_y();

		
		do {
			dx = rand.nextInt(5) - 2;
			dy = rand.nextInt(5) - 2;
		} while ((x+dx)<0 || (y+dy)<0 || (x+dx)>= max_x || (y+dy)>= max_y);

		// on s’assure qu’il ne bouge que d’une case ou deux casesà la fois
		if (Math.abs(dx) > 3 || Math.abs(dy) > 3) {
			throw new IllegalArgumentException("Le nuage ne peut se déplacer que d'une case à la fois !");
		}
		super.getPos().translate(dx, dy);
		System.out.println("☁️  Le nuage toxique se déplace en " + super.getPos());
	}

	/**
	 * Mise en place des dégats sur les créatures dans le rayon d'action
	 * @param c La créature à infliger les dégats (si elle est dans le rayon d'action)
	 */
	@Override
	public void combattre(Creature c) {
		// Vérifie la distance entre le nuage et la créature
		double dist = super.getPos().distance(c.getPos());

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

	/**
	 * Fonction override
	 * @return Les informations du nuage
	 */
	@Override
	public String toString() {
		return "NuageToxique en " + super.getPos() + " (rayon=" + rayon + ", dégâts=" + degats + ")";
	}

	/**
	 * Getter du rayon
	 * @return Le rayon
	 */
	public int getRayon() {
		return rayon;
	}

	/**
	 * Setter du rayon
	 * @param rayon Le rayon
	 */
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	/**
	 * Getter des dégats
	 * @return Les dégats positifs ou négatifs
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Setter des dégats
	 * @param degats Les dégats positifs ou négatifs
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}

	
}

