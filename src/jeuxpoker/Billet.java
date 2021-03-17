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
public class Billet {
    
    //attributs
    private static int nextNoBillet=1;
    private int noBillet;
    private Date dateBillet;
    private Set<Message> messages= new HashSet(0);
    
    
    //constructeurs

    public Billet() {
        noBillet=nextNoBillet;
        nextNoBillet++;
    }

    public Billet( Date dateBillet) {
        
        this.dateBillet = dateBillet;
        noBillet=nextNoBillet++;
    }

    public Billet(Date dateBillet, Set<Message> messages) {
        
        this.dateBillet = dateBillet;
        this.messages=messages;
        noBillet=nextNoBillet++;
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

    
    public void setNoBillet(int noBillet) {
        this.noBillet = noBillet;
    }

    public void setDateBillet(Date dateBillet) {
        this.dateBillet = dateBillet;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
    
public void afficher(){
        System.out.println(this.noBillet +"-"+ this.dateBillet+"-"+ this.messages );
        
    }
    
}
