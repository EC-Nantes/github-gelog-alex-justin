/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Classe permettant de gérer les sauvegardes de joueurs
 * @author Catherine
 */
public class Sauvegarde {
	private final String delimiteurs = " ,;";
	private ArrayList<Creature> list_creature;
	private ArrayList<Objet> list_objet;
	private ArrayList<Objet> list_objet_inventaire;
	private String nom_joueur;
	private Personnage perso_joueur;
	private int largeur;
	private int longueur;
	
	/**
	 * Constructeur pour avoir créer et charger une sauvegarde
	 */
	public Sauvegarde() {
		list_creature = new ArrayList<>();
		list_objet = new ArrayList<>();
		list_objet_inventaire = new ArrayList<>();
	}
	
	/**
	 * Chargement d'un monde
	 * Toutes les données du monde et du joueur seront écrasées
	 * @param filename Nom du fichier
	 * @param w Le monde à charger
	 * @param j Le personnage à charger
	 * @return Vrai si le chargement s'est bien effectué
	 */
	public boolean loadWorld(String filename, World w, Joueur j) {
		BufferedReader file = null;
		try {
			String line;
			file = new BufferedReader(new FileReader(filename));
			
			// Initialisation des variables
			largeur = -1;
			longueur = -1;
			list_creature.clear();
			list_objet.clear();
			list_objet_inventaire.clear();
			nom_joueur = "Joueur";
			
			// Constitution du jeu
			line = file.readLine();
			while (line != null) {
			ajoutElementDeJeu(line);
			line = file.readLine();
			
			}
			file.close();
			
			if (largeur == -1 || longueur == -1) {
			return false;
			}
					
			// Copie des éléments du monde
			j.setInventaire(new ArrayList(list_objet_inventaire));
			j.setPerso(perso_joueur);
			j.setNomJoueur(nom_joueur);
			
			
			w.setWorld_max_x(largeur);
			w.setWorld_max_y(longueur);
			w.setList_creature(new ArrayList(list_creature));
			w.setList_objet(new ArrayList(list_objet));
			w.setJ(j);
			
			
			// Destruction des objets
			list_creature.clear();
			list_objet.clear();
			list_objet_inventaire.clear();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la lecture de la sauvegarde");
		}
		
		return true;
	}
	
