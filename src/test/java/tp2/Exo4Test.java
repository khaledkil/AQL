package tp2;

import org.example.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Exo4Test {

    private Banque banqueMock;
    private Joueur joueurMock;
    private De de1Mock;
    private De de2Mock;
    private Jeu jeu;

    @Before
    public void setUp() {
        banqueMock = mock(Banque.class);
        joueurMock = mock(Joueur.class);
        de1Mock = mock(De.class);
        de2Mock = mock(De.class);
        jeu = new Jeu(banqueMock);
    }

    // 1. Le jeu est fermé
    @Test(expected = JeuFermeException.class)
    public void testJeuFerme() throws Exception {
        jeu.fermer();
        jeu.jouer(joueurMock, de1Mock, de2Mock);
    }

    // 2. Joueur insolvable
    @Test
    public void testJoueurInsolvable() throws Exception {
        when(joueurMock.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Fonds insuffisants")).when(joueurMock).debiter(100);

        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(joueurMock).mise();
        verify(joueurMock).debiter(100);
        verifyNoInteractions(de1Mock, de2Mock);
    }

    // 3. Le joueur perd (somme des dés ≠ 7)
    @Test
    public void testJoueurPerd() throws Exception {
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // total = 7
        when(banqueMock.est_solvable()).thenReturn(true);

        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(joueurMock).crediter(200);
        verify(banqueMock).debiter(200);
        assertTrue(jeu.estOuvert());
    }

    // 4. Le joueur gagne mais la banque devient insolvable
    @Test
    public void testJoueurGagneEtBanqueInsolvable() throws Exception {
        when(joueurMock.mise()).thenReturn(50);
        when(de1Mock.lancer()).thenReturn(4);
        when(de2Mock.lancer()).thenReturn(3); // total = 7
        when(banqueMock.est_solvable()).thenReturn(false); // après paiement

        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(joueurMock).crediter(100);
        assertFalse(jeu.estOuvert());
    }

    // 5. Vérification des interactions avec ArgumentCaptor
    @Test
    public void testInteractionAvecCaptor() throws Exception {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        when(joueurMock.mise()).thenReturn(70);
        when(de1Mock.lancer()).thenReturn(5);
        when(de2Mock.lancer()).thenReturn(2); // 5+2=7
        when(banqueMock.est_solvable()).thenReturn(true);

        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(joueurMock).debiter(captor.capture());
        assertEquals(Integer.valueOf(70), captor.getValue());
    }


}
