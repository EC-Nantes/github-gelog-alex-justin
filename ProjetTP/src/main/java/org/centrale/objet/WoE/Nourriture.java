/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant la nourriture, pouvant servir de Bonus oou de Malus en fonction de ce que l'on consomme
 * @author jujus
 */
public class Nourriture extends Objet implements Utilisable {
	private String statCible; //La stat qui va êytre modifiée par la nourriture
	private int intensite; //Quantifie le changement de stat (Négatif si c'est un malus)
	private int dureeEffet; //Nombre de tours que va durer l'effet

	/**
	 * Constructeur complet de la classe nourriture
	 * @param statCible la stat qui doit être modifiée
	 * @param intensite l'intensité de l'effet (Négatif si c'est un malus)
	 * @param dureeEffet la durée de l'effet en TOURS DE JEU
	 * @param nom le nom de la nourriture
	 * @param pos la position de l'objet
	 */
	public Nourriture(String nom, int intensite, int dureeEffet, String statCible, Point2D pos) {
		super(nom, pos);
		this.statCible = statCible;
		this.intensite = intensite;
		this.dureeEffet = dureeEffet;
	}

	/**
	 * Constructeur partiel de la nourriture
	 * @param nom le nom de la nourriture
	 * @param statCible stat ciblée par les effets
	 * @param intensite intensité des effets
	 * @param dureeEffet durée des effets en tours
	 */
	public Nourriture(String nom, int intensite, int dureeEffet, String statCible) {
		super(nom);
		this.statCible = statCible;
		this.intensite = intensite;
		this.dureeEffet = dureeEffet;
	}
	
	/**
	 * Constructeur de transformation d'un objet en Nourriture
	 * @param statCible la stat ciblée par les effets
	 * @param intensite l'intensité des effets
	 * @param dureeEffet la durée des effets en tours
	 * @param o l'objet transformé
	 */
	public Nourriture(String statCible, int intensite, int dureeEffet, Objet o) {
		super(o);
		this.statCible = statCible;
		this.intensite = intensite;
		this.dureeEffet = dureeEffet;
	}
	
	/**
	 * Constructeur par défaut de Nourriture
	 */
	public Nourriture(){
		super();
		this.statCible = "degAtt";
		this.intensite = 2;
		this.dureeEffet = 3;
		super.setNom("feuille d'épinard");
	}
	
	/**
	 * Constructeur de copie de Nourriture
	 * @param no la nourriture copiée
	 */
	public Nourriture(Nourriture no){
		super(no);
		this.statCible = no.statCible;
		this.intensite = no.intensite;
		this.dureeEffet = no.dureeEffet;
	}

	/**
	 * Guetteur de la stat cible
	 * @return la stat cible
	 */
	public String getStatCible() {
		return statCible;
	}

	/**
	 * Setteur de la stat cible
	 * @param statCible la nouvelle stat ciblée par les effets
	 */
	public void setStatCible(String statCible) {
		this.statCible = statCible;
	}

	/**
	 * Guetteur d'intensité
	 * @return l'intensité des effets
	 */
	public int getIntensite() {
		return intensite;
	}

	/**
	 * Le setteur d'intensité
	 * @param intensite la nouvelle intensité des effets désirée
	 */
	public void setIntensite(int intensite) {
		this.intensite = intensite;
	}

	/**
	 * Le guetteur de la durée des effets
	 * @return la durée des effets en tours
	 */
	public int getDureeEffet() {
		return dureeEffet;
	}

	/**
	 * Setteur de la durée des effets
	 * @param dureeEffet le nombre de tours que doit durer l'effet
	 */
	public void setDureeEffet(int dureeEffet) {
		this.dureeEffet = dureeEffet;
	}
	
	/**
	 * méthode d'utilisation de la nourritre
	 * @param cible la créature qui bénéficie des effets
	 */
	@Override
	public void utilisation(Creature cible){
		if (dureeEffet < 1){
			System.out.println("L'objet ne peut plus être utilisé");
		} else {
			switch (statCible) {
				case "pv":
					cible.setPtVie(cible.getPtVie() + intensite);
					System.out.println("+ " + intensite + " PV pendant " + dureeEffet + " tours !");
					break;

				case "degAtt":
					cible.setDegAtt(cible.getDegAtt() + intensite);
					System.out.println("+ " + intensite + " dégâts pendant " + dureeEffet + " tours !");
					break;

				case "ptPar":
					cible.setPtPar(cible.getPtPar() + intensite);
					System.out.println("+ " + intensite + " parade pendant " + dureeEffet + " tours !");
					break;

				case "pageAtt":
					cible.setPageAtt(cible.getPageAtt() + intensite);
					System.out.println("+ " + intensite + "% de réussite en attaque pendant " + dureeEffet + " tours !");
					break;

				case "pagePar":
					cible.setPagePar(cible.getPagePar() + intensite);
					System.out.println("+ " + intensite + "% de réussite en parade pendant " + dureeEffet + " tours !");
					break;

				default:
					System.out.println("Stat cible inconnue : " + statCible);
			}
		}
	}
	
	/**
	 * Méthode pour décrémenter la durée d'un effet d'une créature cible
	 * @param cible la créature cible
	 */
	public void decrementerDuree(Creature cible) {
		dureeEffet--;
		if (dureeEffet <= 0) {
			System.out.println("L'effet de la nourriture " + getNom() + " s'est dissipé !");
			// On retire le bonus appliqué au départ
			switch (statCible) {
				case "pv": cible.setPtVie(cible.getPtVie() - intensite); break;
				case "degAtt": cible.setDegAtt(cible.getDegAtt() - intensite); break;
				case "ptPar": cible.setPtPar(cible.getPtPar() - intensite); break;
				case "pageAtt": cible.setPageAtt(cible.getPageAtt() - intensite); break;
				case "pagePar": cible.setPagePar(cible.getPagePar() - intensite); break;
			}
		}
	}
}
