/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuxpoker;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author thomas
 */
public class Produits {
    //attributs

    private int noProduit;
    private static int nextNoProduit = 1;
    private String nomProduit;
    private int prixProduit;
    private String description;
    private Set<Commande> commandes = new HashSet(0);

    //constructeurs
    public Produits(String nomProduit, int prixProduit, String description) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.description = description;
        noProduit = nextNoProduit++;

    }

    //getter-setter
    //méthode
    public static int getNextNoProduit() {
        return nextNoProduit;
    }

    public static void setNextNoProduit(int nextNoProduit) {
        Produits.nextNoProduit = nextNoProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(int prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public int getNoProduit() {
        return noProduit;
    }

    public void afficher() {
        System.out.println(this.noProduit + "-" + this.nomProduit + "-" + this.prixProduit + "-" + this.description);

    }
}
