package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.joueur.Joueur;

public class Equipe {
    private final Joueur[] listeJoueurs;

    public Equipe(Joueur[] listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public Joueur[] listeJoueurs() { return listeJoueurs(); }
}