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
    System.out.print("Entrez votre nom: ");
    var nomJoueur = new Scanner(System.in).next();
    var joueurHumain = Joueur.humain(nomJoueur);

    var equipe1 = new Equipe();
    var equipe2 = new Equipe();

    equipe1.ajouterJoueur(joueurHumain);

    equipe2.ajouterJoueur(Joueur.ordinateur("Equipe2-Ordinateur0"));

    if(nombreJoueurParEquipe > 1)
    {
      for (var i = 1 ; i < nombreJoueurParEquipe ; i++)
      {
        equipe1.ajouterJoueur(Joueur.ordinateur("Equipe1-Ordinateur" + String.valueOf(i)));
      }

      for (var i = 1 ; i < nombreJoueurParEquipe ; i++)
      {
        equipe2.ajouterJoueur(Joueur.ordinateur("Equipe2-Ordinateur" + String.valueOf(i)));
      }
    }

    var partie = new Partie(new AffichageEvenements(joueurHumain));
    var resultat = partie.jouer(new Opposants(equipe1,equipe2));
    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
