/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.handlers;

import java.util.Vector;
import smartravelmobile.entities.Reservation;
import smartravelmobile.entities.Voyage;

/**
 *
 * @author Belgacem
 */
public class reservationHandler {
    
    private  Vector resrvs  ; 
     String idTag ;
    String paymentTag ;
    String date_inscriptionTag ;
    String  id_voyageTag ; 
    String  id_voyageurTag ; 
    
    
    public reservationHandler() {
    }
    
       public Reservation[] getReservs() {
       Reservation[] res = new Reservation[resrvs.size()];
        resrvs.copyInto(res);
        return res;
    }
    
  
}
