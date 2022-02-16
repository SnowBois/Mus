package com.montaury.mus.jeu.tour;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class OpposantsTest {
    @BeforeEach
    void setUp() {
    }


    @Test
    void doit_donner_la_priorite_au_prochain_joueur_et_esku_devient_zaku() {
        var joueur1 = Joueur.humain("Sophie");
        var joueur2 = Joueur.ordinateur();
        var joueur3 = Joueur.ordinateur();
        var joueur4 = Joueur.ordinateur();

        var equipe1 = new Equipe();
        var equipe2 = new Equipe();

        var opposants = new Opposants(equipe1, equipe2);

        var ancienEsku = opposants.tousJoueursDansLOrdre().get(0);

        opposants.tourner();

        var actuelZaku = opposants.tousJoueursDansLOrdre().get(opposants.tousJoueursDansLOrdre().size() - 1);

        assertThat(actuelZaku == ancienEsku);
    }

    private Opposants opposants;
}
