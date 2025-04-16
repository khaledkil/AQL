package tp2;

import org.example.Calculatrice;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Exo1Test {

    @Mock
    private Calculatrice calculatrice;
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks pour TestNG
    }
    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode mockée
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // ✅ Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // ✅ Vérification du résultat
        assert resultat == 5;

        // ✅ Vérification que la méthode a été appelée
        verify(calculatrice).additionner(2, 3);
        verifyNoMoreInteractions(calculatrice);

        // ✅ Vérification de l’état d’un vrai objet, pas le mock
        Calculatrice realCalc = new Calculatrice();
        realCalc.additionner(2, 3);  // appel réel

        // Vérification de l’état sans utiliser verify() car c'est un vrai objet
        assert realCalc.getResult() == 5;
    }

}
