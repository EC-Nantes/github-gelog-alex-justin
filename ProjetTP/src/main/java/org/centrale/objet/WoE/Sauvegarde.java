/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;

/**
 *
 * @author Catherine
 */
public class Sauvegarde {
    private final String delimiteurs = " ,;";
    private LinkedList<Creature> list_creature;
    private LinkedList<Objet> list_objet;
    private LinkedList<Objet> list_objet_inventaire;
    private int largeur;
    private int longueur;
    
    /**
     * Constructeur pour avoir créer et charger une sauvegarde
     */
    public Sauvegarde() {
	list_creature = new LinkedList<>();
	list_objet = new LinkedList<>();
	list_objet_inventaire = new LinkedList<>();
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
	try {
	    String line;
	    BufferedReader file = new BufferedReader(new FileReader(filename));
	    
	    // Initialisation des variables
	    largeur = -1;
	    longueur = -1;
	    list_creature.clear();
	    list_objet.clear();
	    
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
	    w = new World(largeur, longueur);
	    w.list_creature = new LinkedList(list_creature);
	    w.list_objet = new LinkedList(list_objet);
	    
	    // Destruction des objets
	    list_creature.clear();
	    list_objet.clear();
	    
	} catch(Exception e) {
	    e.printStackTrace();
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
	return false;
    }
    
    
    /**
     * Ajout d'un élément de jeu dans la structure de donnée
     * @param cmd 
     */
    public void ajoutElementDeJeu(String cmd) {
	StringTokenizer tokenizer = new StringTokenizer(cmd, delimiteurs);
	if (tokenizer.countTokens() > 1) {
	    String element = tokenizer.nextToken();
	    
	    String name = "";
	    String temp = "";
	    int[] args = new int[9];
	    Point2D pos;
	    boolean inventaire = false;
		    
	    try {
		if (element.equals("Inventaire")) {
		    element = tokenizer.nextToken();
		    inventaire = false;
		}
		switch (element) {
		    case "Largeur":
			if (tokenizer.countTokens() != 1) break;
			largeur = Integer.parseInt(tokenizer.nextToken());
			break;
			
		    case "Longueur":
			if (tokenizer.countTokens() != 1) break;
			longueur = Integer.parseInt(tokenizer.nextToken());
			break;
			
		    case "Guerrier":
			if (tokenizer.countTokens() != 9) break;
			name = tokenizer.nextToken();
			for (int  i = 0; i < 8; i++) {
			    args[i] = Integer.parseInt(tokenizer.nextToken());
			}

			pos = new Point2D(args[6], args[7]);
			Guerrier g = new Guerrier(name, args[0], args[1], args[2], args[3], args[4], args[5], pos);
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
			if (tokenizer.countTokens() != 4) break;
			name = tokenizer.nextToken();
			args[0] = Integer.parseInt(tokenizer.nextToken());
			pos = new Point2D(args[2], args[3]);
                        
			if (inventaire) {
			    for (int  i = 1; i < 3; i++) {
				args[i] = Integer.parseInt(tokenizer.nextToken());
			    }
			}
			
			PotionSoin po;
			if (!inventaire) {
			    po = new PotionSoin(name, args[1], pos);
			    list_objet.add(po);
			} else {
			    po = new PotionSoin(name, args[1]);
			    list_objet_inventaire.add(po);
			}
			
			
			break;

		    case "Epee":
			if (tokenizer.countTokens() != 5) break;
			name = tokenizer.nextToken();
			for (int  i = 0; i < 2; i++) {
			    args[i] = Integer.parseInt(tokenizer.nextToken());
			}
                        pos = new Point2D(args[3], args[4]);
			
			if (inventaire) {
			    for (int  i = 2; i < 4; i++) {
				args[i] = Integer.parseInt(tokenizer.nextToken());
			    }
			}

			Epee sw;
			if (!inventaire) {
			    sw = new Epee(name, args[1], args[2], pos);
			    list_objet.add(sw);
			} else {
			    sw = new Epee(name, args[1], args[2]);
			    list_objet_inventaire.add(sw);
			}
			
			
			break;
		
		    case "Nourriture":
			if (tokenizer.countTokens() != 6) break;
			name = tokenizer.nextToken();
			temp = tokenizer.nextToken();
			
			for (int  i = 0; i < 2; i++) {
			    args[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			if (inventaire) {
			    for (int  i = 2; i < 4; i++) {
				args[i] = Integer.parseInt(tokenizer.nextToken());
			    }
			    pos = new Point2D(args[3], args[4]);
			}

			Nourriture n;
			if (!inventaire) {
			    n = new Nourriture(name, temp, args[1], args[2], pos);
			    list_objet.add(n);
			} else {
			    n = new Nourriture(name, temp, args[1], args[2]);
			    list_objet_inventaire.add(n);
			}
			
			list_objet.add(n);
			break;

		    case "NuageToxique":
			if (tokenizer.countTokens() != 4) break;
			for (int  i = 0; i < 4; i++) {
			    args[i] = Integer.parseInt(tokenizer.nextToken());
			}

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
    
}
