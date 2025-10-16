/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.*;

/**
 * La classe qui représente tous les "êtres" de WoE
 * 
 * @author jujus
 */
public class Creature extends ElementDeJeu implements Deplacable {
	private int ptVie;
	private int degAtt;
	private int ptPar;
	private int pageAtt;
	private int pagePar;
	private List<Utilisable> effets;
	
	/**
	 * Constructeur quasi-complet de la classe Créature
	 * @param pV Nombre de points de vie du personnage
	 * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
	 * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
	 * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
	 * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
	 * @param eff Les effets qui s'appliquent à la créature
	 * @param pos position de la Créature
	 */
	public Creature(int pV, int dA, int pPar, int paAtt, int paPar, List<Utilisable> eff, Point2D pos) {
		super(pos);
		ptVie = pV;
		degAtt = dA;
		ptPar = pPar;
		pageAtt = paAtt;
		pagePar = paPar;
		this.effets = eff;
	}

	/**
	 * Constructeur quasi-complet de la classe Créature
	 * @param pV Nombre de points de vie du personnage
	 * @param dA Nombre de dégâts que le personnage inflige en cas d'attaque réussie
	 * @param pPar Nombre de dégâts que le personnage peut parer en cas de parade réussie
	 * @param paAtt Pourcentage de chance de réussite d'une attaque (entre 0 et 100)
	 * @param paPar Pourcentage de chance de réussite d'une parade (entre 0 et 100)
	 * @param pos position de la Créature
	 */
	public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
		super(pos);
		ptVie = pV;
		degAtt = dA;
		ptPar = pPar;
		pageAtt = paAtt;
		pagePar = paPar;
		this.effets = new ArrayList<>();
	}
	
	/**
	 * Constructeur de copie de la classe créature
	 * @param c la créature copiée
	 */
	public Creature(Creature c) {
		super(c);
		this.ptVie = c.ptVie;
		this.degAtt = c.degAtt;
		this.ptPar = c.ptPar;
		this.pageAtt = c.pageAtt;
		this.pagePar = c.pagePar;
		this.effets = c.effets;
	}
	
	/**
	 * Constructeur par défaut de la classe créature
	 */
	public Creature() {
		super();
		ptVie = 100;
		degAtt = 10;
		ptPar = 10;
		pageAtt = 10;
		pagePar = 10;
		this.effets = new ArrayList<>();
	}
	
	/**
	 * Méthode de déplacement de la classe Monstre
	 * Déplacement aléatoire sur une des cases adjacente au monstre (équiprobable) sans contraintes
	 */
	public void deplaceLibre() {
		Random rand = new Random();
		
		// Pour avoir un vecteur dont les valeurs sont entre -1 et 1
		int dx = 0;
		int dy = 0;
		while (dx == 0 && dy == 0) {
			dx = rand.nextInt(3) - 1;
			dy = rand.nextInt(3) - 1;
		}
		super.getPos().translate(dx, dy);
	}
	
	/**
	 * Déplace un mob sans altercation avec un autre mob ou un élément du jeu non fusionnable
	 * @param w LE monde dans lequel on se déplace
	 */
	@Override
	public void deplace(World w) {
		Random rand = new Random();
		
		LinkedList<Point2D> temp = new LinkedList<>(); // Liste ayant toutes les positions
		LinkedList<Point2D> move = new LinkedList<>(); // Même chose mais mélangée
		int x = super.getPos().getX();
		int y = super.getPos().getY();
		
		// Lister les déplacements possibles
		// Il y en a 8
		for (int dx = -1; dx < 2; dx++) {
			for (int dy = -1; dy < 2; dy++) {
			// Exclusion du non déplacement du mob
			if (dx == 0 && dy == 0) continue;
			
			temp.add(new Point2D(dx+x, dy+y));
			}
		}
		
		// Mélange des poistions pour les avoir dans le désordre
		while (!temp.isEmpty()) {
			// Sélection d'une des positions de façon aléatoire
			int index = rand.nextInt(temp.size());
			
			Point2D position = temp.get(index);
			
			// Enregistrement dans la nouvelle structure de donnée
			move.add(position);
			
			// Enlèvement de la position dans temp pour ne pas avoir de doublont
			temp.remove(index);
		}
		
		// Test des déplacements dans le monde
		for (Point2D p : move) {
			if (w.validPos(p)) {
			super.setPos(p);
			break;
			}
		}
		
		// Il y a la possibilité que le mob ne puisse pas de déplacer,
		// Dans ce cas il ne bougera pas
	}
	
	/**
	 * Méthode affichage des informations importantes de la créature : Points de vie et position
	 */
	public void affiche() {
		System.out.print("Pt Vie :" + ptVie + "/ position :" );
		super.getPos().affiche();
		System.out.println("");
	}
	
	/**
	 * Guetteur de points vie
	 * @return le nombre de points de vie
	 */
	public int getPtVie() {
		return ptVie;
	}
	
	/** 
	 * Setter de point de vie
	 * @param pV le nouveau nombre de points de vie
	 */
	public void setPtVie(int pV) {
		ptVie = pV;
	}

	/**
	 * Guetteur de la quantité de dégâts
	 * @return le nombre de dégâts infligés
	 */
	public int getDegAtt() {
		return degAtt;
	}

	/**
	 * Getter du nombre de points de parade
	 * @return les points de parade
	 */
	public int getPtPar() {
		return ptPar;
	}

	/**
	 * le gettter du pourcentage d'attaque
	 * @return le pourcentage de réussite d'attaque
	 */
	public int getPageAtt() {
		return pageAtt;
	}

	/**
	 * le gettter du pourcentage de parade
	 * @return le pourcentage de réussite de parade
	 */
	public int getPagePar() {
		return pagePar;
	}

	/**
	 * le setter de la quantité de dégâts infligés
	 * @param degAtt la quantité de dégâts
	 */
	public void setDegAtt(int degAtt) {
		this.degAtt = degAtt;
	}

	/**
	 * le setter de la quantité de dégâts parés
	 * @param ptPar les points de parade
	 */
	public void setPtPar(int ptPar) {
		this.ptPar = ptPar;
	}

	/**
	 * le setter du pourcentage d'attaque réussie
	 * @param pageAtt le pourcentage d'attaque réussie
	 */
	public void setPageAtt(int pageAtt) {
		this.pageAtt = pageAtt;
	}

	/** 
	 * le setteur du pourcentage de parade réussie
	 * @param pagePar le pourcentage de parade réussie
	 */
	public void setPagePar(int pagePar) {
		this.pagePar = pagePar;
	}

	/**
	 * Getteur des effets qui s'appliquent au personnage
	 * @return les effets
	 */
	public List<Utilisable> getEffets() {
		return effets;
	}

	/**
	 * Setteur des effets qui s'appliquent au personnage
	 * @param effets les nouveaux effets
	 */
	public void setEffets(List<Utilisable> effets) {
		this.effets = effets;
	}
	
	/**
	 * Méthode pour mettre à jour les effets sur la créature
	 */
	 public void majEffets() {
		for (int i = 0; i < effets.size(); i++) {
			Utilisable effet = effets.get(i);

			if (effet instanceof Nourriture n) {
				n.decrementerDuree(this);

				if (n.getDureeEffet() <= 0) {
					effets.remove(i);
					i--; // important car on retire pendant la boucle
				}
			} else if (effet instanceof Epee e) {
				e.decrementerDurabilite((Guerrier)this);

				if (e.getPtDurabilite() <= 0) {
					effets.remove(i);
					i--;
				}
			}
		}
	}
	 
	/**
	 * Méthode pourn utiliser un objet correctement
	 * @param objet l'objet utilisé
	 */
	public void UtiliserObjet(Utilisable objet) {
		objet.utilisation(this); // applique l’effet

		// Si c’est une Nourriture ou une Epee, on garde l’effet dans la liste
		if (objet instanceof Nourriture || objet instanceof Epee) {
			effets.add(objet);
		}
	}
	
	/**
	* Affiche les effets actuellement actifs sur la créature.
	*/
	public void afficherEffets() {
		if (!(this instanceof Personnage)){
		} else {
			if (effets == null || effets.isEmpty()) {
				System.out.println(((Personnage)this).getNom() + " n’a actuellement aucun effet actif.");
				return;
			}

			System.out.println("Effets actifs sur " + ((Personnage)this).getNom() + " :");
			
			for (int i = 0; i < effets.size(); i++) {
				Utilisable effet = effets.get(i);

				if (effet instanceof Nourriture n) {
					System.out.print("- Effet de " + ((Nourriture)effet).getNom());
					System.out.print("\u001B[33m"+ "| Statistique affectée : " + ((Nourriture)effet).getStatCible() +"\u001B[0m");
					System.out.print("\u001B[31m"+" | Intensité : " + ((Nourriture)effet).getIntensite()+"\u001B[0m");
					System.out.println("\u001B[34m"+" | Durée Restante : " + ((Nourriture)effet).getDureeEffet()+" tours"+"\u001B[0m");
				} else if (effet instanceof Epee e) {
					System.out.print("- Effet de " + ((Epee)effet).getNom());
					System.out.print("\u001B[31m"+" | Puissance : " + ((Epee)effet).getPtAttaque()+"\u001B[0m");
					System.out.println("\u001B[34m"+" | Durabilité : " + ((Epee)effet).getPtDurabilite()+"\u001B[0m");
				} 
			}
		}
	}
}
