package com.montaury.mus.jeu.tour;

import com.montaury.mus.jeu.Opposants;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

        var equipe1 = new Equipe(new Joueur[]{joueur1, joueur2});
        var equipe2 = new Equipe(new Joueur[]{joueur3, joueur4});

        var opposants = new Opposants(equipe1, equipe2);

        var ancienEsku = opposants.dansLOrdre().get(0);

        for (Joueur joueur : opposants.dansLOrdre())
        {
            System.out.println(joueur.nom());
        }

        opposants.tourner();

        for (Joueur joueur : opposants.dansLOrdre())
        {
            System.out.println(joueur.nom());
        };

        var actuelZaku = opposants.dansLOrdre().get(opposants.dansLOrdre().size() - 1);

        assertThat(actuelZaku == ancienEsku);
    }

    private Opposants opposants;
}
