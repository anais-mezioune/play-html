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

    public static void presentationResponsive(){
        render();
    }
    
    public static void getAsyncPresentationMessage(String name, String signature){
        String videoCode = "1NKWop13q7I";
        renderTemplate("tags/presentation-message.html", name, signature);
    }

    public static void test(){
        render();
    }
}