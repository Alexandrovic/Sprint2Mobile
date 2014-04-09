/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.handlers;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import smartravelmobile.entities.Voyage;
import java.util.Date;
import java.util.Vector;
import smartravelmobile.entities.Voyage;
import org.xml.sax.helpers.DefaultHandler;
import  org.xml.sax.Attributes;
import org.xml.sax.SAXException;
/**
 *
 * @author Belgacem
 */
public class factureHandler extends DefaultHandler{

  
    private Vector fcts;
    String id_factureT;
    String n_serieT;
    String somme_factureT;
    String date_payement_factureT;
   
    public factureHandler() {
         fcts = new Vector();
    }

    public Voyage[] getVoyages() {
        Voyage[] ans = new Voyage[fcts.size()];
        fcts.copyInto(ans);
        return ans;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Voyage currentAnnon;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("annonce")) {

            if (currentAnnon != null) {
                throw new IllegalStateException("already processing a voys");
            }
            currentAnnon = new Voyage();
        } else if (qName.equals("id_facture")) {
            id_factureT = "open";
        } else if (qName.equals("n_serie")) {
            n_serieT = "open";
        } else if (qName.equals("somme_facture")) {
            somme_factureT = "open";
        } else if (qName.equals("date_payement_facture")) {
            date_payement_factureT = "open";
        } 
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("annonce")) {

           fcts.addElement(currentAnnon);
           currentAnnon = null;
        } else if (qName.equals("id_facture")) {
            id_factureT = "close";
        } else if (qName.equals("n_serie")) {
            n_serieT = "close";
        } else if (qName.equals("somme_facture")) {
            somme_factureT = "close";
        } else if (qName.equals("date_payement_facture")) {
            date_payement_factureT = "close";
        } 
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentAnnon != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (id_factureT.equals("open")) {
                String ids = new String(ch, start, length).trim();
                int id = Integer.parseInt(ids);
                currentAnnon.setId_voyage(id);
            } else if (n_serieT.equals("open")) {
                String moy = new String(ch, start, length).trim();
                currentAnnon.setMoyen_transport(moy);
            } else if (somme_factureT.equals("open")) {
                String dest = new String(ch, start, length).trim();
                currentAnnon.setDestination(dest);
            } else if (date_payement_factureT.equals("open")) {
                String bud = new String(ch, start, length).trim();
                float budget = Float.parseFloat(bud);
                currentAnnon.setBudget(budget);
            } 
        }
    }
}
