package controllers;

import com.formation.exceptions.MetierException;
import com.formation.services.ClientService;
import play.mvc.Controller;

public class Client extends Controller {

    public static void create() {
        render();
    }

    public static void save(String email, String password) {

        com.formation.models.Client client = null;
        try {
            client = ClientService.creerClient(email,password, "","");

        } catch (MetierException e) {
            e.printStackTrace();
        }

        render(client);

//        render(email, password);
    }
}
