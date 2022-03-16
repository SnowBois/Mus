package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquipeTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void ajoute_correctement_un_joueur_a_une_equipe() {
        var joueur = Joueur.ordinateur();

        var equipe = new Equipe();

        assertThat(equipe.listeJoueurs()).isEmpty();

        equipe.ajouterJoueur(joueur);

        assertThat(equipe.listeJoueurs()).isNotEmpty();
    }

    @Test
    void retire_correctement_un_joueur_a_une_equipe() {
        var joueur = Joueur.ordinateur();

        var equipe = new Equipe();

        equipe.ajouterJoueur(joueur);

        assertThat(equipe.listeJoueurs()).isNotEmpty();

        equipe.retirerJoueur(0);

        assertThat(equipe.listeJoueurs()).isEmpty();
    }
}
