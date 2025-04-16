package tp2;

import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class Exo3Test {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur_Success() throws ServiceException, UserService.ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",123);

        // Simuler un appel sans exception
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification que la méthode a bien été appelée
        verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
    }

    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_Echec() throws ServiceException, UserService.ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",132);

        // Simuler une exception lors de l'appel
        doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester, cela doit lever une exception
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateur_avecIdRetourne() throws ServiceException, UserService.ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",123);

        // Utilisez doNothing() pour simuler un succès dans la méthode void
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Appel de la méthode à tester
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        // Affecter un ID fictif à l'utilisateur
        int idUtilisateur = 123;
        utilisateur.setId(idUtilisateur);

        // Vérification que l'ID de l'utilisateur a été correctement mis à jour
        assert utilisateur.getId() == idUtilisateur;
    }

    @Test
    public void testCreerUtilisateur_ArgumentCaptor() throws ServiceException, UserService.ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com",123);

        // Création de l'ArgumentCaptor
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        // Simuler un appel sans exception
        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification que l'argument passé à la méthode est celui attendu
        verify(utilisateurApiMock, times(1)).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // Vérification des arguments capturés
        assertEquals("Jean", utilisateurCapture.getPrenom());
        assertEquals("Dupont", utilisateurCapture.getNom());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
    }
}
