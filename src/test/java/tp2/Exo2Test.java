package tp2;

import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Exo2Test {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws UserService.ServiceException, ServiceException {
        // ✅ Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",133);

        // ✅ Configuration du comportement du mock (facultatif ici, car void)
        // Ici, comme la méthode retourne void, pas besoin de thenReturn
        // mais on peut utiliser doNothing() pour être explicite :
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // ✅ Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // ✅ Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // ✅ Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Optionnel : s'assurer qu'aucune autre méthode n'a été appelée
        verifyNoMoreInteractions(utilisateurApiMock);
    }
}
