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
    private final static int NB_CREDIT_DEPART = 200;

    private int noMembre;
    private static int nextNoMembre = 1;
    private String avatar;
    private String surnom;
    private String email;
    private int nbCredit;
    private Set<Message> messages = new HashSet(0);
    private Set<Partie> parties = new HashSet(0);
    private Set<Commande> commandes = new HashSet(0);
    private Set<Ami> demandeAmiEnAttente = new HashSet(0);
    private Set<Ami> listeAmi = new HashSet(0);

    //constructeurs
    public Membre(String avatar, String surnom, String email, String nom, String prenom) {
        super(nom, prenom);
        this.avatar = avatar;
        this.surnom = surnom;
        this.email = email;
        this.nbCredit = NB_CREDIT_DEPART;
        noMembre = nextNoMembre++;
    }

    // Getter
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

    public Set<Ami> getDemandeAmiEnAttente() {
        return demandeAmiEnAttente;
    }

    public Set<Ami> getListeAmi() {
        return listeAmi;
    }

    // setter
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

    public void setDemandeAmiEnAttente(Set<Ami> demandeAmiEnAttente) {
        this.demandeAmiEnAttente = demandeAmiEnAttente;
    }

    public void setListeAmi(Set<Ami> listeAmi) {
        this.listeAmi = listeAmi;
    }

    // methodes
    public void ajoutDemandeAmi(Ami mbReceveur) {

        this.getDemandeAmiEnAttente().add(mbReceveur);
//TODO : ajouter a l'autre bozo

    }

    public void reponseDemandeAmi(Membre mbDemandeur, Membre mbReceveur, boolean reponseAmi) {

        if (reponseAmi) {
            // Ajouter l'ami
            mbDemandeur.getDemandeAmiEnAttente();
            mbReceveur.getDemandeAmiEnAttente();

            mbDemandeur.setListeAmi(listeAmi);
            mbReceveur.setListeAmi(listeAmi);

        } else {
            mbDemandeur.getDemandeAmiEnAttente();
            mbReceveur.getDemandeAmiEnAttente(); // retirer demande
        }

    }

    public void afficherAllAmis() {
        System.out.println("/////////tous les amis//////////////////////////////////////////////////");
        this.getListeAmi().forEach(item -> {
            System.out.println("| " + item.getMembre().getSurnom() + "|");
        });
    }

    public void afficherAllDemandesEnAttente() {
        System.out.println("/////////ALL demandes en attente//////////////////////////////////////////////////");
        this.getDemandeAmiEnAttente().forEach(item -> {
            System.out.println("| " + item.getMembre().getSurnom() + "|" + item.getDateDemande() + "|" + item.isEtatDemande());
        });
    }

    public void afficherMesAchats() {
        System.out.println(this.getSurnom());
        this.getCommandes().forEach(item -> {
            System.out.println("No commande: " + item.getNoCommande() + " | " + item.getDateCommande());
            item.getProduits().forEach(pdt -> {
                System.out.println("Item: " + pdt.getNoProduit() + " | " + pdt.getNomProduit() + " | " + pdt.getDescription());
            });
        });
    }

    // Dérivée
    public int nbPartie() {
        return this.getParties().size();
    }

    public int nbVictoire() {
        return this.getParties().size();
    }

    public int nbDefaite() {
        return this.getParties().size();
    }

    public int totalAchats() {
        int somme = this.getCommandes().stream().mapToInt(p -> p.totalCommande()).sum();

        return somme;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("No membre: " + this.noMembre);
    }
}
