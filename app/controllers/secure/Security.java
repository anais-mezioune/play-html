package controllers.secure;

import controllers.Application;
import controllers.Secure;
import models.Client;
import play.Logger;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {

        Logger.debug("tentative de connexion de " + username);

        Client client = Client.find("email = ?1", username).first();
//        Client client = ClientService.getClientByEmail(username);
        if (client != null && client.motDePasse.equals(password)) {
            return true;
        }
        return false;
    }

    public static String connected() {
        return session.get("username");
    }

    public static boolean isConnected() {
        return session.contains("username");
    }

    static void onDisconnected() {
        Application.index();
    }

}
