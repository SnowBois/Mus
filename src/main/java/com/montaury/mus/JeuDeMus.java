package com.montaury.mus;

import com.montaury.mus.console.AffichageEvenements;
import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.Partie;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;

import java.util.Scanner;

public class JeuDeMus {
  public static void main(String[] args) {
    System.out.print("Entrez le nombre de joueur par equipe(1 ou 2) : ");
    var nombreJoueurParEquipe = new Scanner(System.in).nextInt();
    System.out.print("Entrez votre nom: ");
    var nomJoueur = new Scanner(System.in).next();
    var joueurHumain = Joueur.humain(nomJoueur);


    Joueur[] tabEquipe1 = new Joueur[nombreJoueurParEquipe];
    tabEquipe1[0] = joueurHumain;

    Joueur[] tabEquipe2 = new Joueur[nombreJoueurParEquipe];
    tabEquipe2[0] = Joueur.ordinateur();

    if(nombreJoueurParEquipe > 1)
    {
      for (var i = 1 ; i < nombreJoueurParEquipe ; i++)
      {
        tabEquipe1[i] = Joueur.ordinateur();
      }

      for (var i = 0 ; i < nombreJoueurParEquipe ; i++)
      {
        tabEquipe2[i] = Joueur.ordinateur();
      }
    }

    var equipe1 = new Equipe(tabEquipe1);
    var equipe2= new Equipe(tabEquipe2);

    var partie = new Partie(new AffichageEvenements(joueurHumain));
    var resultat = partie.jouer(new Opposants(equipe1,equipe2));
    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
