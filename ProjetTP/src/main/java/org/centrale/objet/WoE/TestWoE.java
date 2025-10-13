/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Classe de tests des différentes classes
 * @author jujus
 */
public class TestWoE {

    /**
     * le vrai main
     */
    public void main(){
        Lapin Alexandre = new Lapin();
        Point2D p = new Point2D();
        Paysan Justin = new Paysan("Justin", 101, 50, 50, 50, 50, 50, p);
        Justin.affiche();
        Alexandre.affiche();
        for (int i=0 ; i<3; i++){    
            Justin.deplaceLibre();
            Alexandre.deplaceLibre();
        }
        Justin.affiche();
        Alexandre.affiche();
        
	System.out.println("\nCréation du monde");
        World Centrale = new World();
        Centrale.creerMondeAlea(100);
	
	Centrale.afficheWorld();
	
	System.out.println();
	Centrale.tourDeJeu();
	Centrale.afficheWorld();
        
	
	/*System.out.println("");
        System.out.println("\nPositions intitiales");
        Centrale.robin.affiche();
        Centrale.peon.affiche();
        Centrale.bugs0.affiche();
        Centrale.bugs1.affiche();
	
	System.out.println("\nTour de jeu pour tester la fonction deplace()");
	Centrale.tourDeJeu();
	Centrale.robin.affiche();
        Centrale.peon.affiche();
        Centrale.bugs0.affiche();
        Centrale.bugs1.affiche();*/
	
        
	
	// Test des foncitons de combat
	//testCombat();
	
	// Test des fonctions de soin
	//testSoin();
	
	// Test de la vitesse des conteneurs
        //testConteneur(100);
	//testConteneur(1000);
	//testConteneur(10000);
	//testConteneur(100000);
	//testConteneur(1000000);
        
        
    }
    
    
    /**
     * Test des fonctions de combat
     */
    public void testCombat() {
	System.out.println("\nTest des fonctions de combat avec les créatures suivantes:");
	Archer Cupidon = new Archer(10, "Cupidon", 50, 20, 10, 50, 50, 10, new Point2D(0, 0));
	Guerrier Lancelot = new Guerrier("Lancelot", 70, 30, 20, 75, 50, 0, new Point2D(1, 1));
	Paysan Jean = new Paysan("Pierre", 200, 0, 30, 0, 60, 0, new Point2D(11, 1));
	Loup Amarok = new Loup(120, 100, 50, 80, 80, new Point2D(11, 2));
	Lapin PierreLapin = new Lapin(3, 0, 0, 0, 0, new Point2D (2, 2));
	
	Cupidon.affiche();
	Lancelot.affiche();
	Jean.affiche(); // Nom random
	Amarok.affiche(); // Loup de la mythologie
	PierreLapin.affiche();
	
	System.out.println("A noter: les affichages dans la console sont uniquement dans le but d'expliciter le processus et seront enlevés par la ensuite");
	
	System.out.println("\nPour les deux prochains essais, la cible est respectivement trop proche et trop loin");
	Cupidon.combattre(Lancelot);
	Cupidon.combattre(Jean);
	System.out.println("Le nombre de flèches devrait rester le même (10): " + Cupidon.getNbFleches());
	
	System.out.println("\nCupidon va maintenant essayer d'abattre Pierre Lapin qui est à sa portée, il n'aura que 10 essais (son nombre de flèches).");
	for (int i = 0; i < 10; i++) {
	    Cupidon.combattre(PierreLapin);
	    if (PierreLapin.getPtVie() == 0) {
		System.out.println("Pierre Lapin est mort. On pourra en faire un ragout.");
		break;
	    }
	}
	System.out.println("Il reste " + Cupidon.getNbFleches() + " flèches à Cupidon.");
	if (PierreLapin.getPtVie() != 0) {
	    System.out.println("Pierre Lapin est vivant.");
	    System.out.println("Il peu encore vivre un peu.");
	}
	
	System.out.println("\nLancelot est dérangé par le comportement de Cupidon.");
	System.out.println("Comme il est à coté, Lancelot va le tuer.");
	while (Cupidon.getPtVie() != 0) {
	    Lancelot.combattre(Cupidon);
	    System.out.println("Il reste " + Cupidon.getPtVie() + " point de vie à Cupidon");
	}
	
	System.out.println("\nMaintenant que Lancelot est apaisé, nous allons passer à l'histoire de Jean.");
	System.out.println("Jean est un petit paysan tranquille mais relativement robuste (200 PV).");
	System.out.println("Grace à cette robustesse, il va en forêt pour cueillir des fleurs.");
	System.out.println("Amarok n'attaque que 3 fois avant de repartir au fond de la forêt.");
	for (int i = 0; i < 3; i++) {
	    Amarok.combattre(Jean);
	}
	if (Jean.getPtVie() == 0) {
	    System.out.println("Malheuresement, cette fois Amaroq le grand loup a eu raison de Jean.");
	} else {
	    System.out.println("Jean s'en est sortie de peu. Il lui reste " + Jean.getPtVie() + " points de vie.");
	}
    }
    
    
    /**
     * Test des fonctions de soin
     */
    public void testSoin() {
	Personnage Perso_Blessé = new Personnage();
        Archer Archer_Blessé = new Archer();
        Paysan Paysan_Blessé = new Paysan();
        Guerrier Guerrier_Blessé = new Guerrier();
        
	Perso_Blessé.setNom("Personnage blessé");
        Archer_Blessé.setNom("Archer blessé");
	Paysan_Blessé.setNom("Paysan blessé");
        Guerrier_Blessé.setNom("Guerrier blessé");
        
        System.out.println("");
        System.out.println("Essayons nos potions de soin sur les personnages suivants :");
	
        Perso_Blessé.affiche();
        Archer_Blessé.affiche();
	Paysan_Blessé.affiche();
        Guerrier_Blessé.affiche();
        
        PotionSoin PotionPerso = new PotionSoin();
        PotionSoin PotionArcher = new PotionSoin();
        PotionSoin PotionPaysan = new PotionSoin();
        PotionSoin PotionGuerrier = new PotionSoin();
        
        PotionPerso.utilisation(Perso_Blessé);
        PotionArcher.utilisation(Archer_Blessé);
        PotionPaysan.utilisation(Paysan_Blessé);
        PotionGuerrier.utilisation(Guerrier_Blessé);
        
        System.out.println("Les personnages suivants sont censés avoir gagné 10pV :");
        
        Perso_Blessé.affiche();
        Archer_Blessé.affiche();
	Paysan_Blessé.affiche();
        Guerrier_Blessé.affiche();
    }
    
