package models;

import org.hibernate.annotations.Type;
import play.db.jpa.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Panier extends Model {

    @OneToOne
    public Client client;

    @OneToMany(mappedBy = "panier")
    public List<ProduitAjouteAuPanier> produits;

    @Type(type="models.hibernate.LocalDateTimeUserType")
    public LocalDateTime date;

    public Float getMontant() {
        Float montant = 0f;
        for (ProduitAjouteAuPanier produit : produits) {
            montant += (produit.produit.prixUnitaire * produit.quantite);
        }
        return montant;
    }

}

