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
public class Partie {

    //attributs
    enum ModeDeJeu {
        SOLO,
        APPRENDRE_A_JOUER,
        MULTI
    }

    private int noPartie;
    private static int NextNoPartie = 1;
    private Date datePartie;
    private ModeDeJeu modeDeJeu;
    private Set<Membre> membres = new HashSet(0);

    //constructeurs
    public Partie(Date datePartie, ModeDeJeu modeDeJeu) {
        this.datePartie = datePartie;
        this.modeDeJeu = modeDeJeu;
        noPartie = NextNoPartie++;
    }

    public int getNoPartie() {
        return noPartie;
    }

    public Date getDatePartie() {
        return datePartie;
    }

    public Set<Membre> getMembres() {
        return membres;
    }

    public ModeDeJeu getModeDeJeu() {
        return modeDeJeu;
    }

    public void setModeDeJeu(ModeDeJeu modeDeJeu) {
        this.modeDeJeu = modeDeJeu;
    }

    public void setDatePartie(Date datePartie) {
        this.datePartie = datePartie;
    }

    public void setMembres(Set<Membre> membres) {
        this.membres = membres;
    }

    public void afficher() {
        System.out.println(this.noPartie + "-" + this.datePartie + "-" + this.modeDeJeu);

    }

    public void afficherAllMembresPartie() {
        System.out.println("/////////ALL membres partie//////////////////////////////////////////////////");
        System.out.println("No partie : " + this.getNoPartie());
        this.getMembres().forEach(item -> {
            System.out.print("| " + item.getNom()+ "| \t");
        });
        System.out.println("");
    }

    public static void afficherModeDeJeu() {
        for (ModeDeJeu val : ModeDeJeu.values()) {
            System.out.println(val);
        }
    }
}
