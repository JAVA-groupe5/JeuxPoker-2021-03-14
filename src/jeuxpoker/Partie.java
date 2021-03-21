package jeuxpoker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Equipe 5
 */
public class Partie {

    //attributs
    private int noPartie;
    private static int NextNoPartie = 1;
    private Date datePartie;
    private EnumModedeJeu modeDeJeu;
    private List<Membre> membres;
    private Set<Stats> stats;

    //constructeurs
    public Partie(Date datePartie, EnumModedeJeu modeDeJeu) {
        noPartie = NextNoPartie++;
        this.datePartie = datePartie;
        this.modeDeJeu = modeDeJeu;

        membres = new ArrayList();
        stats = new HashSet();
    }

    public int getNoPartie() {
        return noPartie;
    }

    public Date getDatePartie() {
        return datePartie;
    }

    public EnumModedeJeu getModeDeJeu() {
        return modeDeJeu;
    }

    public void setModeDeJeu(EnumModedeJeu modeDeJeu) {
        this.modeDeJeu = modeDeJeu;
    }

    public void setDatePartie(Date datePartie) {
        this.datePartie = datePartie;
    }

    public void afficherPartie() {
        System.out.println(this.noPartie + "-" + this.datePartie + "-" + this.modeDeJeu);

    }

    // Get et Set
    public List<Membre> getMembres() {
        return membres;
    }

    public Set<Stats> getStats() {
        return stats;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public void setStats(Set<Stats> stats) {
        this.stats = stats;
    }

    // Membre
    public void addMembre(Membre m) {
        if (!membres.contains(m)) {
            membres.add(m);
            m.addPartie(this);
        }
    }

    // Stats
    public void ajoutStats(Stats newStats) {
        stats.add(newStats);
        newStats.setPartie(this);
    }

    public void afficherStats() {
        if (this.getStats().size() > 0) {
            System.out.println("Statistiques de la partie no " + this.noPartie);

            this.getStats().forEach(item -> {
                System.out.println("\tMembres: " + item.getMembre().nom + ", " + item.getMembre().prenom);
            });
        } else {
            System.out.println("Aucune stats pour " + this.noPartie);
        }
    }

    public void afficherCumulGains() {

        double somme = this.getStats().stream().mapToDouble(p -> p.getCumulGain()).sum();
        System.out.println("\tTotal des gains/pertes : " + somme);

    }

    public void afficherAllMembresPartie() {
        System.out.println("/////////ALL membres partie//////////////////////////////////////////////////");
        System.out.println("No partie : " + this.getNoPartie());
        this.getMembres().forEach(item -> {
            System.out.print("| " + item.getNom() + "| \t");
        });
        System.out.println("");
    }

    public static void afficherModeDeJeu() {
        for (EnumModedeJeu val : EnumModedeJeu.values()) {
            System.out.println(val);
        }
    }

}
