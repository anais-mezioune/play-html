package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Panier extends Model {

    @OneToOne
    public Client client;

    @OneToMany(mappedBy = "panier")
    public List<ProduitAjouteAuPanier> produits;

    public LocalDateTime date;

    public Float getMontant() {
        Float montant = 0f;
        for (ProduitAjouteAuPanier produit : produits) {
            montant += (produit.produit.prixUnitaire * produit.quantite);
        }
        return montant;
    }

}

