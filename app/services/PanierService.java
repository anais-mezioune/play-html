package services;

import models.Client;
import models.Panier;
import models.Produit;
import models.ProduitAjouteAuPanier;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PanierService {

    public static Panier getPanier(Client client) {
        Panier panier = Panier.find("client.id = ?1", client.id).first();
        if (panier == null) {
            panier = creerPanier(client);
        }
        return panier;
    }

    private static Panier creerPanier(Client client) {
        Panier panier = new Panier();
        panier.client = client;
        panier.produits = new ArrayList<>();
        panier.date = LocalDateTime.now();
        panier.save();
        return panier;
    }

    public static void ajouterProduit(Panier panier, Produit produit) {
        ProduitAjouteAuPanier produitAjouteAuPanier = new ProduitAjouteAuPanier(produit);
        produitAjouteAuPanier.panier = panier;
        produitAjouteAuPanier.save();
    }
}
