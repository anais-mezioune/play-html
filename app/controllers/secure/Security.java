package controllers.secure;

import com.formation.models.Client;
import com.formation.services.ClientService;
import controllers.Secure;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {

        Client client = ClientService.getClientByEmail(username);
        if (client != null && client.motDePasse.equals(password)) {
            return true;
        }
        return false;
    }

}