    /**
     * Test de vitesse des différents conteneurs
     * @param n Le nombre d'instance à construire
     */
    public void testConteneur(int n) {
	System.out.println("Création des instances");
	LinkedList<Personnage> maLinkedListePerso = new LinkedList<>();
	ArrayList<Personnage> maArrayListePerso = new ArrayList<>();
	
	System.out.print("Création des données pour " + n + " perso: ");
	for (int i = 0; i < n; i++) {
	    Personnage p = new Personnage();
	    maLinkedListePerso.add(p);
	    maArrayListePerso.add(p);
	}
	System.out.println("DONE");
	
	
	System.out.println("Boucle basé sur la taille");
	
	// LinkedList
	long a = System.nanoTime();
	long b = 0;
	for (int i = 0; i < maLinkedListePerso.size(); i++) {
	    b += maLinkedListePerso.get(i).getPtVie();
	}
	a = System.nanoTime() - a;
	System.out.println("\ttemps pour LinkedList: " + a + ", somme PV: " + b);
	
	// ArrayList
	a = System.nanoTime();
	b = 0;
	for (int i = 0; i < maArrayListePerso.size(); i++) {
	    b += maArrayListePerso.get(i).getPtVie();
	}
	a = System.nanoTime() - a;
	System.out.println("\ttemps pour ArrayList:  " + a + ", somme PV: " + b);
	
	
	System.out.println("Boucle basé sur les itérateurs");
	
	// LinkedList
	a = System.nanoTime();
	b = 0;
	for (Personnage p : maLinkedListePerso) {
	    b += p.getPtVie();
	}
	a = System.nanoTime() - a;
	System.out.println("\ttemps pour LinkedList: " + a + ", somme PV: " + b);
	
	// ArrayList
	a = System.nanoTime();
	b = 0;
	for (Personnage p : maArrayListePerso) {
	    b+= p.getPtVie();
	}
	a = System.nanoTime() - a;
	System.out.println("\ttemps pour ArrayList:  " + a + ", somme PV: " + b);
	
	System.out.println("");
	
	
	
    }
    
    /**
     * Méthode pour tester les fonctionnalités du joueur
     */
    public void testJoueur() {
        Scanner scanner = new Scanner(System.in);

        // --- Création d'un monde simple ---
        World Monde = new World();

        // Création de quelques créatures ennemies
        Archer ennemi1 = new Archer();
        ennemi1.setNom("EnnemiArcher");
        ennemi1.setPos(new Point2D(2, 2));
        ennemi1.setPtVie(50);

        Guerrier ennemi2 = new Guerrier();
        ennemi2.setNom("EnnemiGuerrier");
        ennemi2.setPos(new Point2D(3, 3));
        ennemi2.setPtVie(80);

        ennemi1.affiche();
        ennemi2.affiche();
             
        Monde.creerMondeAlea(0);
        
        Monde.list_creature.add(ennemi1);
        Monde.list_creature.add(ennemi2);

        // --- Création du joueur ---
        System.out.print("Nom du joueur : ");
        String nomJoueur = scanner.nextLine();

        Joueur joueur = new Joueur();
        
        joueur.setNomJoueur(nomJoueur);
        
        System.out.print("Choisissez votre classe (Archer/Guerrier) : ");
        String nomClasse = scanner.nextLine();

        System.out.print("Nom du personnage : ");
        String nomPerso = scanner.nextLine();

        if (!joueur.choisirPersonnage(nomClasse, nomPerso)) {
            System.out.println("Classe invalide, programme terminé.");
            return;
        }
        
        Monde.list_creature.add(joueur.perso);

        // Ajout d'objets dans l’inventaire pour tester
        joueur.ajouterObjet(new PotionSoin());
        joueur.ajouterObjet(new Epee());

        // --- Boucle de test simple ---
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n--- Tour du joueur ---");
            Monde.afficheWorld();
            
            joueur.afficherInventaire();

            joueur.jouerTour(Monde);

            System.out.print("Voulez-vous continuer ? (O/N) : ");
            String rep = scanner.nextLine().trim().toLowerCase();
            if (rep.equals("n")) continuer = false;
        }

        scanner.close();
    }
    
}
