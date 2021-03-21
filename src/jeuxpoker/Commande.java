package jeuxpoker;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static jeuxpoker.utilitaires.retourDate;

/**
 *
 * @author Equipe 5
 */
public class Commande {
    //attributs

    private int noCommande;
    private Date dateCommande;
    private Set<Details> details;

    private Membre membre;

    private static int nextNoCommande = 1;

    public Commande(Date dateCommande, Membre membre) {
        this.noCommande = nextNoCommande++;
        this.dateCommande = dateCommande;
        this.membre = membre;
        this.details = new HashSet();

    }

    //getter-setter
    /**
     * @return the noCommande
     */
    public int getNoCommande() {
        return noCommande;
    }

    /**
     * @return the dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        if (this.membre != membre) {
            Membre old = this.membre;
            this.membre = membre;
            if (membre != null) {
                membre.ajoutCommande(this);
            }
            if (old != null) {
                old.supprimerCommande(this);
            }
        }
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Set<Produits> getProduits() {
        Set<Produits> resultat = new HashSet();

        details.forEach(item -> {
            resultat.add(item.getProduits());
        });
        return resultat;
    }

    public void ajoutDetail(Details d) {
        details.add(d);
        d.setCommandes(this);
    }

    public void supprimerDetail(Details d) {
        details.remove(d);
        d.setCommandes(null);
    }

    public void afficherCommande() {
        System.out.println("Commande No: " + this.noCommande + " du " + retourDate(this.dateCommande) + "");
    }

    public void afficherProduitsCommande() {

        if (this.getDetails().size() > 0) {
            System.out.println("********** Commande No: " + this.noCommande + " du " + retourDate(this.getDateCommande()) + " **********");
            System.out.println("********** LISTE DES PRODUITS **********");
            this.getDetails().forEach(item -> {
                System.out.print("Produit no: " + item.getProduits().getNoProduit() + " | " + item.getProduits().getNomProduit() + " | " + item.getProduits().getDescription());
                System.out.println(" | Prix achat: " + item.getPrixAchat() + " | Quantité: " + item.getQutAchat());
            });
        }
    }

    public double totalCommande() {

        double somme = this.getDetails().stream().mapToDouble(p -> p.getPrixAchat() * p.getQutAchat()).sum();
        return somme;
    }

    public void afficherDetails() {
        this.getDetails().forEach(item -> {
            System.out.print("Commande no:" + item.getCommandes().getNoCommande());
            System.out.print(" | Produit no: " + item.getProduits().getNoProduit() + " | " + item.getProduits().getNomProduit() + " | " + item.getProduits().getDescription());
            System.out.println(" | Prix achat: " + item.getPrixAchat() + " | Quantité: " + item.getQutAchat());
        });
    }

}
