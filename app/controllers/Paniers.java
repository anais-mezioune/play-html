package controllers;

import models.Client;
import models.Panier;
import models.Produit;
import play.mvc.Controller;
import play.mvc.With;
import services.PanierService;

@With(Secure.class)
public class Paniers extends Controller {

    public static void ajouterAuPanier(Long id) {

        Produit produit = Produit.findById(id);
        String email = Secure.Security.connected();
        Client client = Client.find("email = ?1", email).first();
        Panier panier = PanierService.getPanier(client);

        // Travail
        PanierService.ajouterProduit(panier, produit);

        // Ou est ce qu'on va quand on a fini
        afficher();


//        Produit produit = ProduitService.getProduit(id);
//        String email = Secure.Security.connected();
//        Client client = ClientService.getClientByEmail(email);
//        Panier panier = PanierService.getPanier(client);
//        try {
//            PanierService.ajouterProduit(panier, produit);
//            afficher();
//        } catch (MetierException e) {
//            e.printStackTrace();
//            // TODO : Traiter l'erreur
//        }
    }

    public static void afficher() {
        String email = Secure.Security.connected();
        Client client = Client.find("email = ?1", email).first();
        Panier panier = PanierService.getPanier(client);

        render(panier);
    }

}
