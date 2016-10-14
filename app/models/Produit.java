package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Produit extends Model {

    public String nom;
    public String description;
    public Float prixUnitaire;
//    public List<String> images;
    public String categorie;
    public String url;
    public boolean isSupprime = false;

}
