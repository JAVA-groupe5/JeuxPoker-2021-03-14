package jeuxpoker;

/**
 *
 * @author Equipe 5
 */
public class Stats {

    //attributs
    private int cumulGain;
    private Partie partie;
    private Membre membre;

    //constructeurs
    public Stats(Partie partie, Membre membre, int cumulGain) {
        this.cumulGain = cumulGain;
        this.partie = partie;
        this.membre = membre;
    }

    public int getCumulGain() {
        return cumulGain;
    }

    public Partie getPartie() {
        return partie;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setCumulGain(int cumulGain) {
        this.cumulGain = cumulGain;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public void afficherStats() {        
        this.getMembre().afficherMembre();
        System.out.println(" | Partie no: " + this.getPartie().getNoPartie() + " | Gain/Perte: " +  this.cumulGain);
    }
}
