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
        Membre mb1 = new Membre("mb1.png", "MB1", "mb1@java.ca", 900, "nomMembre1", "prenomMembre1");
        Membre mb2 = new Membre("mb2.png", "MB2", "mb2@java.ca", 200, "nomMembre2", "prenomMembre2");
        Membre mb3 = new Membre("mb3.png", "MB3", "mb3@java.ca", 300, "nomMembre3", "prenomMembre3");
        Membre mb4 = new Membre("mb4.png", "MB4", "mb4@java.ca", 785, "nomMembre4", "prenomMembre4");

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
        messages.add(msg7);
        admin3.setMessages(messages);
        messages.clear();
        
        Message.afficherMessage(messages);
        
        messages.add(msg3);
        messages.add(msg8);
        
        

        System.out.println("/////////declaration amis//////////////////////////////////////////////////");

        //Déclaration ami
        Ami ami3 = new Ami(date, true, mb2);
        Ami ami4 = new Ami(date, false, mb1);

        Set<Ami> amiss = new HashSet(0);
        amiss.add(ami3);
        amiss.add(ami4);
        Membre.afficherAmi(amiss);

        System.out.println("/////////declaration stats//////////////////////////////////////////////////");

        //Déclaration stats
        Stats stat1 = new Stats(0);
        Stats stat2 = new Stats(9862);

        stat1.afficher(); //affichage 0
        stat2.afficher();
        System.out.println("/////////declaration partie//////////////////////////////////////////////////");

        //Déclaration partie
        Partie partie1 = new Partie();
        Partie partie2 = new Partie(date, null);
        Set<Membre> membres = new HashSet(0);

        partie1.afficher(); //affichage 0-null-null
        partie2.afficher();//affichage 1-date du moment-null

        System.out.println("/////////declaration eum//////////////////////////////////////////////////");

        //enum
        EnumModedeJeu j1 = EnumModedeJeu.Apprendre_A_Jouer;
        EnumModedeJeu j2 = EnumModedeJeu.Multi;
        EnumModedeJeu j3 = EnumModedeJeu.Solo;
        System.out.println(j1 + " " + j2 + " " + j3);

        System.out.println("/////////declaration mode de jeu//////////////////////////////////////////////////");

        //Déclaration mode de jeu
        ModeDeJeu mode1 = new ModeDeJeu();
        ModeDeJeu mode2 = new ModeDeJeu(2, "Apprendre_A_Jouer");
        ModeDeJeu mode3 = new ModeDeJeu(3, "Multi");

        mode1.afficher(); //affichage 0-null
        mode2.afficher(); //affichage 2-Apprendre_A_Jouer
        mode3.afficher(); //affichage 3-Multi

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

        //produit1.afficher(); //affichage 1-tablette-190-samsung v2, 1go
        //produit2.afficher();
        Set<Produits> pdt = new HashSet(0);
        pdt.add(produit1);
        pdt.add(produit2);
        cde1.setProduits(pdt);
        pdt.add(produit2);
        cde2.setProduits(pdt);

        Set<Commande> mesAchats = new HashSet(0);
        mesAchats.add(cde1);
        mesAchats.add(cde2);
        mesAchats.add(cde3);
        Membre.afficherMesAchats(mesAchats);

    }

}
