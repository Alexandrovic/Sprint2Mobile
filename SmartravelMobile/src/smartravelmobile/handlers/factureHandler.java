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
import smartravelmobile.entities.Facture;
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
    private Facture currentFacture;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("annonce")) {

            if (currentFacture != null) {
                throw new IllegalStateException("already processing a voys");
            }
            currentFacture = new Facture();
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

           fcts.addElement(currentFacture);
           currentFacture = null;
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
        if (currentFacture != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (id_factureT.equals("open")) {
                String ids = new String(ch, start, length).trim();
                int id = Integer.parseInt(ids);
                currentFacture.setId_facture(id);
            } else if (n_serieT.equals("open")) {
                String ser = new String(ch, start, length).trim();
                currentFacture.setNumero_serie_facture(ser);
            } else if (somme_factureT.equals("open")) {
                String som = new String(ch, start, length).trim();
                float s = Float.parseFloat(som);
                currentFacture.setSomme_facture(s);
            } else if (date_payement_factureT.equals("open")) {
                
               String dated = new String(ch, start, length).trim();
                     currentFacture.setDate_payement_facture(dated);
                     
            }
        }
    }
}
