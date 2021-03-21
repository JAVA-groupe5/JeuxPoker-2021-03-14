package jeuxpoker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static jeuxpoker.utilitaires.retourDate;

/**
 *
 * @author Equipe 5
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
    private Set<Message> messages;
    private List<Partie> parties;
    private Set<Commande> commandes;
    private Set<Ami> demandeAmiEnAttente;
    private Set<Ami> listeAmi;
    private Set<Stats> stats;

    //constructeurs
    public Membre(String avatar, String surnom, String email, String nom, String prenom) {
        super(nom, prenom);
        this.avatar = avatar;
        this.surnom = surnom;
        this.email = email;
        this.nbCredit = NB_CREDIT_DEPART;
        noMembre = nextNoMembre++;

        messages = new HashSet();
        commandes = new HashSet();
        parties = new ArrayList(0);
        demandeAmiEnAttente = new HashSet(0);
        listeAmi = new HashSet(0);
        stats = new HashSet(0);
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

    public List<Partie> getParties() {
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

    public void setParties(List<Partie> parties) {
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

    public Set<Stats> getStats() {
        return stats;
    }

    public void setStats(Set<Stats> stats) {
        this.stats = stats;
    }

    // methodes
    public void afficherNewMembre() {
        System.out.print("Nouveau membre: " + this.noMembre);
        System.out.println(" | Nom, prénom: " + this.nom + " " + this.prenom);
    }

    public void afficherMembre() {
        System.out.print("No: " + this.noMembre);
        System.out.print(" | " + this.nom + " " + this.prenom);
    }

    // Amis
    public void ajoutDemandeAmi(Ami mbReceveur) {
        this.demandeAmiEnAttente.add(mbReceveur);
    }

    public void supprimerDemandeAmi(Ami mbReceveur) {
        this.demandeAmiEnAttente.remove(mbReceveur);
    }

    public void ajoutAmi(Ami mbReceveur) {
        this.listeAmi.add(mbReceveur);
    }

    public void supprimerAmi(Ami mbReceveur) {
        this.listeAmi.remove(mbReceveur);
    }

    public void afficherAllAmis() {
        if (this.getListeAmi().size() > 0) {
            System.out.println("TOUS LES AMIS de " + this.nom + " " + this.prenom + " **********");

            this.getListeAmi().forEach(item -> {
                System.out.println("\tSurnom: " + item.getMembre().getSurnom() + "");
            });
        } else {
            System.out.println("Liste ami vide pour " + this.nom + " " + this.prenom);
        }
    }

    public void afficherAllDemandesEnAttente() {
        if (this.getDemandeAmiEnAttente().size() > 0) {
            System.out.println("TOUTES LES DEMANDES D'AMIS EN ATTENTE de " + this.nom + " " + this.prenom + " **********");

            this.getDemandeAmiEnAttente().forEach(item -> {
                System.out.print("\tSurnom: " + item.getMembre().getSurnom() + " | Date: " + retourDate(item.getDateDemande()));
                System.out.println(" | État demande: " + item.isEtatDemande());
            });
        } else {
            System.out.println("Aucune demande en attente pour " + this.nom + " " + this.prenom);
        }
    }

    // Commandes
    public void ajoutCommande(Commande newCommande) {
        commandes.add(newCommande);
        newCommande.setMembre(this);
    }

    public void supprimerCommande(Commande newCommande) {
        commandes.remove(newCommande);
        newCommande.setMembre(null);
    }

    public void afficherMesAchats() {
        System.out.println(this.getSurnom());
        this.getCommandes().forEach(item -> {
            System.out.println("No commande: " + item.getNoCommande() + " | " + item.getDateCommande());
            item.getDetails().forEach(pdt -> {
                System.out.println("Item: " + pdt.getProduits().getNoProduit() + " | " + pdt.getProduits().getNomProduit() + " | " + pdt.getProduits().getDescription());
            });
        });
    }

    public void afficherTotalAchats() {
        double somme = this.getCommandes().stream().mapToDouble(p -> p.totalCommande()).sum();

        System.out.print("\t" + this.getSurnom());
        System.out.println(" | Total : " + somme);
    }

    // Stats
    public void ajoutStats(Stats newStats) {
        stats.add(newStats);
        newStats.setMembre(this);
    }

    public void afficherStats() {
        if (this.getStats().size() > 0) {
            System.out.println("Statistiques de " + this.nom + " " + this.prenom);

            this.getStats().forEach(item -> {
                System.out.println("\tPartie no: " + item.getPartie().getNoPartie() + " gain/perte de " + item.getCumulGain());
            });
        } else {
            System.out.println("Aucune stats pour " + this.nom + " " + this.prenom);
        }
    }

    public void afficherCumulGains() {

        double somme = this.getStats().stream().mapToDouble(p -> p.getCumulGain()).sum();
        System.out.println("\tTotal des gains/pertes : " + somme);

    }

    // Partie
    public void addPartie(Partie p) {
        if (!parties.contains(p)) {
            parties.add(p);
            p.addMembre(this);
        }
    }

    public void afficherPartie() {
        if (this.getParties().size() > 0) {
            System.out.println("Partie de " + this.nom + " " + this.prenom);

            this.getParties().forEach(item -> {
                System.out.println("\tPartie no: " + item.getNoPartie() + " en date du " + item.getDatePartie());
            });
        } else {
            System.out.println("Liste partie vide pour " + this.nom + " " + this.prenom);
        }
    }

    // Dérivée
    public int nbPartie() {
        return this.getParties().size();
    }

    public int nbVictoire() {

        int nbVic = this.getStats().stream().mapToInt(p -> p.getCumulGain() > 0 ? 1 : 0).sum();        
        return nbVic;
    }

    public int nbDefaite() {
        return this.getParties().size();
    }

}
