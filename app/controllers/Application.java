package controllers;

import models.Produit;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Produit> produits = Produit.findAll();
//        List<Produit> produits = ProduitService.lister();
        render(produits);
    }

    public static void produit(Long id) {
        Produit produit = Produit.findById(id);
//        Produit produit = ProduitService.getProduit(id);
        render(produit);
    }

    public static void presentation(){
        render();
    }

}