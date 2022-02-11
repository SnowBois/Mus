package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.Iterator;
import java.util.List;
import java.util.Deque;

public class Opposants {
  private Equipe equipe1;
  private Equipe equipe2;
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private Deque<Joueur> ordreDePassage;

  public Opposants(Equipe equipe1, Equipe equipe2) {
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;

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
    return List.of(ordreDePassage);
  }
}