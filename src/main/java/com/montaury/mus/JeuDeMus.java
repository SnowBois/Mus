package com.montaury.mus;

import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.Partie;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JeuDeMus {
  public static void main(String[] args) {
    System.out.print("Entrez le nombre de joueur par equipe (1 ou 2) : ");
    var nombreJoueurParEquipe = new Scanner(System.in).nextInt();
    System.out.print("Entrez votre nom : ");
    var nomJoueur = new Scanner(System.in).nextLine();

    System.out.print("Entrez votre nom d'équipe : ");
    var nomEquipe1 = new Scanner(System.in).nextLine();

    // On préfixe le nom choisi pour le joueur par le nom de son équipe suivi d'un tirer
    nomJoueur = nomEquipe1 + "-" + nomJoueur;
    var joueurHumain = Joueur.humain(nomJoueur);

    var nomEquipe2 = "Technodroïdes";

    var equipe1 = new Equipe(nomEquipe1);
    var equipe2 = new Equipe(nomEquipe2);

    equipe1.ajouterJoueur(joueurHumain);
    equipe2.ajouterJoueur(Joueur.ordinateur(nomEquipe2 + "-Ordinateur1"));

    // Si le mode de jeu choisi n'est pas le 1v1, on remplit les équipes avec plus d'ordinateurs
    if(nombreJoueurParEquipe == 2)
    {
      equipe1.ajouterJoueur(Joueur.ordinateur(nomEquipe1 + "-Ordinateur" + (2)));
      equipe2.ajouterJoueur(Joueur.ordinateur(nomEquipe2 + "-Ordinateur" + (2)));
    }

    var partie = new Partie(new AffichageEvenements(joueurHumain));
    var resultat = partie.jouer(new Opposants(equipe1,equipe2));
    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
