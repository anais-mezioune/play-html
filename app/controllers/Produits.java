package controllers;

import models.Produit;
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

        Produit produit = new Produit();
        produit.nom = nom;
        produit.prixUnitaire = prixUnitaire;
        produit.save();
        render(produit);

//        Produit produit = null;
//        try {
//            produit = ProduitService.creerProduit(nom, prixUnitaire);
//            render(produit);
//        } catch (MetierException e) {
//            e.printStackTrace();
//            params.flash();
//            Validation.addError("error", e.getMessage());
//            validation.keep();
//            create();
//        }
    }

}
