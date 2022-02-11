package com.montaury.mus.jeu;

import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import java.util.Iterator;
import java.util.List;

public class Opposants {
  private Equipe equipe1;
  private Equipe equipe2;
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private Joueur[] ordreDePassage;

  public Opposants(Equipe equipe1, Equipe equipe2) {
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;

    ordreDePassage = new Joueur[equipe1.listeJoueurs().length + equipe2.listeJoueurs().length];

    var j = 0;
    for (var i = 0 ; i < equipe1.listeJoueurs().length ; i++)
    {
      ordreDePassage[j] = equipe1.listeJoueurs()[i];
      j++;
      ordreDePassage[j] = equipe2.listeJoueurs()[i];
      j++;
    }

    this.joueurEsku = ordreDePassage[0];
    this.joueurZaku = ordreDePassage[ordreDePassage.length - 1];
  }

  public void tourner() {
    var copieOrdreDePassage = ordreDePassage;

    for (var i = 0 ; i < ordreDePassage.length ; i++)
    {
      ordreDePassage[(i+1) % ordreDePassage.length] = copieOrdreDePassage[i];
    }

    this.joueurEsku = ordreDePassage[0];
    this.joueurZaku = ordreDePassage[ordreDePassage.length - 1];
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