package com.montaury.mus.jeu.tour;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class OpposantsTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void fait_correctement_tourner_la_priorite_1v1() {
        var joueur1 = Joueur.ordinateur();
        var joueur2 = Joueur.ordinateur();

        var equipe1 = new Equipe();
        var equipe2 = new Equipe();

        equipe1.ajouterJoueur(joueur1);

        equipe2.ajouterJoueur(joueur2);

        var opposants = new Opposants(equipe1, equipe2);

        assertThat(opposants.estEsku(joueur1)).isTrue();
        assertThat(opposants.estEsku(joueur2)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isTrue();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isFalse();
        assertThat(opposants.estEsku(joueur2)).isTrue();

        assertThat(opposants.estZaku(joueur1)).isTrue();
        assertThat(opposants.estZaku(joueur2)).isFalse();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isTrue();
        assertThat(opposants.estEsku(joueur2)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isTrue();
    }


    @Test
    void fait_correctement_tourner_la_priorite_2v2() {
        var joueur1 = Joueur.ordinateur();
        var joueur2 = Joueur.ordinateur();
        var joueur3 = Joueur.ordinateur();
        var joueur4 = Joueur.ordinateur();

        var equipe1 = new Equipe();
        var equipe2 = new Equipe();

        equipe1.ajouterJoueur(joueur1);
        equipe1.ajouterJoueur(joueur3);

        equipe2.ajouterJoueur(joueur2);
        equipe2.ajouterJoueur(joueur4);

        var opposants = new Opposants(equipe1, equipe2);

        assertThat(opposants.estEsku(joueur1)).isTrue();
        assertThat(opposants.estEsku(joueur2)).isFalse();
        assertThat(opposants.estEsku(joueur3)).isFalse();
        assertThat(opposants.estEsku(joueur4)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isFalse();
        assertThat(opposants.estZaku(joueur3)).isFalse();
        assertThat(opposants.estZaku(joueur4)).isTrue();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isFalse();
        assertThat(opposants.estEsku(joueur2)).isTrue();
        assertThat(opposants.estEsku(joueur3)).isFalse();
        assertThat(opposants.estEsku(joueur4)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isTrue();
        assertThat(opposants.estZaku(joueur2)).isFalse();
        assertThat(opposants.estZaku(joueur3)).isFalse();
        assertThat(opposants.estZaku(joueur4)).isFalse();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isFalse();
        assertThat(opposants.estEsku(joueur2)).isFalse();
        assertThat(opposants.estEsku(joueur3)).isTrue();
        assertThat(opposants.estEsku(joueur4)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isTrue();
        assertThat(opposants.estZaku(joueur3)).isFalse();
        assertThat(opposants.estZaku(joueur4)).isFalse();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isFalse();
        assertThat(opposants.estEsku(joueur2)).isFalse();
        assertThat(opposants.estEsku(joueur3)).isFalse();
        assertThat(opposants.estEsku(joueur4)).isTrue();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isFalse();
        assertThat(opposants.estZaku(joueur3)).isTrue();
        assertThat(opposants.estZaku(joueur4)).isFalse();

        opposants.tourner();

        assertThat(opposants.estEsku(joueur1)).isTrue();
        assertThat(opposants.estEsku(joueur2)).isFalse();
        assertThat(opposants.estEsku(joueur3)).isFalse();
        assertThat(opposants.estEsku(joueur4)).isFalse();

        assertThat(opposants.estZaku(joueur1)).isFalse();
        assertThat(opposants.estZaku(joueur2)).isFalse();
        assertThat(opposants.estZaku(joueur3)).isFalse();
        assertThat(opposants.estZaku(joueur4)).isTrue();
    }

    private Opposants opposants;
}
