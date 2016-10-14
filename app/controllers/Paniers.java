package controllers;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import com.formation.models.Panier;
import com.formation.models.Produit;
import com.formation.services.ClientService;
import com.formation.services.PanierService;
import com.formation.services.ProduitService;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Paniers extends Controller {

    public static void ajouterAuPanier(String id) {
        Produit produit = ProduitService.getProduit(id);
        String email = Secure.Security.connected();
        Client client = ClientService.getClientByEmail(email);
        Panier panier = PanierService.getPanier(client);
        try {
            PanierService.ajouterProduit(panier, produit);
            afficher();
        } catch (MetierException e) {
            e.printStackTrace();
            // TODO : Traiter l'erreur
        }
    }

    public static void afficher() {
        String email = Secure.Security.connected();
        Client client = ClientService.getClientByEmail(email);
        Panier panier = PanierService.getPanier(client);
        render(panier);
    }

}
