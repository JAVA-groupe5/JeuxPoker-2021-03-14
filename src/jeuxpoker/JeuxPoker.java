package jeuxpoker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Equipe 5
 */
public class JeuxPoker {

    //Déclaration globalDate
    public static Date globalDate = new Date();

    public static Map<Integer, Membre> listeMembres = new HashMap();
    public static Map<Integer, Admin> listeAdmin = new HashMap();
    public static Map<Integer, Billet> listeBillet = new HashMap();
    public static Map<Integer, Message> listeMessages = new HashMap();
    public static Map<Integer, Ami> listeAmis = new HashMap();
    public static Map<Integer, Commande> listeCommandes = new HashMap();
    public static Map<Integer, Produits> listeProduits = new HashMap();
    public static Map<Integer, Details> listeDetail = new HashMap();
    public static Map<Integer, Partie> listePartie = new HashMap();
    public static Map<Integer, Stats> listeStats = new HashMap();

    public static void separateur(String val) {
        System.out.println("********** " + val + " **********");
    }

    public static void main(String[] args) {
        initAll();
    }

    public static void initAll() {
        initAdmin();
        initMembre();
        initBillet();
        initMessage();
        initAmi();
        initCommande();
        initProduits();
        initDetail();
        initPartie();
        initStat();
    }

    public static void initAdmin() {
        separateur("Création des Admins");
        //Déclaration admin        
        Admin admin1 = new Admin("Bouchard", "Stephane");
        Admin admin2 = new Admin("Gervais", "Patrick");
        Admin admin3 = new Admin("Proulx", "Gabriel");
        Admin admin4 = new Admin("Perre", "Thomas");

        listeAdmin.put(admin1.getNoAdmin(), admin1);
        listeAdmin.put(admin2.getNoAdmin(), admin2);
        listeAdmin.put(admin3.getNoAdmin(), admin3);
        listeAdmin.put(admin4.getNoAdmin(), admin4);

        listeAdmin.entrySet().forEach(val -> {
            val.getValue().afficherNewAdmin();
        });
    }

