package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Client extends Model {

    public String email;
    public String motDePasse;
    public String nom;
    public String prenom;
    public String adressePostale;
    public String telephone;
    public boolean isSupprime = false;

}
