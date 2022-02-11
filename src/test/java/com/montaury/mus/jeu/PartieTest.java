package com.montaury.mus.jeu;

import com.montaury.mus.jeu.evenements.Evenements;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Hordago;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Kanta;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Mintza;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Mus;
import com.montaury.mus.jeu.tour.phases.dialogue.choix.Paso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurFaisantChoix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PartieTest {

  @BeforeEach
  void setUp() {
    partie = new Partie(mock(Evenements.class));
  }

  @Test
  void devrait_faire_gagner_le_premier_joueur_a_3_manches() {
    var joueurEsku = unJoueurFaisantChoix(new Mintza(), new Hordago(), new Mintza(), new Hordago(), new Mintza(), new Hordago(), new Mintza(), new Hordago(), new Mintza(), new Hordago());
    var joueurZaku = unJoueurFaisantChoix(new Kanta(), new Mus(), new Paso(), new Kanta(), new Kanta(), new Mus(), new Paso(), new Kanta(), new Kanta());

    Joueur[] tabEquipe1 = new Joueur[1];
    tabEquipe1[0] = joueurEsku;

    Joueur[] tabEquipe2 = new Joueur[1];
    tabEquipe2[0] = joueurEsku;

    Equipe equipe1 = new Equipe(tabEquipe1);
    Equipe equipe2 = new Equipe(tabEquipe2);

    var opposants = new Opposants(equipe1, equipe2);

    Partie.Resultat resultat = partie.jouer(opposants);

    assertThat(resultat.vainqueur()).isNotNull();
    assertThat(resultat.score().resultatManches()).hasSizeGreaterThanOrEqualTo(3);
  }

  private Partie partie;
}
