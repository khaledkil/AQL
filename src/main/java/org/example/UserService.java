package org.example;

public class UserService {

    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException, org.example.ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }

    public static class ServiceException extends Exception {
        public ServiceException(String message) {
            super(message);
        }
    }
}

