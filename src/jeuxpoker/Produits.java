package jeuxpoker;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Equipe 5
 */
public class Produits {
    //attributs

    private int noProduit;
    private static int nextNoProduit = 1;
    private String nomProduit;
    private double prixProduit;
    private String description;
    private Set<Details> details;

    //constructeurs
    public Produits(String nomProduit, String description, double prixProduit) {
        noProduit = nextNoProduit++;
        this.nomProduit = nomProduit;
        this.description = description;
        this.prixProduit = prixProduit;
        this.details = new HashSet();
    }

    //getter-setter
    //méthode
    public static int getNextNoProduit() {
        return nextNoProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
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

    public int getNoProduit() {
        return noProduit;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public void setDetails(Set<Details> details) {
        this.details = details;
    }

    public void ajoutDetail(Details d) {
        details.add(d);
        d.setProduits(this);
    }

    public void supprimerDetail(Details d) {
        details.remove(d);
        d.setProduits(null);
    }

    public void afficherProduit() {
        System.out.println("Produit no: " + this.noProduit + " | " + this.nomProduit + " | " + this.description);
    }

    public void afficherDetails() {
        this.getDetails().forEach(item -> {
            System.out.print("Commande no:" + item.getCommandes().getNoCommande());
            System.out.print(" | Produit no: " + item.getProduits().getNoProduit() + " | " + item.getProduits().getNomProduit() + " | " + item.getProduits().getDescription());            
            System.out.println(" | Prix achat: " + item.getPrixAchat() + " | Quantité: " + item.getQutAchat());
        });
    }

}
