package jeuxpoker;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Equipe 5
 */
public class Admin extends Personne {
    //attributs

    private int noAdmin;
    private static int nextNoAdmin = 1;
    private Set<Message> messages;

    //constructeurs
    public Admin(String nom, String prenom) {
        super(nom, prenom);

        this.noAdmin = nextNoAdmin++;
        this.messages = new HashSet();
    }

    //getter-setter
    /**
     * @return the noAdmin
     */
    public int getNoAdmin() {
        return noAdmin;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void afficherNewAdmin() {
        System.out.print("Nouvel admin: " + this.noAdmin);
        System.out.println(" | Nom, prénom: " + this.nom + " " + this.prenom);
    }

}
