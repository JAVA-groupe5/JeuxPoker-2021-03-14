/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuxpoker;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author thomas
 */
public class Commande {
    //attributs

    private int noCommande;
    private Date dateCommande;
    private Set<Produits> produits = new HashSet(0);

    //constructeurs
    public Commande() {
    }

    public Commande(int noCommande, Date dateCommande) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
    }

    //getter-setter
    /**
     * @return the noCommande
     */
    public int getNoCommande() {
        return noCommande;
    }

    /**
     * @param noCommande the noCommande to set
     */
    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    /**
     * @return the dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Set<Produits> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produits> produits) {
        this.produits = produits;
    }

    public void afficher() {
        System.out.println(this.noCommande + "-" + this.produits + "-" + this.dateCommande);

    }

    public void afficherProduits() {

        this.getProduits().forEach(item -> {
            System.out.println("Item: " + item.getNoProduit() + " | " + item.getNomProduit() + " | " + item.getDescription());
        });
    }

    public int totalCommande() {
        int somme = this.getProduits().stream() .mapToInt( p -> p.getPrixProduit()) .sum();
        
        return somme;
    }
}
