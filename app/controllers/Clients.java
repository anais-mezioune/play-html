package controllers;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import com.formation.services.ClientService;
import play.data.validation.*;
import play.mvc.Controller;

public class Clients extends Controller {

    public static void create() {
        render();
    }

    public static void save(@Required @Email String email, @Required String password, @Required String nom, @Required String prenom) {

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            create();
        }

        Client client = null;
        try {
            client = ClientService.creerClient(email, password, nom, prenom);
            render(client);
        } catch (MetierException e) {
            e.printStackTrace();
            params.flash();
            Validation.addError("error", e.getMessage());
            validation.keep();
            create();
        }
    }
}
