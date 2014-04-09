/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.entities;
import java.util.Date;
import javax.microedition.lcdui.List;

/**
 *
 * @author akrem
 */
public class Facture {
      int id_facture;
    String n_serie;
    float somme_facture;
    String date_payement_facture;

    public String getNumero_serie_facture() {
        return n_serie;
    }

    public void setNumero_serie_facture(String numero_serie_facture) {
        this.n_serie = numero_serie_facture;
    }

    public Facture() {
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }
  
   
    public float getSomme_facture() {
        return somme_facture;
    }

    public void setSomme_facture(float somme_facture) {
        this.somme_facture = somme_facture;
    }

    public String getDate_payement_facture() {
        return date_payement_facture;
    }

    public void setDate_payement_facture(String date_payement_facture) {
        this.date_payement_facture = date_payement_facture;
    }

    
    
}
