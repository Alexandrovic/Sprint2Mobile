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
public class Voyage {

    public Voyage() {
    }
     String type_voyage;
    int id_voyage;
    String moyen_transport;
   String  destination ;
   float budget ;
   int nb_place;
   
   String programme;
   String itineraire;
    Date date_depart;
    Date date_retour;
    int voyage_responsable;

  
    
    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }
    
    
    
    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public String getMoyen_transport() {
        return moyen_transport;
    }

    public void setMoyen_transport(String moyen_transport) {
        this.moyen_transport = moyen_transport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getItineraire() {
        return itineraire;
    }

    public void setItineraire(String itineraire) {
        this.itineraire = itineraire;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public int getVoyage_responsable() {
        return voyage_responsable;
    }

    public void setVoyage_responsable(int voyage_responsable) {
        this.voyage_responsable = voyage_responsable;
    }

    public Voyage(int id_voyage, String type_voyage,String moyen_transport, String destination, float budget,int nb_place, String programme, String itineraire, Date date_depart, Date date_retour, int voyage_responsable) {
        this.id_voyage = id_voyage;
        this.moyen_transport = moyen_transport;
        this.destination = destination;
        this.budget = budget;
        this.programme = programme;
        this.itineraire = itineraire;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.voyage_responsable = voyage_responsable;
        this.type_voyage=type_voyage;
    }

    public String getType_voyage() {
        return type_voyage;
    }

    public void setType_voyage(String type_voyage) {
        this.type_voyage = type_voyage;
    }

   
    
    
    
}
