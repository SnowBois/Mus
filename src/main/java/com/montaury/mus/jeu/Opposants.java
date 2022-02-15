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

  public Opposants(Equipe equipe1, Equipe equipe2) {
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;

    this.ordreDePassage = new ArrayDeque<Joueur>();

    for (var i = 0 ; i < equipe1.listeJoueurs().length ; i++)
    {
      this.ordreDePassage.add(this.equipe1.listeJoueurs()[i]);
      this.ordreDePassage.add(this.equipe2.listeJoueurs()[i]);
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
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public List<Joueur> dansLOrdre() {
    return new ArrayList(ordreDePassage);
  }
}