package controllers;

import com.formation.exceptions.MetierException;
import com.formation.models.Produit;
import com.formation.services.ProduitService;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Produits extends Controller {

    public static void create() {
        render();
    }

    public static void save(@Required String nom, @Required Float prixUnitaire) {

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            create();
        }

        Produit produit = null;
        try {
            produit = ProduitService.creerProduit(nom, prixUnitaire);
            render(produit);
        } catch (MetierException e) {
            e.printStackTrace();
            params.flash();
            Validation.addError("error", e.getMessage());
            validation.keep();
            create();
        }
    }

}
