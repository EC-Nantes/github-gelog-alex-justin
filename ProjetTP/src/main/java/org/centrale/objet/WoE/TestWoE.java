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
     * le vrai main
     */
    public void main(){
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
        System.out.println("");
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
        Centrale.bugs1.affiche();
	
        
        Point2D pou1 = new Point2D();
        Bulbi Bulbizart = new Bulbi(24, 100, 40, 30, 20, 20, pou1);
        Bulbizart.affiche();
	
	// Test des foncitons de combat
	//testCombat();
	
	// Test des fonctions de soin
	//testSoin();
	
        
        
        
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
    
}
