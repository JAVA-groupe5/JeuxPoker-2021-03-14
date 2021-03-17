/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuxpoker;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author thomas
 */
public class Ami {
       //attributs
    private Date dateDemande;
    private boolean EtatDemande;
    private Membre membre;
    
    
    
    //constructeurs
   
      
    public Ami() {
    }

    public Ami(Date dateDemande, boolean EtatDemande, Membre membre) {
        this.dateDemande = dateDemande;
        this.EtatDemande = EtatDemande;
        this.membre = membre;
    }

     //getter-setter

    public Date getDateDemande() {
        return dateDemande;
    }

    public boolean isEtatDemande() {
        return EtatDemande;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public void setEtatDemande(boolean EtatDemande) {
        this.EtatDemande = EtatDemande;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

   public void afficher(){
        System.out.println(this.dateDemande +"-"+ this.EtatDemande+"-"+ this.membre );
        
    }
}
