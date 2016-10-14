package controllers.api;

import models.Produit;
import play.mvc.Controller;

import java.util.List;

public class Api extends Controller {

    public static void produits(){
        List<Produit> produits = Produit.findAll();
        if(request.format.equals("json")) {
            renderJSON(produits);
        } else if(request.format.equals("xml")) {
            renderXml(produits);
        }
    }
}
