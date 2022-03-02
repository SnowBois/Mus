package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.joueur.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private final List<Joueur> listeJoueurs;
    private final String nom;

    public Equipe() {
        this.nom = "Equipe";
        this.listeJoueurs = new ArrayList<Joueur>();
    }

    public Equipe(String nom) {
        this.nom = nom;
        this.listeJoueurs = new ArrayList<Joueur>();
    }

    public Equipe(String nom, List<Joueur> listeJoueurs) {
        this.nom = nom;
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
        joueur.setEquipe(this);
    }

    public void retirerJoueur(int indice) {
        this.listeJoueurs.get(indice).setEquipe(null);
        this.listeJoueurs.remove(indice);
    }

    public List<Joueur> listeJoueurs() { return listeJoueurs; }

    public String nom() {
        return nom;
    }
}