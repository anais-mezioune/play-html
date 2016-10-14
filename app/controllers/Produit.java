package controllers;

import com.formation.exceptions.MetierException;
import com.formation.services.ProduitService;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Produit extends Controller {

    public static void create() {
        render();
    }

    public static void save(String nom, Float prixUnitaire) {
        com.formation.models.Produit produit = null;
        try {
            produit = ProduitService.creerProduit(nom, prixUnitaire);
        } catch (MetierException e) {
            e.printStackTrace();
        }
        render(produit);
    }

}
