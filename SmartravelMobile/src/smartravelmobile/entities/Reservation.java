/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.entities;

import java.util.Date;

/**
 *
 * @author Belgacem
 */
public class Reservation {

    public Reservation() {
    }
    
    int id ;
    boolean payment ;
    Date date_inscription ;
    Voyage voyage;
    Voyageur voy ; 
    Facture facture ; 

    public int getId() {
        return id;
    }

    public boolean isPayment() {
        return payment;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public Voyageur getVoy() {
        return voy;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public void setVoy(Voyageur voy) {
        this.voy = voy;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    



}
