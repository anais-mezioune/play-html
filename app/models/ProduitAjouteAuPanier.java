package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProduitAjouteAuPanier extends Model {

    @ManyToOne
    public Panier panier;

    @OneToOne
    public Produit produit;
    public Integer quantite;

    public ProduitAjouteAuPanier(Produit produit) {
        this.produit = produit;
        this.quantite = 1;
    }
}
