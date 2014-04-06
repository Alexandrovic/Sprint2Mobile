/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.handlers;

import java.util.Vector;
import smartravelmobile.entities.Reservation;

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
     private Reservation currentReserv;

//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        if (qName.equals("reservation")) {
//
//            if (currentReserv!= null) {
//                throw new IllegalStateException("already processing a voys");
//            }
//            currentReserv= new Voyage();
//        } else if (qName.equals("id_voyage")) {
//            id_voyageT = "open";
//        } else if (qName.equals("moyen_transport")) {
//            moyen_transportT = "open";
//        } else if (qName.equals("destination")) {
//            destinationT = "open";
//        } else if (qName.equals("budget")) {
//            budgetT = "open";
//        } else if (qName.equals("nb_place")) {
//            nb_placeT = "open";
//        } else if (qName.equals("programme")) {
//            programmeT = "open";
//        } else if (qName.equals("iteniraire")) {
//            itineraireT = "open";
//        } else if (qName.equals("date_depart")) {
//            date_departT = "open";
//        } else if (qName.equals("voyage_responsable")) {
//            voyage_responsableT = "open";
//        }
//    }
//
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//
//        if (qName.equals("annonce")) {
//
//            if (currentReserv!= null) {
//                throw new IllegalStateException("already processing a voys");
//            }
//            currentReserv= new Voyage();
//        } else if (qName.equals("id_voyage")) {
//            id_voyageT = "close";
//        } else if (qName.equals("moyen_transport")) {
//            moyen_transportT = "close";
//        } else if (qName.equals("destination")) {
//            destinationT = "close";
//        } else if (qName.equals("budget")) {
//            budgetT = "close";
//        } else if (qName.equals("nb_place")) {
//            nb_placeT = "close";
//        } else if (qName.equals("programme")) {
//            programmeT = "close";
//        } else if (qName.equals("iteniraire")) {
//            itineraireT = "close";
//        } else if (qName.equals("date_depart")) {
//            date_departT = "close";
//        } else if (qName.equals("voyage_responsable")) {
//            voyage_responsableT = "close";
//        }
//    }
//    // "characters" are the text inbetween tags
//
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        // we're only interested in this inside a <phone.../> tag
//        if (currentReserv != null) {
//            // don't forget to trim excess spaces from the ends of the string
//            if (id_voyageT.equals("open")) {
//                String ids = new String(ch, start, length).trim();
//                int id = Integer.parseInt(ids);
//                currentAnnon.setId_voyage(id);
//            } else if (moyen_transportT.equals("open")) {
//                String moy = new String(ch, start, length).trim();
//                currentAnnon.setMoyen_transport(moy);
//            } else if (destinationT.equals("open")) {
//                String dest = new String(ch, start, length).trim();
//                currentAnnon.setDestination(dest);
//            } else if (budgetT.equals("open")) {
//                String bud = new String(ch, start, length).trim();
//                float budget = Float.parseFloat(bud);
//                currentAnnon.setBudget(budget);
//            } else if (nb_placeT.equals("open")) {
//                String nbp = new String(ch, start, length).trim();
//                int nb = Integer.parseInt(nbp);
//                currentAnnon.setNb_place(nb);
//            } else if (programmeT.equals("open")) {
//                String prog = new String(ch, start, length).trim();
//                currentAnnon.setProgramme(prog);
//            } else if (itineraireT.equals("open")) {
//                String iten = new String(ch, start, length).trim();
//                currentAnnon.setItineraire(iten);
//            } else if (date_departT.equals("open")) {
//                String date = new String(ch, start, length).trim();
//
//            } else if (voyage_responsableT.equals("open")) {
//                String resp = new String(ch, start, length).trim();
//                int id_resp = Integer.parseInt(resp);
//                currentAnnon.setVoyage_responsable(id_resp);
//            }
//        }
//    }
  
       
}
