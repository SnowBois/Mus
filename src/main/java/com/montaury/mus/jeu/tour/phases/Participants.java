package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.joueur.Joueur;
import java.util.ArrayList;
import java.util.List;

public class Participants {
  private final List<Joueur> dansLOrdre;

  public Participants(List<Joueur> dansLOrdre) {
    this.dansLOrdre = dansLOrdre;
  }

  public boolean aucun() {
    return dansLOrdre.isEmpty();
  }

  public boolean estUnique() {
    return dansLOrdre.size() == 1;
  }

  public Joueur premier() {
    return dansLOrdre.get(0);
  }

  public Joueur adversaireDe(Joueur joueurParlant) {
    int indiceJoueurParlant = dansLOrdre.lastIndexOf(joueurParlant);

    if(indiceJoueurParlant == dansLOrdre.size()-1)  // Cas où le joueur parlant est le dernier
    {
      return premier();
    }
    else
    {
      return dansLOrdre.get(indiceJoueurParlant+1);
    }
  }

  public Iterable<Joueur> dansLOrdre() {
    return dansLOrdre;
  }

  public Participants retirer(Joueur joueur) {
    var joueurs = new ArrayList<>(dansLOrdre);
    joueurs.remove(joueur);
    return new Participants(joueurs);
  }
}