    public static void initMembre() {
        //Déclaration membre
        separateur("Création des Membres");
        //String avatar, String surnom, String email, String nom, String prenom
        Membre mb1 = new Membre("mb1.png", "Conquete", "mb1@java.ca", "Cheval", "Blanc");
        Membre mb2 = new Membre("mb2.png", "Guerre", "mb2@java.ca", "Cheval", "Rouge");
        Membre mb3 = new Membre("mb3.png", "Famine", "mb3@java.ca", "Cheval", "Noir");
        Membre mb4 = new Membre("mb4.png", "Mort", "mb4@java.ca", "Cheval", "Pale");
        mb1.setNbCredit(900); // MAJ des crédits d'un joueur

        listeMembres.put(mb1.getNoMembre(), mb1);
        listeMembres.put(mb2.getNoMembre(), mb2);
        listeMembres.put(mb3.getNoMembre(), mb3);
        listeMembres.put(mb4.getNoMembre(), mb4);

        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherNewMembre();
        });

    }

    public static void initBillet() {
        //Déclaration billet
        separateur("Création Billet");
        Billet bn1 = new Billet(globalDate, null);
        Billet bn2 = new Billet(globalDate, null);
        Billet bn3 = new Billet(globalDate, null);
        Billet bn4 = new Billet(globalDate, null);
        Billet bn5 = new Billet(globalDate, null);
        Billet bn6 = new Billet(globalDate, null);

        listeBillet.put(bn1.getNoBillet(), bn1);
        listeBillet.put(bn2.getNoBillet(), bn2);
        listeBillet.put(bn3.getNoBillet(), bn3);
        listeBillet.put(bn4.getNoBillet(), bn4);
        listeBillet.put(bn5.getNoBillet(), bn5);
        listeBillet.put(bn6.getNoBillet(), bn6);

        listeBillet.entrySet().forEach(val -> {
            val.getValue().afficherNewBillet();
        });

    }

    public static void initMessage() {
        //Déclaration message
        separateur("Création Message");

        Message msg1 = new Message("messageMembre message3", "reponseAdmin message3", listeMembres.get(3), listeBillet.get(1), listeAdmin.get(3));
        Message msg2 = new Message("messageMembre message7", "reponseAdmin message7", listeMembres.get(4), listeBillet.get(3), listeAdmin.get(2));
        Message msg3 = new Message("messageMembre message8", "reponseAdmin message8", listeMembres.get(4), listeBillet.get(5), listeAdmin.get(4));

        listeMessages.put(1, msg1);
        listeMessages.put(2, msg2);
        listeMessages.put(3, msg3);

        listeMessages.entrySet().forEach(val -> {
            val.getValue().afficherMessageComplet();
        });

        // Affichage des messages et réponses seulement
//        listeMessage.entrySet().forEach(val -> {
//            val.getValue().afficherMessageMembre();
//            val.getValue().afficherReponseAdmin();
//        });
    }

    public static void initAmi() {
        //Déclaration ami
        separateur("Création des demandes Amis");

        Ami ami1 = new Ami(globalDate, false, listeMembres.get(1));
        Ami ami2 = new Ami(globalDate, false, listeMembres.get(2));
        Ami ami3 = new Ami(globalDate, false, listeMembres.get(3));
        Ami ami4 = new Ami(globalDate, false, listeMembres.get(4));

        listeAmis.put(1, ami1);
        listeAmis.put(2, ami2);
        listeAmis.put(3, ami3);
        listeAmis.put(4, ami4);

        listeAmis.entrySet().forEach(val -> {
            val.getValue().afficherDemandeAmi();
        });

        listeMembres.get(1).ajoutDemandeAmi(ami2);
        listeMembres.get(2).ajoutDemandeAmi(ami3);
        listeMembres.get(3).ajoutDemandeAmi(ami4);
        listeMembres.get(4).ajoutDemandeAmi(ami1);

        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherAllDemandesEnAttente();
            //val.getValue().afficherAllAmis();
        });

        listeMembres.get(4).supprimerDemandeAmi(ami1);
        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherAllDemandesEnAttente();
        });

        listeMembres.get(4).ajoutAmi(ami1);
        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherAllAmis();
        });

    }

    public static void initCommande() {
        //Déclaration commande
        separateur("Création des Commandes");
        Commande cde1 = new Commande(globalDate, listeMembres.get(1));
        Commande cde2 = new Commande(globalDate, listeMembres.get(1));
        Commande cde3 = new Commande(globalDate, listeMembres.get(2));

        listeCommandes.put(cde1.getNoCommande(), cde1);
        listeCommandes.put(cde2.getNoCommande(), cde2);
        listeCommandes.put(cde3.getNoCommande(), cde3);

        listeMembres.get(1).ajoutCommande(listeCommandes.get(1));
        listeMembres.get(1).ajoutCommande(listeCommandes.get(2));
        listeMembres.get(2).ajoutCommande(listeCommandes.get(3));

        listeCommandes.entrySet().forEach(val -> {
            val.getValue().afficherCommande();
        });

    }

    public static void initProduits() {
        //Déclaration produits
        separateur("Création des Produits");
        Produits produit1 = new Produits("Crédit", "Monnaie du jeu", 1.00);
        Produits produit2 = new Produits("Familier Chien", "Chien à 3 têtes", 10.00);
        Produits produit3 = new Produits("Chapeau melon", "Look génial, film affreux", 5.00);
        Produits produit4 = new Produits("Avatar Virus", "Promotion 2020", 2.50);

        listeProduits.put(produit1.getNoProduit(), produit1);
        listeProduits.put(produit2.getNoProduit(), produit2);
        listeProduits.put(produit3.getNoProduit(), produit3);
        listeProduits.put(produit4.getNoProduit(), produit4);

        listeProduits.entrySet().forEach(val -> {
            val.getValue().afficherProduit();
        });

    }

    public static void initDetail() {
        //Déclaration details
        separateur("Création d'une commande - Détail");
        Details detail1 = new Details(listeCommandes.get(1), listeProduits.get(1), 5, listeProduits.get(1).getPrixProduit());
        Details detail2 = new Details(listeCommandes.get(1), listeProduits.get(2), 5, listeProduits.get(2).getPrixProduit());
        Details detail3 = new Details(listeCommandes.get(1), listeProduits.get(3), 5, listeProduits.get(3).getPrixProduit());
        Details detail4 = new Details(listeCommandes.get(2), listeProduits.get(3), 5, listeProduits.get(3).getPrixProduit());
        Details detail5 = new Details(listeCommandes.get(2), listeProduits.get(4), 5, listeProduits.get(4).getPrixProduit());
        Details detail6 = new Details(listeCommandes.get(3), listeProduits.get(4), 15, listeProduits.get(4).getPrixProduit() + 10.00);

        listeDetail.put(1, detail1);
        listeDetail.put(2, detail2);
        listeDetail.put(3, detail3);
        listeDetail.put(4, detail4);
        listeDetail.put(5, detail5);
        listeDetail.put(6, detail6);

        
        // Verifier si appel dans constructeur ok
//        listeCommandes.get(1).ajoutDetail(listeDetail.get(1));
//        listeCommandes.get(1).ajoutDetail(listeDetail.get(2));
//        listeCommandes.get(1).ajoutDetail(listeDetail.get(3));
//        listeCommandes.get(2).ajoutDetail(listeDetail.get(4));
//        listeCommandes.get(2).ajoutDetail(listeDetail.get(5));
//        listeCommandes.get(3).ajoutDetail(listeDetail.get(6));
//
//        listeProduits.get(1).ajoutDetail(listeDetail.get(1));
//        listeProduits.get(2).ajoutDetail(listeDetail.get(2));
//        listeProduits.get(3).ajoutDetail(listeDetail.get(3));
//        listeProduits.get(3).ajoutDetail(listeDetail.get(4));
//        listeProduits.get(4).ajoutDetail(listeDetail.get(5));
//        listeProduits.get(4).ajoutDetail(listeDetail.get(6));

        //System.out.println("*** APRES SUPPRESSION ***");
        //listeCommandes.get(1).supprimerCommandeDetail(listeDetail.get(1));
        //listeCommandes.get(1).supprimerCommandeDetail(listeDetail.get(6));
        //listeCommandes.get(1).afficherProduitsCommande();
        System.out.println("*** TOTAL ACHATS MEMBRES ***");
        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherTotalAchats();
        });
        System.out.println("*** LISTE PRODUITS DETAILS ***");
        listeProduits.entrySet().forEach(val -> {
            val.getValue().afficherDetails();
        });
        System.out.println("*** LISTE COMMANDES DETAILS ***");
        listeCommandes.entrySet().forEach(val -> {
            val.getValue().afficherDetails();
        });
    }

    public static void initPartie() {
        //Déclaration partie
        separateur("Création Partie");
        Partie partie1 = new Partie(globalDate, EnumModedeJeu.Apprendre_A_Jouer);
        Partie partie2 = new Partie(globalDate, EnumModedeJeu.Multi);
        Partie partie3 = new Partie(globalDate, EnumModedeJeu.Solo);

        listePartie.put(partie1.getNoPartie(), partie1);
        listePartie.put(partie2.getNoPartie(), partie2);
        listePartie.put(partie3.getNoPartie(), partie3);

        listePartie.entrySet().forEach(val -> {
            val.getValue().afficherPartie();
        });

        listeMembres.get(1).addPartie(partie1);
        listeMembres.get(2).addPartie(partie2);
        listeMembres.get(3).addPartie(partie2);
        listeMembres.get(4).addPartie(partie2);
        listeMembres.get(1).addPartie(partie3);

        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherPartie();            
        });

        Partie.afficherModeDeJeu();
    }

    public static void initStat() {
        //Déclaration stats
        separateur("Création des Stats");
        Stats stat1 = new Stats(listePartie.get(1), listeMembres.get(1), 200);
        Stats stat2 = new Stats(listePartie.get(2), listeMembres.get(2), 1200);
        Stats stat3 = new Stats(listePartie.get(2), listeMembres.get(3), -200);
        Stats stat4 = new Stats(listePartie.get(2), listeMembres.get(4), -200);
        Stats stat5 = new Stats(listePartie.get(3), listeMembres.get(1), -200);

        listeStats.put(1, stat1);
        listeStats.put(2, stat2);
        listeStats.put(3, stat3);
        listeStats.put(4, stat4);
        listeStats.put(5, stat5);

        listeStats.entrySet().forEach(val -> {
            val.getValue().afficherStats();
            //System.out.println("Nb partie(s): " + val.getValue().nbPartie());
        });
        separateur("Stats Membres");
        listeMembres.get(1).ajoutStats(stat1);
        listeMembres.get(2).ajoutStats(stat2);
        listeMembres.get(3).ajoutStats(stat3);
        listeMembres.get(4).ajoutStats(stat4);
        listeMembres.get(1).ajoutStats(stat5);

        listeMembres.entrySet().forEach(val -> {
            val.getValue().afficherStats();
            val.getValue().afficherCumulGains();
        });

        separateur("Stats Parties");

        listePartie.get(1).ajoutStats(stat1);
        listePartie.get(2).ajoutStats(stat2);
        listePartie.get(2).ajoutStats(stat3);
        listePartie.get(2).ajoutStats(stat4);
        listePartie.get(3).ajoutStats(stat5);

        listePartie.entrySet().forEach(item -> {
            item.getValue().afficherStats();
            item.getValue().afficherCumulGains();
        });

    }
}
