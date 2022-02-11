package com.montaury.mus.jeu;

import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Gehiago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Hordago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Imido;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Kanta;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Mintza;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Tira;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class MancheTest {

  @BeforeEach
  void setUp() {
    manche = new Manche(mock(Evenements.class));
  }

  @Test
  void devrait_terminer_la_manche_si_hordago_au_grand() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());

    Joueur[] tabEquipe1 = new Joueur[1];
    tabEquipe1[0] = joueurEsku;

    Joueur[] tabEquipe2 = new Joueur[1];
    tabEquipe2[0] = joueurEsku;

    Equipe equipe1 = new Equipe(tabEquipe1);
    Equipe equipe2 = new Equipe(tabEquipe2);

    var resultat = manche.jouer(new Opposants(equipe1, equipe2));

    assertThat(resultat.vainqueur()).isNotNull();
    assertThat(resultat.pointsVaincu()).isZero();
  }

  @Test
  void devrait_terminer_la_manche_si_un_joueur_a_40_points() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Imido(), new Gehiago(2));
    var joueurZaku = unJoueurFaisantChoix(new Gehiago(40), new Tira());

    Joueur[] tabEquipe1 = new Joueur[1];
    tabEquipe1[0] = joueurEsku;

    Joueur[] tabEquipe2 = new Joueur[1];
    tabEquipe2[0] = joueurEsku;

    Equipe equipe1 = new Equipe(tabEquipe1);
    Equipe equipe2 = new Equipe(tabEquipe2);

    var resultat = manche.jouer(new Opposants(equipe1, equipe2));

    assertThat(resultat.vainqueur()).isEqualTo(joueurEsku);
    assertThat(resultat.pointsVaincu()).isZero();
  }

  @Test
  void devrait_changer_l_ordre_des_opposants_a_la_fin_du_tour() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta());

    Joueur[] tabEquipe1 = new Joueur[1];
    tabEquipe1[0] = joueurEsku;

    Joueur[] tabEquipe2 = new Joueur[1];
    tabEquipe2[0] = joueurEsku;

    Equipe equipe1 = new Equipe(tabEquipe1);
    Equipe equipe2 = new Equipe(tabEquipe2);

    var opposants = new Opposants(equipe1, equipe2);

    manche.jouer(opposants);

    assertThat(opposants.dansLOrdre()).containsExactly(joueurZaku, joueurEsku);
  }

  private Manche manche;
}
