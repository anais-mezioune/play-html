package controllers;

import com.formation.models.*;
import com.formation.services.ProduitService;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Produit> produits = ProduitService.lister();
        render(produits);
    }

    public static void produit(String id) {
        Produit produit = ProduitService.getProduit(id);
        render(produit);
    }

}