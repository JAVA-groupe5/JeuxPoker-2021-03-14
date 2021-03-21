package jeuxpoker;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static jeuxpoker.utilitaires.retourDate;

/**
 *
 * @author Equipe 5
 */
public class Billet {

    //attributs
    private static int nextNoBillet = 1;
    private int noBillet;
    private Date dateBillet;
    private Set<Message> messages = new HashSet(0);

    //constructeurs
    public Billet(Date dateBillet, Set<Message> messages) {

        this.dateBillet = dateBillet;
        this.messages = messages;
        this.noBillet = nextNoBillet++;
    }

    //getter-setter
    public int getNoBillet() {
        return noBillet;
    }

    public Date getDateBillet() {
        return dateBillet;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setDateBillet(Date dateBillet) {
        this.dateBillet = dateBillet;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void afficherNewBillet() {
        System.out.print("Nouveau billet: " + this.noBillet);
        System.out.println(" | Date du: " + retourDate(this.dateBillet));
    }

}
