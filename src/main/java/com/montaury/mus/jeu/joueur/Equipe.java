package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.joueur.Joueur;

import java.util.List;

public class Equipe {
    private final List<Joueur> listeJoueurs;

    public Equipe(List<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;

        for(Joueur joueur : listeJoueurs)
        {
            joueur.setEquipe(this);
        }
    }

    public Joueur recupererJoueur(int indice) {
        return this.listeJoueurs.get(indice);
    }

    public void ajouterJoueur(Joueur joueur) {
        this.listeJoueurs.add(joueur);
    }

    public void retirerJoueur(int indice) {
        this.listeJoueurs.remove(indice);
    }

    public List<Joueur> listeJoueurs() { return listeJoueurs; }
}