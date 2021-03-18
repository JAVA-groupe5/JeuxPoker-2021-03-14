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
public class JeuxPoker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Déclaration date
        Date date = new Date();

        //Déclaration Personne =>Personne is abstract donc on peut pas l'appeler
        System.out.println("////////////////////declaration admin/////////////");
        //Déclaration admin
        Admin admin1 = new Admin("nomAdmin1", "prenomAdmin1", null);
        Admin admin2 = new Admin("nomAdmin2", "prenomAdmin2", null);
        Admin admin3 = new Admin("nomAdmin3", "prenomAdmin3", null);
        Admin admin4 = new Admin("nomAdmin4", "prenomAdmin4", null);

        admin1.afficher();
        admin2.afficher();
        admin3.afficher(); // affiche 2-null et  nomAdmin3-prenomAdmin3
        admin4.afficher();
        System.out.println("/////////declaration membre///////////////////////////////////////////");
        //Déclaration membre

        //String avatar, String surnom, String email, String nom, String prenom
        Membre mb1 = new Membre("mb1.png", "Conquete", "mb1@java.ca", "nomMembre1", "prenomMembre1");
        Membre mb2 = new Membre("mb2.png", "Guerre", "mb2@java.ca", "nomMembre2", "prenomMembre2");
        Membre mb3 = new Membre("mb3.png", "Famine", "mb3@java.ca", "nomMembre3", "prenomMembre3");
        Membre mb4 = new Membre("mb4.png", "Mort", "mb4@java.ca", "nomMembre4", "prenomMembre4");

        mb1.setNbCredit(900);
        mb1.afficher(); //affiche 1-null-null-null-0 et nomMembre1-prenomMembre1
        mb2.afficher(); //affiche correctement
        mb3.afficher(); //affiche 3-mb3.png-MB3-mb3@java.ca-3 et nomMembre3-prenomMembre3
        mb4.afficher(); //affiche correctement

        System.out.println("/////////declaration billet//////////////////////////////////////////////////");

        //Déclaration billet
        Billet bn1 = new Billet();
        Billet bn2 = new Billet();
        Billet bn3 = new Billet(date);
        Billet bn4 = new Billet(date);
        Billet bn5 = new Billet(date, null);
        Billet bn6 = new Billet(date, null);

        bn1.afficher(); // affiche 1-null-[]
        bn2.afficher();// affiche 2-null-[]
        bn3.afficher();// affiche 3-la date du moment-[]
        bn4.afficher();// affiche 4-la date du moment-[]
        bn5.afficher(); // affiche 5-la date du moment-[]
        bn6.afficher();// affiche 6-la date du moment-[]

        System.out.println("//////////declaration message///////////////////////////////////////////");
        //Déclaration message

        Message msg3 = new Message("messageMembre message3", "reponseAdmin message3", mb3, bn1, admin3);
        Message msg7 = new Message("messageMembre message7", "reponseAdmin message7", mb4, bn3, admin2);
        Message msg8 = new Message("messageMembre message8", "reponseAdmin message8", mb4, bn5, admin4);

        Set<Message> messages = new HashSet(0);
        messages.add(msg3);
        admin3.setMessages(messages);
        mb3.setMessages(messages);
        bn1.setMessages(messages);
        Message.afficherMessage(bn1.getMessages());
        messages.clear();

        messages.add(msg7);
        admin2.setMessages(messages);
        mb4.setMessages(messages);
        bn3.setMessages(messages);
        Message.afficherMessage(messages);

        messages.clear();

        messages.add(msg8);
        admin4.setMessages(messages);
        mb4.setMessages(messages);
        bn5.setMessages(messages);

        Message.afficherMessage(messages);
        messages.clear();
        System.out.println("/////////declaration amis//////////////////////////////////////////////////");

        //Déclaration ami
        Ami ami3 = new Ami(date, true, mb2);
        Ami ami4 = new Ami(date, false, mb1);

        mb1.afficher();

        mb1.ajoutDemandeAmi(ami3);
        mb1.ajoutDemandeAmi(ami4);

        mb1.afficherAllAmis();
        mb1.afficherAllDemandesEnAttente();

        System.out.println("/////////declaration stats//////////////////////////////////////////////////");

        //Déclaration stats
        Stats stat1 = new Stats(0);
        Stats stat2 = new Stats(9862);

        stat1.afficher(); //affichage 0
        stat2.afficher();
        System.out.println("/////////declaration partie//////////////////////////////////////////////////");

        //Déclaration partie
        Partie partie1 = new Partie(date, Partie.ModeDeJeu.APPRENDRE_A_JOUER);
        Partie partie2 = new Partie(date, Partie.ModeDeJeu.MULTI);

        Set<Partie> partieTest = new HashSet(0);
        partie1.afficher(); //affichage 0-null-null
        partie2.afficher();//affichage 1-date du moment-null

        partieTest.add(partie2);

        mb1.setParties(partieTest);
        mb2.setParties(partieTest);
        mb3.setParties(partieTest);

        Set<Membre> membrePartieTest = new HashSet(0);
        membrePartieTest.add(mb1);
        membrePartieTest.add(mb2);
        membrePartieTest.add(mb3);

        partie2.setMembres(membrePartieTest);

        partie2.afficherAllMembresPartie();

        System.out.println("Bravo ! : " + mb1.nbPartie() + " jouées");

        Partie.afficherModeDeJeu();

        System.out.println("/////////declaration mode de jeu//////////////////////////////////////////////////");

        //Déclaration mode de jeu
        System.out.println("/////////declaration commande//////////////////////////////////////////////////");

        //Déclaration commande
        Commande cde1 = new Commande(102, date);
        Commande cde2 = new Commande(213, date);
        Commande cde3 = new Commande(154, date);

        System.out.println("/////////declaration details//////////////////////////////////////////////////");

        //Déclaration details
        Details detail1 = new Details(190, 5);
        Details detail2 = new Details(999, 3);

        detail1.afficher(); //affichage 190-5
        detail2.afficher();

        System.out.println("/////////declaration produit//////////////////////////////////////////////////");

        //Déclaration produits
        Produits produit1 = new Produits("tablette", 190, "samsung v2, 1go");
        Produits produit2 = new Produits("macbook air", 999, "version 10, 32go");
        Produits produit3 = new Produits("air", 2999, "10, 132go");
        Produits produit4 = new Produits("mars", 1999, "version 0, 22232go");

        Set<Produits> pdt = new HashSet(0);
        pdt.add(produit1);
        pdt.add(produit2);
        pdt.add(produit3);
        cde1.setProduits(pdt);
        cde1.afficherProduits();
        System.out.println("Total : " + cde1.totalCommande() + " $");

        System.out.println("///////// CD1 //////////////////////////////////////////////////");

        Set<Produits> pdt2 = new HashSet(0);
        pdt2.add(produit4);
        cde2.setProduits(pdt2);
        cde2.afficherProduits();
        System.out.println("///////// CD2 //////////////////////////////////////////////////");

        Set<Commande> mesAchats = new HashSet(0);
        mesAchats.add(cde1);
        mb1.setCommandes(mesAchats);

        Set<Commande> mesAchat2 = new HashSet(0);
        mesAchat2.add(cde2);
        mesAchat2.add(cde3);
        mb2.setCommandes(mesAchat2);

        mb1.afficherMesAchats();
        System.out.println("/////////la faute//////////////////////////////////////////////////");
        mb2.afficherMesAchats();

        System.out.println("Total : " + mb1.totalAchats() + " $");
        System.out.println("Total : " + mb2.totalAchats() + " $");
    }

}
