package jeuxpoker;

/**
 *
 * @author Equipe 5
 */
public class Details {
    //attributs

    private double prixAchat;
    private int qutAchat;
    private Commande commandes;
    private Produits produits;

    //constructeurs
    public Details(Commande commandes, Produits produits, int qutAchat, double prixAchat) {
        this.prixAchat = prixAchat;
        this.qutAchat = qutAchat;
        this.commandes = commandes;
        this.produits = produits;
        produits.ajoutDetail(this); // Verifier avec Zied
        commandes.ajoutDetail(this); // Verifier avec Zied
    }

    //getter-setter
    /**
     * @return the prixAchat
     */
    public double getPrixAchat() {
        return prixAchat;
    }

    /**
     * @param prixAchat the prixAchat to set
     */
    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * @return the qutAchat
     */
    public int getQutAchat() {
        return qutAchat;
    }

    /**
     * @param qutAchat the qutAchat to set
     */
    public void setQutAchat(int qutAchat) {
        this.qutAchat = qutAchat;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public Commande getCommandes() {
        return commandes;
    }

    public void setCommandes(Commande commandes) {

        this.commandes = commandes;
    }
     
    public void afficherDetails() {
        System.out.println("Prix achat: " + this.prixAchat + " | Quantité: " + this.qutAchat);

    }

}
