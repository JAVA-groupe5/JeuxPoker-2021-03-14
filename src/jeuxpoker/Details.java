/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuxpoker;

/**
 *
 * @author thomas
 */
public class Details {
       //attributs
    private double prixAchat;
    private int qutAchat;
    private Commande commandes;
    private Produits produits;
    
    
    
    //constructeurs

    public Details(double prixAchat, int qutAchat) {
        this.prixAchat = prixAchat;
        this.qutAchat = qutAchat;
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
    
       

    public Commande getCommandes() {
        return commandes;
    }

    public void setCommandes(Commande commandes) {
        this.commandes = commandes;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }
    
    public void afficher(){
        System.out.println(this.prixAchat +"-"+ this.qutAchat);
        
    }
}