	/**
	 * Chargement d'un monde
	 * @param filename Nom du fichier
	 * @param w Le monde a enregistrer
	 * @param j Le personnage a enregistrer
	 * @return Vrai si l'enregistrement s'est bien effectué
	 */
	public boolean saveWorld(String filename, World w, Joueur j) {
		list_creature = new ArrayList(w.getList_creature());
		list_objet = new ArrayList(w.getList_objet());
		list_objet_inventaire = new ArrayList(j.getInventaire());
		
		BufferedWriter file = null;
		
		try {
			file = new BufferedWriter(new FileWriter(filename));
			
			file.write("Largeur " + w.getWorld_max_x() + "\n");
			file.write("Longueur " + w.getWorld_max_y() + "\n");
			
			for (Creature c : list_creature) writeCreature(file, c);
			file.newLine();
			for (Objet o : list_objet) writeObjet(file, o);
			file.newLine();
			for (Objet o : list_objet_inventaire) writeInventaire(file, o);
			file.newLine();
			
			String line = "Joueur ";
			line += j.getNomJoueur();
			line += " ";
			file.write(line);
			writeCreature(file, j.getPerso());
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
			if (file != null) {
				file.flush();
				file.close();
			}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		return true;
	}
	
	
	/**
	 * Ajout d'un élément de jeu dans la structure de donnée
	 * @param cmd
	 */
	private void ajoutElementDeJeu(String cmd) {
		StringTokenizer tokenizer = new StringTokenizer(cmd, delimiteurs);
		if (tokenizer.countTokens() > 1) {
			String element = tokenizer.nextToken();
			
			String name;
			String temp;
			int[] args = new int[10];
			Point2D pos;
			boolean inventaire = false;
				
			try {
			if (element.equals("Inventaire")) {
				element = tokenizer.nextToken();
				inventaire = true;
			}
			
			switch (element) {
				case "Joueur":
					temp = tokenizer.nextToken();
					name = tokenizer.nextToken();
					nom_joueur = name;
					
					if (temp.equals("Guerrier") && tokenizer.countTokens() == 10) {
						for (int  i = 0; i < 10; i++) {
							args[i] = Integer.parseInt(tokenizer.nextToken());
						}

						pos = new Point2D(args[8], args[9]);
						Guerrier g = new Guerrier(name, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], pos);
						perso_joueur = (Personnage)g;
					} else if (temp.equals("Archer") && tokenizer.countTokens() == 9) {
						for (int  i = 0; i < 9; i++) {
							args[i] = Integer.parseInt(tokenizer.nextToken());
						}

						pos = new Point2D(args[6], args[7]);
						Archer a = new Archer(name, args[0], args[1], args[2], args[3], args[4], args[5], pos, args[8]);
						perso_joueur = (Personnage)a;
					}
					
					break;
				case "Largeur":
					if (tokenizer.countTokens() != 1) break;
					largeur = Integer.parseInt(tokenizer.nextToken());
					break;
				
				case "Longueur":
					if (tokenizer.countTokens() != 1) break;
					longueur = Integer.parseInt(tokenizer.nextToken());
					break;
				
				case "Guerrier":
					if (tokenizer.countTokens() != 11) break;
					name = tokenizer.nextToken();
					for (int  i = 0; i < 10; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[8], args[9]);
					Guerrier g = new Guerrier(name, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], pos);
					list_creature.add(g);
					break;
				
				case "Archer":
					if (tokenizer.countTokens() != 10) break;
					name = tokenizer.nextToken();
					for (int  i = 0; i < 9; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[6], args[7]);
					Archer a = new Archer(name, args[0], args[1], args[2], args[3], args[4], args[5], pos, args[8]);
					list_creature.add(a);
					break;
		
				case "Paysan":
					if (tokenizer.countTokens() != 9) break;
					name = tokenizer.nextToken();
					for (int  i = 0; i < 8; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}
			
					pos = new Point2D(args[6], args[7]);
					Paysan p = new Paysan(name, args[0], args[1], args[2], args[3], args[4], args[5], pos);
					list_creature.add(p);
					break;
		
				case "Loup":
					if (tokenizer.countTokens() != 7) break;
					for (int  i = 0; i < 7; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[5], args[6]);
					Loup lo = new Loup(args[0], args[1], args[2], args[3], args[4], pos);
					list_creature.add(lo);
					break;
		
				case "Lapin":
					if (tokenizer.countTokens() != 7) break;
					for (int  i = 0; i < 7; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[5], args[6]);
					Lapin la = new Lapin(args[0], args[1], args[2], args[3], args[4], pos);
					list_creature.add(la);
					break;

				case "Bulbi":
					if (tokenizer.countTokens() != 8) break;
					for (int  i = 0; i < 8; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[7], args[8]);
					Bulbi b = new Bulbi(args[0], args[1], args[2], args[3], args[4], args[5], pos);
					list_creature.add(b);
					break;

				case "PotionSoin":
					if (tokenizer.countTokens() != 4 && !inventaire) break;
					if (tokenizer.countTokens() != 2 && inventaire) break;
					name = tokenizer.nextToken();
					args[0] = Integer.parseInt(tokenizer.nextToken());
					
					PotionSoin po;
					if (!inventaire) {
						for (int  i = 1; i < 3; i++) {
							args[i] = Integer.parseInt(tokenizer.nextToken());
						}
									
						pos = new Point2D(args[1], args[2]);
						po = new PotionSoin(name, args[0], pos);
						list_objet.add(po);
					} else {
						po = new PotionSoin(name, args[0]);
						list_objet_inventaire.add(po);
					}
					
					
					break;

				case "Epee":
					if (tokenizer.countTokens() != 5 && !inventaire) break;
					if (tokenizer.countTokens() != 3 && inventaire) break;
					name = tokenizer.nextToken();
					for (int  i = 0; i < 2; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					Epee sw;
					if (!inventaire) {
									for (int  i = 2; i < 4; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
						}
									pos = new Point2D(args[2], args[3]);
						sw = new Epee(name, args[0], args[1], pos);
						list_objet.add(sw);
					} else {
						sw = new Epee(name, args[0], args[1]);
						list_objet_inventaire.add(sw);
					}
					
					break;
			
				case "Nourriture":
					if (tokenizer.countTokens() != 6 && !inventaire) break;
					if (tokenizer.countTokens() != 4 && inventaire) break;
					name = tokenizer.nextToken();
					temp = tokenizer.nextToken();
					
					for (int  i = 0; i < 2; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					Nourriture n;
					if (!inventaire) {
									for (int  i = 2; i < 4; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
						}
						pos = new Point2D(args[2], args[3]);
						n = new Nourriture(name, args[0], args[1], temp, pos);
						list_objet.add(n);
					} else {
						n = new Nourriture(name, args[0], args[1], temp);
						list_objet_inventaire.add(n);
					}
					
					list_objet.add(n);
					break;

				case "NuageToxique":
					if (tokenizer.countTokens() != 4) break;
					for (int  i = 0; i < 4; i++) {
						args[i] = Integer.parseInt(tokenizer.nextToken());
					}

					pos = new Point2D(args[3], args[4]);
					NuageToxique nt = new NuageToxique(pos, args[0], args[1]);
					list_objet.add(nt);
					break;
				
				default:
				break;

			}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void writeCreature(BufferedWriter f, Creature c) throws IOException {
		String classe = c.getClass().getSimpleName();
		String line = c.getPtVie() + " ";
		line += c.getDegAtt() + " ";
		line += c.getPtPar() + " ";
		line += c.getPageAtt()+ " ";
		line += c.getPagePar() + " ";

		boolean write_line = true;
		
		
		switch (classe) {
			case "Archer":
				line += ((Archer)c).getNbFleches() + " ";
				line = ((Personnage)c).getNom() + " " + line;
				break;
			case "Guerrier":
				Epee e = ((Guerrier)c).getArme();
				line += e.getPtAttaque() + " " + e.getPtDurabilite() + " ";
				line = ((Personnage)c).getNom() + " " + line;
				break;
			case "Bulbi":
				line += ((Bulbi)c).getPP();
				break;
			case "Paysan":
				line = ((Personnage)c).getNom() + " " + line;
				break;
			default:
				write_line = false;
				break;
		}
		
		
		Point2D p = c.getPos();
		line += p.getX() + " " + p.getY() + "\n";
		line = classe + " " + line;
		
		if (write_line) f.write(line);
	}
	
	private void writeObjet(BufferedWriter f, Objet o) throws IOException {
		String classe = o.getClass().getSimpleName();
		String line = classe + " ";

		Point2D pos = o.getPos();
		boolean write_line = true;

		switch (classe) {
			case "Epee":
				line +=  o.getNom() + " ";
				line += ((Epee)o).getPtAttaque() + " ";
				line += ((Epee)o).getPtDurabilite() + " ";
				line += pos.getX() + " " + pos.getY() + "\n";
				break;
			case "PotionSoin":
				line +=  o.getNom() + " ";
				line += ((PotionSoin)o).getPtRegen() + " ";
				line += pos.getX() + " " + pos.getY() + "\n";
				break;
			case "NuageToxique":
				line += pos.getX() + " " + pos.getY() + " ";
				line += ((NuageToxique)o).getRayon() + " ";
				line += ((NuageToxique)o).getDegats() + "\n";
				break;
			case "Nourriture":
				line += ((Nourriture)o).getNom() + " ";
				line += ((Nourriture)o).getIntensite() + " ";
				line += ((Nourriture)o).getDureeEffet() + " ";
				line += ((Nourriture)o).getStatCible() + " ";
				line += pos.getX() + " " + pos.getY() + "\n";
				break;
			default:
				write_line = false;
				break;
		}

		if (write_line) f.write(line);
	}
	
	private void writeInventaire(BufferedWriter f, Objet o) throws IOException {
		String classe = o.getClass().getSimpleName();
		String line = "Inventaire " + classe + " ";

		boolean write_line = true;

		switch (classe) {
			case "Epee":
				line +=  o.getNom() + " ";
				line += ((Epee)o).getPtAttaque() + " ";
				line += ((Epee)o).getPtDurabilite() + "\n";
				break;
			case "PotionSoin":
				line +=  o.getNom() + " ";
				line += ((PotionSoin)o).getPtRegen() + "\n";
				break;
			case "Nourriture":
				line += ((Nourriture)o).getNom() + " ";
				line += ((Nourriture)o).getIntensite() + " ";
				line += ((Nourriture)o).getDureeEffet() + " ";
				line += ((Nourriture)o).getStatCible() + "\n";
				break;
			default:
				write_line = false;
				break;
		}

		if (write_line) f.write(line);
	}
}
