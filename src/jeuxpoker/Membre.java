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
public class Membre extends Personne {

    //attributs
    private int noMembre;
    private static int nextNoMembre = 1;
    private String avatar;
    private String surnom;
    private String email;
    private int nbCredit;
    private static int nbCreditDepart;
    private Set<Message> messages = new HashSet(0);
    private Set<Partie> parties = new HashSet(0);
    private Set<Commande> commandes = new HashSet(0);
    private Set<Membre> demandeur = new HashSet(0);
    private Set<Membre> receveur = new HashSet(0);

    //constructeurs
    public Membre(String avatar, String surnom, String email, int nbCredit, String nom, String prenom) {
        super(nom, prenom);

        this.avatar = avatar;
        this.surnom = surnom;
        this.email = email;
        this.nbCredit = nbCredit;
        noMembre = nextNoMembre++;

    }

    public int getNoMembre() {
        return noMembre;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getSurnom() {
        return surnom;
    }

    public String getEmail() {
        return email;
    }

    public int getNbCredit() {
        return nbCredit;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Set<Partie> getParties() {
        return parties;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNbCredit(int nbCredit) {
        this.nbCredit = nbCredit;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void setParties(Set<Partie> parties) {
        this.parties = parties;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public void afficher() {
        System.out.println(noMembre + "-" + this.avatar
                + "-" + this.surnom + "-" + this.email + "-" + this.nbCredit);
        super.afficher();
    }

    public static void afficherAmi(Set<Ami> amiss) {

        amiss.forEach(item -> {
            System.out.println("| " + item.getMembre().getSurnom() + "|" + item.getDateDemande());
            System.out.println(item.isEtatDemande());
        });
    }

    public static void afficherMesAchats(Set<Commande> cde) {

        cde.forEach(item -> {
            System.out.println("| " + item.getNoCommande() + "|" + item.getDateCommande());
            item.getProduits().forEach(pdt -> {
                System.out.println("| " + pdt.getNomProduit() + "|" + pdt.getDescription());
            });
        });
    }
}
