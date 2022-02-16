package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;

import java.util.*;

public class Opposants {
  private Equipe equipe1;
  private Equipe equipe2;
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private ArrayDeque<Joueur> ordreDePassage;

  public Opposants(Joueur joueurEsku, Joueur joueurZaku) {
    this.joueurEsku = joueurEsku;
    this.joueurZaku = joueurZaku;

    this.equipe1.ajouterJoueur(joueurEsku);
    this.equipe2.ajouterJoueur(joueurZaku);
  }

  public Opposants(Equipe equipe1, Equipe equipe2) {
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;

    this.ordreDePassage = new ArrayDeque<Joueur>();

    for (var i = 0; i < equipe1.listeJoueurs().size() ; i++) {
      this.ordreDePassage.add(this.equipe1.recupererJoueur(i));
      this.ordreDePassage.add(this.equipe2.recupererJoueur(i));
    }

    this.joueurEsku = this.ordreDePassage.getFirst();
    this.joueurZaku = this.ordreDePassage.getLast();
  }

  public void tourner() {
    var ancienEsku = this.ordreDePassage.pollFirst();
    this.ordreDePassage.add(ancienEsku);

    this.joueurEsku = this.ordreDePassage.getFirst();
    this.joueurZaku = this.ordreDePassage.getLast();
  }

  public Joueur joueurEsku() {
    return this.joueurEsku;
  }

  public Joueur joueurZaku() {
    return this.joueurZaku;
  }

  public List<Joueur> tousJoueursDansLOrdre() {
    return new ArrayList(this.ordreDePassage);
  }

  public List<Joueur> equipe1DansLOrdre() {
    List<Joueur> equipe1DansLOrdre = new ArrayList();

    for (Joueur joueur : this.ordreDePassage) {
      if(joueur.equipe() == this.equipe1)
      {
        equipe1DansLOrdre.add(joueur);
      }
    }

    return equipe1DansLOrdre;
  }

  public List<Joueur> equipe2DansLOrdre() {
    List<Joueur> equipe2DansLOrdre = new ArrayList();

    for (Joueur joueur : this.ordreDePassage) {
      if(joueur.equipe() == this.equipe2)
      {
        equipe2DansLOrdre.add(joueur);
      }
    }

    return equipe2DansLOrdre;
  }
}