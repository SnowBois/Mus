package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.joueur.Joueur;

public class Equipe {
    private final Joueur[] listeJoueurs;

    public Equipe(Joueur[] listeJoueurs) {
        this.listeJoueurs = listeJoueurs;

        for(Joueur joueur : listeJoueurs)
        {
            joueur.setEquipe(this);
        }
    }

    public Joueur[] listeJoueurs() { return listeJoueurs; }
}